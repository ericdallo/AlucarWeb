import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.text.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border; 
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.*;

public class GUILocacao extends JDialog implements ActionListener {
   static final int WIDTH = 750;
   static final int HEIGHT = 570;
   static final int HEIGHT2 = 290;
   static final Color COR = new Color(243,243,243);
   static final Color COR2 = new Color(219,219,219);
   static final Color CORBRANCA = new Color(255,255,255);
   private ResourceBundle bn = null;
   private JFrame frame;
   private JLabel lblcod, lblnome, lblemail, lblendereco,lblrg,lblinformacoes,lblcpf,lbldata,lblcidade,lbluf;
   private JTextField txtcod, txtnome, txttelefone, txtendereco, txtrg,txtemail,txtcpf,txtcidade;
   private JLabel lblclicod, lblclinome,lbllocacaocod,lbldtlocacao,lblcarcod,lblcarmodelo,lbldtdevolucao;
   private JTextField txtclicod, txtclinome,txtlocacaocod,txtcarcod,txtcarmodelo;   
   private JFormattedTextField txtdtlocacao,txtdtdevolucao;
   private MaskFormatter maskdtlocacao,maskdtdevolucao;
   private Border border;
   private Color verdeEscuro, vermelhoEscuro, cinza, branco;
   private Font normal, XLnormal, btnormal, negrito;
   private JScrollPane pane;
   private JTable tabela;
   private JLabel lblpesquisar,lblresposta;
   private JComboBox combopesquisar,cmbuf;
   private JPanel painelp,pnlBotoes,painelc;
   private ImageIcon img;
   private JLabel lblagalu, lblagdev,lblcarkm, lblvalor,lbltipopag,lblstatus,lblstatus2;
   private JTextField txtcarkm,txtvalor,txtpesquisa;
   private JComboBox cbagalu, cbagdev;
   private JRadioButton radkmlivre,radkmcontrol;   
   private JButton btvoltar, btpesquisarloca,btpagamento,btconsultacli, btconsultacar;
   private JButton btadicionar, btsalvar, btlimpar, btpesquisar, btexcluir,bthabilitar;
   private Usuario user;
   private String status;
   private boolean pesquisando;
   protected JButton btpuxar;
   protected GUICliente cliente;
   protected GUIAutomovel carro;
   private String taxaLivre;
   private String taxaControlado;
   ArrayList<Locacao> locacoes;
   private Locacao locacao;
   
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
   
