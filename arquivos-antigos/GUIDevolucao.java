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
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.Calendar;

public class GUIDevolucao extends JDialog implements ActionListener {
   static final int WIDTH = 750;
	static final int HEIGHT = 430;
   private JFrame frame;
   private ResourceBundle bn = null;
	private JLabel lblcod, lblnome, lblemail, lbltelefone, lblendereco,lblrg,lblinformacoes,lblcpf,lbldata,lblcidade,lbluf,lblresposta;
	private JTextField txtstatus,txtcod, txtnome, txttelefone, txtendereco, txtrg,txtemail,txtcpf,txtcidade;
   private JLabel lblcarmodelo;
   private JTextField txtcarmodelo;
   
   private JButton btadicionar, btsalvar, btlimpar, btpesquisar, btexcluir,bthabilita,btpagamento,btvoltar;
	private Border border;
	private Color verdeEscuro, vermelhoEscuro, cinza, branco;
	private Font normal, XLnormal, btnormal, negrito;
	private JScrollPane pane;
	private JTable tabela,tabela2;
	private boolean selecionado = false,tabelaprincipal = true;
	private JLabel lblpesquisar;
	private JComboBox combopesquisar,cmbuf;
	private JPanel painelp,pnlBotoes,painelc;
   private JLabel lblclicod, lblclinome,lbllocacaocod,lbldtlocacao,lblcarcod,lbldtdevolucao;
   private JLabel lblagalu, lblagdev,lblcarkm, lblvalor,lbltipopag,lblstatus,lblstatus2;
   private JTextField txtcarkm,txtvalor;
   private JTextField txtclicod, txtclinome,txtlocacaocod,txtcarcod;   
   private JFormattedTextField txtdtlocacao,txtdtdevolucao;
   private MaskFormatter maskdtlocacao,maskdtdevolucao;
   
   private JButton btpesquisardev;
   private JLabel  lbldtdevolucaoprev, lblagdevprev,   lbljuros;
   private JTextField txttipopag, txtjuros;
   private JLabel lbldevolucaocod,lblcarplaca,lblpagamento;
   private JTextField  txtdevolucaocod,txtcarplaca;
   private JComboBox cbagalu, cbagdev, cbagdevprev;
   private JRadioButton radcredito,raddebito;
   private JRadioButton radkmlivre,radkmcontrol; 
   private ImageIcon img;
   private Usuario user;
   private String status;
   protected GUILocacao glocacao;   
   private Locacao locacao;
      
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
   
   
   public GUIDevolucao(JFrame fr, Usuario user){
      super(fr,true);
      frame = fr;
      setUsuario(user);
      status = "";
   }
   public GUIDevolucao(JFrame fr){
      super(fr,true);
      frame = fr;
      status = "";
   } 
   
	
   
