import java.util.Date;
public class Locacao{   
   private Cliente cliente;
   private Automovel automovel;
   private Pagamento pagamento;   
         
   private int lccode;
   private Date dtlocacao;
   private Date dtprevista;
   private String aglocacao;
   private String agprevista;
   private String tipokm;
   private String valor;
   private Date dtdevolucao;
   private String agdevolucao;
   private String status;
  
   public Locacao(){
      setCliente(new Cliente());
      setAutomovel(new Automovel());
   }
   
   public Locacao(Cliente c, Automovel a){
      setCliente(c);
      setAutomovel(a);
   }
   
   
   ///OBJETOS LIGADOS A CLASSE DE LOCACAO, ONDE SERA PEGO TODOS OS DADOS
   public Cliente getCliente(){
      return cliente;
   }
   public void setCliente(Cliente cliente){
      this.cliente = cliente;
   }
   
   public Automovel getAutomovel(){
      return automovel;
   }
   public void setAutomovel(Automovel automovel){
      this.automovel = automovel;
   }
   
   public Pagamento getPagamento(){
      return pagamento;
   }
   public void setPagamento(Pagamento pagamento){
      this.pagamento = pagamento;
   }
   //////////////////////////////
   
   
    
   public int getLccode(){
      return lccode;
   }
   public void setLccode(int lccode){
      this.lccode = lccode;
   }
   public Date getDtlocacao() {
      return dtlocacao;
   }
   public void setDtlocacao(Date dtlocacao) {
      this.dtlocacao = dtlocacao;
   }
   public Date getDtprevista() {
      return dtprevista;
   }
   public void setDtprevista(Date dtprevista) {
      this.dtprevista = dtprevista;
   }
   public String getAglocacao() {
      return aglocacao;
   }
   public void setAglocacao(String aglocacao) {
      this.aglocacao = aglocacao;
   }
   public String getAgprevista() {
      return agprevista;
   }
   public void setAgprevista(String agprevista) {
      this.agprevista = agprevista;
   }
   public String getTipokm() {
      return tipokm;
   }
   public void setTipokm(String tipokm) {
      this.tipokm = tipokm;
   }
   public String getValor() {
      return valor;
   }
   public void setValor(String valor) {
      this.valor = valor;
   }
   public Date getDtdevolucao() {
      return dtdevolucao;
   }
   public void setDtdevolucao(Date dtdevolucao) {
      this.dtdevolucao = dtdevolucao;
   }
   public String getAgdevolucao() {
      return agdevolucao;
   }
   public void setAgdevolucao(String agdevolucao) {
      this.agdevolucao = agdevolucao;
   }
   public String getStatus() {
      return status;
   }
   public void setStatus(String status) {
      this.status = status;
   }
}