   public GUILocacao(JFrame fr, Usuario user,boolean isSearching){
      super(fr,true);
      frame = fr;
      setUsuario(user);
      status = "";
      pesquisando = isSearching;
   }
   public GUILocacao(JFrame fr, Usuario user){
      super(fr,true);
      frame = fr;
      setUsuario(user);
      status = "";
      pesquisando = false;
   }
   public GUILocacao(JFrame fr){
      super(fr,true);
      frame = fr;
      status = "";
      pesquisando = false;
   }
   
   
   
   
   public void init(JFrame fr){    
      //==============================================================================
      //PAINEL DE BOTOES
      pnlBotoes = new JPanel(null);
      pnlBotoes.setBounds(20,10,WIDTH-40,50);
      
      btpesquisar = new JButton(getBundle().getString("locacao.btpesquisar"));
      btpesquisar.setBounds(0, 5, 130, 40);
      btpesquisar.addActionListener(this);      
      pnlBotoes.add(btpesquisar);
      if(pesquisando)pnlBotoes.add(btpuxar);
      
      
      btadicionar = new JButton(getBundle().getString("locacao.btadicionar"));
      btadicionar.setBounds(135, 5, 130, 40);
      btadicionar.addActionListener(this);
      if(!pesquisando)pnlBotoes.add(btadicionar);
      
      btexcluir = new JButton(getBundle().getString("locacao.btexcluir"));
      btexcluir.setBounds(270, 5, 130, 40);
      btexcluir.addActionListener(this);
      btexcluir.setEnabled(false);
      if(!pesquisando)pnlBotoes.add(btexcluir);
      
      btsalvar = new JButton(getBundle().getString("locacao.btsalvar"));
      btsalvar.setBounds(405, 5, 130, 40);
      btsalvar.addActionListener(this);
      btsalvar.setEnabled(false);
      if(!pesquisando)pnlBotoes.add(btsalvar);
      
      bthabilitar = new JButton(getBundle().getString("locacao.bthabilita"));
      bthabilitar.setBounds(540, 5, 130, 40);
      bthabilitar.addActionListener(this);
      bthabilitar.setEnabled(false);
      if(!pesquisando)pnlBotoes.add(bthabilitar);
      
      if(!pesquisando)
         add(pnlBotoes);
      //==============================================================================
      
      
      //==============================================================================      
      //PAINEL PESQUISAR
      painelp = new JPanel(null);
      painelp.setBounds(20,5,WIDTH-40,70);
      
      lblpesquisar = new JLabel(getBundle().getString("cliente.painelp.lblpesquisar"),JLabel.LEFT);
      lblpesquisar.setBounds(10, 0, 120, 30);
      lblpesquisar.setFont(XLnormal);
      painelp.add(lblpesquisar);
      
      String[] opcoespesq = { 
         bn("locacao.painelp.cborder1"),
         bn("locacao.painelp.cborder2"), bn("locacao.painelp.cborder3"),
         bn("locacao.painelp.cborder4")};
      combopesquisar = new JComboBox(opcoespesq);
      combopesquisar.setBounds(10, 30, 120, 30);
      combopesquisar.addActionListener(this);
      painelp.add(combopesquisar);
      
      if(pesquisando){
         txtpesquisa = new JTextField();
         txtpesquisa.setBounds(140,30,130,30);
         txtpesquisa.setEnabled(true);
         txtpesquisa.setBackground(COR);
         painelp.add(txtpesquisa);
      }
      
      btpesquisarloca = new JButton(getBundle().getString("locacao.painelp.btpesquisarloca"));
      if(!pesquisando)btpesquisarloca.setBounds(140, 25, 120, 40);
      else btpesquisarloca.setBounds(280,25,120,40);
      btpesquisarloca.addActionListener(this);
      painelp.add(btpesquisarloca);		
      
      btvoltar = new JButton(getBundle().getString("locacao.painelp.btvoltar"));
      btvoltar.setBounds(265, 25, 120, 40);
      btvoltar.addActionListener(this);
      if(!pesquisando)btvoltar.setBounds(265, 25, 120, 40);
      else btvoltar.setBounds(405, 25, 120, 40);
      painelp.add(btvoltar);
      
      if(pesquisando)
         add(painelp);
      //==============================================================================
   
   
   
   
      
      //==============================================================================
   	//PAINEL LOCACAO
      lblresposta = new JLabel("...");
      lblresposta.setBounds(20,60,WIDTH-40,30);
      lblresposta.setForeground(Color.RED);
      lblresposta.setFont(new Font("Lucida Sans", Font.PLAIN, 18));
      add(lblresposta);
      
      
      painelc = new JPanel(null);
      painelc.setBounds(20, 90, WIDTH-40, 240);
      painelc.setBorder(BorderFactory.createTitledBorder(null,
         	getBundle().getString("locacao.painelc.title"), TitledBorder.CENTER,
         	TitledBorder.TOP, new Font("Lucida Sans", Font.PLAIN, 16),
         	Color.BLUE));
      
      lbllocacaocod = new JLabel(getBundle().getString("locacao.painelc.lbllocacaocod"));
      lbllocacaocod.setBounds(10,30,150,30);
      txtlocacaocod = new JTextField();
      txtlocacaocod.setBounds(10,60,100,30);
      txtlocacaocod.setBorder(BorderFactory.createCompoundBorder(txtlocacaocod.getBorder(), 
         BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      txtlocacaocod.setEnabled(false);
      painelc.add(lbllocacaocod);
      painelc.add(txtlocacaocod);
      
      
      //CLIENTE==================
      lblclicod = new JLabel(getBundle().getString("locacao.painelc.lblclicod"));
      lblclicod.setBounds(140, 30, 100, 30);
      lblclicod.setFont(normal);
      txtclicod = new JTextField();
      txtclicod.setBounds(140, 60, 80, 30);
      txtclicod.setBorder(BorderFactory.createCompoundBorder(txtclicod.getBorder(), 
         BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      txtclicod.addFocusListener(
            new FocusAdapter() {  
               public void focusLost(FocusEvent e) {  
               }
            });
      painelc.add(lblclicod);
      painelc.add(txtclicod);
      
      btconsultacli = new JButton();
      btconsultacli.setBounds(225,60,30,30);
      btconsultacli.setIcon(new ImageIcon(this.getClass().getResource("images/search.png")));
      btconsultacli.setEnabled(false);
      btconsultacli.addActionListener(
            new ActionListener(){
               public void actionPerformed(ActionEvent e){
                  cliente = new GUICliente(frame,true,0,txtclicod.getText());
                  cliente.setUsuario(getUsuario());
                  cliente.setBundle(getBundle());
                  cliente.addListenerConsulta(new ClienteListener());
                  cliente.init(frame);
               }
            });
      painelc.add(btconsultacli);
      
      lblclinome = new JLabel(getBundle().getString("locacao.painelc.lblclinome"));
      lblclinome.setBounds(290,30,380,30);
      txtclinome = new JTextField();
      txtclinome.setBounds(290,60,380,30);
      txtclinome.setBorder(BorderFactory.createCompoundBorder(txtclinome.getBorder(), 
         BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      painelc.add(lblclinome);
      painelc.add(txtclinome);
      //================================
      
      
      //CARRO===========================
      lblcarcod = new JLabel(getBundle().getString("locacao.painelc.lblcarcod"));
      lblcarcod.setBounds(10,90,80,30);
      txtcarcod = new JTextField();
      txtcarcod.setBounds(10,120,80,30);
      txtcarcod.setBorder(BorderFactory.createCompoundBorder(txtcarcod.getBorder(), 
         BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      painelc.add(lblcarcod);
      painelc.add(txtcarcod);
      
      btconsultacar = new JButton();
      btconsultacar.setBounds(95,120,30,30);
      btconsultacar.setIcon(new ImageIcon(this.getClass().getResource("images/search.png")));
      btconsultacar.setEnabled(false);
      btconsultacar.addActionListener(
            new ActionListener(){
               public void actionPerformed(ActionEvent e){
                  txtcarcod.setText("");
                  txtcarmodelo.setText("");
                  carro = new GUIAutomovel(frame,true,0,txtcarcod.getText());
                  carro.setUsuario(getUsuario());
                  carro.setBundle(getBundle());
                  carro.addListenerConsulta(new CarroListener());
                  carro.init(frame);
               }
            });
      painelc.add(btconsultacar); 
      
      lblcarmodelo = new JLabel(getBundle().getString("locacao.painelc.lblcarmodelo"));
      lblcarmodelo.setBounds(140,90,150,30);
      txtcarmodelo = new JTextField();
      txtcarmodelo.setBounds(140,120,150,30);
      txtcarmodelo.setBorder(BorderFactory.createCompoundBorder(txtcarmodelo.getBorder(), 
         BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      painelc.add(lblcarmodelo);
      painelc.add(txtcarmodelo);
      //==============================
      
      
      lbldtlocacao = new JLabel(getBundle().getString("locacao.painelc.lbldtlocacao"));
      lbldtlocacao.setBounds(330,90,150,30);
      try{
         maskdtlocacao = new MaskFormatter("##/##/####");
         maskdtlocacao.setPlaceholderCharacter('_');
         txtdtlocacao = new JFormattedTextField(maskdtlocacao);
      }
      catch(Exception e){}
      txtdtlocacao.setBounds(330,120,90,30);
      txtdtlocacao.setBorder(BorderFactory.createCompoundBorder(txtdtlocacao.getBorder(), 
         BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      painelc.add(lbldtlocacao);
      painelc.add(txtdtlocacao);
      
      
      lbldtdevolucao = new JLabel(getBundle().getString("locacao.painelc.lbldtdevolucao"));
      lbldtdevolucao.setBounds(460,90,150,30);
      try{
         maskdtdevolucao = new MaskFormatter("##/##/####");
         maskdtdevolucao.setPlaceholderCharacter('_');
         txtdtdevolucao = new JFormattedTextField(maskdtdevolucao);
      }
      catch(Exception e){}
      txtdtdevolucao.setBounds(460,120,90,30);
      txtdtdevolucao.setBorder(BorderFactory.createCompoundBorder(txtdtdevolucao.getBorder(), 
         BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      painelc.add(lbldtdevolucao);
      painelc.add(txtdtdevolucao);
   
      
      lblagalu = new JLabel(bn("locacao.painelc.lblagalu"));
      lblagalu.setBounds(590,90,130,30);
      String op[] = {"SP","RJ"};
      cbagalu = new JComboBox(op);
      cbagalu.setBounds(590,120,80,30);
      painelc.add(lblagalu);
      painelc.add(cbagalu);
      
      lblagdev = new JLabel(bn("locacao.painelc.lblagdev"));
      lblagdev.setBounds(10,150,130,30);
      String op2[] = {"SP","RJ"};
      cbagdev = new JComboBox(op2);
      cbagdev.setBounds(10,180,80,30);
      painelc.add(lblagdev);
      painelc.add(cbagdev);
      
      lblcarkm = new JLabel(bn("locacao.painelc.lblcarkm"));
      lblcarkm.setBounds(150,150,150,30);
      radkmlivre = new JRadioButton(getBundle().getString("locacao.painelc.radkmlivre"));
      radkmlivre.setBounds(145,180,65,30);
      radkmlivre.addActionListener(this);
      radkmcontrol = new JRadioButton(getBundle().getString("locacao.painelc.radkmcontrol"));
      radkmcontrol.setBounds(210,180,100,30);
      radkmcontrol.addActionListener(this);
      ButtonGroup btngroup = new ButtonGroup();
      btngroup.add(radkmlivre);
      btngroup.add(radkmcontrol);
      painelc.add(lblcarkm);
      painelc.add(radkmlivre);
      painelc.add(radkmcontrol);
   
      lblvalor = new JLabel(bn("locacao.painelc.lblvalor"));
      lblvalor.setBounds(320,150,150,30);
      //txtvalor = new JTextField();
      txtvalor = new JNumberFormatField(new DecimalFormat("0.00")){{setLimit(9);}};
      txtvalor.setBounds(320,180,100,30);
      txtvalor.setBorder(BorderFactory.createCompoundBorder(txtvalor.getBorder(), 
         BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      painelc.add(lblvalor);
      painelc.add(txtvalor);
      
      
      lblstatus = new JLabel(bn("locacao.painelc.lblstatus"));
      lblstatus.setBounds(480,150,100,30);
      lblstatus2 = new JLabel();
      lblstatus2.setBounds(480,180,100,30);
      lblstatus2.setFont(new Font("Arial", Font.PLAIN, 15));
      painelc.add(lblstatus);
      painelc.add(lblstatus2);
      
      //BLOQUEIA OS CAMPOS
      habilitaBotoes(true,true,false,false,false);
      limpaTxts();
      habilitaTxts(false);
      
   	
      
      if(!pesquisando)add(painelc);
   	//==============================================================================
      
      
      
            
     
   	//==============================================================================
      //TABELA
      tabela = new JTable();
      tabela.setGridColor(Color.BLACK);
      tabela.getTableHeader().setReorderingAllowed(false);//nao move as colunas
      tabela.setBorder(new LineBorder(Color.BLACK));
      tabela.setShowGrid(true);
      tabela.setBounds(0,0,WIDTH-40,140);
      tabela.setVisible(true);
      TabelaListener listener = new TabelaListener(tabela);
      tabela.getSelectionModel().addListSelectionListener(listener);
      
      pane = new JScrollPane();
      pane.getViewport().add(tabela);
      if(pesquisando)
         pane.setBounds(20,90,WIDTH-40,140);
      else
         pane.setBounds(20, 340, WIDTH-40, 140);
      add(pane);
   	
   	
   	//==============================================================================
      	
      
      
      //==============================================================================
      //ALUGADOMENTO DA LOCAÇÃO
      img = new ImageIcon(getClass().getResource("images/btpagar.png"));
      btpagamento = new JButton(getBundle().getString("locacao.btpagamento"));
      btpagamento.addActionListener(this);
      btpagamento.setBounds(WIDTH-220,490,200,40);
      btpagamento.setIcon(img);
      btpagamento.setEnabled(false);
      if(!pesquisando)
         add(btpagamento);
      //==============================================================================
         
      
      //===============================================================================================================
      setTitle(getBundle().getString("locacao.title"));
      setResizable(false);
      setLayout(null);
      setSize(WIDTH, pesquisando ? HEIGHT2 : HEIGHT);
      setLocationRelativeTo(null); 
      setIconImage(new ImageIcon(getClass().getResource("images/logo2.png")).getImage());
      setVisible(true);
      setModal(true);
      //===============================================================================================================
      
      
      //CORES
      verdeEscuro = new Color(0, 190, 0);
      vermelhoEscuro = new Color(190, 0, 0);
      cinza = new Color(210, 210, 210);
      branco = new Color(255, 255, 255);
      btexcluir.setForeground(vermelhoEscuro);
      
      //FONTES
      normal = new Font("Arial", Font.PLAIN, 12);
      XLnormal = new Font("Arial", Font.PLAIN, 14);
      btnormal = new Font("Candara", Font.PLAIN, 14);
      negrito = new Font("Candara", Font.BOLD, 14);
   	
   	
   }//init()
   
   
   public void actionPerformed(ActionEvent e) {
      //VAI PARA A TELA DE PESQUISA
      if(e.getSource() == btpesquisar){
         remove(pnlBotoes);
         add(painelp);
         combopesquisar.setSelectedIndex(-1);
         tabela.setEnabled(false);
         tabela.setBackground(COR);
         limpaTxts();
         habilitaTxts(false);
         combopesquisar.requestFocus();
         btpagamento.setEnabled(false);
         repaint();
      }
      
      //CANCELA A PESQUISA
      else if(e.getSource() == btvoltar){
         add(pnlBotoes);
         remove(painelp);
         limpaTxts();
         habilitaTxts(false);
         tabela.getSelectionModel().clearSelection();
         tabela.setEnabled(true);
         tabela.setBackground(COR);
         habilitaBotoes(true,true,false,false,false);
         btpagamento.setEnabled(false);
         repaint();
      }
      
      
      //ONCHANGE DO COMBOBOX DE PESQUISA
      else if(e.getSource() == combopesquisar){
         habilitaTxts(false);
         int combo = combopesquisar.getSelectedIndex();
         switch(combo){
            case 0://Código
               limpaTxts();
               txtlocacaocod.setEnabled(true);
               txtlocacaocod.setBackground(new Color(255,255,255));
               txtlocacaocod.requestFocus();
               break;
            
            case 1://Nome do cliente
               limpaTxts();
               txtclinome.setEnabled(true);
               txtclinome.setBackground(new Color(255,255,255));
               txtclinome.requestFocus();
               break;
            
            case 2://Numero do Carro
               limpaTxts();
               txtcarcod.setEnabled(true);
               txtcarcod.setBackground(new Color(255,255,255));
               txtcarcod.requestFocus();
               break;
            
            case 3://Data da locação
               limpaTxts();
               txtdtlocacao.setEnabled(true);
               txtdtlocacao.setBackground(new Color(255,255,255));
               txtdtlocacao.requestFocus();
               break;
         }//switch
      }//combopesquisa listener
      
      
      //REALIZAR A PESQUISA NO BANCO
      else if(e.getSource() == btpesquisarloca){
         pesquisar();
      }//PESQUISAR
      
      
      //HABILITAR EDIÇÃO
      else if(e.getSource() == bthabilitar){
         if(status.equals("")){
            if(!locacao.getStatus().equals("A")){
               String msg = getBundle().getString("erro.locacao.editar");
               String[] options = {"  OK  "};  
               JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            }
            else{
               btpagamento.setEnabled(false);
               tabela.setEnabled(false);
               tabela.setBackground(COR2);
               habilitaTxts(true);
               btconsultacli.setEnabled(true);
               btconsultacar.setEnabled(true);
               
               txtlocacaocod.setEnabled(false);
               txtclicod.setEnabled(false);
               txtclinome.setEnabled(false);
               habilitaBotoes(false,false,false,true,true);
               bthabilitar.setText(getBundle().getString("locacao.bthabilita2"));
               status = "a";
            }
         }
         else if(status.equals("a") || status.equals("+")){//ESTOU ALTERANDO OS DADOS - VOU CANCELAR A ALTERAÇÃO
            String msg = getBundle().getString("erro.perguntasalvar");
            String[] options = {"  "+getBundle().getString("erro.opcoes.sim")+"  ","  "+getBundle().getString("erro.opcoes.nao")+"  "};//0 = sim, 1 = nao 
            int resp = JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if(resp == 0){
               limpaTxts();
               habilitaTxts(false);
               btconsultacli.setEnabled(false);            
               btconsultacar.setEnabled(false);
               habilitaBotoes(true,true,false,false,false);
               bthabilitar.setText(getBundle().getString("locacao.bthabilita"));
               txtclicod.setEnabled(false);
               txtclinome.setEnabled(false);
               tabela.getSelectionModel().clearSelection();
               tabela.setEnabled(true);
               tabela.setBackground(COR);
               status = "";
            } 
         }
      }//HABILITA EDICAO
      
      
      
      
      //GRAVAR ALTERAÇÃO
      else if(e.getSource() == btsalvar){
         boolean passou = true;
         JTextField a[] = {txtlocacaocod,txtclicod,txtcarcod
                              ,txtdtlocacao,txtdtdevolucao,new JTextField("agencia do alugel"),new JTextField("agencia devolucao")
                              ,new JTextField("km"),txtvalor,new JTextField("status")};
         String b[] = new String[a.length];
         
         //=============================
         //CONSISTENCIA DOS DADOS
         for(int i = 1; i < a.length; i++){
            if(a[i].getText().equals("") || a[i].getText().equals("__/__/____")){
               lblresposta.setText(getBundle().getString("erro.preenchainformacoes"));
               a[i].requestFocus();
               passou = false;
               break;
            }
         }
         if((!radkmlivre.isSelected() && !radkmcontrol.isSelected()) || cbagalu.getSelectedIndex() == -1 || cbagdev.getSelectedIndex() == -1){
            lblresposta.setText(getBundle().getString("erro.preenchainformacoes"));
            passou = false;
         }
         
         //VALIDA DATA
         if(passou){
            try{
               Date lc_dtlocacao = null,lc_dtprevista = null;
               DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
               lc_dtlocacao = (java.util.Date)formatter.parse(a[3].getText());  
               lc_dtprevista = (java.util.Date)formatter.parse(a[4].getText());
               if(lc_dtlocacao.getTime() > lc_dtprevista.getTime()){
                  String msg = getBundle().getString("erro.locacao.datamaior");
                  String[] options = {"  OK  "};
                  JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                  passou = false;
               }
            }catch(Exception i){
               String msg = getBundle().getString("erro.locacao.datacorreta");
               String[] options = {"  OK  "};
               JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
               passou = false;
            }
         }
         //==========================  
         
         if(passou){ 
            for(int i = 0; i < a.length; i++){
               if(i == 5 || i == 6){//AGENCIAS
                  b[i] = (i == 5 ? (cbagalu.getSelectedIndex() == 0 ? "SP" : "RJ") : (cbagdev.getSelectedIndex() == 0 ? "SP" : "RJ"));
               }
               else if(i == 7){//TIPO KM
                  b[i] = radkmlivre.isSelected() ? "L" : (radkmcontrol.isSelected() ? "C" : "");
               }
               else if(i == 9){//STATUS
                  b[i] = lblstatus2.getText();
               }
               else{
                  b[i] = i == 8 ? a[i].getText().replace(',', '.') : a[i].getText();
                  //System.out.println(b[i]);
               }
            }
            LocacaoDAO lDAO = new LocacaoDAO();
            
            if(status.equals("a")){//ALTERANDO
               if(lDAO.update(b)){
                  pane.remove(tabela);
                  pesquisar();   
                  tabela.setEnabled(true);
                  tabela.setBackground(COR);
                  habilitaTxts(false);
                  limpaTxts();
                  bthabilitar.setText(getBundle().getString("locacao.bthabilita"));
                  status = "";
                  //tabela.addRowSelectionInterval(tabela.getRowCount()+1,tabela.getRowCount()+1);//seleciona a ultima linha
               }
               else{
                  String msg = getBundle().getString("erro.locacao.alterar");
                  String[] options = {"  OK  "};
                  JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
               }
            }
            else if(status.equals("+")){//INCLUINDO
               if(lDAO.insert(b)){// && passou){
                  pane.remove(tabela);
                  pesquisar();   
                  tabela.setEnabled(true);
                  tabela.setBackground(COR);
                  habilitaTxts(false);
                  limpaTxts();
                  bthabilitar.setText(getBundle().getString("locacao.bthabilita"));
                  status = "";
                  //tabela.addRowSelectionInterval(tabela.getRowCount()+1,tabela.getRowCount()+1);//seleciona a ultima linha
               }
               else{
                  String msg = getBundle().getString("erro.locacao.inserir");
                  String[] options = {"  OK  "};
                  JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
               }
            }
         }//consistencia
      }
      
      
      //EXCLUIR REGISTRO
      else if(e.getSource() == btexcluir){
         String msg = getBundle().getString("erro.perguntaexcluir");
         String[] options = {"  SIM  ","  NÃO  "};//0 = sim, 1 = nao 
         int resp = JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
         if(resp == 0){
            LocacaoDAO lDAO = new LocacaoDAO();
            String code = txtlocacaocod.getText();
            if(lDAO.delete(code)){
               pesquisar();
               limpaTxts();
               habilitaTxts(false);
               habilitaBotoes(true,true,false,false,false);
               tabela.setEnabled(true);
               tabela.setBackground(COR);
            }
            else{
               msg = getBundle().getString("erro.locacao.excluir");
               String[] options2 = {"  OK  "};
               resp = JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
            }
         }
      }
      
      
      
      //INSERIR
      else if(e.getSource() == btadicionar){
         habilitaTxts(true);
         btconsultacli.setEnabled(true);
         btconsultacar.setEnabled(true);
         limpaTxts();
         lblstatus2.setText("ABERTO");
         txtlocacaocod.setEnabled(false);
         radkmlivre.setSelected(true);
         habilitaBotoes(false,false,false,true,true);
         bthabilitar.setText(getBundle().getString("locacao.bthabilita3"));
         btpagamento.setEnabled(false);
         tabela.setEnabled(false);
         tabela.getSelectionModel().clearSelection();
         status = "+";  
      } 
      
      
      //BOTAO DE PAGAMENTO
      else if(e.getSource() == btpagamento){
         GUIPagamento p = new GUIPagamento(frame);
         p.setBundle(getBundle());
         p.init(frame);
         p.setUsuario(getUsuario());
         p.pesquisar(txtlocacaocod.getText());
         this.dispose();
         p.setVisible(true);
      }
      
      else if(e.getSource() == radkmlivre){
         txtvalor.setText(taxaLivre);
      }
      
      else if(e.getSource() == radkmcontrol){
         txtvalor.setText(taxaControlado);
      }
   }//LISTENER
   
   
   
   
   
   
   ////////////////////////////////////////////////////////////////////////////////////////
   public void pesquisar(){
      pane.getViewport().remove(tabela);
      
      //RECRIA A TABELA
      tabela = new JTable();
      tabela.setGridColor(Color.BLACK);
      tabela.getTableHeader().setReorderingAllowed(false);//NAO MOVE AS COLUNAS
      tabela.setBorder(new LineBorder(Color.BLACK));
      tabela.setShowGrid(true);
      tabela.setBounds(0,0,WIDTH-40,140);
      tabela.setVisible(true);
      tabela.getSelectionModel().addListSelectionListener(new TabelaListener(tabela));
      
      repaint();
      int combo = combopesquisar.getSelectedIndex();
      String campo = "";
      String pesquisa = "";
      switch(combo){
         case 0: campo = "lc_code"; pesquisa = txtlocacaocod.getText(); break;
         case 1: campo = "cl_nome"; pesquisa = txtclinome.getText();    break;
         case 2: campo = "au_code";  pesquisa = txtcarcod.getText();    break;
         case 3: campo = "lc_dtlocacao";  pesquisa = txtdtlocacao.getText();break;
         default: campo = "cl_code";      pesquisa = "";                break;
      }
      if(pesquisando)
         pesquisa = txtpesquisa.getText();
      
      LocacaoDAO lDAO = new LocacaoDAO();
      locacoes = lDAO.consultarLocacao(pesquisa,campo);
      tabela.setModel(new TabelaLocacao(locacoes));
      pane.getViewport().add(tabela);
      
      add(pnlBotoes);
      remove(painelp);
      limpaTxts();
      habilitaTxts(false);
      btpagamento.setEnabled(false);
      tabela.getSelectionModel().clearSelection();
      habilitaBotoes(true,true,false,false,false);
      if(pesquisando)btpuxar.setEnabled(false);
      repaint();
      
      //if(tabela.getRowCount() > 0)
         //tabela.addRowSelectionInterval(0,0);  
   }
   ////////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   
   
   
   //TABELA LISTENER///////////////////////////////////////////////////////////////////////////
   class TabelaListener implements ListSelectionListener{
      JTable table;
   
      TabelaListener(JTable table) {
         this.table = table;
      }
      public void valueChanged(ListSelectionEvent e) {
         if (e.getSource() == table.getSelectionModel() && table.getRowSelectionAllowed()) {
            int first = e.getFirstIndex();
            int last = e.getLastIndex();
         }
         else if (e.getSource() == table.getColumnModel().getSelectionModel()&& table.getColumnSelectionAllowed()) {
            int first = e.getFirstIndex();
            int last = e.getLastIndex();
         }
         
         if(e.getValueIsAdjusting()){
            //PEGA O OBJETO QUE ESTA NA LINHA DA TABELA
            Locacao l = new Locacao();
            TabelaLocacao tabLoc = new TabelaLocacao(locacoes);
            l = tabLoc.getLinha(table.getSelectedRow());
            
            
            txtlocacaocod.setText(""+l.getLccode());           //CODIGO DA LOCACAO
            txtclinome.setText(l.getCliente().getNome());      //NOME DO CLIENTE
            txtcarcod.setText(""+l.getAutomovel().getCode());  //CODIGO DO CARRO
            try{                                               //DATA DE LOCACAO
               String data = String.valueOf(l.getDtlocacao());
               String s[] = data.split("-");
               txtdtlocacao.setText(s[2]+"/"+s[1]+"/"+s[0]);
            }catch(Exception ex ){txtdtlocacao.setText("");}
            
            
            //STATUS DA LOCACAO
            if(l.getStatus().substring(0,1).equals("A")){
               lblstatus2.setText(getBundle().getString("locacao.status.aberto"));
            }else if(l.getStatus().substring(0,1).equals("P")){
               lblstatus2.setText(getBundle().getString("locacao.status.alugado"));
            }else if(l.getStatus().substring(0,1).equals("D")){
               lblstatus2.setText(getBundle().getString("locacao.status.devolvido"));
            }else{
               lblstatus2.setText(getBundle().getString("locacao.status.fechado"));
            }
            
            
            txtclicod.setText(""+l.getCliente().getCode());    //CODIGO DO CLIENTE
            try{                                               //DATA DE DEVOLUCAO
               String data = String.valueOf(l.getDtprevista());
               String s[] = data.split("-");
               txtdtdevolucao.setText(s[2]+"/"+s[1]+"/"+s[0]);
            }catch(Exception ex){txtdtdevolucao.setText("");} 
            cbagalu.setSelectedIndex(l.getAglocacao().equals("SP") ? 0 : 1);  //AGENCIA DE LOCACAO
            cbagdev.setSelectedIndex(l.getAgprevista().equals("SP") ? 0 : 1); //AGENCIA DE DEVOLUCAO
            txtvalor.setText(l.getValor());                    //VALOR
            
            if(l.getTipokm().equals("L")){                     //TIPO DE KILOMETRAGEM  L - livre/ C - controlado
               radkmlivre.setSelected(true);
               radkmcontrol.setSelected(false);
            }else{
               radkmlivre.setSelected(false);
               radkmcontrol.setSelected(true);
            }   
            txtcarmodelo.setText(l.getAutomovel().getFabricante() + " - "+l.getAutomovel().getModelo());//FABRICANTE/MODELO DO CARRO
            locacao = l;
            
            //if(String.valueOf(l.getDtdevolucao()).equals("null")){
               btpagamento.setEnabled(true);
            //}else{
              // btpagamento.setEnabled(false);
            //}
            
            //HABILITA OS BOTOES
            habilitaBotoes(true,true,true,false,true);
            if(pesquisando)
               btpuxar.setEnabled(true);
         }
      }//valueChanged()
   }//tabelaLstener/////////////////////////////////////////////////////////////////////////////////////////
   
   
   
   
     
   //HABILITA BOTOES
   public void habilitaBotoes(boolean pesquisa, boolean novo, boolean excluir, boolean salvar, boolean habilitar){
      if(user.getNivel().compareToIgnoreCase("s") == 0){//SUPERVISOR
         btpesquisar.setEnabled(pesquisa);
         btadicionar.setEnabled(novo);
         btexcluir.setEnabled(excluir);
         btsalvar.setEnabled(salvar);
         bthabilitar.setEnabled(habilitar);
      }
      else{//ATENDENTE
         btpesquisar.setEnabled(true);
         btadicionar.setEnabled(false);
         btexcluir.setEnabled(false);
         btsalvar.setEnabled(false);
         bthabilitar.setEnabled(false);
      }
   }
   
   
   //LIMPA TXTS
   public void limpaTxts(){
      txtlocacaocod.setText("");
      txtclicod.setText("");
      txtclinome.setText("");
      txtcarcod.setText("");
      txtcarmodelo.setText("");
      txtdtlocacao.setText("");
      txtdtdevolucao.setText("");
      cbagalu.setSelectedIndex(-1);
      cbagdev.setSelectedIndex(-1);
      txtvalor.setText("");
      radkmlivre.setSelected(false);
      radkmcontrol.setSelected(false);
      lblstatus2.setText("");
      lblresposta.setText("");
   }
   
   //HABILITA TXTS
   public void habilitaTxts(boolean isActive){
      Color cor = isActive ? CORBRANCA : COR;
      txtlocacaocod.setEnabled(isActive);
      txtlocacaocod.setBackground(cor);
      txtclicod.setEnabled(false);
      txtclicod.setBackground(cor);
      txtclinome.setEnabled(false);
      txtclinome.setBackground(cor);
      txtcarcod.setEnabled(false);
      txtcarcod.setBackground(cor);
      txtcarmodelo.setEnabled(false);
      txtcarmodelo.setBackground(cor);
      txtdtlocacao.setEnabled(isActive);
      txtdtlocacao.setBackground(cor);
      txtdtdevolucao.setEnabled(isActive);
      txtdtdevolucao.setBackground(cor);
      cbagalu.setEnabled(isActive);
      cbagalu.setBackground(cor);
      cbagdev.setEnabled(isActive);
      cbagdev.setBackground(cor);
      txtvalor.setEnabled(false);
      //txtvalor.setBackground(cor);
      radkmlivre.setEnabled(isActive);
      radkmcontrol.setEnabled(isActive);
      repaint();
   }
   
   
   class ClienteListener implements ActionListener {
      @Override
      public void actionPerformed (ActionEvent evt){
         if(evt.getSource() == cliente.btpuxar){
            String info = cliente.consultarClientes();
            String s[] = info.split("#");
            txtclicod.setText(s[0]);
            txtclinome.setText(s[1]);
            cliente.dispose();
            txtcarcod.requestFocus();
         }
      }
   }
   
   
   class CarroListener implements ActionListener {
      @Override
      public void actionPerformed (ActionEvent evt){
         if(evt.getSource() == carro.btpuxar){
            boolean livre = true;//kmlivre ou controlado
            String info = carro.consultarCarros();
            String s[] = info.split("#");
            txtcarcod.setText(s[0]);
            txtcarmodelo.setText(s[1]);
            taxaLivre = s[3];
            taxaControlado = s[2]; 
            txtvalor.setText(radkmlivre.isSelected() ? s[3] : s[2]);
            carro.dispose();
         }
      }
   }
   
   
   public void addListenerConsulta(ActionListener ouvinte){
      btpuxar = new JButton(getBundle().getString("locacao.btpuxar"));
      btpuxar.addActionListener(ouvinte);
      btpuxar.setBounds(135,5,200,40);
      btpuxar.setEnabled(false);
      repaint();
	}
   
   public Locacao getLocacao(){
      TabelaLocacao tabLoc = new TabelaLocacao(locacoes);
      Locacao l = new Locacao();
      l = tabLoc.getLinha(tabela.getSelectedRow());
      return l;
   }
   
}//CLASSE