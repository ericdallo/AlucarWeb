import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
public class TabelaCliente extends AbstractTableModel {
   private ResourceBundle bn = null;
	private ArrayList<Cliente> cli;
	
	public String bn(String str){
      return getBundle().getString(str);
   }
   public void setBundle(ResourceBundle bn){
		this.bn = bn;
	}
	public ResourceBundle getBundle(){
		return this.bn;
	}
	
   
      
   public TabelaCliente(ArrayList<Cliente> c) {
   	this.cli = c;
   }
	
	public TabelaCliente(ArrayList<Cliente> c,ResourceBundle bn) {
   	this.cli = c;
		setBundle(bn);
   }
      
   public String getColumnName(int column){
      String[] a = {bn("tab.cod"),bn("tab.nome"),bn("tab.cpf"),bn("tab.doc"),bn("tab.tel")};
      return (column < 5 ? a[column] : "");
/*      if (column == 0){return "Código";}
      else if(column == 1){return "Nome";}
      else if(column == 2){return "Cpf";}
      else if(column == 3){return "Documento";}
      else if(column == 4){return "Telefone";}
      return "";*/
   }
         
   public int getColumnCount() {
      return 5;
   }
      

   //CONTA O NUMERO DE LINHAS//
   public int getRowCount() {
      return cli.size();
   }
      
   //COLOCA OS DADOS DO ARRAY EM SUAS DEVIDAS POSIÇÕES//
   /*
   CL_CODE, CL_NOME, CL_CPF, CL_DOCUMENTO, CL_TELEFONE, 
   CL_EMAIL,CL_NASCIMENTO,CL_SEXO,CL_UFCODE, CL_CIDADE,
   CL_ENDERECO,CL_NUMENDERECO,CL_CADASTRO,CL_HB_NUM,CL_HB_VALIDADE
   A,CL_HB_UFCODE, CL_HB_CIDADE,CL_BAIRRO
   */
   public String getValueAt(int rowIndex, int columnIndex){
      int i = 0;
      Cliente c = new Cliente();
      //System.out.println(""+cli.size());
         while(i < cli.size()){
            c = this.cli.get(i);				
            if(columnIndex == 0 && rowIndex == i){	
               return String.valueOf(c.getCode());
            }
            
            if(columnIndex == 1 && rowIndex == i){	
               return c.getNome();
            }
            
            if(columnIndex == 2 && rowIndex == i){	
               return c.getCpf();
            }
            
            if(columnIndex == 3 && rowIndex == i){
               return c.getDocumento();
            }
            
            if(columnIndex == 4 && rowIndex == i){
               return c.getTelefone();
            }
            
            //ESSAS COLUNAS DE BAIXO SAO INVISIVEIS NA TABELA
            if(columnIndex == 5 && rowIndex == i){
               return c.getEmail();
            }
            
            if(columnIndex == 6 && rowIndex == i){
               return String.valueOf(c.getNascimento());
            }
            
            if(columnIndex == 7 && rowIndex == i){
               return c.getSexo();
            }
            
            if(columnIndex == 8 && rowIndex == i){
               return String.valueOf(c.getUfcode());
            }
            
            if(columnIndex == 9 && rowIndex == i){
               return String.valueOf(c.getCidade());
            }
            
            if(columnIndex == 10 && rowIndex == i){
               return String.valueOf(c.getEndereco());
            }
            
            if(columnIndex == 11 && rowIndex == i){
               return String.valueOf(c.getNumEndereco());
            }
            
            if(columnIndex == 12 && rowIndex == i){
               return String.valueOf(c.getCadastro());
            }
            
            if(columnIndex == 13 && rowIndex == i){
               return String.valueOf(c.getHabilitacao());
            }
            
            if(columnIndex == 14 && rowIndex == i){
               return String.valueOf(c.getHabilitacaoValidade());
            }
            
            if(columnIndex == 15 && rowIndex == i){
               return String.valueOf(c.getHabilitacaoufcode());
            }
            
            if(columnIndex == 16 && rowIndex == i){
               return String.valueOf(c.getHabilitacaocidade());
            }
            
            if(columnIndex == 17 && rowIndex == i){
               return String.valueOf(c.getBairro());
            }
            
            i++;		           		
		   }
      return "";
   }
   
   public int getTotal(){
      return cli.size();
   }
   
   public Cliente getCli(int rowIndex){
      Cliente c = new Cliente();
      c = cli.get(rowIndex);
      return c;
   }
}
