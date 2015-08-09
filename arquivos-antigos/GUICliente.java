import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.text.*;
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
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class GUICliente extends JDialog implements ActionListener {
   static final int WIDTH = 750;
	static final int HEIGHT = 650;
   static final Color COR = new Color(243,243,243);
   static final Color COR2 = new Color(219,219,219);
   static final Color CORBRANCA = new Color(255,255,255);
   
   private Border border;
	private Color verdeEscuro, vermelhoEscuro, cinza, branco;
	private Font normal, XLnormal, btnormal, negrito;
	private JScrollPane pane;
   private ResourceBundle bn = null;
   private JLabel lblcod, lblnome, lblemail, lbltelefone, lblendereco,lblnumend,lblbairro,lblrg,lblinformacoes,lblcpf,lbldata,lblcidade,lbluf;
	private JLabel lblpesquisar, lblnumregistro, lblestadoch, lblvalidade,lblcadastro,lblhabilitacaocidade, lblresposta;
	private JTextField txtcod, txtnome, txtendereco,txtnumend, txtbairro,txtemail,txtcidade,txtpesquisa;
   private JFormattedTextField txtcpf,txtrg,txttelefone,txtnascimento,txtvalidade,txtcadastro,cmbuf,cbestadoch;
   private MaskFormatter maskcpf,maskrg,masktelefone,masknascimento,maskvalidade,maskcadastro,maskuf,maskestadoch;
   private JTextField txtnumregistro,txthabilitacaocidade;
   private JButton btadicionar, btsalvar, bthabilitar, btpesquisar, btexcluir,btautomovel;
   protected  JButton btpuxar;
	private JTable tabela;
	private boolean selecionado = false,tabelaprincipal = true;
	private JButton btvoltar, btpesquisarcli, btloading;
	private JComboBox combopesquisar,cmbuf2, cbestadoch2;
   private String status;
	private JPanel painelp,pnlBotoes,painelc;
   private ClienteDAO cDAO;   
   private Usuario user;
   
   
   private boolean pesquisando;
   private int index;
   private String campo;
   
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
	public GUICliente(JFrame fr){
      super(fr,true);//1 parametro = JFrame a quem pertence, 2 parametro = titulo, 3 parametro = nunca perde o foco
      this.pesquisando = false;
   }
   
   public GUICliente(JFrame fr,boolean pesquisa,int index,String campo){
      super(fr,true);
      this.pesquisando = pesquisa;
      this.index = index;
      this.campo = campo;
   }
   
   public void init(JFrame fr){  
      status = "";
		        
      //PAINEL DE BOTOES
      //==============================================================================
      pnlBotoes = new JPanel(null);
      pnlBotoes.setBounds(20,10,WIDTH-40,50);
      
      btpesquisar = new JButton(getBundle().getString("cliente.btpesquisar"));
      btpesquisar.setBounds(0, 5, 130, 40);
      btpesquisar.addActionListener(this);
      pnlBotoes.add(btpesquisar);
      
      if(pesquisando)
         pnlBotoes.add(btpuxar);
         
      btadicionar = new JButton(getBundle().getString("cliente.btadicionar"));
      btadicionar.setBounds(135, 5, 130, 40);
      btadicionar.addActionListener(this);
      if(!pesquisando)pnlBotoes.add(btadicionar);
      
      btexcluir = new JButton(getBundle().getString("cliente.btexcluir"));
      btexcluir.setBounds(270, 5, 130, 40);
      btexcluir.addActionListener(this);
      if(!pesquisando)pnlBotoes.add(btexcluir);
      
		btsalvar = new JButton(getBundle().getString("cliente.btsalvar"));
      btsalvar.setBounds(405, 5, 130, 40);
		btsalvar.addActionListener(this);
      if(!pesquisando)pnlBotoes.add(btsalvar);
      
      bthabilitar = new JButton(getBundle().getString("cliente.bthabilitar"));
      bthabilitar.setBounds(540, 5, 130, 40);
      bthabilitar.addActionListener(this);
      if(!pesquisando)pnlBotoes.add(bthabilitar);
      
      habilitaBotoes(true,true,false,false,false);
      if(!pesquisando)
         add(pnlBotoes);
      //==============================================================================
      
      
      
      
      //PAINEL PESQUISAR
      //==============================================================================      
		painelp = new JPanel(null);
      painelp.setBounds(20,5,WIDTH-40,70);
      
      lblpesquisar = new JLabel(getBundle().getString("cliente.painelp.lblpesquisar"),JLabel.LEFT);
      lblpesquisar.setBounds(10, 0, 120, 30);
      lblpesquisar.setFont(XLnormal);
      painelp.add(lblpesquisar);

		String[] opcoespesq = { 
         bn("cliente.painelp.cborder0"), bn("cliente.painelp.cborder1"),
         bn("cliente.painelp.cborder2"), bn("cliente.painelp.cborder3")};
		combopesquisar = new JComboBox(opcoespesq);
      combopesquisar.setSelectedIndex(pesquisando ? index : -1);
      combopesquisar.setBounds(10, 30, 120, 30);
      combopesquisar.addActionListener(this);
      painelp.add(combopesquisar);
      
      if(pesquisando){
         txtpesquisa = new JTextField(campo);
         txtpesquisa.setBounds(140,30,130,30);
         txtpesquisa.setEnabled(true);
         txtpesquisa.setBackground(COR);
         painelp.add(txtpesquisa);
      }
            
      btpesquisarcli = new JButton(getBundle().getString("cliente.painelp.btpesquisarcli"));
      if(!pesquisando)btpesquisarcli.setBounds(140, 25, 120, 40);
      else btpesquisarcli.setBounds(280,25,120,40);
      btpesquisarcli.addActionListener(this);
      painelp.add(btpesquisarcli);		
      
      btvoltar = new JButton(getBundle().getString("cliente.painelp.btvoltar"));
      if(!pesquisando)btvoltar.setBounds(265, 25, 120, 40);
      else btvoltar.setBounds(405, 25, 120, 40);
      btvoltar.addActionListener(this);
      painelp.add(btvoltar);
      
      if(pesquisando)
         add(painelp);
      //==============================================================================

      
      
      
      //PAINEL CLIENTE
      //==============================================================================
      String msg = getBundle().getString("erro.mascara"); //erro na mascara
      
      lblresposta = new JLabel("...");
      lblresposta.setBounds(20,60,WIDTH-40,30);
      lblresposta.setForeground(Color.RED);
      lblresposta.setFont(new Font("Lucida Sans", Font.PLAIN, 18));
      add(lblresposta);
      
      
		painelc = new JPanel(null);
      painelc.setBounds(20, 90, WIDTH-40, 340);
      
		painelc.setBorder(BorderFactory.createTitledBorder(null,
				getBundle().getString("cliente.painelc.title"), TitledBorder.CENTER,
				TitledBorder.TOP, new Font("Lucida Sans", Font.PLAIN, 16),
				Color.BLUE));
            
		lblcod = new JLabel(getBundle().getString("cliente.painelc.lblcod"));
      lblcod.setBounds(10, 30, 100, 30);
      lblcod.setFont(normal);
		txtcod = new JTextField();
      txtcod.setBounds(10, 60, 100, 30);
      txtcod.setBorder(BorderFactory.createCompoundBorder(txtcod.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txtcod.setEnabled(false);
      txtcod.setBackground(COR);
      painelc.add(lblcod);
      painelc.add(txtcod);
      
      
		lblnome = new JLabel(getBundle().getString("cliente.painelc.lblnome"));
      lblnome.setBounds(120, 30, 360, 30);
      lblnome.setFont(normal);
		txtnome = new JTextField();    
      txtnome.setBounds(120, 60, 360, 30);
      txtnome.setBorder(BorderFactory.createCompoundBorder(txtnome.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txtnome.setEnabled(false);
      txtnome.setBackground(COR);
      painelc.add(lblnome);
      painelc.add(txtnome);
            
      
		lblemail = new JLabel(getBundle().getString("cliente.painelc.lblemail"));
      lblemail.setBounds(490, 30, 200, 30);
      lblemail.setFont(normal);
		txtemail = new JTextField();
      txtemail.setBounds(490,60, 200, 30);
      txtemail.setBorder(BorderFactory.createCompoundBorder(txtemail.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txtemail.setEnabled(false);
      txtemail.setBackground(COR);
      painelc.add(lblemail);
      painelc.add(txtemail);
      
      
      lblendereco = new JLabel(getBundle().getString("cliente.painelc.lblendereco"));
      lblendereco.setBounds(10, 90, 270, 30);
      lblendereco.setFont(normal);
		txtendereco = new JTextField();
      txtendereco.setBounds(10, 120, 270, 30);
      txtendereco.setBorder(BorderFactory.createCompoundBorder(txtendereco.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txtendereco.setEnabled(false);
      txtendereco.setBackground(COR);
      painelc.add(lblendereco);
      painelc.add(txtendereco);
      
      
      lblnumend = new JLabel(getBundle().getString("cliente.painelc.lblnumend"));
      lblnumend.setBounds(290, 90, 50, 30);
      lblnumend.setFont(normal);
		txtnumend = new JTextField();
      txtnumend.setBounds(290, 120, 50, 30);
      txtnumend.setBorder(BorderFactory.createCompoundBorder(txtnumend.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txtnumend.setEnabled(false);
      txtnumend.setBackground(COR);
      painelc.add(lblnumend);
      painelc.add(txtnumend);


      lblbairro = new JLabel(getBundle().getString("cliente.painelc.lblbairro"));
      lblbairro.setBounds(350, 90, 160, 30);
      lblbairro.setFont(normal);
		txtbairro = new JTextField();
      txtbairro.setBounds(350, 120, 160, 30);
      txtbairro.setEnabled(false);
      txtbairro.setBackground(COR);
      painelc.add(lblbairro);
      painelc.add(txtbairro);
      
      
      lbltelefone = new JLabel(getBundle().getString("cliente.painelc.lbltelefone"));
      lbltelefone.setBounds(520, 90, 160, 30);
      lbltelefone.setFont(normal);
      try{
         masktelefone = new MaskFormatter("(##) ####-####");
         masktelefone.setPlaceholderCharacter('_');
         txttelefone = new JFormattedTextField(masktelefone);
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,msg);
      }
		
      txttelefone.setBounds(520, 120, 160, 30);
      txttelefone.setBorder(BorderFactory.createCompoundBorder(txttelefone.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txttelefone.setEnabled(false);
      txttelefone.setBackground(COR);
      painelc.add(lbltelefone);
      painelc.add(txttelefone);
      
      
      lblcidade = new JLabel(getBundle().getString("cliente.painelc.lblcidade"));
      lblcidade.setBounds(10, 150, 180, 30);
      lblcidade.setFont(normal);
		txtcidade = new JTextField();      
      txtcidade.setBounds(10, 180, 180, 30); 
      txtcidade.setBorder(BorderFactory.createCompoundBorder(txtcidade.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txtcidade.setEnabled(false);
      txtcidade.setBackground(COR);
      painelc.add(lblcidade);
      painelc.add(txtcidade);
       
      
      lbluf = new JLabel(getBundle().getString("cliente.painelc.lbluf"));
      lbluf.setBounds(220, 150, 100, 30);
      lbluf.setFont(normal);
      String[] opcoes3 = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PR","PB","PA","PE","PI","RJ","RN","RS","RO","RR","SC","SE","SP","TO" };
      try{
         maskuf = new MaskFormatter("UU");
         maskuf.setPlaceholderCharacter('_');
         cmbuf = new JFormattedTextField(maskuf);
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,msg);
      }
      cmbuf.setBounds(220, 180, 35, 30);
      cmbuf.setEnabled(false);
      cmbuf.setBackground(COR);
      painelc.add(lbluf);
      painelc.add(cmbuf);
      
           
		lbldata = new JLabel(getBundle().getString("cliente.painelc.lbldata"));
      lbldata.setBounds(310, 150, 130, 30);
      lbldata.setFont(normal);
      try{
         masknascimento = new MaskFormatter("##/##/####");
         masknascimento.setPlaceholderCharacter('_');
         txtnascimento = new JFormattedTextField(masknascimento);
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,msg);
      }
      txtnascimento.setBounds(310,180,100,30);
      txtnascimento.setBorder(BorderFactory.createCompoundBorder(txtnascimento.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txtnascimento.setEnabled(false);
      painelc.add(lbldata);
      painelc.add(txtnascimento);
      
      
      lblcadastro = new JLabel(getBundle().getString("cliente.painelc.lblcadastro"));        
      lblcadastro.setBounds(430, 150, 130, 30);
      lblcadastro.setFont(normal);
      try{
         maskcadastro = new MaskFormatter("##/##/####");
         maskcadastro.setPlaceholderCharacter('_');
         txtcadastro = new JFormattedTextField(maskcadastro);
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,msg);
      }
      txtcadastro.setBounds(430, 180, 100, 30);
      txtcadastro.setBorder(BorderFactory.createCompoundBorder(txtcadastro.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txtcadastro.setEnabled(false);
      txtcadastro.setBackground(COR);
      painelc.add(lblcadastro);
      painelc.add(txtcadastro);
      
		lblrg = new JLabel(getBundle().getString("cliente.painelc.lblrg"));
      lblrg.setBounds(550, 150, 130, 30);
      lblrg.setFont(normal);
      try{
         maskrg = new MaskFormatter("##.###.###-#");
         maskrg.setPlaceholderCharacter('_');
         txtrg = new JFormattedTextField(maskrg);
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,msg);
      }
      txtrg.setBounds(550, 180, 130, 30);
      txtrg.setBorder(BorderFactory.createCompoundBorder(txtrg.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txtrg.setEnabled(false);
      txtrg.setBackground(COR);
      painelc.add(lblrg);
      painelc.add(txtrg);
      
      lblcpf = new JLabel(getBundle().getString("cliente.painelc.lblcpf"));
      lblcpf.setBounds(10, 210, 130, 30);
      lblcpf.setFont(normal);
      try{
         maskcpf = new MaskFormatter("#########-##");
         maskcpf.setPlaceholderCharacter('_');
         txtcpf = new JFormattedTextField(maskcpf);
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,msg);
      }
      txtcpf.setBounds(10, 240, 130, 30);
      txtcpf.setBorder(BorderFactory.createCompoundBorder(txtcpf.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txtcpf.setEnabled(false);
      txtcpf.setBackground(COR);
      painelc.add(lblcpf);
      painelc.add(txtcpf);
      
      
      
      //DADOS DA HABILITAÇÃO
      lblnumregistro = new JLabel(getBundle().getString("cliente.painelc.lblnumregistro"));
      lblnumregistro.setBounds(10,270,100,30);
      txtnumregistro = new JTextField();
      txtnumregistro.setBounds(10,300,100,30);
      txtnumregistro.setBorder(BorderFactory.createCompoundBorder(txtnumregistro.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txtnumregistro.setEnabled(false);
      txtnumregistro.setBackground(COR);
      painelc.add(lblnumregistro);
      painelc.add(txtnumregistro);
      
      lblhabilitacaocidade = new JLabel(getBundle().getString("cliente.painelc.lblhabilitacaocidade"));
      lblhabilitacaocidade.setBounds(120,270,120,30);
      txthabilitacaocidade = new JTextField();
      txthabilitacaocidade.setBounds(120,300,120,30);
      txthabilitacaocidade.setBorder(BorderFactory.createCompoundBorder(txthabilitacaocidade.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txthabilitacaocidade.setEnabled(false);
      txthabilitacaocidade.setBackground(COR);
      painelc.add(lblhabilitacaocidade);
      painelc.add(txthabilitacaocidade);
      
      lblestadoch = new JLabel(getBundle().getString("cliente.painelc.lblestadoch"));
      lblestadoch.setBounds(260,270,100,30);
      try{
         maskestadoch = new MaskFormatter("UU");
         maskestadoch.setPlaceholderCharacter('_');
         cbestadoch = new JFormattedTextField(maskestadoch);
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,msg);
      }
      cbestadoch.setBounds(270,300,35,30);
      cbestadoch.setEnabled(false);
      cbestadoch.setBackground(COR);
      painelc.add(lblestadoch);
      painelc.add(cbestadoch);

      lblvalidade = new JLabel(getBundle().getString("cliente.painelc.lblvalidade"));
      lblvalidade.setBounds(360,270,100,30);
      try{
         maskvalidade = new MaskFormatter("##/##/####");
         maskvalidade.setPlaceholderCharacter('_');
      }catch(Exception e){
         JOptionPane.showMessageDialog(null,msg);
      }
      txtvalidade = new JFormattedTextField(maskvalidade);
      txtvalidade.setBounds(360,300,100,30);
      txtvalidade.setBorder(BorderFactory.createCompoundBorder(txtvalidade.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txtvalidade.setEnabled(false);
      txtvalidade.setBackground(COR);
      painelc.add(lblvalidade);
      painelc.add(txtvalidade);
      
      //BLOQUEIA CAMPOS
      habilitaTxt(false);
      limpaTxts();
      if(!pesquisando)
         add(painelc);
		//==============================================================================
      
            

		//TABELAS      
		//==============================================================================
		tabela = new JTable();
		tabela.setGridColor(Color.BLACK);
      tabela.getTableHeader().setReorderingAllowed(false);//nao move as colunas
		tabela.setBorder(new LineBorder(Color.BLACK));
		tabela.setShowGrid(true);
      tabela.setBounds(0,0,WIDTH-40,140);
      setIconImage(new ImageIcon(getClass().getResource("images/logo2.png")).getImage());
      tabela.setVisible(true);
		
      TabelaListener listener = new TabelaListener(tabela);
      tabela.getSelectionModel().addListSelectionListener(listener);
      
      
      btloading = new JButton();
      btloading.setIcon(new ImageIcon(getClass().getResource("images/loading.gif")));
      btloading.setBounds(0,0,50,50);
      btloading.setBorderPainted(false); 
      btloading.setContentAreaFilled(false); 
      btloading.setFocusPainted(false); 
      btloading.setOpaque(false);
      btloading.setEnabled(false);

      pane = new JScrollPane();
      pane.getViewport().add(tabela);
      if(!pesquisando)
         pane.setBounds(20, 440, WIDTH-40, 140);
      else
         pane.setBounds(20, 100, WIDTH-40, 140);
      add(pane);
		//==============================================================================
      

		
      
      //===============================================================================================================
      setTitle(getBundle().getString(pesquisando ? "cliente.title2" : "cliente.title"));
      setResizable(false);
      setLayout(null);
      if(!pesquisando)
   		setSize(WIDTH, HEIGHT);
      else
         setSize(WIDTH,290);
		setLocationRelativeTo(null); 
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
      
      
      repaint();
   }//INIT()
   
   
   
   public void actionPerformed(ActionEvent e) {
      //VAI PARA A TELA DE PESQUISA
      if(e.getSource() == btpesquisar){
         remove(pnlBotoes);
         add(painelp);
         combopesquisar.setSelectedIndex(-1);
         tabela.setEnabled(false);
         tabela.setBackground(COR);
         limpaTxts();
         habilitaTxt(false);
         combopesquisar.requestFocus();
         if(pesquisando)btpuxar.setEnabled(false);
         repaint();
      }
      
      //CANCELA A PESQUISA
      else if(e.getSource() == btvoltar){
         add(pnlBotoes);
         remove(painelp);
         limpaTxts();
         habilitaTxt(false);
         tabela.getSelectionModel().clearSelection();
         tabela.setEnabled(true);
         tabela.setBackground(COR);
         habilitaBotoes(true,true,false,false,false);
         if(pesquisando)btpuxar.setEnabled(false);
         repaint();
      }
      
      //ONCHANGE DO COMBOBOX DE PESQUISA
      else if(e.getSource() == combopesquisar){
         habilitaTxt(false);
         int combo = combopesquisar.getSelectedIndex();
         switch(combo){
            case 0://Código
               limpaTxts();
               txtcod.setEnabled(true);
               txtcod.setBackground(new Color(255,255,255));
               txtcod.requestFocus();
            break;
            
            case 1://Nome
               limpaTxts();
               txtnome.setEnabled(true);
               txtnome.setBackground(new Color(255,255,255));
               txtnome.requestFocus();
            break;
            
            case 2://CPF
               limpaTxts();
               txtcpf.setEnabled(true);
               txtcpf.setBackground(new Color(255,255,255));
               txtcpf.requestFocus();
            break;
            
            case 3://Documento
               limpaTxts();
               txtrg.setEnabled(true);
               txtrg.setBackground(new Color(255,255,255));
               txtrg.requestFocus();
            break;
         }//switch
         if(pesquisando){
            txtpesquisa.setEnabled(true);
            txtpesquisa.requestFocus();
         }
		}//combopesquisa listener
      
      
      
      //REALIZAR A PESQUISA NO BANCO
      else if(e.getSource() == btpesquisarcli){
         pesquisar();
      }//PESQUISAR
      
      
      //HABILITAR EDIÇÃO
      else if(e.getSource() == bthabilitar){
         if(status.equals("")){
            tabela.setEnabled(false);
            tabela.setBackground(COR2);
            habilitaTxt(true);
            txtcod.setEnabled(false);
            txtnome.requestFocus();
            habilitaBotoes(false,false,false,true,true);
            bthabilitar.setText(getBundle().getString("cliente.bthabilitar2"));
            status = "a";
         }
         else if(status.equals("a") || status.equals("+")){//ESTOU ALTERANDO OS DADOS
            String msg = getBundle().getString("erro.perguntasalvar");
            String[] options = {"  "+getBundle().getString("erro.opcoes.sim")+"  ","  "+getBundle().getString("erro.opcoes.nao")+"  "};//0 = sim, 1 = nao 
            int resp = JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if(resp == 0){
               limpaTxts();
               habilitaTxt(false);
               habilitaBotoes(true,true,false,false,false);
               bthabilitar.setText(getBundle().getString("cliente.bthabilitar"));
               status = "";
               tabela.getSelectionModel().clearSelection();
               tabela.setEnabled(true);
               tabela.setBackground(COR);
               status = "";
            }
         }
      }//HABILITA EDICAO
      
      
      
      
      //GRAVAR ALTERÇÃO
      else if(e.getSource() == btsalvar){
      	if(status.equals("a")){//ALTERANDO
            boolean passou = true;
            
				JTextField a[] = {txtcod,txtnome,txtcpf,txtrg,txttelefone,
                           txtemail,txtnascimento,new JTextField("f"),cmbuf,txtcidade,
                           txtendereco,txtnumend,txtcadastro,txtnumregistro,txtvalidade,
                           cbestadoch,txthabilitacaocidade,txtbairro};
				String b[] = new String[a.length];
            boolean vazio = false;
				for(int i = 0; i < a.length; i++){
               if(a[i].getText().equals("") || a[i].getText().equals("__/__/___") || a[i].getText().equals("__.___.___-_")
               || a[i].getText().equals("(__) ____-____") || a[i].getText().equals("__") || a[i].getText().equals("_________-__")){
                  String msg = getBundle().getString("erro.pvreenchadados");
                  String[] options = {"  OK  "};
                  JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                  vazio = true;
                  a[i].requestFocus();
                  break;
               }
					if(i >= 2 && i <= 4){
                  b[i] = a[i].getText().replaceAll("\\D+","");
               }else
                  b[i] = a[i].getText();
               if(a[i].getText().equals(""))
                  passou = false;
            }
            if(!vazio){
   				ClienteDAO cDAO = new ClienteDAO();
   				if(cDAO.update(b) && passou){
                  pane.remove(tabela);
   					pesquisar();   
                  tabela.setEnabled(true);
                  tabela.setBackground(COR);
                  habilitaTxt(false);
                  limpaTxts();
                  bthabilitar.setText(getBundle().getString("cliente.bthabilitar"));
                  status = "";
   				}else{
                  String msg = getBundle().getString("erro.inserir");
                  String[] options2 = {"  OK  "};
                  int resp = JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
   				}
            }
			}
         
         //INSERINDO
         else if(status.equals("+")){
            JTextField a[] = {txtcod,txtnome,txtcpf,txtrg,txttelefone,
                           txtemail,txtnascimento,new JTextField("f"),cmbuf,txtcidade,
                           txtendereco,txtnumend,txtcadastro,txtnumregistro,txtvalidade,
                           cbestadoch,txthabilitacaocidade,txtbairro};
            boolean vazio = false;
				String b[] = new String[a.length];
				for(int i = 0; i < a.length; i++){
               if(a[i].getText().equals("") || a[i].getText().equals("__/__/___") || a[i].getText().equals("__.___.___-_")
               || a[i].getText().equals("(__) ____-____") || a[i].getText().equals("__") || a[i].getText().equals("_________-__")){
                  String msg = getBundle().getString("erro.pvreenchadados");
                  String[] options = {"  OK  "};
                  JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                  vazio = true;
                  a[i].requestFocus();
                  break;
               }
					if(i == 2 || i == 3 || i== 4 ){
                  b[i] = a[i].getText().replaceAll("\\D+","");
               }else
                  b[i] = a[i].getText();
				}
            if(!vazio){
   				ClienteDAO cDAO = new ClienteDAO();
   				if(cDAO.insert(b)){
                  pesquisar();
                  tabela.setEnabled(true);
                  tabela.setBackground(COR);
                  habilitaTxt(false);
                  bthabilitar.setText(getBundle().getString("cliente.bthabilitar"));
                  limpaTxts();
               }else{
                  String msg = getBundle().getString("erro.inserir");
                  String[] options2 = {"  OK  "};
                  int resp = JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
               }
            }
         }  
      }//GRAVAR
      
      
      //EXCLUIR CLIENTE
      else if(e.getSource() == btexcluir){
         String codigo = txtcod.getText();
         ClienteDAO cDAO = new ClienteDAO();
			if(cDAO.delete(codigo)){
            pesquisar();
            tabela.setEnabled(true);
            tabela.setBackground(COR);
            habilitaTxt(false);
            limpaTxts();
         }
      }//EXCLUIR
      
      
      //INSERIR
      else if(e.getSource() == btadicionar){
         habilitaTxt(true);
         limpaTxts();
         txtcod.setEnabled(false);
         habilitaBotoes(false,false,false,true,true);
         bthabilitar.setText(getBundle().getString("cliente.bthabilitar3"));
         status = "+";
      }//INSERIR
   }
   
   //REALIZA A PESQUISA NO BANCO DE DADOS
   public void pesquisar(){
      pane.getViewport().remove(tabela);
      pane.getViewport().add(btloading);
      
      //RECRIA A TABELA
      tabela = new JTable();
		tabela.setGridColor(Color.BLACK);
      tabela.getTableHeader().setReorderingAllowed(false);//NAO MOVE AS COLUNAS
		tabela.setBorder(new LineBorder(Color.BLACK));
		tabela.setShowGrid(true);
      tabela.setBounds(0,0,WIDTH-40,140);
      tabela.setVisible(true);
      TabelaListener listener = new TabelaListener(tabela);
      tabela.getSelectionModel().addListSelectionListener(listener);
      
      repaint();
      int combo = combopesquisar.getSelectedIndex();
      String campo = "";
      String pesquisa = "";
      
      //TODO
      switch(combo){
         case 0: campo = "cl_code";       pesquisa = pesquisando ? txtpesquisa.getText() : txtcod.getText();break;
         case 1: campo = "cl_nome";       pesquisa = pesquisando ? txtpesquisa.getText() : txtnome.getText();break;
         case 2: campo = "cl_cpf";        pesquisa = pesquisando ? txtpesquisa.getText() : txtcpf.getText();break;
         case 3: campo = "cl_documento";  pesquisa = pesquisando ? txtpesquisa.getText() : txtrg.getText();break;
         default: campo = "cl_code";      pesquisa = "";break;
      }
      
      
      ClienteDAO cDAO = new ClienteDAO();
		ArrayList<Cliente> cli = cDAO.consultarCliente(pesquisa,campo);
      tabela.setModel(new TabelaCliente(cli,getBundle()));
      pane.getViewport().remove(btloading);
      pane.getViewport().add(tabela);
      
      add(pnlBotoes);
      remove(painelp);
      limpaTxts();
      habilitaTxt(false);
      tabela.getSelectionModel().clearSelection();
      habilitaBotoes(true,true,false,false,false);
      
      //FAZ COM QUE SOMENTE AS 5 PRIMEIRAS COLUNAS TABELA SEJAM EXIBIDAS
      for(int i = 5; i < tabela.getColumnCount(); i++){
         tabela.getColumnModel().getColumn(i).setMaxWidth(0);
         tabela.getColumnModel().getColumn(i).setPreferredWidth(0);
         tabela.getColumnModel().getColumn(i).setMinWidth(0);                  
      }
      repaint();
   }
   
   class TabelaListener implements ListSelectionListener{
	   JTable table;
      TabelaListener(JTable table) {
         this.table = table;
      }
      public void valueChanged(ListSelectionEvent e) {
         if (e.getSource() == table.getSelectionModel() && table.getRowSelectionAllowed()) {
            int first = e.getFirstIndex();
            int last = e.getLastIndex();
         }else if (e.getSource() == table.getColumnModel().getSelectionModel()&& table.getColumnSelectionAllowed()) {
            int first = e.getFirstIndex();
            int last = e.getLastIndex();
         }

         if(e.getValueIsAdjusting()){
          /*CL_CODE, CL_NOME, CL_CPF, CL_DOCUMENTO, CL_TELEFONE, 
            CL_EMAIL,CL_NASCIMENTO,CL_SEXO,CL_UFCODE, CL_CIDADE,
            CL_ENDERECO,CL_NUMENDERECO,CL_CADASTRO,CL_HB_NUM,CL_HB_VALIDADE
            A,CL_HB_UFCODE, CL_HB_CIDADE,CL_BAIRRO*/
            JTextField a[] = {txtcod,txtnome,txtcpf,txtrg,txttelefone,
                              txtemail,txtnascimento,new JTextField("sexo"),cmbuf,txtcidade,
                              txtendereco,txtnumend,txtcadastro,txtnumregistro,txtvalidade,
                              cbestadoch,txthabilitacaocidade,txtbairro};
            for(int i = 0; i < 18; i++){
               if(i == 6 || i == 12 || i == 14){
                  try{
                     String data = String.valueOf(tabela.getModel().getValueAt(table.getSelectedRow(),i));
                     String s[] = data.split("-");
                     a[i].setText(s[2]+"/"+s[1]+"/"+s[0]);
                  }catch(Exception b){
                     String msg2 = getBundle().getString("erro.tabela");
                     JOptionPane.showMessageDialog(null,msg2);
                  }
               }else{
                  a[i].setText(String.valueOf(tabela.getModel().getValueAt(table.getSelectedRow(),i)));
               }
            }
            //HABILITA OS BOTOES
            habilitaBotoes(true,true,true,false,true);
            
            if(pesquisando)
               btpuxar.setEnabled(true);
         }
      }
   }//tabelaListener
   
   
   
   public void limpaTxts(){
      txtcod.setText("");
      txtnome.setText("");
      txtemail.setText("");
      txtendereco.setText("");
      txtnumend.setText("");
      txtbairro.setText("");
      txttelefone.setText("");
      txtcidade.setText("");
      cmbuf.setText("");
      txtrg.setText("");
      txtcpf.setText("");
      cbestadoch.setText("");
      txtnascimento.setText("");      
      txtvalidade.setText("");
      txtnumregistro.setText("");
      txthabilitacaocidade.setText("");
      txtcadastro.setText("");
   }
   
   public void habilitaTxt(boolean isActive){
      Color cor = isActive ? COR : CORBRANCA;
      ///Color cor = new Color(243,243,243);
      txtcod.setEnabled(isActive);
      txtcod.setBackground(cor);
      txtnome.setEnabled(isActive);
      txtnome.setBackground(cor);
      txtemail.setEnabled(isActive);
      txtemail.setBackground(cor);
      txtendereco.setEnabled(isActive);
      txtendereco.setBackground(cor);
      txtnumend.setEnabled(isActive);
      txtnumend.setBackground(cor);
      txtbairro.setEnabled(isActive);
      txtbairro.setBackground(cor);
      txttelefone.setEnabled(isActive);
      txttelefone.setBackground(cor);
      txtcidade.setEnabled(isActive);
      txtcidade.setBackground(cor);
      cmbuf.setEnabled(isActive);
      cmbuf.setBackground(cor);
      txtrg.setEnabled(isActive);
      txtrg.setBackground(cor);
      txtcpf.setEnabled(isActive);
      txtcpf.setBackground(cor);
      cbestadoch.setEnabled(isActive);
      cbestadoch.setBackground(cor);
      txtnascimento.setEnabled(isActive);
      txtnascimento.setBackground(cor);
      txtvalidade.setEnabled(isActive);
      txtvalidade.setBackground(cor);
      txtcadastro.setEnabled(isActive);
      txtcadastro.setBackground(cor);
      txtnumregistro.setEnabled(isActive);
      txtnumregistro.setBackground(cor);
      txthabilitacaocidade.setEnabled(isActive);
      txtnumregistro.setBackground(cor);
      repaint();
   }
   
   
   public void habilitaBotoes(boolean pesquisa, boolean novo, boolean excluir, boolean salvar, boolean habilitar){
      if(user.getNivel().compareToIgnoreCase("s") == 0){//SUPERVISOR
         btpesquisar.setEnabled(pesquisa);
         btadicionar.setEnabled(novo);
         btexcluir.setEnabled(excluir);
         btsalvar.setEnabled(salvar);
         bthabilitar.setEnabled(habilitar);
      }else{//ATENDENTE
         btpesquisar.setEnabled(true);
         btadicionar.setEnabled(false);
         btexcluir.setEnabled(false);
         btsalvar.setEnabled(false);
         bthabilitar.setEnabled(false);
      }
   }  
   
   
   public String consultarClientes(){
      return txtcod.getText()+"#"+txtnome.getText();
   }
   
   public void addListenerConsulta(ActionListener ouvinte){
      btpuxar = new JButton(getBundle().getString("cliente.btpuxar"));
      btpuxar.addActionListener(ouvinte);
      btpuxar.setBounds(135,5,200,40);
      btpuxar.setEnabled(false);
      repaint();
	}
   
}
		
