import java.util.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class GUIPagamento extends JDialog implements ActionListener{
   static final int WIDTH = 720;
   static final int HEIGHT = 320;
   private ResourceBundle bn = null;
   private JFrame frame;
   private JLabel lblidcliente,lblcliente,lblnumcartao,lblpago,lblidautomovel,lblinformacoes,lblcartao;
   private JLabel lblidlocacao,lbliddevolucao,lbldatadevolucao,lbldatalocacao;
   private JTextField txtidcliente,txtcliente,txtnumcartao,txtpago,txtidautomovel;
   private JTextField txtidlocacao,txtiddevolucao;
   private JRadioButton radcredito,raddebito;
   private JButton btvoltar,btpagar,btimprimir;
   private Color cor1;
   private Font negrito,normal;
   private ImageIcon img,img2;
   private JLabel lbldevolucaocod,lbldtlocacao, lblvalor,lblclinome,lblcarcod,lblcarplaca,lbltipopag,lblagencia;
   private JTextField txtdevolucaocod,txtdtlocacao, txtvalor,txtclinome, txtcarcod,txtcarplaca,txttipopag,txtagencia;
   private JLabel lbllocacaocod, lbldtdevolucaoprev, lblagalu, lblagdev,lblagdevprev, lblcarkm, lbljuros;
   private JTextField txtlocacaocod, txtdtdevolucaoprev, txtjuros;
   private JLabel lblclicod, lbldtdevolucao,lblpagamento;
   private JTextField txtclicod, txtdtdevolucao;
   private JComboBox cbagalu, cbagdev, cbagdevprev,combopesquisar;
   private JLabel lblvalorpag,lblpesquisar;
   private JTextField txtvalorpag;
   private JPanel painelp,pnlBotoes,painelc;
   private JTable tabela;
   private JButton btadicionar, btsalvar, btlimpar, btpesquisar, btexcluir,bthabilitar,btconsultaloc,btpesquisarpag;
   private JScrollPane pane;
   private Usuario user;
   private JLabel lblstatusLocacao,lblpagstatus;
   private JTextField txtstatusLocacao,txtpagstatus;
   private JButton btjuros;
   private boolean pagajuros;
   String codLocacao;
   ArrayList<Pagamento> pagamentos;
   
   public void setBundle(ResourceBundle bn){
      this.bn = bn;
   }  
   public ResourceBundle getBundle(){
      return this.bn;
   } 
   public String bn(String str){
      return getBundle().getString(str);
   }
   
   
   //USUARIO QUE ESTA LOGADO
   public void setUsuario(Usuario user){
      this.user = user;
   }
   public Usuario getUsuario(){
      return this.user;
   } 
   
   
   public GUIPagamento(JFrame fr){
      super(fr,true);
      this.frame = fr;
      codLocacao = "";
      pagajuros = false;
   }
   public GUIPagamento(JFrame fr,String codLocacao){
      super(fr,true);
      this.frame = fr;
      this.codLocacao = codLocacao;
      pagajuros = false;
   }
   
   
   public void pagajuros(){
      pagajuros = true;
   }
   
   public void init(JFrame fr){  
      //==========================================================================================
      //PAINEL DE PAGAMENTO
      painelc = new JPanel(null);
      painelc.setBorder(BorderFactory.createTitledBorder(null,
            getBundle().getString("pagamento.painelp.title"),TitledBorder.CENTER, 
            TitledBorder.TOP, new Font("Lucida Sans", Font.BOLD, 16),
            new Color(0,200,0)));
      painelc.setBounds(20,10,WIDTH-40,225);
      
      
      lbllocacaocod = new JLabel(getBundle().getString("pagamento.painelp.lbllocacaocod"));//CODIGO DA LOCACAO
      lbllocacaocod.setBounds(10,30,150,30);
      txtlocacaocod = new JTextField();
      txtlocacaocod.setBounds(10,60,100,30);
      txtlocacaocod.setEnabled(false);
      txtlocacaocod.setBorder(BorderFactory.createCompoundBorder(txtlocacaocod.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painelc.add(lbllocacaocod);
      painelc.add(txtlocacaocod);
      
      
      btconsultaloc = new JButton();
      btconsultaloc.setBounds(115,60,30,30);
      btconsultaloc.setIcon(new ImageIcon(this.getClass().getResource("images/search.png")));
      btconsultaloc.setEnabled(false);
      
      
      lblclicod = new JLabel(getBundle().getString("pagamento.painelp.lblclicod"));//CODIGO DO CLIENTE
      lblclicod.setBounds(160, 30, 100, 30);
      lblclicod.setFont(normal);
      txtclicod = new JTextField();
      txtclicod.setBounds(160, 60, 100, 30);
      txtclicod.setBorder(BorderFactory.createCompoundBorder(txtclicod.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painelc.add(lblclicod);
      painelc.add(txtclicod);
      
      lblclinome = new JLabel(getBundle().getString("pagamento.painelp.lblclinome"));//NOME DO CLITNTE
      lblclinome.setBounds(270,30,380,30);
      txtclinome = new JTextField();
      txtclinome.setBounds(270,60,380,30);
      txtclinome.setBorder(BorderFactory.createCompoundBorder(txtclinome.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painelc.add(lblclinome);
      painelc.add(txtclinome);
      
      lblvalorpag = new JLabel(bn("pagamento.painelp.lblvalorpag"));//VALOR JA ALUGADO ANTERIORMENTE NA LOCAÇÃO DO VEICULO
      lblvalorpag.setBounds(10,90,170,30);
      txtvalorpag = new JTextField();
      txtvalorpag.setBounds(10,120,100,30);
      txtvalorpag.setBorder(BorderFactory.createCompoundBorder(txtvalorpag.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painelc.add(lblvalorpag);
      painelc.add(txtvalorpag);
      
      lbljuros = new JLabel(bn("pagamento.painelp.lbljuros"));//VALOR DO JUROS(SE HOUVER)
      lbljuros.setBounds(190,90,150,30);
      txtjuros = new JTextField();
      txtjuros.setBounds(140,120,100,30);
      txtjuros.setBorder(BorderFactory.createCompoundBorder(txtjuros.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painelc.add(lbljuros);
      painelc.add(txtjuros);
      btjuros = new JButton();
      btjuros.setBounds(250,120,30,30);
      btjuros.setIcon(new ImageIcon(this.getClass().getResource("images/money.png")));
      btjuros.setEnabled(false);
      painelc.add(btjuros);
      btjuros.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            String msg = bn("pagamento.bt");
            String[] options = {"  OK  "};
            JOptionPane.showOptionDialog(null, msg, bn("pagamento.atencao"),JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
         }
      });
      
            
      lbltipopag = new JLabel(bn("pagamento.painelp.lbltipopag"));//TIPO DE ALUGADOMENTO
      lbltipopag.setBounds(300,90,200,30);
      ButtonGroup group = new ButtonGroup();
      radcredito = new JRadioButton(getBundle().getString("pagamento.painelp.radcred"));
      radcredito.setBounds(300,120,80,30);
      raddebito = new JRadioButton(getBundle().getString("pagamento.painelp.raddeb"));
      raddebito.setBounds(380,120,80,30);
      group.add(raddebito);
      group.add(radcredito);
      painelc.add(lbltipopag);
      painelc.add(raddebito);
      painelc.add(radcredito);
      add(painelc);
      
      lblstatusLocacao = new JLabel(getBundle().getString("pagamento.painelp.lblstatus"));
      lblstatusLocacao.setBounds(470,90,120,30);
      txtstatusLocacao = new JTextField();
      txtstatusLocacao.setBounds(470,120,120,30);
      txtstatusLocacao.setBorder(BorderFactory.createCompoundBorder(txtstatusLocacao.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painelc.add(lblstatusLocacao);
      painelc.add(txtstatusLocacao);
      
      
      
      
      lbldtlocacao = new JLabel(getBundle().getString("pagamento.painelp.datalocacao"));
      lbldtlocacao.setBounds(10,150,120,30);
      txtdtlocacao = new JTextField();
      txtdtlocacao.setBounds(10,180,80,30);
      txtdtlocacao.setBorder(BorderFactory.createCompoundBorder(txtdtlocacao.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painelc.add(lbldtlocacao);
      painelc.add(txtdtlocacao);
      
      
      lbldtdevolucao = new JLabel(getBundle().getString("pagamento.painelp.datadevolucao"));
      lbldtdevolucao.setBounds(140,150,120,30);
      txtdtdevolucao = new JTextField();
      txtdtdevolucao.setBounds(140,180,80,30);
      txtdtdevolucao.setBorder(BorderFactory.createCompoundBorder(txtdtdevolucao.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painelc.add(lbldtdevolucao);
      painelc.add(txtdtdevolucao);
      
      
      
      JLabel lblagalu = new JLabel(bn("locacao.painelc.lblagalu"));
      lblagalu.setBounds(270,150,130,30);
      String op[] = {"SP","RJ"};
      cbagalu = new JComboBox(op);
      cbagalu.setBounds(270,180,80,30);
      cbagalu.setSelectedIndex(-1);
      painelc.add(lblagalu);
      painelc.add(cbagalu);
      
      lblagdev = new JLabel(bn("locacao.painelc.lblagdev"));
      lblagdev.setBounds(380,150,130,30);
      String op2[] = {"SP","RJ"};
      cbagdev = new JComboBox(op2);
      cbagdev.setBounds(380,180,80,30);
      cbagdev.setSelectedIndex(-1);
      painelc.add(lblagdev);
      painelc.add(cbagdev);
      
      
      lblpagstatus = new JLabel(getBundle().getString("pagamento.painelp.statuspag"));
      lblpagstatus.setBounds(520,150,200,30);
      txtpagstatus = new JTextField();
      txtpagstatus.setBounds(520,180,120,30);
      txtpagstatus.setBorder(BorderFactory.createCompoundBorder(txtpagstatus.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      painelc.add(lblpagstatus);
      painelc.add(txtpagstatus);
      
      //===========================================================================================    
      
      
      
      
      //==============================================================================
      //TABELA
      tabela = new JTable();
      tabela.setGridColor(Color.BLACK);
      tabela.getTableHeader().setReorderingAllowed(false);//nao move as colunas
      tabela.setBorder(new LineBorder(Color.BLACK));
      tabela.setShowGrid(true);
      tabela.setBounds(0,0,WIDTH-40,140);
      tabela.setVisible(true);
      //TabelaListener listener = new TabelaListener(tabela);
      //tabela.getSelectionModel().addListSelectionListener(listener);
      
      pane = new JScrollPane();
      pane.getViewport().add(tabela);
      pane.setBounds(20, 315, WIDTH-40, 140);
      //add(pane);
   	//==============================================================================
      
      
      
      
      
      //========================================================================================== 
      //BOTOES DO PAGAMENTO
      btvoltar = new JButton(getBundle().getString("pagamento.btboltar"));
      btvoltar.setBounds(20,245,130,35);
      btvoltar.setIcon(new ImageIcon(getClass().getResource("images/btvoltar.png")));
      btvoltar.addActionListener(this);
      add(btvoltar); 
           
      btimprimir = new JButton(getBundle().getString("pagamento.btimprimir"));
      btimprimir.setBounds(WIDTH-300,245,130,35);            
      btimprimir.addActionListener(this);
      add(btimprimir);
      
      btpagar = new JButton(getBundle().getString("pagamento.btpagar"));      
      btpagar.setBounds(WIDTH-150,245,130,35);
      btpagar.setIcon(new ImageIcon(getClass().getResource("images/btpagar.png")));
      btpagar.addActionListener(this);
      btpagar.setEnabled(false);
      add(btpagar);
      //==========================================================================================
      
      
      habilitaTxts(false);
      
      //==============
      //FRAME
      setTitle(getBundle().getString("pagamento.title"));
      setResizable(false);
      setLayout(null);
      setSize(WIDTH,HEIGHT);
      setLocationRelativeTo(null);
      setIconImage(new ImageIcon(getClass().getResource("images/logo2.png")).getImage());
      //setVisible(true);
      //==============
   }
   
      
   public void actionPerformed(ActionEvent e){      
      if(e.getSource() == btvoltar){
         dispose();
      }
      
      
      //BOTAO DE PAGAMENTO
      else if(e.getSource() == btpagar){
         if(radcredito.isSelected()){
            boolean pagaJuros = false;
            String valorJuros = "";
            if(!String.valueOf(pagamentos.get(0).getLocacao().getDtdevolucao()).equals("null")){
               pagaJuros = true;
               valorJuros = pagamentos.get(0).calculaJuros();
            }
         
            GUICredito c = new GUICredito(frame,pagamentos.get(0),pagaJuros,valorJuros);
            c.setBundle(this.getBundle());
            this.dispose();
            c.init(frame); 
         }
         else if(raddebito.isSelected()){
            boolean pagaJuros = false;
            String valorJuros = "";
            if(!String.valueOf(pagamentos.get(0).getLocacao().getDtdevolucao()).equals("null")){
               pagaJuros = true;
               valorJuros = pagamentos.get(0).calculaJuros();
            }
         
            GUIDebito d = new GUIDebito(frame,pagamentos.get(0),pagaJuros,valorJuros);
            d.setBundle(this.getBundle());
            this.dispose();
            d.init(frame);
         }
         else{
            JOptionPane.showMessageDialog(null,getBundle().getString("pagamento.alert.pagamento"));
         }
      }
      
      
      
   }
   
   //=================================
   //PESQUISA
   public void pesquisar(String cod){
      pane.getViewport().remove(tabela);
      
      //RECRIA A TABELA
      tabela = new JTable();
      tabela.setGridColor(Color.BLACK);
      tabela.getTableHeader().setReorderingAllowed(false);//NAO MOVE AS COLUNAS
      tabela.setBorder(new LineBorder(Color.BLACK));
      tabela.setShowGrid(true);
      tabela.setBounds(0,0,WIDTH-40,140);
      tabela.setVisible(true);
      
      repaint();
      String pesquisa = cod;
      String campo = "lc_code";
      
      PagamentoDAO pDAO = new PagamentoDAO();
      pagamentos = pDAO.consultarPagamento(pesquisa,campo);
      tabela.setModel(new TabelaPagamento(pagamentos));
      pane.getViewport().add(tabela);
      

      habilitaTxts(false);
      tabela.getSelectionModel().clearSelection();
      btjuros.setEnabled(false);
      repaint();
      selecionar();
   }
	//===================================
   
   
   
   
   
   //LIMPA OS TXTS
   public void limpaTxts(){
      txtlocacaocod.setText("");
      txtclicod.setText("");
      txtclinome.setText("");
      txtvalorpag.setText("");
      txtjuros.setText("");
      radcredito.setSelected(false);
      raddebito.setSelected(false);
      txtstatusLocacao.setText("");
      txtdtlocacao.setText("");
      txtdtdevolucao.setText("");
      cbagalu.setSelectedIndex(-1);
      cbagdev.setSelectedIndex(-1);  
      txtpagstatus.setText("");
   }
   //===================================
   
   
   public void habilitaTxts(boolean isActive){
      txtlocacaocod.setEnabled(isActive);
      txtclicod.setEnabled(isActive);
      txtclinome.setEnabled(isActive);
      txtvalorpag.setEnabled(isActive);
      txtjuros.setEnabled(isActive);
      radcredito.setEnabled(false);
      raddebito.setEnabled(false);
      txtstatusLocacao.setEnabled(isActive);
      txtdtlocacao.setEnabled(isActive);
      txtdtdevolucao.setEnabled(isActive);
      cbagalu.setEnabled(isActive);
      cbagdev.setEnabled(isActive);
      txtpagstatus.setEnabled(isActive);
   }
   
   
   public void selecionar(){
      //PEGA O OBJETO QUE ESTA NA LINHA DA TABELA
      Pagamento p = new Pagamento();
      TabelaPagamento tabPag = new TabelaPagamento(pagamentos);
      p = tabPag.getLinha(0);
      
      
      //DATA DA LOCACAO
      String dataL = String.valueOf(p.getLocacao().getDtlocacao());
      if(dataL != null && dataL.length() == 10 && dataL != "null"){
         String s1[] = dataL.split("-");
         txtdtlocacao.setText(s1[2]+"/"+s1[1]+"/"+s1[0]);
      }else
         txtdtlocacao.setText("");
      
      //DATA DA DEVOLUCAO
      String data = String.valueOf(p.getLocacao().getDtdevolucao());
      if(data != null && data.length() == 10 && data != "null"){
         String s[] = data.split("-");
         txtdtdevolucao.setText(s[2]+"/"+s[1]+"/"+s[0]);
      }else
         txtdtdevolucao.setText("");
      
      
      //STATUS DA LOCACAO
      if(String.valueOf(p.getLocacao().getStatus()).substring(0,1).equals("A")){
         txtstatusLocacao.setText(getBundle().getString("pagamento.status.aberto"));
         if(getUsuario().getNivel().compareToIgnoreCase("s") == 0){//SUPERVISOR
            btpagar.setEnabled(true);
         }else{
            btpagar.setEnabled(false);
         }
      }else if(p.getLocacao().getStatus().substring(0,1).equals("P")){
         txtstatusLocacao.setText(getBundle().getString("pagamento.status.alugado"));
      }else if(p.getLocacao().getStatus().substring(0,1).equals("D")){
         txtstatusLocacao.setText(getBundle().getString("pagamento.status.devolvido"));
         if(getUsuario().getNivel().compareToIgnoreCase("s") == 0){//SUPERVISOR
            btpagar.setEnabled(true);
            radcredito.setEnabled(false);
            raddebito.setEnabled(false); 
         }else{
            btpagar.setEnabled(false);
            radcredito.setEnabled(false);
            raddebito.setEnabled(false); 
         }
      }else{
         txtstatusLocacao.setText(getBundle().getString("pagamento.status.fechado"));
      }
      
     
      
      //AGENCIA EM QUE FOI ALUGADO O CARRO
      cbagalu.setSelectedIndex(-1);
      if(p.getLocacao().getAglocacao().equals("SP"))
         cbagalu.setSelectedIndex(0);
      else if(p.getLocacao().getAglocacao().equals("RJ"))
         cbagalu.setSelectedIndex(1);
      
      //AGENCIA EM QUE O CARRO FOI DEVOLVIDO
      cbagdev.setSelectedIndex(-1);
      if(String.valueOf(p.getLocacao().getAgdevolucao()).equals("SP"))
         cbagdev.setSelectedIndex(0);
      else if(String.valueOf(p.getLocacao().getAgdevolucao()).equals("RJ"))
         cbagdev.setSelectedIndex(1);
      
      //CODIGO DA LOCACAO
      txtlocacaocod.setText(String.valueOf(p.getLocacao().getLccode()));
      
      //TIPO DE ALUGADOMENTO = CREDITO OU DEBITO
      raddebito.setSelected(String.valueOf(p.getPgtipopag()).equals("D") ? true : false);
      radcredito.setSelected(String.valueOf(p.getPgtipopag()).equals("C") ? true : false);
      if(String.valueOf(p.getPgtipopag()).equals("null") || pagajuros){
         if(getUsuario().getNivel().compareToIgnoreCase("s") == 0){//SUPERVISOR
            raddebito.setEnabled(true);
            radcredito.setEnabled(true);
         }else{
            raddebito.setEnabled(false);
            radcredito.setEnabled(false);
         }
      }
      
      //CODIGO DO CLIENTE
      txtclicod.setText(String.valueOf(p.getLocacao().getCliente().getCode()));
      //NOME DO CLIENTE
      txtclinome.setText(String.valueOf(p.getLocacao().getCliente().getNome()));
      //VALOR ALUGADO NA HORA DA LOCACAO
      txtvalorpag.setText(p.getLocacao().getValor());
      Double valorLocacao = p.getLocacao().getValor().equals("") ? 0.0 : Double.parseDouble(p.getLocacao().getValor()) ;
      Double juros = 0.0;
      if(!String.valueOf(p.getLocacao().getDtdevolucao()).equals("null")){
         juros = Double.parseDouble(p.calculaJuros());
      }
      txtjuros.setText(String.valueOf(juros));
      
      
      //STATUS DO PAGAMENTO
      if(String.valueOf(p.getPgstatus()).equals("A")){
         txtpagstatus.setText(getBundle().getString("pagamento.status.aberto"));
      }else{
         txtpagstatus.setText(getBundle().getString("pagamento.status.fechado"));
      }
      btjuros.setEnabled(true);
   }   
}