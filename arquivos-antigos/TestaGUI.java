import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.*;

public class TestaGUI{
   public static void main(String args[]){
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            try {
               //for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                  //NIMBUS.
                  
                  /*if ("NimnumeroLocacao: intbus".equals(info.getName())) {
                     JOptionPane.showMessageDialog(null,info.getClassName());
                     UIManager.setLookAndFeel(info.getClassName());
                     break;
                  }*/
                  
                  
                  //1°
                  UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                  
                  //2°
                  //UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                  
                  //3º
                  //UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                  
                  //4°
                  UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
                  
               //}
            }catch(Exception e){}
            
            ResourceBundle bn = ResourceBundle.getBundle("bn", new Locale("pt", "BR"));
            
            /*/
            Pagamento p = new Pagamento(); 
            Locacao l = new Locacao();
            l.setLccode(1);
            p.setPgvalortot("1.50");
            p.setLocacao(l);
            
            //GUICredito c = new GUICredito(new JFrame(),p,false,"");
            GUIDebito c = new GUIDebito(new JFrame());
            c.setBundle(bn);
            c.init(new JFrame());
            /*/
            
            boolean b = true;
            //b = false;
            if(b){
               GUIIdioma c = new GUIIdioma();
               c.init();
               //GUIPagamento p = new GUIPagamento(new JFrame());
               //GUILocacao p = new GUILocacao(new JFrame(),new Usuario("ramon","ramon","s"));
					//GUIAutomovel p = new GUIAutomovel(new JFrame());
               //p.setBundle(bn);
               //p.init(new JFrame());
               //p.setVisible(true);
            }else{
               GUIAutomovel a = new GUIAutomovel(new JFrame());
               //GUIDevolucao a = new GUIDevolucao(new JFrame(),new Usuario("ramon","ramon","s"));
               a.setBundle(bn);
               a.setUsuario(new Usuario("ramon","ramon","s"));
               a.init(new JFrame());
            }
            /**/
         }
      });            
   }
}