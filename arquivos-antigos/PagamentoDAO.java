import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.Date;


public class PagamentoDAO extends MysqlConnect{
   private PreparedStatement st;
   
   public PagamentoDAO(){
      st = null;
   }
   
   
   public ArrayList<Pagamento> consultarPagamento(String pesquisa, String campo){
      ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
      ResultSet rs = null;
      String order = (campo != "" ? campo : "1");                     
      String query = "select pg_code, p.lc_code, pg_valor,pg_tipopag,pg_status "+
                     "from pagamento p where "+campo+" like '"+pesquisa+"%' order by "+order;    
      try{
         this.st = this.conn.prepareStatement(query);
         rs = this.st.executeQuery();
         while(rs.next()){
            Pagamento p = new Pagamento();
            p.setPgcode(rs.getInt("pg_code"));
            p.setPgvalortot(rs.getString("pg_valor"));//VALOR QUE SERA/FOI PAGO DEPOIS DO CALCULO DO JUROS
            p.setPgtipopag(rs.getString("pg_tipopag"));
            p.setPgstatus(rs.getString("pg_status"));
            
            //===========
            //LOCACAO
            String query2 = "Select * from locacao where lc_code = "+rs.getInt("lc_code");
            PreparedStatement st2 = this.conn.prepareStatement(query2);
            ResultSet rs2 = st2.executeQuery();
            Locacao l = new Locacao();
            while(rs2.next()){
               l.setLccode(rs2.getInt("lc_code"));
               l.setDtlocacao(rs2.getDate("lc_dtlocacao"));
               l.setDtprevista(rs2.getDate("lc_dtprevista"));
               l.setAglocacao(rs2.getString("lc_aglocacao"));
               l.setAgprevista(rs2.getString("lc_agprevista"));
               l.setTipokm(rs2.getString("lc_tipokm"));
               l.setValor(rs2.getString("lc_valor"));
               l.setDtdevolucao(rs2.getDate("lc_dtdevolucao"));
               l.setAgdevolucao(rs2.getString("lc_agdevolucao"));
               l.setStatus(rs2.getString("lc_status"));
               
               
               
               //============
               //CLIENTE            
               String query3 = "select * from cliente where cl_code = "+rs2.getInt("cl_code");
               PreparedStatement st3 = this.conn.prepareStatement(query3);
               ResultSet rs3 = st3.executeQuery();
               Cliente c = new Cliente();
               while(rs3.next()){
                  c.setCode(rs3.getInt("cl_code")); 
                  c.setCpf(rs3.getString("cl_cpf")); 
                  c.setNome(rs3.getString("cl_nome"));
                  c.setDocumento(rs3.getString("cl_documento"));
                  c.setEmail(rs3.getString("cl_email"));
                  c.setTelefone(rs3.getString("cl_telefone"));
                  c.setNascimento(rs3.getDate("cl_nascimento"));
                  c.setSexo(rs3.getString("cl_sexo"));
                  c.setUfcode(rs3.getString("cl_ufcode"));
                  c.setCidade(rs3.getString("cl_cidade"));
                  c.setEndereco(rs3.getString("cl_endereco"));
                  c.setNumEndereco(rs3.getString("cl_numEndereco"));
                  c.setCadastro(rs3.getDate("cl_cadastro"));
                  c.setHabilitacao(rs3.getString("cl_hb_num"));
                  c.setHabilitacaoValidade(rs3.getDate("cl_hb_validade"));
                  c.setHabilitacaoufcode(rs3.getString("cl_hb_ufcode"));
                  c.setHabilitacaocidade(rs3.getString("cl_hb_cidade"));
                  c.setBairro(rs3.getString("cl_bairro"));
               }
               l.setCliente(c);
            }
            p.setLocacao(l);
            pagamentos.add(p);
         }
      }
      catch(Exception e){   
         System.out.println(e);
      }
      return pagamentos;
   }
   
   
   public boolean realizaPagamentoLocacao(Pagamento p,String tipo){//tipo = C - credito, D - debito
      if(tipo.equals("C")){
         ResultSet rs = null;
         String query = "update locacao set lc_status = ? where lc_code = ?";
         try{
            //TRANSACTION
            conn.setAutoCommit(false);
            this.st = this.conn.prepareStatement(query);
            this.st.setString(1,"P");
            this.st.setInt(2, p.getLocacao().getLccode());
            this.st.executeUpdate();
            this.st.close();
            
            
            Date validadeCartao = null;
            try{  
               DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
               validadeCartao = (java.util.Date)formatter.parse(String.valueOf(p.getPgdatavalidade()));  
            }catch(Exception e){}  
            String queryUpdate = "update pagamento set pg_numerocartao = ?,"+
                                 "pg_datavalidade = ?, pg_codigoseguranca = ?,pg_tipopag = ?,"+
                                 "pg_status = ?, pg_valor = ? where pg_code = ?";
            PreparedStatement st2 = this.conn.prepareStatement(queryUpdate);
            
            st2.setString(1,p.getPgnumerocartao());
            st2.setDate(2,new java.sql.Date(validadeCartao.getTime()));
            st2.setString(3,p.getPgcodigoseguranca());
            st2.setString(4,p.getPgtipopag());
            st2.setString(5,p.getPgstatus());
            st2.setFloat(6,Float.parseFloat(p.getPgvalortot()));
            st2.setInt(7,p.getPgcode());
            st2.executeUpdate();
            conn.commit();
            
            return true;
         }catch(Exception e){
            try{conn.rollback();}catch(Exception e2){}
            System.out.println("Erro:"+e);
            return false;
         }
      }//FIM CREDITO
      
      
      //DEBITO - SEM JUROS
      else{
         ResultSet rs = null;
         String query = "update locacao set lc_status = ? where lc_code = ?";
         try{
            conn.setAutoCommit(false);
            this.st = this.conn.prepareStatement(query);
            this.st.setString(1,"P");
            this.st.setInt(2, p.getLocacao().getLccode());
            this.st.executeUpdate();
            this.st.close();                   
            String queryUpdate = "update pagamento set pg_tipopag = ?,pg_valor = ?, pg_banco = ?, pg_agencia = ?,"+
                                 "pg_conta = ? where pg_code = ?";
            PreparedStatement st2 = this.conn.prepareStatement(queryUpdate);
            st2.setString(1,p.getPgtipopag());
            st2.setFloat(2,Float.parseFloat(p.getPgvalortot()));
            st2.setString(3,p.getPgbanco());
            st2.setString(4,p.getPgagencia());
            st2.setString(5,p.getPgconta());
            st2.setInt(6,p.getPgcode());
            st2.executeUpdate();
            conn.commit();
            return true;
         }catch(Exception e){
            try{conn.rollback();}catch(Exception e2){}
            System.out.println("Erro:"+e);
            return false;
         }
      }//FIM DEBITO      
   }
   
   
   public boolean finalizaPagamento(String codpag,String codLocacao,String tipo,String valor){//TIPO = C - CREDITO, D - DEBITO
      //CREDITO
      String query = "update pagamento set pg_status = 'F', pg_valor = (pg_valor+"+valor+") where pg_code = "+codpag;
      try{
         //TRANSACTION
         conn.setAutoCommit(false);
         this.st = this.conn.prepareStatement(query);
         this.st.executeUpdate();
         this.st.close();
         
         query = "update locacao set lc_status = 'F' where lc_code = "+codLocacao;
         PreparedStatement st2 = this.conn.prepareStatement(query);
         st2.executeUpdate();
         st2.close();
         conn.commit();
         return true;
      }catch(Exception e){
         System.out.println("pDAO 155: "+e);
         try{
            conn.rollback();
         }catch(Exception e2){}
         return false;
      }
   }
   
   private static java.sql.Date getCurrentDate() {
      java.util.Date today = new java.util.Date();
      return new java.sql.Date(today.getTime());
   }
}