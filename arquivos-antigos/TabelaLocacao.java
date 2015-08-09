import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
public class TabelaLocacao extends AbstractTableModel {
   
   private ArrayList<Locacao> loc;
      
   public TabelaLocacao(ArrayList<Locacao> l) {
      this.loc = l;
   }
      
   public String getColumnName(int column){
      String[] a = {"Código","Cliente","Carro","Data da Locação","Status"};
      return (column < 5 ? a[column] : "");
   }
         
   public int getColumnCount() {
      return 5;
   }
      

   //CONTA O NUMERO DE LINHAS//
   public int getRowCount() {
      return loc.size();
   }
      
   //COLOCA OS DADOS DO ARRAY EM SUAS DEVIDAS POSIÇÕES//
   /*
   */
   public String getValueAt(int rowIndex, int columnIndex){
      int i = 0;
      Locacao l = new Locacao();
      while(i < loc.size()){
         l = this.loc.get(i);				
         
         //Código","Cliente","Carro","Data da Locação","Status"
         
         if(columnIndex == 0 && rowIndex == i){	
            return String.valueOf(l.getLccode());
         }
         
         if(columnIndex == 1 && rowIndex == i){	
            return l.getCliente().getNome();
         }
         
         if(columnIndex == 2 && rowIndex == i){	
            return String.valueOf(l.getAutomovel().getCode());
         }
         
         if(columnIndex == 3 && rowIndex == i){
            return String.valueOf(l.getDtlocacao());
         }
         
         if(columnIndex == 4 && rowIndex == i){
            if(l.getStatus().substring(0,1).equals("A")){
               return "ABERTO";
            }else if(l.getStatus().substring(0,1).equals("P")){
               return "ALUGADO";
            }else if(l.getStatus().substring(0,1).equals("D")){
               return "DEVOLVIDO";
            }else{
               return "FECHADA";
            }
         }
         i++;		           		
      }
      return "";
   }
   
   public int getTotal(){
      return loc.size();
   }
   
   public Locacao getLinha(int rowIndex){
      Locacao l = loc.get(rowIndex);
      return l;
   }
}
