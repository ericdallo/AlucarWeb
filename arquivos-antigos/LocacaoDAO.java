import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.Date;
import java.util.*;

public class LocacaoDAO extends MysqlConnect{
   private PreparedStatement st;
   
   public LocacaoDAO(){
      st = null;
   }
   
   public ArrayList<Locacao> consultarLocacao(String pesquisa, String campo){
      ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
      ResultSet rs = null;
      String order = (campo != "" ? campo : "1");
      String query = "";
      if(campo.equals("cl_nome")){
         query = "select lc_code, cl_code, au_code, pg_code,"+
                  "lc_dtlocacao,lc_dtprevista,lc_aglocacao,lc_agprevista,lc_tipokm,lc_valor,pg_code,lc_dtdevolucao,lc_agdevolucao,"+
                  "lc_status  from locacao l where l.cl_code in(select c.cl_code from cliente c where c.cl_nome like '"+pesquisa+"%')";
      }else{
         query = "select lc_code, cl_code, au_code, pg_code,"+
                        "lc_dtlocacao,lc_dtprevista,lc_aglocacao,lc_agprevista,lc_tipokm,lc_valor,pg_code,lc_dtdevolucao,lc_agdevolucao,"+
                        "lc_status  from locacao where "+campo+" like '"+pesquisa+"%' order by "+order;
      }
      try{
         this.st = this.conn.prepareStatement(query);
         rs = this.st.executeQuery();
         while(rs.next()){
            Locacao l = new Locacao();
            l.setLccode(rs.getInt("lc_code"));
            
            //===================================
            //BUSCA CLIENTE
            String queryCliente = "select * from cliente where cl_code = "+String.valueOf(rs.getInt("cl_code"));
            PreparedStatement stCliente = this.conn.prepareStatement(queryCliente);
            ResultSet rsCliente = stCliente.executeQuery();
            Cliente c = new Cliente();
            while(rsCliente.next()){
               c.setCode(rsCliente.getInt("cl_code")); 
               c.setCpf(rsCliente.getString("cl_cpf")); 
               c.setNome(rsCliente.getString("cl_nome"));
               c.setDocumento(rsCliente.getString("cl_documento"));
               c.setEmail(rsCliente.getString("cl_email"));
               c.setTelefone(rsCliente.getString("cl_telefone"));
               c.setNascimento(rsCliente.getDate("cl_nascimento"));
               c.setSexo(rsCliente.getString("cl_sexo"));
               c.setUfcode(rsCliente.getString("cl_ufcode"));
               c.setCidade(rsCliente.getString("cl_cidade"));
               c.setEndereco(rsCliente.getString("cl_endereco"));
               c.setNumEndereco(rsCliente.getString("cl_numEndereco"));
               c.setCadastro(rsCliente.getDate("cl_cadastro"));
               c.setHabilitacao(rsCliente.getString("cl_hb_num"));
               c.setHabilitacaoValidade(rsCliente.getDate("cl_hb_validade"));
               c.setHabilitacaoufcode(rsCliente.getString("cl_hb_ufcode"));
               c.setHabilitacaocidade(rsCliente.getString("cl_hb_cidade"));
               c.setBairro(rsCliente.getString("cl_bairro"));
            }
            l.setCliente(c);
            //===================================
            
            
            
            
            //===================================
            //BUSCA AUTOMOVEL
            String queryCar = "Select * from automovel where au_code = "+String.valueOf(rs.getInt("au_code"));
            PreparedStatement stCar = this.conn.prepareStatement(queryCar);
            ResultSet rsCar = stCar.executeQuery();
            Automovel a = new Automovel();
            while(rsCar.next()){
               a.setCode(rsCar.getInt("au_code")); 
               a.setChassi(rsCar.getString("au_chassi")); 
               a.setModelo(rsCar.getString("au_modelo"));
               a.setPlaca(rsCar.getString("au_placa"));
               a.setGrupo(rsCar.getString("au_grupo"));
               a.setFabricante(rsCar.getString("au_fabricante"));
               a.setCidade(rsCar.getString("au_cidade"));
               a.setEstado(rsCar.getString("au_estado"));
               a.setKm(rsCar.getString("au_km"));
               a.setKmlivre(rsCar.getString("au_kmLivre"));
               a.setKmcontrolado(rsCar.getString("au_kmControlado"));
               a.setFoto(rsCar.getString("au_foto"));
               a.setGps(rsCar.getString("au_gps"));
               a.setCadeira(rsCar.getString("au_cadeira"));
               a.setMotorista(rsCar.getString("au_motorista"));															
            }
            l.setAutomovel(a);
            //===================================
            
            
            
            
            //===================================
            //BUSCA PAGAMENTO
            String queryPag = "Select * from pagamento where pg_code = "+String.valueOf(rs.getInt("pg_code"));
            PreparedStatement stPag = this.conn.prepareStatement(queryPag);
            ResultSet rsPag = stPag.executeQuery();
            Pagamento p = new Pagamento();
            while(rsPag.next()){
            }
            l.setPagamento(p);
            //===================================            
            
            l.setDtlocacao(rs.getDate("lc_dtlocacao"));
            l.setDtprevista(rs.getDate("lc_dtprevista"));
            l.setAglocacao(rs.getString("lc_aglocacao"));
            l.setAgprevista(rs.getString("lc_agprevista"));
            l.setTipokm(rs.getString("lc_tipokm"));
            l.setValor(rs.getString("lc_valor"));
            l.setDtdevolucao(rs.getDate("lc_dtdevolucao"));
            l.setAgdevolucao(rs.getString("lc_agdevolucao"));
            l.setStatus(rs.getString("lc_status"));            
            
            locacoes.add(l);
         }
      }
      catch(Exception e){   
         System.out.println(e);
      }
      
      return locacoes;
   }
   
   
   public boolean update(String[] dados){
      ResultSet rs = null;
      String query = "update locacao "+
         "set "+
         "cl_code = ? ,"+
         "au_code = ?,"+
         "lc_dtlocacao = ?,"+
         "lc_dtprevista = ?,"+
         "lc_aglocacao = ?,"+
         "lc_agprevista = ?,"+
         "lc_tipokm = ?,"+
         "lc_valor = ?,"+
         "pg_code = null,"+
         "lc_dtdevolucao = null,"+
         "lc_agdevolucao = null,"+
         "lc_status = ?"+
         "where lc_code = ?";
      try{  
         Date lc_dtlocacao = null, lc_dtprevista = null;  
         try{  
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            lc_dtlocacao = (java.util.Date)formatter.parse(dados[3]);  
            lc_dtprevista = (java.util.Date)formatter.parse(dados[4]);  
         }
         catch(Exception e){
            throw e;  
         }  
         this.st = this.conn.prepareStatement(query);
         this.st.setInt(1, Integer.parseInt(dados[1]));//cli code
         this.st.setInt(2, Integer.parseInt(dados[2]));//car code
         this.st.setDate(3, new java.sql.Date(lc_dtlocacao.getTime()));//data locacao
         this.st.setDate(4, new java.sql.Date(lc_dtprevista.getTime()));//data prevista
         this.st.setString(5, dados[5]);//agnc locacao
         this.st.setString(6, dados[6]);//agnc prevista
         
         this.st.setString(7, dados[7]);//tipo km
         this.st.setString(8, dados[8]);//valor
         this.st.setString(9, dados[9].substring(0,1));//status
         this.st.setString(10, dados[0]);//locacao cod - where
         this.st.executeUpdate();
         this.st.close();
         return true;				
      }
      catch(Exception e){
         System.out.println("\n\nErro: "+e);
         return false;
      }
   }
   
   
   
   
   public boolean delete(String codigo){
      ResultSet rs = null;
      String query = "delete from locacao where lc_code = ?";
      try{ 
         this.st = this.conn.prepareStatement(query);
         this.st.setInt(1, Integer.parseInt(codigo)); 
         this.st.executeUpdate();
         this.st.close();
         return true;				
      }
      catch(Exception e){
         return false;
      }
   }
   
