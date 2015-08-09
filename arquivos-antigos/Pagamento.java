import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;

public class Pagamento{
   private int pgcode;
   private String pgvalortot;
   private String pgtipopag;
   private String pgstatus;
   private String pgnumerocartao;
   private String pgdatavalidade;
   private String pgcodigoseguranca;
   
   private String pgbanco;
   private String pgagencia;
   private String pgconta;
   
   private Locacao locacao;
   
   
   public Pagamento(){
      setLocacao(new Locacao());
   }
   public Pagamento(Locacao locacao){
      setLocacao(locacao);
   }
   
   
   public int getPgcode() {
      return pgcode;
   }
   public void setPgcode(int pgcode) {
      this.pgcode = pgcode;
   }
   public String getPgvalortot() {
      return pgvalortot;
   }
   public void setPgvalortot(String pgvalortot) {
      this.pgvalortot = pgvalortot;
   }
   public String getPgtipopag() {
      return pgtipopag;
   }
   public void setPgtipopag(String pgtipopag) {
      this.pgtipopag = pgtipopag;
   }
   public String getPgstatus() {
      return pgstatus;
   }
   public void setPgstatus(String pgstatus) {
      this.pgstatus = pgstatus;
   }
   
   public Locacao getLocacao(){
      return locacao;
   }
   public void setLocacao(Locacao locacao){
      this.locacao = locacao;
   }
   
   public String getPgnumerocartao(){
      return pgnumerocartao;
   }
   public void setPgnumerocartao(String pgnumerocartao){
      this.pgnumerocartao = pgnumerocartao;
   }
   
   
   public String getPgdatavalidade(){
      return pgdatavalidade;
   }
   public void setPgdatavalidade(String pgdatavalidade){
      this.pgdatavalidade = pgdatavalidade;
   }
   
   public String getPgcodigoseguranca(){
      return pgcodigoseguranca;
   }
   public void setPgcodigoseguranca(String pgcodigoseguranca){
      this.pgcodigoseguranca = pgcodigoseguranca;
   }
   
   
   
   
   public String getPgbanco(){
      return this.pgbanco;
   }
   public void setPgbanco(String pgbanco){
      this.pgbanco = pgbanco;
   }
   
   public String getPgagencia(){
      return this.pgagencia;
   }
   public void setPgagencia(String pgagencia){
      this.pgagencia = pgagencia;
   }
   public String getPgconta(){
      return this.pgconta;
   }
   public void setPgconta(String pgconta){
      this.pgconta = pgconta;
   }
   
   
   
   
   //DISTANCIA ENTRE SP E RJ = 450KM
   public String calculaJuros(){
      Double valor = 0.00;
      String saida = "0.00";
      if(!getLocacao().getAglocacao().equals(getLocacao().getAgdevolucao())){
         valor += 2 * 450;//DISTANCIA ENTRE SP E RJ = 450KM * 2
      }
      
      Date dataLOC = getLocacao().getDtprevista();
      Date dataDEV = getLocacao().getDtdevolucao();
      
      
      int diferencaDeDias;
      diferencaDeDias = (int) ((dataDEV.getTime() - dataLOC.getTime()) / 86400000L);
      if(diferencaDeDias > 0){
         if(diferencaDeDias > 20){
            diferencaDeDias = 20;
         }
         Double porcentagem = Double.parseDouble(getLocacao().getValor()) * 0.01;
         valor += porcentagem * diferencaDeDias;
         saida = valor+"";
         //System.out.println("\n\nDias em atrasao: " + diferencaDeDias+"");
         //System.out.println("Valor inicial da Locacao: "+getLocacao().getValor().toString());
         //System.out.println("1% do valor total: "+porcentagem);
         //System.out.println("Dias em atraso * 1% do valor: "+(porcentagem * diferencaDeDias));
         
         
         
      }
      return ""+saida;
   }
   
   
}

