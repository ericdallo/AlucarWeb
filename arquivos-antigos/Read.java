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


 
public class Read{
		private ObjectInputStream input;
		private FileInputStream arquivoSemCifra;

		public Read(){}
			
		public void open() throws IOException{
			arquivoSemCifra = new FileInputStream("usuariosCifrados.dat");
			input = new ObjectInputStream(arquivoSemCifra);
		}
		
		
		public ArrayList<Usuario> read() throws IOException{
			ArrayList<Usuario> users = new ArrayList<Usuario>();
         try{
				open();
				String a = (String) input.readObject();
				close();            
				AES aes = new AES();
				aes.geraDecifra(a.getBytes("ISO-8859-1"),new File("chave.aes"));
            
            String strusers[] = new String(aes.getTextoDecifrado(),"ISO-8859-1").split(";"); 
            for(int i = 0; i < strusers.length - 2; i+=3){
               Usuario user = new Usuario(strusers[i],strusers[i+1],strusers[i+2]);
               users.add(user);
            }
            
			}catch(Exception e){
				System.out.println("a"+e);
			}
         return users;
		}
		
		public void close() throws IOException{
			input.close();
		}
}