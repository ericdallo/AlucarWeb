import java.io.*; 
import javax.crypto.*; 
import javax.crypto.spec.*; 
import java.security.*; 
import java.security.cert.*; 
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.*;
import java.util.ArrayList; 
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;


public class AES{
   private byte[] textoCifrado; 
   private byte[] textoDecifrado; 
   private Scanner arquivo;
   private ArrayList<Usuario> listUsers;
 
   public AES(){
      textoCifrado = null; 
      textoDecifrado = null; 
      arquivo = null;
      listUsers = new ArrayList<Usuario>();
   } 
   
   //GERA A CHAVE
   public void geraChave(File arquivo) throws IOException, NoSuchAlgorithmException,InvalidAlgorithmParameterException,
   CertificateException, KeyStoreException{
   
      KeyGenerator kg = KeyGenerator.getInstance("AES"); 
      kg.init(128); // Gera uma chave simetrica de 128 bits: 
      SecretKey sk = kg.generateKey(); // Grava a chave simetrica em formato serializado 
      
      ObjectOutputStream objetoSaida = new ObjectOutputStream(new FileOutputStream(arquivo)); 
      objetoSaida.writeObject(sk); 
      objetoSaida.close(); 
   } 
   
   //GERA A CIFRA
   public void geraCifra(byte[] texto, File arquivo) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
   IllegalBlockSizeException, BadPaddingException,InvalidAlgorithmParameterException,IOException, ClassNotFoundException{
    
      ObjectInputStream objetoEntrada = new ObjectInputStream (new FileInputStream (arquivo)); 
      SecretKey sk = (SecretKey) objetoEntrada.readObject(); 
      
      byte[] chave = sk.getEncoded(); 
      objetoEntrada.close(); 
      
      Cipher aes = Cipher.getInstance ("AES/CBC/PKCS5Padding"); 
      IvParameterSpec para = new IvParameterSpec (new byte[16]); 
      aes.init (Cipher.ENCRYPT_MODE, new SecretKeySpec (chave, "AES"), para); 
      textoCifrado = aes.doFinal(texto); 
		
		//textoCifrado = texto;
		//System.out.println("\n\ngeraCifra():"+textoCifrado);
   } 
   
   
   public void geraDecifra(byte[] texto, File fSim)throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, IOException, ClassNotFoundException { 
      ObjectInputStream ois = new ObjectInputStream (new FileInputStream (fSim));    
      SecretKeySpec iSim = (SecretKeySpec) ois.readObject(); 
      ois.close();    
      
      Cipher aescf = Cipher.getInstance ("AES/CBC/PKCS5Padding");    
      IvParameterSpec ivspec = new IvParameterSpec (new byte[16]); 
      aescf.init (Cipher.DECRYPT_MODE, iSim, ivspec); 
      textoDecifrado = aescf.doFinal (texto); 
		
		//textoDecifrado = texto;
		//System.out.println("\n\ngeraDecifra():"+textoDecifrado);
   }
   
   public byte[] getTextoCifrado() throws Exception{ 
      return textoCifrado; 
   }
   
   public byte[] getTextoDecifrado() throws Exception{ 
      return textoDecifrado; 
   } 
   
   
   public void openFile(String arquivoAbre){
      try{
         arquivo = new Scanner( new File(arquivoAbre));
      }
      catch ( FileNotFoundException fileNotFoundException ){
         JOptionPane.showMessageDialog(null, "Arquivo na leitura das informações\nSaindo do sistema...");
         System.exit(1);
      }
   }
   public void closeFile(){
      if(arquivo != null){
         arquivo.close();
      } 
   }
}