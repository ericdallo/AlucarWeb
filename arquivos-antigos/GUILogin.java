import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class GUILogin extends JFrame implements ActionListener,KeyListener {
   static final int WIDTH = 470;
   static final int HEIGHT = 300;
   private ResourceBundle bn = null;

   private JLabel lblagencia,lbllogin,lblsenha,lblinfo,lbllogo;
   private JPasswordField pswsenha;
   private JTextField txtlogin;
   private JComboBox comboagencia;
   private JButton btlogar;
   private JPanel pnlp;

   public void setBundle(ResourceBundle bn){
      this.bn = bn;
   }
 
   public ResourceBundle getBundle(){
      return this.bn;
   }


   public GUILogin(){
   
   }

   public void init(){
      pnlp = new JPanel(null);
      pnlp.setBounds(0,0,WIDTH,HEIGHT);
   
      lblinfo = new JLabel(getBundle().getString("login.lblinfo"),JLabel.CENTER);
      lblinfo.setBounds(0,10,WIDTH,30);
      lblinfo.setFont(new Font("Arial",Font.PLAIN,20));
      lblinfo.setVisible(false);
      pnlp.add(lblinfo);
   
   
   
      //IMAGEM - LOGO
      lbllogo = new JLabel();
      lbllogo.setBounds(20,(HEIGHT-195)/2,130,130);
      lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/logo2.png")));  
      pnlp.add(lbllogo);
   
      //CAMPOS
      lbllogin = new JLabel(getBundle().getString("login.lbllogin"));
      lbllogin.setBounds(180,50,300,30);
      lbllogin.setBackground(Color.RED);
      lbllogin.setFont(new Font("Arial",Font.PLAIN,16));
      txtlogin = new JTextField();
      txtlogin.setBounds(180,80,220,30);
      txtlogin.addActionListener(this);
      txtlogin.setBorder(BorderFactory.createCompoundBorder(txtlogin.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnlp.add(lbllogin);
      pnlp.add(txtlogin);
   
   
      lblsenha = new JLabel(getBundle().getString("login.lblsenha"));
      lblsenha.setBounds(180,110,300,30);
      lblsenha.setBackground(Color.RED);
      lblsenha.setFont(new Font("Arial",Font.PLAIN,16));
      pswsenha = new JPasswordField();
      pswsenha.setBounds(180,140,220,30);
      pswsenha.addActionListener(this);
      pswsenha.setBorder(BorderFactory.createCompoundBorder(pswsenha.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnlp.add(lblsenha);
      pnlp.add(pswsenha);
   
   
      lblagencia = new JLabel(getBundle().getString("login.lblagencia"));
      lblagencia.setBounds(180,180,100,30);
      lblagencia.setBackground(Color.RED);
      lblagencia.setFont(new Font("Arial",Font.PLAIN,16));
      String[] agencias = {"SP","RJ"};
      comboagencia = new JComboBox(agencias);
      comboagencia.setBounds(180,210,100,30);
      pnlp.add(lblagencia);
      pnlp.add(comboagencia);
   
   
   
      btlogar = new JButton(getBundle().getString("login.btlogar"));
      btlogar.setBounds(290,205,120,40);
      btlogar.addActionListener(this);
      pnlp.add(btlogar);
   
      add(pnlp); 
      
      
      //===============================================================================================================
      setTitle(getBundle().getString("login.title"));
      setResizable(false);
      setSize(WIDTH, HEIGHT);
      setLocationRelativeTo(null); 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setIconImage(new ImageIcon(getClass().getResource("images/logo2.png")).getImage());
      setVisible(true);
      //===============================================================================================================
      
   }
   
   
   //KEY LISTENER
   public void keyTyped(KeyEvent e){
      lblinfo.setVisible(false);
   }
   public void keyPressed(KeyEvent e){}
   public void keyReleased(KeyEvent e){}



   //ACTION LISTENER
   
   public void actionPerformed(ActionEvent e){
      ArrayList<Usuario> users = new ArrayList<Usuario>();
		//Write w = new Write();
		Read r = new Read();
		try{
			//w.write();
			users = r.read();
		   boolean achou = false;
         int alto = users.size() - 1;
         int baixo = 0;
         int meio = alto/2;
         int pos = 0;
         
         while(!achou && alto >= baixo){
            if(txtlogin.getText().equals(users.get(meio).getLogin())){
               if(new String(pswsenha.getPassword()).equals(users.get(meio).getSenha())){
                  achou = true;
                  pos = meio;
               }else
                  achou = false;
               break;
            }
            else if(txtlogin.getText().compareToIgnoreCase(users.get(meio).getLogin()) < 0){
               alto = meio - 1;       
            }
            else {
               baixo = meio + 1;
            }   
            meio = (alto + baixo) / 2;
         }
      
         if(achou){//ACERTOU O LOGIN
            int index = comboagencia.getSelectedIndex();
            String agencia = comboagencia.getSelectedItem().toString();
            GUIPrincipal p = new GUIPrincipal(agencia,users.get(pos));
            p.setBundle(this.getBundle());
            //p.setUsuario(users.get(pos));
            p.init();
            dispose();
         }
         
         else{//ERROU O LOGIN
            lblinfo.setVisible(true);
            lblinfo.setForeground(new Color(220,0,0));
            vibrar(this);
            pswsenha.setText("");
            pswsenha.requestFocus();
         }
      
      }catch(Exception e2){
         String msg = getBundle().getString("erro.login");
         JOptionPane.showMessageDialog(null, msg);
         //e2.printStackTrace();
		}
   }//action
      
   public static void vibrar(JFrame frame) { 
      final int TAMANHO = 7;
      final int VELOCIDADE = 4;
   
      try { 
         final int originalX = frame.getLocationOnScreen().x; 
         final int originalY = frame.getLocationOnScreen().y; 
         for(int i = 0; i < TAMANHO; i++) { 
            Thread.sleep(10); 
            frame.setLocation(originalX, originalY + VELOCIDADE); 
            Thread.sleep(10); 
            frame.setLocation(originalX, originalY - VELOCIDADE);
            Thread.sleep(10); 
            frame.setLocation(originalX + VELOCIDADE, originalY);
            Thread.sleep(10); 
            frame.setLocation(originalX, originalY); 
         } 
      } 
      catch (Exception e) { 
         e.printStackTrace(); 
      } 
  }
}//CLASSE