   public boolean insert(String[] dados){
      ResultSet rs = null;
      String query = "insert into locacao( "+
         "cl_code,au_code,lc_dtlocacao,lc_dtprevista,lc_aglocacao,"+
         "lc_agprevista,lc_tipokm,lc_valor,pg_code,lc_dtdevolucao,"+
         "lc_agdevolucao,lc_status,lc_code)VALUES("+
         "?,?,?,?,?,"+
         "?,?,?,null,null,"+
         "null,?,null)";
   		
      try{  
         //TRANSACTION
         conn.setAutoCommit(false);
         
         
         Date lc_dtlocacao = null, lc_dtprevista = null;  
         try{  
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            lc_dtlocacao = (java.util.Date)formatter.parse(dados[3]);  
            lc_dtprevista = (java.util.Date)formatter.parse(dados[4]);  
         }
         catch(Exception e){
            throw e;  
         }  
         this.st = this.conn.prepareStatement(query);
         this.st.setInt(1, Integer.parseInt(dados[1]));//cli code
         this.st.setInt(2, Integer.parseInt(dados[2]));//car code
         this.st.setDate(3, new java.sql.Date(lc_dtlocacao.getTime()));//data locacao
         this.st.setDate(4, new java.sql.Date(lc_dtprevista.getTime()));//data prevista
         this.st.setString(5, dados[5]);//agnc locacao
         this.st.setString(6, dados[6]);//agnc prevista
         this.st.setString(7, dados[7]);//tipo km
         this.st.setString(8, dados[8]);//valor
         this.st.setString(9, "A");//status
         this.st.executeUpdate();
         this.st.close();
         
         
         //QUERY PARA INSERIR UM PAGAMENTO
         String queryLocacao = "select max(lc_code) as max from locacao";
         ResultSet rs2 = null;
         PreparedStatement st2 = this.conn.prepareStatement(queryLocacao);
         rs2 = st2.executeQuery();
         while(rs2.next()){
            String queryPag = "insert into pagamento("+
                           "pg_code,lc_code,pg_status)VALUES("+
                           "null,?,?)";
            PreparedStatement st3 = this.conn.prepareStatement(queryPag);
            st3.setInt(1,rs2.getInt("max"));
            st3.setString(2,"A");
            st3.executeUpdate();
            st3.close();
            
            
            
            String queryAux = "select max(pg_code) as max from pagamento";
            ResultSet rs4 = null;
            PreparedStatement st4 = this.conn.prepareStatement(queryAux);
            rs4 = st4.executeQuery();
            while(rs4.next()){
               String queryUpdate = "update locacao set pg_code = ? where lc_code = ?";
               PreparedStatement st5 = this.conn.prepareStatement(queryUpdate);
               st5.setInt(1,rs4.getInt("max"));
               st5.setInt(2,rs2.getInt("max"));
               st5.executeUpdate();
               conn.commit();
            }
         }
         
         return true;				
      }
      catch(Exception e){
         try{
            conn.rollback();
         }
         catch(Exception e2){}
         System.out.println("\n\nErro: "+e);
         return false;
      }
   }
   
	
   public Date baixaLocacao(Locacao l,String data){
      ResultSet rs = null;
      String query = "update locacao set lc_dtdevolucao = '"+data+"', lc_agdevolucao = ?, lc_status = ? where lc_code = ?";
      try{  
         this.st = this.conn.prepareStatement(query);
         this.st.setString(1,l.getAgdevolucao());
         this.st.setString(2,"D");
         this.st.setInt(3,l.getLccode());
         this.st.executeUpdate();
         this.st.close();
         
         String query2 = "select lc_dtdevolucao from locacao where lc_code = "+l.getLccode();
         PreparedStatement st2 = this.conn.prepareStatement(query2);
         ResultSet rs2 = st2.executeQuery();
         Locacao l2 = new Locacao();
         l2 = l;
         Date d = null;
         while(rs2.next()){
            l2.setDtlocacao(rs2.getDate("lc_dtdevolucao"));
            d = rs2.getDate("lc_dtdevolucao");
            System.out.println(l2.getDtlocacao()+"");
         }
         return d;
      }
      catch(Exception e2){
         System.out.println("\n\nErro: "+e2);
         Date d = null;
         return d;
      }
   }
   
    
   private static java.sql.Date getCurrentDate() {
      java.util.Date today = new java.util.Date();
      return new java.sql.Date(today.getTime());
   }
}