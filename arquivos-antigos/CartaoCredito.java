public class CartaoCredito extends Pagamento{
   private String banco;
   private String agencia; 
   private String contaCorrente;
   private String telefone;
   
   
   public CartaoCredito(){
      super();
   }   
   
   public String getBanco(){
      return banco;
   }
   public void setBanco(String banco){
      this.banco = banco;
   }
   
   public String getAgencia(){
      return agencia;
   }
   public void setAgencia(String agencia){
      this.agencia = agencia;
   }
   
   public String getContacorrente(){
      return contaCorrente;
   }
   public void setContacorrente(String contaCorrente){
      this.contaCorrente = contaCorrente;
   }
   
   public String getTelefone(){
      return telefone;
   }
   public void setTelefone(String telefone){
      this.telefone = telefone;
   }
}