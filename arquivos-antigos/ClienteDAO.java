import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.Date;

public class ClienteDAO extends MysqlConnect{
   private PreparedStatement st;
   
   public ClienteDAO(){
      st = null;
   }
   
   public ArrayList<Cliente> consultarCliente(String pesquisa, String campo){
      ArrayList<Cliente> clientes = new ArrayList<Cliente>();
      ResultSet rs = null;
      String order = (campo != "" ? campo : "1");
      String query = "Select * from cliente where "+campo+" like '"+pesquisa+"%' order by "+order;
      try{
         this.st = this.conn.prepareStatement(query);
         rs = this.st.executeQuery();
         while(rs.next()){
            Cliente c = new Cliente();
            c.setCode(rs.getInt("cl_code")); 
            c.setCpf(rs.getString("cl_cpf")); 
            c.setNome(rs.getString("cl_nome"));
            c.setDocumento(rs.getString("cl_documento"));
            c.setEmail(rs.getString("cl_email"));
            c.setTelefone(rs.getString("cl_telefone"));
            c.setNascimento(rs.getDate("cl_nascimento"));
            c.setSexo(rs.getString("cl_sexo"));
            c.setUfcode(rs.getString("cl_ufcode"));
            c.setCidade(rs.getString("cl_cidade"));
            c.setEndereco(rs.getString("cl_endereco"));
            c.setNumEndereco(rs.getString("cl_numEndereco"));
            c.setCadastro(rs.getDate("cl_cadastro"));
            c.setHabilitacao(rs.getString("cl_hb_num"));
            c.setHabilitacaoValidade(rs.getDate("cl_hb_validade"));
            c.setHabilitacaoufcode(rs.getString("cl_hb_ufcode"));
            c.setHabilitacaocidade(rs.getString("cl_hb_cidade"));
            c.setBairro(rs.getString("cl_bairro"));
            
            clientes.add(c);
         }
      }catch(Exception e){   
         System.out.println(query);
      }
      
      return clientes;
   }
   
   public boolean delete(String codigo){
      ResultSet rs = null;
      String query = "delete from cliente where cl_code = ?";
      try{ 
         this.st = this.conn.prepareStatement(query);
         this.st.setInt(1, Integer.parseInt(codigo)); 
         this.st.executeUpdate();
         this.st.close();
         return true;				
		}catch(Exception e){
         return false;
      }
 
   }
   
   public boolean insert(String[] dados){
      ResultSet rs = null;
      String query = "insert into cliente("+
			"cl_code,cl_cpf,cl_nome,cl_documento,cl_email,cl_telefone,cl_nascimento,cl_sexo,"+
			"cl_ufcode,cl_cidade,cl_endereco,cl_numEndereco,cl_cadastro,cl_hb_num,"+
			"cl_hb_validade,cl_hb_ufcode,cl_hb_cidade,cl_bairro)VALUES("+
         "NULL,?,?,?,?,?,?,?,"+
         "?,?,?,?,?,?,"+
         "?,?,?,?)";
         //System.out.println(query);
		try{  
         Date nascimento = null, cadastro = null, cnh = null;  
         try{  
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            nascimento = (java.util.Date)formatter.parse(dados[6]);  
            cadastro = (java.util.Date)formatter.parse(dados[12]);  
            cnh = (java.util.Date)formatter.parse(dados[14]);  
         }catch (ParseException e) {              
            throw e;
              
         }  
         this.st = this.conn.prepareStatement(query);
         this.st.setString(1, dados[2]);
			this.st.setString(2, dados[1]);
			this.st.setString(3, dados[3]);
			this.st.setString(4, dados[5]);
			this.st.setString(5, dados[4]);
			this.st.setDate(6, new java.sql.Date(nascimento.getTime()));
			this.st.setString(7, dados[7]);
         this.st.setString(8, dados[8]);
			this.st.setString(9, dados[9]);
			this.st.setString(10, dados[10]);
			this.st.setString(11, dados[11]);
			this.st.setDate(12, new java.sql.Date(cadastro.getTime()));
			this.st.setString(13, dados[13]);
			this.st.setDate(14, new java.sql.Date(cnh.getTime()));
			this.st.setString(15, dados[15]);
			this.st.setString(16, dados[16]);
			this.st.setString(17, dados[17]);	
			//this.st.setInt(18, Integer.parseInt(dados[0]));	
			this.st.executeUpdate();
         this.st.close();
         return true;				
		}catch(Exception e){
         return false;
      }
   }
   
	public boolean update(String[] dados){
		ResultSet rs = null;

      String query = "update cliente "+
			"set "+
			"cl_cpf = ? ,"+
			"cl_nome = ? ,"+
			"cl_documento = ?,"+
			"cl_email = ?,"+
			"cl_telefone = ?,"+
			"cl_nascimento = ?,"+
			"cl_sexo = ?,"+
			"cl_ufcode = ?,"+
			"cl_cidade = ?,"+
			"cl_endereco = ?,"+
			"cl_numEndereco = ?,"+
			"cl_cadastro = ?,"+
			"cl_hb_num = ?,"+
			"cl_hb_validade = ?,"+
			"cl_hb_ufcode = ?,"+
			"cl_hb_cidade = ?,"+
			"cl_bairro = ?"+
			"where cl_code = ?";
		try{  
         Date nascimento = null, cadastro = null, cnh = null;  
         try{  
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            nascimento = (java.util.Date)formatter.parse(dados[6]);  
            cadastro = (java.util.Date)formatter.parse(dados[12]);  
            cnh = (java.util.Date)formatter.parse(dados[14]);  
         }catch(Exception e){
            throw e;  
         }  
         this.st = this.conn.prepareStatement(query);
         this.st.setString(1, dados[2]);
			this.st.setString(2, dados[1]);
			this.st.setString(3, dados[3]);
			this.st.setString(4, dados[5]);
			this.st.setString(5, dados[4]);
			this.st.setDate(6, new java.sql.Date(nascimento.getTime()));
			this.st.setString(7, dados[7]);
         this.st.setString(8, dados[8]);
			this.st.setString(9, dados[9]);
			this.st.setString(10, dados[10]);
			this.st.setString(11, dados[11]);
			this.st.setDate(12, new java.sql.Date(cadastro.getTime()));
			this.st.setString(13, dados[13]);
			this.st.setDate(14, new java.sql.Date(cnh.getTime()));
			this.st.setString(15, dados[15]);
			this.st.setString(16, dados[16]);
			this.st.setString(17, dados[17]);	
			this.st.setInt(18, Integer.parseInt(dados[0]));	
			this.st.executeUpdate();
         this.st.close();
         return true;				
		}catch(Exception e){
         return false;
      }
	}
   
   
    
   private static java.sql.Date getCurrentDate() {
      java.util.Date today = new java.util.Date();
      return new java.sql.Date(today.getTime());
   }
}  