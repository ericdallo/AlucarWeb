import java.awt.Color;
import java.awt.Font;
import java.util.*;
import java.awt.event.*;

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

public class GUIAutomovel extends JDialog implements ActionListener {
   static final int WIDTH = 750;
   static final int HEIGHT = 600;
   static final Color COR = new Color(243,243,243);
   static final Color COR2 = new Color(219,219,219);
   static final Color CORBRANCA = new Color(255,255,255);
   private ResourceBundle bn = null;
   private JLabel lblcod, lblchassi, lblmodelo, lblfabricante, lblplaca,lblgrupo,lblestado,lblkmlivre,lblinformacoes,lblacessorios,lblkm,lblcidade,lblkmcontrolado,lblfoto;
   private JTextField txtcod, txtchassi, txtmodelo, txtfabricante,txtplaca, txtcidade,txtkmlivre,txtkm,txtkmcontrolado, txtpesquisa;
   private JFormattedTextField txtestado;
   private MaskFormatter maskestado;
   private JButton btadicionar, btsalvar, bthabilitar, btpesquisar, btexcluir,btautomovel,btconteudofoto;
   private JFileChooser chooser;   
   private Border border;
   private Color verdeEscuro, vermelhoEscuro, cinza, branco;
   private Font normal, XLnormal, btnormal, negrito;
   private JScrollPane pane;
   private JTable tabela,tabela2;
   private boolean selecionado = false,tabelaprincipal = true,escolheu = false;
   private JLabel lblpesquisar;
   private JButton btvoltar, btpesquisaraut,btloading;
   protected  JButton btpuxar;
   private JComboBox combopesquisar;
	private JCheckBox chkgps,chkcadeira,chkmotorista;
   private JTextField txtgrupo;
   private String status,caminho = "";
   private final String DIRETORIO = System.getProperty("user.dir");
   private JFrame frame;
   private AutomovelDAO aDAO;
   private JPanel painelp,pnlBotoes,painela;
   private JButton btnrelatorio;
   
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
   public GUIAutomovel(JFrame fr){
      super(fr,true);//1 parametro = JFrame a quem pertence, 2 parametro = titulo, 3 parametro = nunca perde o foco
      frame = fr;
   }
   public GUIAutomovel(JFrame fr,boolean pesquisa,int index,String campo){
      super(fr,true);
      this.pesquisando = pesquisa;
      this.index = index;
      this.campo = campo;
      frame = fr;
   }
   
