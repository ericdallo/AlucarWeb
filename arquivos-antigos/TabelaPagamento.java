import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
public class TabelaPagamento extends AbstractTableModel {
   
   private ArrayList<Pagamento> pag;
      
   public TabelaPagamento(ArrayList<Pagamento> pag) {
   	this.pag = pag;
   }
      
   public String getColumnName(int column){
      String[] a = {"Pagamento","Código da Locação","Tipo","Valor Total","Status"};
      return (column < 5 ? a[column] : "");
   }
         
   public int getColumnCount() {
      return 5;
   }
      

   //CONTA O NUMERO DE LINHAS//
   public int getRowCount() {
      return pag.size();
   }
      
   //COLOCA OS DADOS DO ARRAY EM SUAS DEVIDAS POSIÇÕES//
   public String getValueAt(int rowIndex, int columnIndex){
      int i = 0;
      Pagamento p = new Pagamento();
      while(i < pag.size()){
         p = this.pag.get(i);				
         if(columnIndex == 0 && rowIndex == i){	
            return String.valueOf(p.getPgcode());
         }
         
         if(columnIndex == 1 && rowIndex == i){	
            return String.valueOf(p.getLocacao().getLccode());
         }
         
         if(columnIndex == 2 && rowIndex == i){
            return String.valueOf(p.getPgtipopag());
         }
         
         if(columnIndex == 3 && rowIndex == i){
            return String.valueOf(p.getPgvalortot());
         }
         
         if(columnIndex == 4 && rowIndex == i){	
            return String.valueOf(p.getPgstatus());
         }
         i++;		           		
	   }
      return "";
   } 
   
   public Pagamento getLinha(int rowIndex){
      Pagamento p = pag.get(rowIndex);
      return p;
   }
}
