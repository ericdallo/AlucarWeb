public class Usuario{
   private String login;
   private String senha;
   private String nivel;
   
   public Usuario(){
      setLogin("");
      setSenha("");
      setNivel("");
   }
   
   public Usuario(String login, String senha,String nivel){
      setLogin(login);
      setSenha(senha);
      setNivel(nivel);
   }
   
   public void setLogin(String login){
      this.login = login;
   }
   
   public String getLogin(){
      return this.login;
   }
   
   public void setSenha(String senha){
      this.senha = senha;
   }
   
   public String getSenha(){
      return this.senha;
   }
   
   public void setNivel(String nivel){
      this.nivel = nivel;
   }
   
   public String getNivel(){
      return this.nivel;
   }
}