   public void init(JFrame fr){    
      //PAINEL DE BOTOES
      //==============================================================================
      pnlBotoes = new JPanel(null);
      pnlBotoes.setBounds(20,10,WIDTH-40,50);
      
      btpesquisar = new JButton(getBundle().getString("devolucao.btpesquisar"));
      btpesquisar.setBounds(0, 5, 150, 40);
      btpesquisar.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            glocacao = new GUILocacao(frame,getUsuario(),true);
            glocacao.setBundle(getBundle());
            glocacao.addListenerConsulta(new LocacaoListener());
            glocacao.init(frame);
         }
      });
      pnlBotoes.add(btpesquisar);
      
      btsalvar = new JButton(getBundle().getString("devolucao.btsalvar"));
      btsalvar.setBounds(155, 5, 150, 40);
      btsalvar.addActionListener(this);
      btsalvar.setEnabled(false);
      pnlBotoes.add(btsalvar);
            
      add(pnlBotoes);
      //==============================================================================
      
      
           
      //==============================================================================
   	//PAINEL DEVOLUCAO
      lblresposta = new JLabel("...");
      lblresposta.setBounds(20,60,WIDTH-40,30);
      lblresposta.setForeground(Color.RED);
      lblresposta.setFont(new Font("Lucida Sans", Font.PLAIN, 18));
      add(lblresposta);
      
      
      painelc = new JPanel(null);
      painelc.setBounds(20, 90, WIDTH-40, 240);
      painelc.setBorder(BorderFactory.createTitledBorder(null,
         	getBundle().getString("devolucao.paineld.title"), TitledBorder.CENTER,
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
      txtclicod.setEnabled(false);
      painelc.add(lblclicod);
      painelc.add(txtclicod);
      
      
      lblclinome = new JLabel(getBundle().getString("locacao.painelc.lblclinome"));
      lblclinome.setBounds(290,30,380,30);
      txtclinome = new JTextField();
      txtclinome.setBounds(290,60,380,30);
      txtclinome.setBorder(BorderFactory.createCompoundBorder(txtclinome.getBorder(), 
         BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      txtclinome.setEnabled(false);
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
      txtcarcod.setEnabled(false);
      painelc.add(lblcarcod);
      painelc.add(txtcarcod);
      
            
      lblcarmodelo = new JLabel(getBundle().getString("locacao.painelc.lblcarmodelo"));
      lblcarmodelo.setBounds(140,90,150,30);
      txtcarmodelo = new JTextField();
      txtcarmodelo.setBounds(140,120,150,30);
      txtcarmodelo.setBorder(BorderFactory.createCompoundBorder(txtcarmodelo.getBorder(), 
         BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      txtcarmodelo.setEnabled(false);
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
      txtdtlocacao.setEnabled(false); 
      txtdtlocacao.setBorder(BorderFactory.createCompoundBorder(txtdtlocacao.getBorder(), 
         BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      painelc.add(lbldtlocacao);
      painelc.add(txtdtlocacao);
      
      
      lbldtdevolucao = new JLabel(getBundle().getString("devolucao.paineld.lbldtdevolucao"));
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
      txtdtdevolucao.setEnabled(false);
      painelc.add(lbldtdevolucao);
      painelc.add(txtdtdevolucao);
   
      
      lblagalu = new JLabel(bn("locacao.painelc.lblagalu"));
      lblagalu.setBounds(590,90,130,30);
      String op[] = {"SP","RJ"};
      cbagalu = new JComboBox(op);
      cbagalu.setBounds(590,120,80,30);
      cbagalu.setEnabled(false);
      painelc.add(lblagalu);
      painelc.add(cbagalu);
      
      lblagdev = new JLabel(bn("locacao.painelc.lblagdev"));
      lblagdev.setBounds(10,150,130,30);
      String op2[] = {"SP","RJ"};
      cbagdev = new JComboBox(op2);
      cbagdev.setBounds(10,180,80,30);
      cbagdev.setEnabled(false);
      painelc.add(lblagdev);
      painelc.add(cbagdev);
      
      lblcarkm = new JLabel(bn("locacao.painelc.lblcarkm"));
      lblcarkm.setBounds(150,150,150,30);
      radkmlivre = new JRadioButton(getBundle().getString("locacao.painelc.radkmlivre"));
      radkmlivre.setBounds(145,180,65,30);
      radkmlivre.addActionListener(this);
      radkmlivre.setEnabled(false);
      radkmcontrol = new JRadioButton(getBundle().getString("locacao.painelc.radkmcontrol"));
      radkmcontrol.setBounds(210,180,100,30);
      radkmcontrol.addActionListener(this);
      radkmcontrol.setEnabled(false);
      ButtonGroup btngroup = new ButtonGroup();
      btngroup.add(radkmlivre);
      btngroup.add(radkmcontrol);
      painelc.add(lblcarkm);
      painelc.add(radkmlivre);
      painelc.add(radkmcontrol);
   
      lblvalor = new JLabel(bn("devolucao.paineld.lblvalor"));
      lblvalor.setBounds(320,150,150,30);
      txtvalor = new JNumberFormatField(new DecimalFormat("0.00")){{setLimit(9);}};
      txtvalor.setBounds(320,180,90,30);
      txtvalor.setBorder(BorderFactory.createCompoundBorder(txtvalor.getBorder(), 
         BorderFactory.createEmptyBorder(5, 5, 5, 5)));
      txtvalor.setEnabled(false);
      painelc.add(lblvalor);
      painelc.add(txtvalor);
      
      
      
      lbljuros = new JLabel(bn("devolucao.paineld.lbljuros"));
      lbljuros.setBounds(420,150,100,30);
      txtjuros = new JTextField();//new JNumberFormatField(new DecimalFormat("0.00")){{setLimit(9);}};
      txtjuros.setBounds(420,180,90,30);
      txtjuros.setFont(new Font("Arial", Font.PLAIN, 15));
      txtjuros.setEnabled(false);
      painelc.add(lbljuros);
      painelc.add(txtjuros);
      
      
      
      lblstatus = new JLabel(bn("devolucao.painelc.lblstatus"));
      lblstatus.setBounds(550,150,130,30);
      txtstatus = new JTextField();
      txtstatus.setBounds(550,180,130,30);
      txtstatus.setEnabled(false);
      painelc.add(lblstatus);
      painelc.add(txtstatus);
      
      add(painelc);
   	//==============================================================================
      
      
      
            

		      
		    
      //PAGAMENTO DA LOCAÇÃO
      //==============================================================================
      img = new ImageIcon(getClass().getResource("images/btpagar.png"));
      btpagamento = new JButton(getBundle().getString("devolucao.btpagamento"));
      btpagamento.addActionListener(this);
      btpagamento.setBounds(WIDTH-220,340,200,40);
      btpagamento.setIcon(img);
      btpagamento.setEnabled(false);
      add(btpagamento);
      //==============================================================================
		
      
      //===============================================================================================================
      setTitle(getBundle().getString("devolucao.title"));
      setResizable(false);
      setLayout(null);
		setSize(WIDTH, HEIGHT);
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
      
      //FONTES
		normal = new Font("Arial", Font.PLAIN, 12);
		XLnormal = new Font("Arial", Font.PLAIN, 14);
		btnormal = new Font("Candara", Font.PLAIN, 14);
		negrito = new Font("Candara", Font.BOLD, 14);
	}//init()
	
   
   
   
   
   
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == btpesquisar){
         GUILocacao p = new GUILocacao(frame,getUsuario(),true);
         p.setBundle(getBundle());
         p.init(frame);
         p.setVisible(true);
         repaint();
         btpagamento.setEnabled(false);
      }
      
      
      //BOTAO PARA PAGAR OS JUROS RESTANTES
      else if(e.getSource() == btpagamento){
         boolean vai = true;
         if(txtdtdevolucao.getText().equals("") || txtdtdevolucao.getText().equals("__/__/____") || cbagdev.getSelectedIndex() < 0){         
            String msg = getBundle().getString("erro.devolucao.dadosnaosalvos");
            String[] options = {"  "+getBundle().getString("erro.opcoes.sim")+"  ","  "+getBundle().getString("erro.opcoes.nao")+"  "};
            int op = JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);   
            if(op == 1)
               vai = false;
         }
         if(vai){
            GUIPagamento p = new GUIPagamento(frame);
            p.setBundle(getBundle());
				p.setUsuario(getUsuario());
            p.init(frame);
            p.pagajuros();
            p.pesquisar(locacao.getLccode()+"");
            this.dispose(); 
            p.setVisible(true); 
         }            
      }
      
      
      //CONFIRMA DEVOLUCÇÃO
      else if(e.getSource() == btsalvar){
         boolean vazio = false;
         Date devolucao = null;
         if(txtdtdevolucao.getText().equals("") || txtdtdevolucao.getText().equals("__/__/____")){
            String msg = getBundle().getString("erro.preenchainformacoes");
            String[] options = {"  OK  "};
            JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            txtdtdevolucao.requestFocus();
            vazio = true;
         }else if(cbagdev.getSelectedIndex() < 0){
            String msg = getBundle().getString("erro.preenchainformacoes");
            String[] options = {"  OK  "};
            JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            cbagdev.requestFocus();
            vazio = true;
         }else{
            try{
               Date aluguel = null;
               DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
               devolucao = (java.util.Date)formatter.parse(txtdtdevolucao.getText());
               aluguel = (java.util.Date)formatter.parse(txtdtlocacao.getText());
               if(aluguel.getTime() > devolucao.getTime()){
                  String msg = getBundle().getString("erro.locacao.datamaior");
                  String[] options = {"  OK  "};
                  JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                  txtdtdevolucao.requestFocus();
                  vazio = true;
               }
            }catch(Exception i){
               String msg = getBundle().getString("erro.devolucao.datacorreta");
               String[] options = {"  OK  "};
               JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
               txtdtdevolucao.requestFocus();
               vazio = true;
            }
         }
         
         //FOI TUDO PREENCHIDO CORRETAMENTE
         if(!vazio){
            LocacaoDAO lDAO = new LocacaoDAO();
            locacao.setAgdevolucao(cbagdev.getSelectedIndex() == 0 ? "SP" : "RJ");
            
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            String dataBanco = "";
            try {
                c.setTime(df.parse(txtdtdevolucao.getText()));
                dataBanco += c.get(Calendar.YEAR)+"-";
                int mes = c.get(Calendar.MONTH);mes++;
                dataBanco += mes < 2 ? "0"+mes+"-" : mes+"-";
                dataBanco += c.get(Calendar.DAY_OF_MONTH);

            } 
            catch (ParseException y) {
                y.printStackTrace();
            }
            
            try{
               Date a = lDAO.baixaLocacao(locacao,dataBanco);
               locacao.setDtdevolucao(a);
               //VOU COLOCAR UMA DATA DE DEVOLUCAO, A AGENCIA, E ALTERAR O STATUS PARA D - DEVOLVIDO
               if(!String.valueOf(locacao.getDtdevolucao()).equals("null")){
                  cbagdev.setEnabled(false);
                  txtdtdevolucao.setEnabled(false);
                  btsalvar.setEnabled(false);
                  txtstatus.setText(getBundle().getString("devolucao.status.devolvido"));
                  Pagamento p = new Pagamento();
                  p.setLocacao(locacao);
                  String b = p.calculaJuros();
                  txtjuros.setText(b);
                  
                  //SE TIVER JUROS PARA SER PAGO - HABILITA O BOTAO DE JUROS E DA A MENSAGEM
                  if(!b.equals("0.00") && !b.equals("0.0")){
                     String msg = getBundle().getString("erro.devolucao.juros");
                     String[] options = {"  OK  "};
                     JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                     btpagamento.setEnabled(true);
                  }
                  
                  
                  //NAO TEVE JUROS,VOU DAR BAIXA NO PAGAMENTO E NA LOCACAO, COLOCANDO F NO STATUS DOS DOIS
                  else{               
                     PagamentoDAO pDAO2 = new PagamentoDAO();
                     String pg_code = "(select pg_code from locacao where lc_code = "+locacao.getLccode()+")";
                     if(pDAO2.finalizaPagamento(pg_code,locacao.getLccode()+"","C","0.0")){
                        txtstatus.setText(getBundle().getString("devolucao.status.fechado"));
                     }else{
                        //TODO - MENSAGEM QUE NÃO FOI POSSIVEL ATUALIZAR O PAGAMENTO
                        String msg = getBundle().getString("erro.devolucao.baixa");
                        String[] options = {"  OK  "};
                        JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                     }
                  }
               }
               
               
               //NAO DEU CERTO A QUERY DE UPDATE
               else{
                  //TODO - MSG DE NAO FOI POSSIVEL DAR BAIXA NA LOCACAO
                  String msg = getBundle().getString("erro.devoulucao.baixalocacao");
                  String[] options = {"  OK  "};
                  JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
               }
            }catch(Exception w){
               String msg = getBundle().getString("erro.devoulucao.baixalocacao");
               String[] options = {"  OK  "};
               JOptionPane.showOptionDialog(null, msg, getBundle().getString("erro.titulo"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            }
         }  
      }//btsalvar
   }//actionPerformed()
   
   
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
      txtstatus.setText("");
      lblresposta.setText("");
   }
   
   
   
   
   class LocacaoListener implements ActionListener {
      @Override
      public void actionPerformed (ActionEvent evt){
         if(evt.getSource() == glocacao.btpuxar){
            Locacao l = glocacao.getLocacao();
            txtlocacaocod.setText(""+l.getLccode());           //CODIGO DA LOCACAO
            txtclinome.setText(l.getCliente().getNome());      //NOME DO CLIENTE
            txtcarcod.setText(""+l.getAutomovel().getCode());  //CODIGO DO CARRO
            try{//DATA DE LOCACAO
               String data = String.valueOf(l.getDtlocacao());
               String s[] = data.split("-");
               txtdtlocacao.setText(s[2]+"/"+s[1]+"/"+s[0]);
            }catch(Exception ex ){txtdtlocacao.setText("");}
            
            
            //STATUS DA LOCACAO
            if(l.getStatus().substring(0,1).equals("A")){
               txtstatus.setText(getBundle().getString("devolucao.status.aberto"));
               txtdtdevolucao.setEnabled(true);
               txtdtdevolucao.requestFocus();
               cbagdev.setEnabled(true);
               btsalvar.setEnabled(true);
            }else if(l.getStatus().substring(0,1).equals("P")){
               txtstatus.setText(getBundle().getString("devolucao.status.alugado"));
               txtdtdevolucao.setEnabled(true);
               txtdtdevolucao.requestFocus();
               btsalvar.setEnabled(true);
               cbagdev.setEnabled(true);
            }else if(l.getStatus().substring(0,1).equals("D")){
               txtstatus.setText(getBundle().getString("devolucao.status.devolvido"));
               txtdtdevolucao.setEnabled(false);
               cbagdev.setEnabled(false);
               btsalvar.setEnabled(false);
               Pagamento p = new Pagamento();
               p.setLocacao(l);
               txtjuros.setText(p.calculaJuros());
            }else{
               txtstatus.setText(getBundle().getString("devolucao.status.fechado"));
               txtdtdevolucao.setEnabled(false);
               cbagdev.setEnabled(false);
               btsalvar.setEnabled(false);
            }
            btpagamento.setEnabled(true);
            
            txtclicod.setText(""+l.getCliente().getCode());    //CODIGO DO CLIENTE
            try{//DATA DE DEVOLUCAO
               String data = String.valueOf(l.getDtdevolucao());
               String s[] = data.split("-");
               txtdtdevolucao.setText(s[2]+"/"+s[1]+"/"+s[0]);
            }catch(Exception ex){txtdtdevolucao.setText("");} 
            
            cbagalu.setSelectedIndex(l.getAglocacao().equals("SP") ? 0 : 1);  //AGENCIA DE LOCACAO
            cbagdev.setSelectedIndex(String.valueOf(l.getAgdevolucao()).equals("null") ? -1 : String.valueOf(l.getAgdevolucao()).equals("SP") ? 0 : 1);//AGENCIA DE DEVOLUCAO
            txtvalor.setText(l.getValor());                    //VALOR
            
            if(String.valueOf(l.getTipokm()).equals("L")){     //TIPO DE KILOMETRAGEM  L - livre/ C - controlado
               radkmlivre.setSelected(true);
               radkmcontrol.setSelected(false);
            }else{
               radkmlivre.setSelected(false);
               radkmcontrol.setSelected(true);
            }   
            txtcarmodelo.setText(l.getAutomovel().getFabricante() + " - "+l.getAutomovel().getModelo());//FABRICANTE/MODELO DO CARRO
            locacao = l;
            glocacao.dispose();
         }
      }
   }
}