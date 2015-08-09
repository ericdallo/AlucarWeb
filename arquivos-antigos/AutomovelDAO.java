import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.*;

public class AutomovelDAO extends MysqlConnect{
   private PreparedStatement st;
   
   public AutomovelDAO(){
      st = null;
   }
   
   public ArrayList<Locacao> relatorioDia(){
      ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
      ResultSet rs = null;
      String query = "select lc_dtprevista,lc_valor,count(*) as total,"+   
                     "(select a.au_fabricante from automovel a where a.au_code = l.au_code) as au_fabricante, "+
                     "(select a.au_modelo from automovel a where a.au_code = l.au_code) as au_modelo, "+
                     "(select c.cl_nome from cliente c where c.cl_code = l.cl_code) as cl_nome, "+
                     "(select c.cl_cpf from cliente c where c.cl_code = l.cl_code) as cl_cpf "+
                     " from locacao l where lc_dtlocacao = (select curdate());";
      try{
         this.st = this.conn.prepareStatement(query);
         rs = this.st.executeQuery();
         while(rs.next()){
            Locacao l = new Locacao();
            Cliente c = new Cliente();
            Automovel a = new Automovel();
            l.setDtprevista(rs.getDate("lc_dtprevista"));
            l.setValor(rs.getString("lc_valor"));
            a.setFabricante(rs.getString("au_fabricante"));
            a.setModelo(rs.getString("au_modelo"));
            c.setNome(rs.getString("cl_nome"));
            c.setCpf(rs.getString("cl_cpf"));				
            l.setAutomovel(a);
            l.setCliente(c);
            locacoes.add(l);
         }
      }catch(Exception e){   
         System.out.println(query);
      }
      return locacoes;
   }
   
   
   public ArrayList<Automovel> consultarAutomovel(String pesquisa, String campo,boolean pesquisando){
      ArrayList<Automovel> automoveis = new ArrayList<Automovel>();
      ResultSet rs = null;
      String order = (campo != "" ? campo : "1");
      String query = "";
      if(!pesquisando){
         query = "Select * from automovel where "+campo+" like '"+pesquisa+"%' order by "+order;
      }else{ 
         query = "select * from automovel where au_code "+
                        " not in(select l.au_code from locacao l where lc_status <> 'F' and lc_status <> 'A') and "+campo+" like"+
                        " '"+pesquisa+"%' order by " + order;
      }
      try{
         this.st = this.conn.prepareStatement(query);
         rs = this.st.executeQuery();
         while(rs.next()){
            Automovel a = new Automovel();
            a.setCode(rs.getInt("au_code")); 
            a.setChassi(rs.getString("au_chassi")); 
            a.setModelo(rs.getString("au_modelo"));
            a.setPlaca(rs.getString("au_placa"));
            a.setGrupo(rs.getString("au_grupo"));
            a.setFabricante(rs.getString("au_fabricante"));
            a.setCidade(rs.getString("au_cidade"));
            a.setEstado(rs.getString("au_estado"));
            a.setKm(rs.getString("au_km"));
            a.setKmlivre(rs.getString("au_kmLivre"));
            a.setKmcontrolado(rs.getString("au_kmControlado"));
            a.setFoto(rs.getString("au_foto"));
            a.setGps(rs.getString("au_gps"));				
            a.setCadeira(rs.getString("au_cadeira"));				
            a.setMotorista(rs.getString("au_motorista"));				
            
            automoveis.add(a);
         }
      }catch(Exception e){   
         System.out.println(query);
      }
      
      return automoveis;
   }
   
   public boolean delete(String codigo){
      ResultSet rs = null;
      String query = "delete from automovel where au_code = ?";
      try{ 
         this.st = this.conn.prepareStatement(query);
         this.st.setInt(1, Integer.parseInt(codigo)); 
         this.st.executeUpdate();
         this.st.close();
         return true;				
		}catch(Exception e){
         System.out.println("a"+e);
         return false;
      }
 
   }
   
   public boolean insert(String[] dados){
      ResultSet rs = null;
      String query = "insert into automovel("+
			"au_code, au_chassi, au_modelo, au_placa, au_grupo," +
         "au_fabricante, au_cidade,au_estado, au_km, au_kmLivre," +
         "au_kmControlado, au_foto, au_gps, au_cadeira, au_motorista)VALUES("+
         "NULL,?,?,?,?,?,?,?,"+
         "?,?,?,?,?,?,?)";
         //System.out.println(query);
         /*
         txtchassi,txtmodelo,txtplaca,txtgrupo,
         txtfabricante,txtcidade,txtestado,txtkm,txtkmlivre,
         txtkmcontrolado,txtfoto,txtgps,txtcadeira,txtmotorista
         */
		try{    
         this.st = this.conn.prepareStatement(query);
         this.st.setString(1, dados[0]);
			this.st.setString(2, dados[1]);
			this.st.setString(3, dados[2]);
			this.st.setString(4, dados[3]);
			this.st.setString(5, dados[4]);
			this.st.setString(6, dados[5]);
			this.st.setString(7, dados[6]);
         this.st.setString(8, dados[7]);
			this.st.setString(9, dados[8]);
			this.st.setString(10, dados[9]);
			this.st.setString(11, dados[10]);
         this.st.setString(12, dados[11]);
         this.st.setString(13, dados[12]);
         this.st.setString(14, dados[13]);										
			//this.st.setInt(15, Integer.parseInt(dados[0]));	
			this.st.executeUpdate();
         this.st.close();
         return true;				
		}catch(Exception e){
         System.out.println(""+e);
         return false;
      }
   }
   
	public boolean update(String[] dados){
		ResultSet rs = null;

      String query = "update automovel "+
			"set "+
			"au_chassi = ? ,"+
			"au_modelo = ? ,"+
			"au_placa = ?,"+
			"au_grupo = ?,"+
			"au_fabricante = ?,"+
			"au_cidade = ?,"+
			"au_estado = ?,"+
			"au_km = ?,"+
			"au_kmlivre = ?,"+
			"au_kmcontrolado = ?,"+
         "au_foto = ? ,"+
         "au_gps = ? ,"+
         "au_cadeira = ? ,"+
         "au_motorista = ? "+						
			"where au_code = ?";
		try{    
         this.st = this.conn.prepareStatement(query);
         this.st.setString(1, dados[1]);
			this.st.setString(2, dados[2]);
			this.st.setString(3, dados[3]);
			this.st.setString(4, dados[4]);
			this.st.setString(5, dados[5]);
			this.st.setString(6, dados[6]);
			this.st.setString(7, dados[7]);
         this.st.setString(8, dados[8]);
			this.st.setString(9, dados[9]);
			this.st.setString(10, dados[10]);
			this.st.setString(11, dados[11]);
         this.st.setString(12, dados[12]);
         this.st.setString(13, dados[13]);
         this.st.setString(14, dados[14]);
			this.st.setInt(15, Integer.parseInt(dados[0]));	
			this.st.executeUpdate();
         this.st.close();
         return true;				
		}catch(Exception e){
         return false;
      }
	}
}  