   public void init(JFrame fr){    
      status = "";
      lblinformacoes = new JLabel("");
      
      
      
      //==============================================================================
      //PAINEL DE BOTOES
      pnlBotoes = new JPanel(null);
      pnlBotoes.setBounds(20,10,WIDTH-40,50);
      
      if(pesquisando)
         pnlBotoes.add(btpuxar);
      
      btpesquisar = new JButton(getBundle().getString("automovel.btpesquisar"));
      btpesquisar.setBounds(0, 5, 130, 40);
      btpesquisar.addActionListener(this);
      pnlBotoes.add(btpesquisar);
      
      btadicionar = new JButton(getBundle().getString("automovel.btadicionar"));
      btadicionar.setBounds(135, 5, 130, 40);
      btadicionar.addActionListener(this);
      if(!pesquisando)pnlBotoes.add(btadicionar);
      
      btexcluir = new JButton(getBundle().getString("automovel.btexcluir"));
      btexcluir.setBounds(270, 5, 130, 40);
      btexcluir.addActionListener(this);
      if(!pesquisando)pnlBotoes.add(btexcluir);
      
      btsalvar = new JButton(getBundle().getString("automovel.btsalvar"));
      btsalvar.setBounds(405, 5, 130, 40);
      btsalvar.addActionListener(this);
      if(!pesquisando)pnlBotoes.add(btsalvar);
      
      bthabilitar = new JButton(getBundle().getString("automovel.bthabilitar"));
      bthabilitar.setBounds(540, 5, 130, 40);
      bthabilitar.addActionListener(this);
      if(!pesquisando)pnlBotoes.add(bthabilitar);
          
      if(!pesquisando)add(pnlBotoes);
      //==============================================================================
      
      
      
      //==============================================================================
      //PAINEL PESQUISAR
      //==============================================================================      
		painelp = new JPanel(null);
      painelp.setBounds(20,0,WIDTH-40,70);
      
      lblpesquisar = new JLabel(getBundle().getString("automovel.painelp.lblpesquisar"),JLabel.LEFT);
      lblpesquisar.setBounds(10, 0, 120, 30);
      lblpesquisar.setFont(XLnormal);
      painelp.add(lblpesquisar);
      
		String[] opcoespesq = { 
         bn("automovel.painelp.cborder0"), bn("automovel.painelp.cborder1"),
         bn("automovel.painelp.cborder2"), bn("automovel.painelp.cborder3")};
		combopesquisar = new JComboBox(opcoespesq);
      combopesquisar.setSelectedIndex(-1);
      combopesquisar.setBounds(10, 30, 120, 30);
      combopesquisar.addActionListener(this);
      painelp.add(combopesquisar);
      
      btpesquisaraut = new JButton(getBundle().getString("automovel.painelp.btpesquisaraut"));
      if(!pesquisando)btpesquisaraut.setBounds(140, 25, 120, 40);
      else btpesquisaraut.setBounds(280,25,120,40);
      btpesquisaraut.addActionListener(this);
      painelp.add(btpesquisaraut);		
      
      btvoltar = new JButton(getBundle().getString("automovel.painelp.btvoltar"));
      if(!pesquisando)btvoltar.setBounds(265, 25, 120, 40);
      else btvoltar.setBounds(405, 25, 120, 40);
      btvoltar.addActionListener(this);
      painelp.add(btvoltar);
      
      if(pesquisando){
         txtpesquisa = new JTextField(campo);
         txtpesquisa.setBounds(140,30,130,30);
         txtpesquisa.setEnabled(true);
         txtpesquisa.setBackground(COR);
         painelp.add(txtpesquisa);
      }
      
      btnrelatorio = new JButton(bn("automovel.btrelatorio"));
      btnrelatorio.setBounds(500,25,210,40);
      btnrelatorio.addActionListener(this);
      if(!pesquisando)painelp.add(btnrelatorio);
      
      if(pesquisando)add(painelp);
      //==============================================================================

      
      
      
      
      //==============================================================================
   	//PAINEL AUTOMOVEL
      painela = new JPanel(null);
      painela.setBounds(20, 80, WIDTH-40, 320);
      painela.setBorder(BorderFactory.createTitledBorder(null,
         	getBundle().getString("automovel.painela.title"), TitledBorder.CENTER,
         	TitledBorder.TOP, new Font("Lucida Sans", Font.PLAIN, 16),
         	Color.RED));
      
      lblcod = new JLabel(getBundle().getString("automovel.painela.lblcod"));
      lblcod.setBounds(10, 30, 100, 30);
      lblcod.setFont(normal);
      txtcod = new JTextField();
      txtcod.setBounds(10, 60, 100, 30);
      txtcod.setBorder(BorderFactory.createCompoundBorder(txtcod.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painela.add(lblcod);
      painela.add(txtcod);
      
      
      lblchassi = new JLabel(getBundle().getString("automovel.painela.lblchassi"));
      lblchassi.setBounds(120, 30, 360, 30);
      lblchassi.setFont(normal);
      txtchassi = new JTextField();    
      txtchassi.setBounds(120, 60, 360, 30);
      txtchassi.setBorder(BorderFactory.createCompoundBorder(txtchassi.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painela.add(lblchassi);
      painela.add(txtchassi);
            
      
      lblmodelo = new JLabel(getBundle().getString("automovel.painela.lblmodelo"));
      lblmodelo.setBounds(490, 30, 200, 30);
      lblmodelo.setFont(normal);
      txtmodelo = new JTextField();
      txtmodelo.setBounds(490,60, 200, 30);
      txtmodelo.setBorder(BorderFactory.createCompoundBorder(txtmodelo.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painela.add(lblmodelo);
      painela.add(txtmodelo);
      
      
      lblplaca = new JLabel(getBundle().getString("automovel.painela.lblplaca"));
      lblplaca.setBounds(10, 90, 270, 30);
      lblplaca.setFont(normal);
      txtplaca = new JTextField();
      txtplaca.setBounds(10, 120, 270, 30);
      txtplaca.setBorder(BorderFactory.createCompoundBorder(txtplaca.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painela.add(lblplaca);
      painela.add(txtplaca);
      
      
      lblgrupo = new JLabel(getBundle().getString("automovel.painela.lblgrupo"));
      lblgrupo.setBounds(290, 90, 50, 30);
      lblgrupo.setFont(normal);
      String[] opcoes3 = {getBundle().getString("automovel.painela.lblgrupo.selecione")
         ,getBundle().getString("automovel.painela.lblgrupo.a"),getBundle().getString("automovel.painela.lblgrupo.c")
         ,getBundle().getString("automovel.painela.lblgrupo.f"),getBundle().getString("automovel.painela.lblgrupo.g")
         ,getBundle().getString("automovel.painela.lblgrupo.h"),getBundle().getString("automovel.painela.lblgrupo.i")
         ,getBundle().getString("automovel.painela.lblgrupo.k"),getBundle().getString("automovel.painela.lblgrupo.m")
         ,getBundle().getString("automovel.painela.lblgrupo.n"),getBundle().getString("automovel.painela.lblgrupo.p")
         ,getBundle().getString("automovel.painela.lblgrupo.r"),getBundle().getString("automovel.painela.lblgrupo.u")
         ,getBundle().getString("automovel.painela.lblgrupo.y")};
      
      txtgrupo = new JTextField();
      txtgrupo.setBounds(290, 120, 220, 30);
      txtgrupo.setBorder(BorderFactory.createCompoundBorder(txtgrupo.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painela.add(lblgrupo);
      painela.add(txtgrupo);
   
   
      lblestado = new JLabel(getBundle().getString("automovel.painela.lblestado"));
      lblestado.setBounds(130, 160, 200, 30);
      lblestado.setFont(normal);
      try{
         maskestado = new MaskFormatter(" UU");
         maskestado.setPlaceholderCharacter('_');
         txtestado = new JFormattedTextField(maskestado);
      }catch(Exception e){
         System.out.println(e);
      }
      txtestado.setBounds(130, 190, 40, 30);
      txtestado.setBorder(BorderFactory.createCompoundBorder(txtestado.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painela.add(lblestado);
      painela.add(txtestado);
      
      
      lblfabricante = new JLabel(getBundle().getString("automovel.painela.lblfabricante"));
      lblfabricante.setBounds(520, 90, 160, 30);
      lblfabricante.setFont(normal);
      txtfabricante = new JTextField();
      txtfabricante.setBounds(520, 120, 160, 30);
      txtfabricante.setBorder(BorderFactory.createCompoundBorder(txtfabricante.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painela.add(lblfabricante);
      painela.add(txtfabricante);
      
      lblcidade = new JLabel(getBundle().getString("automovel.painela.lblcidade"));
      lblcidade.setBounds(10, 160, 180, 30);
      lblcidade.setFont(normal);
      txtcidade = new JTextField();
      txtcidade.setBounds(10, 190, 100, 30);
      txtcidade.setBorder(BorderFactory.createCompoundBorder(txtcidade.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painela.add(lblcidade);
      painela.add(txtcidade);
   	
      lblkm = new JLabel(getBundle().getString("automovel.painela.lblkm"));
      lblkm.setBounds(340, 220, 200, 30);
      lblkm.setFont(normal);
      txtkm = new JNumberFormatField(new DecimalFormat("0")){{setLimit(8);}};
      txtkm.setBounds(340, 250, 100, 30); 
      txtkm.setBorder(BorderFactory.createCompoundBorder(txtkm.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painela.add(lblkm);
      painela.add(txtkm);
   	
   	
      lblkmlivre = new JLabel(getBundle().getString("automovel.painela.lblkmlivre"));
      lblkmlivre.setBounds(210, 160, 200, 30);
      lblkmlivre.setFont(normal);
      txtkmlivre = new JNumberFormatField(new DecimalFormat("0.00")){{setLimit(9);}};
      txtkmlivre.setBounds(210, 190, 100, 30); 
      txtkmlivre.setBorder(BorderFactory.createCompoundBorder(txtkmlivre.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painela.add(lblkmlivre);
      painela.add(txtkmlivre);
       
      
      lblkmcontrolado = new JLabel(getBundle().getString("automovel.painela.lblkmcontrolado"));
      lblkmcontrolado.setBounds(340, 160, 200, 30);
      lblkmcontrolado.setFont(normal);
      txtkmcontrolado = new JNumberFormatField(new DecimalFormat("0.00")){{setLimit(9);}};
      txtkmcontrolado.setBounds(340, 190, 100, 30); 
      txtkmcontrolado.setBorder(BorderFactory.createCompoundBorder(txtkmcontrolado.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painela.add(lblkmcontrolado);
      painela.add(txtkmcontrolado);
      
   	      
      lblacessorios = new JLabel(getBundle().getString("automovel.painela.lblacessorios"));
      lblacessorios.setBounds(120, 220, 130, 30);
      lblacessorios.setFont(normal);
      //String[] opcoes4 = {"Selecione o Acess๓rio","Navegador GPS","Cadeira de Beb๊","Motorista"};
      chkgps = new JCheckBox(getBundle().getString("automovel.painela.chkgps"));
      chkgps.setBounds(10, 250, 130, 30);
		chkcadeira = new JCheckBox(getBundle().getString("automovel.painela.chkcadeira"));
      chkcadeira.setBounds(10, 280, 130, 30);
		chkmotorista = new JCheckBox(getBundle().getString("automovel.painela.chkmotorista"));
      chkmotorista.setBounds(180, 250, 130, 30);
      painela.add(lblacessorios);
      painela.add(chkgps);
      painela.add(chkcadeira);
      painela.add(chkmotorista);				
      
      lblfoto = new JLabel(getBundle().getString("automovel.painela.lblfoto"));
		lblfoto.setBounds(500,160,200,30);
		lblfoto.setFont(normal);
		btconteudofoto = new JButton(new ImageIcon(getClass().getResource("images/sem_foto" + getBundle().getString("automovel.painela.btconteudofoto")+".png")));
		btconteudofoto.setBounds(500,200,150,100);
      btconteudofoto.setContentAreaFilled(false);
      btconteudofoto.addActionListener(this);
		painela.add(lblfoto);
		painela.add(btconteudofoto);
      
      if(!pesquisando)add(painela);
   	//==============================================================================
      
      
      
      
            
   
   	      
   	//==============================================================================
   	//TABELAS
      tabela = new JTable();
      tabela.setGridColor(Color.BLACK);
      tabela.getTableHeader().setReorderingAllowed(false);//nao move as colunas
      tabela.setBorder(new LineBorder(Color.BLACK));
      tabela.setShowGrid(true);
      tabela.setBounds(20,400,WIDTH-50,140);
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
      if(!pesquisando)pane.setBounds(20, 430, WIDTH-40, 100);
      else pane.setBounds(20, 90, WIDTH-40, 100);
      add(pane);
   	//==============================================================================
      
   	//ESTILOS
      lblinformacoes.setBounds(300, 430, 400, 15);
         
   	// ADDs ActionListeners
   	
   	
   	//add(lblinformacoes);
   	
   
   	//texts sem edit
      txtcod.setEnabled(false);
      habilitaBotoes(true,true,false,false,false);
      habilitaTxts(false);   
   	
      
      //===============================================================================================================
      setTitle(getBundle().getString("automovel.title"));
      setResizable(false);
      setLayout(null);
      if(!pesquisando)setSize(WIDTH, HEIGHT);
      else setSize(WIDTH,260);
      setLocationRelativeTo(null); 
      setVisible(true);
      setModal(true);
      //===============================================================================================================
      
      //BLOQUEIA CAMPOS
      habilitaTxts(false);
      
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
   }
   public void actionPerformed(ActionEvent e) {
      //GERA UM RELATORIO DE VEICULOS LOCADOS NO DIA
      if(e.getSource() == btnrelatorio){
         GUIAutomovelRel auto = new GUIAutomovelRel(frame);
         auto.setBundle(getBundle());
         auto.setUsuario(getUsuario());
         auto.init();
         //auto.pesquisar();
      }
      
      //VAI PARA A TELA DE PESQUISA
      else if(e.getSource() == btpesquisar){
         remove(pnlBotoes);
         add(painelp);
         combopesquisar.setSelectedIndex(-1);
         limpaTxts();
         habilitaTxts(false);
         if(pesquisando)btpuxar.setEnabled(false);
         combopesquisar.requestFocus();
         repaint();
      }
      
      //CANCELA A PESQUISA
      else if(e.getSource() == btvoltar){
         add(pnlBotoes);
         remove(painelp);
         limpaTxts();
         habilitaTxts(false);
         tabela.getSelectionModel().clearSelection();
         habilitaBotoes(true,true,false,false,false);
         if(pesquisando)btpuxar.setEnabled(false);
         repaint();
      }
      
      //ONCHANGE DO COMBOBOX DE PESQUISA
      else if(e.getSource() == combopesquisar){
            habilitaTxts(false);
            int combo = combopesquisar.getSelectedIndex();
            switch(combo){
               case 0://C๓digo
                  limpaTxts();
                  txtcod.setEnabled(true);
                  txtcod.setBackground(new Color(255,255,255));
                  txtcod.requestFocus();
               break;
               
               case 1://Chassi
                  limpaTxts();
                  txtchassi.setEnabled(true);
                  txtchassi.setBackground(new Color(255,255,255));
                  txtchassi.requestFocus();
               break;
               
               case 2://Modelo
                  limpaTxts();
                  txtmodelo.setEnabled(true);
                  txtmodelo.setBackground(new Color(255,255,255));
                  txtmodelo.requestFocus();
               break;
               
               case 3://Placa
                  limpaTxts();
                  txtplaca.setEnabled(true);
                  txtplaca.setBackground(new Color(255,255,255));
                  txtplaca.requestFocus();
               break;
            }//switch
			}//combopesquisa listener
         
         
         
         //REALIZAR A PESQUISA NO BANCO
         else if(e.getSource() == btpesquisaraut){
            pesquisar();
         }//PESQUISAR
         
         
         //HABILITAR EDIวรO
         else if(e.getSource() == bthabilitar){
            if(status.equals("")){
               tabela.setEnabled(false);
               tabela.setBackground(COR2);
               habilitaTxts(true);
               txtcod.setEnabled(false);
               txtchassi.requestFocus();
               habilitaBotoes(false,false,false,true,true);
               bthabilitar.setText(getBundle().getString("automovel.bthabilitar2"));
               status = "a";
            }
            
            else if(status.equals("a") || status.equals("+")){//ESTOU ALTERANDO OS DADOS - CANCELAR ALTERAวรO
               String msg = getBundle().getString("erro.cancelar");
               String[] options = {"  "+getBundle().getString("erro.opcoes.sim")+"  ","  "+getBundle().getString("erro.opcoes.nao")+"  "};//0 = sim, 1 = nao 
               int resp = JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
               if(resp == 0){
                  tabela.setEnabled(true);
                  tabela.getSelectionModel().clearSelection();
                  tabela.setBackground(COR);
                  limpaTxts();
                  habilitaTxts(false);
                  habilitaBotoes(true,true,false,false,false);
                  bthabilitar.setText(getBundle().getString("cliente.bthabilitar"));
                  status = "";
               } 
            }
         }//HABILITA EDICAO
         
         
         
         
         //GRAVAR ALTERAวรO
         else if(e.getSource() == btsalvar){
         	if(status.equals("a")){//ALTERANDO
					JTextField txtgps = new JTextField("false");
					JTextField txtcadeira = new JTextField("false");
					JTextField txtmotorista = new JTextField("false");
					if(chkgps.isSelected())
						txtgps.setText("true");
					if(chkcadeira.isSelected())
						txtcadeira.setText("true");
					if(chkmotorista.isSelected())
						txtmotorista.setText("true");
					String novocaminho;
					if(escolheu)
						novocaminho = caminho.substring(DIRETORIO.length(),caminho.length()).replace("\\","/");//subtrai o caminho absoluto da imagem com o DIRETORIO do porjeto e troca as '\' do caminho por '/'
					else
						novocaminho = caminho;
               JTextField txtfoto = new JTextField(novocaminho);
					JTextField a[] = {txtcod,txtchassi,txtmodelo,txtplaca,txtgrupo,
                              txtfabricante,txtcidade,txtestado,txtkm,txtkmlivre,
                              txtkmcontrolado,txtfoto,txtgps,txtcadeira,txtmotorista};
					String b[] = new String[a.length];
               
               boolean vazio = false;
					for(int i = 0; i < a.length; i++){
                  if(a[i].getText().equals("")){
                     String msg = getBundle().getString("erro.preenchadados");
                     String[] options2 = {"  OK  "};
                     JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
                     a[i].requestFocus();
                     vazio = true;
                     break;
                  }else{
						   b[i] = a[i].getText();
                  }
               }
						
               if(!vazio){
   					AutomovelDAO aDAO = new AutomovelDAO();
   					if(aDAO.update(b)){
   						pesquisar();
                     tabela.setEnabled(true);
                     tabela.setBackground(COR);
                     habilitaTxts(false);
                     limpaTxts();
                     bthabilitar.setText(getBundle().getString("automovel.bthabilitar"));
   					}else{
                     String msg = getBundle().getString("erro.alterar");
                     String[] options2 = {"  OK  "};
                     JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
   					}
               }
				}
            
            
            //INSERINDO
            else if(status.equals("+")){
              	JTextField txtgps = new JTextField("false");
					JTextField txtcadeira = new JTextField("false");
					JTextField txtmotorista = new JTextField("false");
					if(chkgps.isSelected())
						txtgps.setText("true");
					if(chkcadeira.isSelected())
						txtcadeira.setText("true");
					if(chkmotorista.isSelected())
						txtmotorista.setText("true");
					
               String novocaminho = "";
               try{
                  novocaminho = caminho.substring(DIRETORIO.length(),caminho.length()).replace("\\","/");//subtrai o caminho absoluto da imagem com o DIRETORIO do porjeto e troca as '\' do caminho por '/'
               }catch(Exception y){               }
               JTextField txtfoto = new JTextField(novocaminho);
               JTextField a[] = {txtchassi,txtmodelo,txtplaca,txtgrupo,
                              txtfabricante,txtcidade,txtestado,txtkm,txtkmlivre,
                              txtkmcontrolado,txtfoto,txtgps,txtcadeira,txtmotorista};
					String b[] = new String[a.length];
					
               boolean vazio = false;
					for(int i = 0; i < a.length; i++){
                  if(a[i].getText().equals("")){
                     String msg = getBundle().getString("erro.preenchadados");
                     String[] options2 = {"  OK  "};
                     JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
                     a[i].requestFocus();
                     vazio = true;
                     break;
                  }else{
                     b[i] = a[i].getText();  
                  }
               }
				   if(!vazio){
   					AutomovelDAO aDAO = new AutomovelDAO();
   					if(aDAO.insert(b)){
                     pesquisar();
                     tabela.setEnabled(true);
                     tabela.setBackground(COR);
                     habilitaTxts(false);
                     limpaTxts();
                     bthabilitar.setText(getBundle().getString("automovel.bthabilitar"));
                  }else{
                     String msg = getBundle().getString("erro.inserir");
                     String[] options2 = {"  OK  "};
                     JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
                  }
               }
            }  
         }//GRAVAR
         
         
         //EXCLUIR AUTOMOVEL
         else if(e.getSource() == btexcluir){
            String msg = getBundle().getString("erro.perguntaexcluir");
            String[] options = {"  "+getBundle().getString("erro.opcoes.sim")+"  ","  "+getBundle().getString("erro.opcoes.nao")+"  "};//0 = sim, 1 = nao 
            int resp = JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if(resp == 0){
               String codigo = txtcod.getText();
               AutomovelDAO aDAO = new AutomovelDAO();
   				if(aDAO.delete(codigo)){
                  pesquisar();
                  tabela.setEnabled(true);
                  tabela.setBackground(COR);
                  habilitaTxts(false);
                  limpaTxts();
               }else{
                  msg = getBundle().getString("erro.inserir");
                  String[] options2 = {"  OK  "};
                  resp = JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
               }
            }
         }//EXCLUIR
         
         
         //INSERIR
         else if(e.getSource() == btadicionar){
            habilitaTxts(true);
            limpaTxts();
            txtcod.setEnabled(false);
            habilitaBotoes(false,false,false,true,true);
            bthabilitar.setText(getBundle().getString("automovel.bthabilitar2"));
            status = "+";
         }//INSERIR
         
         /*จจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจ
                EDITADO - 16.10.14 - PARTE DE PEGAR A FOTO
         จจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจ*/
         
         //FOTO
         else if(e.getSource() == btconteudofoto){
            chooser = new JFileChooser(new File(DIRETORIO));
            FileFilter filtro = new FileNameExtensionFilter(getBundle().getString("automovel.chooser")+" PNG","png");
            chooser.setFileFilter(filtro);
            int retorno = chooser.showOpenDialog(null);
            
            if(retorno == JFileChooser.APPROVE_OPTION)
               caminho = chooser.getSelectedFile().getAbsolutePath();// o getSelectedFile pega o arquivo e o getAbsolutePath retorna uma string contendo o endere็o               
					escolheu = true;
            if(!caminho.equals(""))
               btconteudofoto.setIcon(new ImageIcon(caminho));
            else{
               //TODOOO   PAU NO CAMINHO
            }
         }
   }
   
  
   
   public void pesquisar(){
      pane.getViewport().remove(tabela);
      pane.getViewport().add(btloading);
      repaint();
      int combo = combopesquisar.getSelectedIndex();
      String campo = "";
      String pesquisa = "";
      switch(combo){
         case 0: campo = "au_code";    pesquisa = txtcod.getText();break;
         case 1: campo = "au_chassi";  pesquisa = txtchassi.getText();break;
         case 2: campo = "au_modelo";  pesquisa = txtmodelo.getText();break;
         case 3: campo = "au_placa";   pesquisa = txtplaca.getText();break;
         default: campo = "au_code";   pesquisa = "";break;
      }
      if(pesquisando)pesquisa = txtpesquisa.getText();
      ArrayList<Automovel> aut = new ArrayList<Automovel>();
      aDAO = new AutomovelDAO();
		aut = aDAO.consultarAutomovel(pesquisa,campo,pesquisando);
      tabela.setModel(new TabelaAutomovel(aut));
      pane.getViewport().remove(btloading);
      pane.getViewport().add(tabela);
      
      add(pnlBotoes);
      remove(painelp);
      limpaTxts();
      habilitaTxts(false);
      tabela.getSelectionModel().clearSelection();
      habilitaBotoes(true,true,false,false,false);
      repaint();
      
      
      //FAZ COM QUE SOMENTE AS 5 PRIMEIRAS COLUNAS TABELA SEJAM EXIBIDAS
      for(int i = 5; i < tabela.getColumnCount(); i++){
         tabela.getColumnModel().getColumn(i).setMaxWidth(0);
         tabela.getColumnModel().getColumn(i).setPreferredWidth(0);
         tabela.getColumnModel().getColumn(i).setMinWidth(0);                  
      }
   }
   
   public void habilitaBotoes(boolean pesquisa, boolean novo, boolean excluir, boolean salvar, boolean habilitar){
      if(getUsuario().getNivel().compareToIgnoreCase("s") == 0){//SUPERVISOR
         btpesquisar.setEnabled(pesquisa);
         btadicionar.setEnabled(novo);
         btexcluir.setEnabled(excluir);
         btsalvar.setEnabled(salvar);
         bthabilitar.setEnabled(habilitar);
      }else{
         btpesquisar.setEnabled(pesquisa);
         btadicionar.setEnabled(false);
         btexcluir.setEnabled(false);
         btsalvar.setEnabled(false);
         bthabilitar.setEnabled(false);
      }
   }

	
   private class TabelaListener implements ListSelectionListener{
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
            /*`au_code`, `au_chassi`, `au_modelo`, `au_placa`, `au_grupo`,
            `au_fabricante`, `au_cidade`,`au_estado`, `au_km`, `au_kmLivre`, 
            `au_kmControlado`, `au_foto`, `au_gps`, `au_cadeira`, `au_motorista`*/
				JTextField txtgps = new JTextField("false");
				JTextField txtcadeira = new JTextField("false");
				JTextField txtmotorista = new JTextField("false");
				if(chkgps.isSelected())
					txtgps.setText("true");
				if(chkcadeira.isSelected())
					txtcadeira.setText("true");
				if(chkmotorista.isSelected())
					txtmotorista.setText("true");
				
            
            JTextField txtfoto = new JTextField(caminho);
            JTextField a[] = {txtcod,txtchassi,txtmodelo,txtplaca,txtfabricante,txtgrupo,
                              txtcidade,txtestado,txtkm,txtkmlivre,
                              txtkmcontrolado,txtfoto,txtgps,txtcadeira,txtmotorista};
            for(int i = 0; i < 15; i++){
               a[i].setText(String.valueOf(tabela.getModel().getValueAt(table.getSelectedRow(),i)));
                /*จจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจ
                      EDITADO - 16.10.14- PARTE DE SETAR A FOTO
               จจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจจ*/
               if(i == 11){
                  caminho = String.valueOf(tabela.getModel().getValueAt(table.getSelectedRow(),i));
						//System.out.println("Caminho salvo no BD " +caminho);
                  btconteudofoto.setIcon(new ImageIcon(getClass().getResource(caminho)));
                  //System.out.println("CAMINHO COMPLETO: " + caminho );
                  //System.out.println("CAMINHO SLASHADO: " + novocaminho);
               }
            }	
				chkgps.setSelected(false);
				chkcadeira.setSelected(false);
				chkmotorista.setSelected(false);							
            if(txtgps.getText().equals("true"))
               chkgps.setSelected(true);
            if(txtcadeira.getText().equals("true"))
               chkcadeira.setSelected(true);
            if(txtmotorista.getText().equals("true"))
               chkmotorista.setSelected(true);
         }
         //HABILITA OS BOTOES
         habilitaBotoes(true,true,true,false,true);
         bthabilitar.setText(getBundle().getString("automovel.bthabilitar"));
         status = "";
         if(pesquisando)btpuxar.setEnabled(true);
      }
   }//tabelaListener
   
   public void limpaTxts(){
      txtcod.setText("");
      txtchassi.setText("");
      txtmodelo.setText("");
      txtplaca.setText("");
      txtgrupo.setText("");
      txtfabricante.setText("");
      txtcidade.setText("");
      txtestado.setText("");
      txtkm.setText("");
      txtkmlivre.setText("");
      txtkmcontrolado.setText("");
      chkgps.setSelected(false);
		chkcadeira.setSelected(false);
		chkmotorista.setSelected(false);
      btconteudofoto.setIcon(new ImageIcon(getClass().getResource("images/sem_foto" + 
      getBundle().getString("automovel.painela.btconteudofoto")+".png")));
   }
   
   public void habilitaTxts(boolean isActive){
      Color cor = (isActive ?CORBRANCA :COR);
      txtcod.setEnabled(isActive);
      txtcod.setBackground(COR);
      txtchassi.setEnabled(isActive);
      txtchassi.setBackground(COR);
      txtmodelo.setEnabled(isActive);
      txtmodelo.setBackground(COR);
      txtplaca.setEnabled(isActive);
      txtplaca.setBackground(COR);
      txtgrupo.setEnabled(isActive);
      txtgrupo.setBackground(COR);
      txtfabricante.setEnabled(isActive);
      txtfabricante.setBackground(COR);
      txtcidade.setEnabled(isActive);
      txtcidade.setBackground(COR);
      txtestado.setEnabled(isActive);
      txtestado.setBackground(COR);
      txtkm.setEnabled(isActive);
      txtkm.setBackground(COR);
      txtkmlivre.setEnabled(isActive);
      txtkmlivre.setBackground(COR);
      txtkmcontrolado.setEnabled(isActive);
      txtkmcontrolado.setBackground(COR);
      chkgps.setEnabled(isActive);
		chkcadeira.setEnabled(isActive);
		chkmotorista.setEnabled(isActive);
      btconteudofoto.setEnabled(isActive);
      repaint();
   }
   
   public void addListenerConsulta(ActionListener ouvinte){
      btpuxar = new JButton(getBundle().getString("automovel.btpuxar"));
      btpuxar.addActionListener(ouvinte);
      btpuxar.setBounds(135,5,200,40);
      btpuxar.setEnabled(false);
      repaint();
	}
   
   public String consultarCarros(){
      return txtcod.getText()+"#"+txtmodelo.getText()+"#"+txtkmcontrolado.getText()+"#"+txtkmlivre.getText();
   }
}
