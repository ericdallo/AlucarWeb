import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.*;

public class GUIIdioma extends JFrame implements MouseListener{
   private JPanel pnl;
   private JDesktopPane pnlD;
   private JButton btPrt, btSpn, btEng;
   private ResourceBundle bn = null;
   
   public GUIIdioma(){}   
   
   public void init(){
      pnlD = new JDesktopPane();
      pnlD.setLayout(null);
      pnl = new JPanel(new FlowLayout());
      
      btPrt = new JButton();
      btPrt.setBounds(25,22,60,60);
      btPrt.setIcon(new ImageIcon(getClass().getResource("images/br.png")));
      btPrt.setBorderPainted(false); 
      btPrt.setContentAreaFilled(false); 
      btPrt.setFocusPainted(false); 
      btPrt.setOpaque(false);
      btPrt.addMouseListener(this);
      
      
      btEng = new JButton();
      btEng.setBounds(110,22,60,60);
      btEng.setIcon(new ImageIcon(this.getClass().getResource("images/eua.png")));
      btEng.setBorderPainted(false); 
      btEng.setContentAreaFilled(false); 
      btEng.setFocusPainted(false); 
      btEng.setOpaque(false);
      btEng.addMouseListener(this);      
      
      
      btSpn = new JButton();
      btSpn.setBounds(195,22,60,60);
      btSpn.setIcon(new ImageIcon(this.getClass().getResource("images/es.png")));
      btSpn.setBorderPainted(false); 
      btSpn.setContentAreaFilled(false); 
      btSpn.setFocusPainted(false); 
      btSpn.setOpaque(false);
      btSpn.addMouseListener(this);   
      
      
      
      pnlD.add(btPrt);
      pnlD.add(btEng);
      pnlD.add(btSpn);
      add(pnlD);
      
      
      setResizable(false);
      //setType(Type.UTILITY);
      setSize(280,130);
      setLocationRelativeTo(null);
      setIconImage(new ImageIcon(getClass().getResource("images/logo2.png")).getImage());
      setVisible(true);
      
   }
   
   
   
   public void mouseClicked(MouseEvent e){
      if(e.getSource() == btPrt){
         try{
            bn = ResourceBundle.getBundle("bn", new Locale("pt", "BR"));
         }catch(Exception ex){
            System.exit(1);
         }
         GUILogin l = new GUILogin();
         l.setBundle(bn);
         l.init();
         
      }else if(e.getSource() == btSpn){
         GUILogin l = new GUILogin();
         try{
            bn = ResourceBundle.getBundle("bn", new Locale("es", "ES"));
         }catch(Exception ex){
            System.exit(1);
         }
         l.setBundle(bn);
         l.init();
      }else if(e.getSource() == btEng){
         GUILogin l = new GUILogin();
         try{
            bn = ResourceBundle.getBundle("bn",Locale.US);
         }catch(Exception ex){
            System.exit(1);
         }
         l.setBundle(bn);
         l.init();
         
      }
      dispose();
    }            
      
    public void mouseEntered(MouseEvent e){
      if(e.getSource() == btPrt){
         btPrt.setIcon(new ImageIcon(getClass().getResource("images/brHover.png")));
         setTitle("Idioma");
      }else if(e.getSource() == btSpn){
         btSpn.setIcon(new ImageIcon(getClass().getResource("images/esHover.png")));
         setTitle("Idioma");
      }else if(e.getSource() == btEng){
         btEng.setIcon(new ImageIcon(getClass().getResource("images/euaHover.png")));
         setTitle("Language");
      }
      repaint();
    }
    
    public void mouseExited(MouseEvent e){
     
     if(e.getSource() == btPrt){
         btPrt.setIcon(new ImageIcon(getClass().getResource("images/br.png")));
      }else if(e.getSource() == btSpn){
         btSpn.setIcon(new ImageIcon(getClass().getResource("images/es.png")));
      }else if(e.getSource() == btEng){
         btEng.setIcon(new ImageIcon(getClass().getResource("images/eua.png")));
      }
      setTitle("");
      repaint();
    }
    
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
    
    
    /* -----------------------  FORMA "ERRADA" EM QUE SE CRIA VARIAS CLASSES ANONIMAS -----------------------------------------------
      
      btPrt.addMouseListener(
            new MouseListener(){
               public void mouseClicked(MouseEvent arg0){
                  GUILogin l = new GUILogin();
                  try{
                     bn = ResourceBundle.getBundle("bn", new Locale("pt", "BR"));
                  }
                  catch(Exception e){
                     System.exit(1);
                  }
                  l.setBundle(bn);
                  l.init();
                  dispose();
               }
               public void mouseEntered(MouseEvent arg0){
                  btPrt.setIcon(new ImageIcon(getClass().getResource(
                     "images/brHover.png")));
                     setTitle("Idioma");
                  repaint();
               }
               public void mouseExited(MouseEvent arg0){
                  btPrt.setIcon(new ImageIcon(getClass().getResource(
                     "images/br.png")));
                     setTitle("");
                  repaint();
               }
               public void mousePressed(MouseEvent arg0){
               }
               public void mouseReleased(MouseEvent arg0) {
               }
            });
      
      btEng.addMouseListener(
            new MouseListener(){
               public void mouseClicked(MouseEvent arg0){
                  GUILogin l = new GUILogin();
                  try{
                     bn = ResourceBundle.getBundle("bn", Locale.US);
                  }
                  catch(Exception e){
                     System.exit(1);
                  }
                  l.setBundle(bn);
                  l.init();
                  dispose();
               }
               public void mouseEntered(MouseEvent arg0){
                  btEng.setIcon(new ImageIcon(getClass().getResource(
                     "images/euaHover.png")));
                     setTitle("Language");
                  repaint();
               }
               public void mouseExited(MouseEvent arg0){
                  btEng.setIcon(new ImageIcon(getClass().getResource(
                     "images/eua.png")));
                     setTitle("");
                  repaint();
               }
               public void mousePressed(MouseEvent arg0){
               }
               public void mouseReleased(MouseEvent arg0) {
               }
            });
      
      btSpn.addMouseListener(
            new MouseListener(){
               public void mouseClicked(MouseEvent arg0){
                  GUILogin l = new GUILogin();
                  try{
                     bn = ResourceBundle.getBundle("bn", new Locale("es", "ES"));
                  }
                  catch(Exception e){
                     System.exit(1);
                  }
                  l.setBundle(bn);
                  l.init();
                  dispose();
               }
               public void mouseEntered(MouseEvent arg0){
                  btSpn.setIcon(new ImageIcon(getClass().getResource(
                     "images/esHover.png")));
                     setTitle("Idioma");
                  repaint();
               }
               public void mouseExited(MouseEvent arg0){
                  btSpn.setIcon(new ImageIcon(getClass().getResource(
                     "images/es.png")));
                     setTitle("");
                  repaint();
               }
               public void mousePressed(MouseEvent arg0){
               }
               public void mouseReleased(MouseEvent arg0) {
               }
            });
            */
}