import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TabelaAutomovel extends AbstractTableModel {
   
   private ArrayList<Automovel> aut;
      
   public TabelaAutomovel(ArrayList<Automovel> a) {
   	this.aut = a;
   }
      
   public String getColumnName(int column){
      String[] a = {"Código","Chassi","Modelo","Placa","Fabricante"};
      return (column < 5 ? a[column] : "");
/*      if (column == 0){return "Código";}
      else if(column == 1){return "Nome";}
      else if(column == 2){return "Cpf";}
      else if(column == 3){return "Documento";}
      else if(column == 4){return "Telefone";}
      return "";*/
   }
         
   public int getColumnCount() {
      return 6;
   }
      

   //CONTA O NUMERO DE LINHAS//
   public int getRowCount() {
      return aut.size();
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
      Automovel a = new Automovel();
         while(i < aut.size()){
            a = this.aut.get(i);				
            if(columnIndex == 0 && rowIndex == i){	
               return String.valueOf(a.getCode());
            }
            
            if(columnIndex == 1 && rowIndex == i){	
               return a.getChassi();
            }
            
            if(columnIndex == 2 && rowIndex == i){	
               return a.getModelo();
            }
            
            if(columnIndex == 3 && rowIndex == i){	
               return a.getPlaca();
            }
            
            if(columnIndex == 4 && rowIndex == i){
               return a.getFabricante();
            }
            
            //ESSAS COLUNAS DE BAIXO SAO INVISIVEIS NA TABELA
            if(columnIndex == 5 && rowIndex == i){
               return a.getGrupo();
            }
            
            if(columnIndex == 6 && rowIndex == i){
               return a.getCidade();
            }
            
            if(columnIndex == 7 && rowIndex == i){
               return a.getEstado();
            }
            
            if(columnIndex == 8 && rowIndex == i){
               return a.getKm();
            }
            
            if(columnIndex == 9 && rowIndex == i){
               return a.getKmlivre();
            }
            
            if(columnIndex == 10 && rowIndex == i){
               return a.getKmcontrolado();
            }
            if(columnIndex == 11 && rowIndex == i){
               return a.getFoto();
            }
            if(columnIndex == 12 && rowIndex == i){
               return a.getGps();
            }
				if(columnIndex == 13 && rowIndex == i){
               return a.getCadeira();
            }
				if(columnIndex == 14 && rowIndex == i){
               return a.getMotorista();
            }
            i++;		           		
		   }
      return "";
   }
   
   public int getTotal(){
      return aut.size();
   }
   
   public Automovel getAut(int rowIndex){
      Automovel a = new Automovel();
      a = aut.get(rowIndex);
      return a;
   }
}
