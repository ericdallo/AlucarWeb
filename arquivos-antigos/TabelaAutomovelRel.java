import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TabelaAutomovelRel extends AbstractTableModel {
   
   private ArrayList<Locacao> loc;
      
   public TabelaAutomovelRel(ArrayList<Locacao> l) {
   	this.loc = l;
   }
      
   public String getColumnName(int column){
      String[] a = {"Marca","Modelo","Nome","Cpf","Data prevista","Valor estimado"};
      return (column < 6 ? a[column] : "");
   }
         
   public int getColumnCount() {
      return 6;
   }
      

   //CONTA O NUMERO DE LINHAS//
   public int getRowCount() {
      return loc.size();
   }
      
   public String getValueAt(int rowIndex, int columnIndex){
      int i = 0;
      Locacao l = new Locacao();
//    "Marca","Modelo","Nome","Cpf","Data prevista","Valor estimado"
      while(i < loc.size()){
         l = this.loc.get(i);				
         if(columnIndex == 0 && rowIndex == i){	
            return String.valueOf(l.getAutomovel().getFabricante());
         }
         
         if(columnIndex == 1 && rowIndex == i){	
            return String.valueOf(l.getAutomovel().getModelo());
         }
         
         if(columnIndex == 2 && rowIndex == i){	
            return String.valueOf(l.getCliente().getNome());
         }
         
         if(columnIndex == 3 && rowIndex == i){	
            return String.valueOf(l.getCliente().getCpf());
         }
         
         if(columnIndex == 4 && rowIndex == i){
            if(String.valueOf(l.getDtprevista()).equals("null")){
               return "";
            }else{
               String a[] = String.valueOf(l.getDtprevista()).split("-");
               System.out.println(a[0]);
               return a[2]+"/"+a[1]+"/"+a[0];
            }
         }
         
         if(columnIndex == 5 && rowIndex == i){
            if(String.valueOf(l.getValor()).equals("null"))
               return ""; 
            else
               return String.valueOf(l.getValor());
         }
         i++;		           		
	   }
      return "";
   }
   
   public int getTotal(){
      return loc.size();
   }
   
   public Locacao getLoc(int rowIndex){
      Locacao l = new Locacao();
      l = loc.get(rowIndex);
      return l;
   }
}
