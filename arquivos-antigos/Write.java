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
 
public class Write{
		private ObjectOutputStream output;
		private FileOutputStream arquivo;
		
		public Write(){}
		
		public void open() throws IOException{
			arquivo = new FileOutputStream("usuariosCifrados.dat");
			output = new ObjectOutputStream(arquivo);
		}
		
		
		public void write(){
			try{
				String logins = "admin;admin;S;eric;eric;s;ramon;ramon;s;ze;ze;a";
				AES aes = new AES();
				aes.geraChave(new File("chave.aes"));
				aes.geraCifra(logins.getBytes("ISO-8859-1"),new File("chave.aes"));
				
				
				//System.out.println("Cifrado: "+new String(aes.getTextoCifrado(),"ISO-8859-1"));
				open();
				output.writeObject(new String(aes.getTextoCifrado(),"ISO-8859-1"));
				close();
			}catch(Exception e){
				System.out.println(e);
			}
			
		}
		
		public void close() throws IOException{
			output.close();
		}	
}