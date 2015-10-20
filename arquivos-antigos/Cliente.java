import java.util.Date;

public class Cliente{
   private int    code;
   private String cpf;
   private String nome;
   private String documento;
   private String email;
   private String telefone;
   private Calendar nascimento;
   private String sexo;
   private String ufcode;
   private String cidade;
   private String endereco;
   private String numEndereco;
   private Calendar cadastro;
   private String habilitacao;
   private Date   habilitacaoValidade;
   private String habilitacaoufcode;
   private String habilitacaocidade;
   private String bairro;
   
   
   
   public int getCode() {
      return code;
   }
   public void setCode(int code) {
      this.code = code;
   }
   public String getCpf() {
      return cpf;
   }
   public void setCpf(String cpf) {
      this.cpf = cpf;
   }
   public String getNome() {
      return nome;
   }
   public void setNome(String nome) {
      this.nome = nome;
   }
   public String getDocumento() {
      return documento;
   }
   public void setDocumento(String documento) {
      this.documento = documento;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getTelefone() {
      return telefone;
   }
   public void setTelefone(String telefone) {
      this.telefone = telefone;
   }
   public Calendar getNascimento() {
      return nascimento;
   }
   public void setNascimento(Calendar nascimento) {
      this.nascimento = nascimento;
   }
   public String getSexo() {
      return sexo;
   }
   public void setSexo(String sexo) {
      this.sexo = sexo;
   }
   public String getUfcode() {
      return ufcode;
   }
   public void setUfcode(String ufcode) {
      this.ufcode = ufcode;
   }
   public String getCidade() {
      return cidade;
   }
   public void setCidade(String cidade) {
      this.cidade = cidade;
   }
   public String getEndereco() {
      return endereco;
   }
   public void setEndereco(String endereco) {
      this.endereco = endereco;
   }
   public String getNumEndereco() {
      return numEndereco;
   }
   public void setNumEndereco(String numEndereco) {
      this.numEndereco = numEndereco;
   }
   public Date getCadastro() {
      return cadastro;
   }
   public void setCadastro(Date cadastro) {
      this.cadastro = cadastro;
   }
   public String getHabilitacao() {
      return habilitacao;
   }
   public void setHabilitacao(String habilitacao) {
      this.habilitacao = habilitacao;
   }
   public Date getHabilitacaoValidade() {
      return habilitacaoValidade;
   }
   public void setHabilitacaoValidade(Date habilitacaoValidade) {
      this.habilitacaoValidade = habilitacaoValidade;
   }
   public String getHabilitacaoufcode(){
      return habilitacaoufcode;
   } 
   public void setHabilitacaoufcode(String habilitacaoufcode){
      this.habilitacaoufcode = habilitacaoufcode;
   }
   public String getHabilitacaocidade(){
      return habilitacaocidade;
   }
   public void setHabilitacaocidade(String habilitacaocidade){
      this.habilitacaocidade = habilitacaocidade;
   }
   public String getBairro() {
      return bairro;
   }
   public void setBairro(String bairro) {
      this.bairro = bairro;
   }
	
	
}