   import java.awt.Color;
   import java.awt.Font;
   import java.util.*;
   import java.awt.event.*;

   import javax.swing.BorderFactory;
   import javax.swing.JButton;
   import javax.swing.JComboBox;
   import javax.swing.JFrame;
   import javax.swing.JLabel;
   import javax.swing.*;
   import javax.swing.filechooser.*;
   import java.io.File;
   import java.io.FileNotFoundException;
   import java.text.*;
   import javax.swing.text.*;
   import javax.swing.event.ListSelectionEvent;
   import javax.swing.event.ListSelectionListener;
   import javax.swing.JPanel;
   import javax.swing.JScrollPane;
   import javax.swing.JTable;
   import javax.swing.JTextField;
   import javax.swing.border.Border; 
   import javax.swing.border.LineBorder;
   import javax.swing.border.TitledBorder;
   import java.util.Locale;
   import java.util.ResourceBundle;

   public class GUIAutomovelRel extends JDialog{
      static final int WIDTH = 700;
      static final int HEIGHT = 450;
      private ResourceBundle bn = null;
      private JFrame frame;
      private Usuario user;
   
      private JTable tabela;
      private JScrollPane pane;
      private JPanel pnlc;
   
   
      private JLabel lblvalor;
      private JTextField txtvalor;
   
   //IDIOMA
      public String bn(String str){
         return getBundle().getString(str);
      }
      public void setBundle(ResourceBundle bn){
         this.bn = bn;
      }
      public ResourceBundle getBundle(){
         return this.bn;
      }
   
   
   //USUARIO QUE ESTA LOGADO   
      public void setUsuario(Usuario user){
         this.user = user;
      } 
      public Usuario getUsuario(){
         return this.user;
      }
   
   
   //CONSTRUTOR
      public GUIAutomovelRel(JFrame fr){
         super(fr,true);
         frame = fr;
      }
   
   
      public void init(){ 
      /**/
      
      
      
         tabela = new JTable();
         tabela.setGridColor(Color.BLACK);
         tabela.getTableHeader().setReorderingAllowed(false);//nao move as colunas
         tabela.setBorder(new LineBorder(Color.BLACK));
         tabela.setShowGrid(true);
         tabela.setBounds(0,0,WIDTH-5,HEIGHT-120);
         tabela.setVisible(true);
      
         pane = new JScrollPane();
         pane.getViewport().add(tabela);
         pane.setBounds(0, 0, WIDTH-5, HEIGHT-120);
         add(pane);
      
         lblvalor = new JLabel(getBundle().getString("automovel.relatorio.valortotal"));
         lblvalor.setBounds(20,HEIGHT-120,100,30);
         txtvalor = new JTextField();
         txtvalor.setBounds(20,HEIGHT-90,100,30);
         add(lblvalor);
         add(txtvalor);
      
         JButton btnbucar = new JButton(getBundle().getString("automovel.relatorio.buscar"));
         btnbucar.setBounds(WIDTH-130,HEIGHT-100,100,40);
         btnbucar.addActionListener(
               new ActionListener(){
                  public void actionPerformed(ActionEvent e){
                     pesquisar();
                  }
               });            
         add(btnbucar); 
      
         JButton btnimprimir = new JButton(getBundle().getString("automovel.relatorio.imprimir"));
         btnimprimir.setBounds(WIDTH-240,HEIGHT-100,100,40);
         add(btnimprimir);
      
       
         setTitle(getBundle().getString("automovel.title2"));
         setResizable(false);
         setLayout(null);
         setSize(WIDTH, HEIGHT);
         setLocationRelativeTo(null); 
         setVisible(true);
         setModal(true);
         setIconImage(new ImageIcon(getClass().getResource("images/logo2.png")).getImage());
      }
   
      public void pesquisar(){
         AutomovelDAO autoDAO = new AutomovelDAO();
         ArrayList<Locacao> locacoes = autoDAO.relatorioDia();
         tabela.setModel(new TabelaAutomovelRel(locacoes));
         pane.getViewport().add(tabela);
         repaint();
         Double a = 0.00;
         try{
         	for(int i=0;i<locacoes.size();i++){  
            	a += Double.parseDouble(locacoes.get(i).getValor());
         	}  
         }catch(Exception ex){
      		a=0.0;
      	}
         txtvalor.setText(String.valueOf(a));
      }
   }