import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.Color;
import java.awt.Font;
import java.util.Locale;
import java.util.ResourceBundle;

public class GUICredito extends JDialog implements ActionListener{
   static final int WIDTH = 455;
	static final int HEIGHT = 400;
   private JPanel pnlcredito;
   private JLabel lblcodpagamento, lblclinome, lblnumcartao, lbldigitocartao, lblvalidade, lblcpf, lblvalor,lblreferente,lblreferente2;
   private JTextField txtcodlocacao, txtclinome, txtnumcartao, txtdigitocartao, txtcpf, txtvalor, txtvalidade;
   private JButton btvoltar,btfinalizar,btlimpar;
   private Color cor1;
   private Font negrito,normal;
   private ResourceBundle bn = null;
   private Pagamento pagamento;
   private boolean pagaJuros;
   private String valorJuros;
   private JFrame frame;
   
   public void setBundle(ResourceBundle bn){
		this.bn = bn;
	}
	public ResourceBundle getBundle(){
		return this.bn;
	}
   
   
   public GUICredito(JFrame f){
      super(f,true);
      frame = f;
      pagaJuros = false;
      valorJuros = "";
   }
   public GUICredito(JFrame f, Pagamento p,boolean juros,String valor){
      super(f,true);
      pagamento = p;
      pagaJuros = juros;
      valorJuros = valor;
      frame = f;
   }
   
   
   public void init(JFrame fr){
      //PAINEL DE CREDITO
      //================================================================================
      pnlcredito = new JPanel(null);
      pnlcredito.setBounds(20,5,WIDTH - 40, 275);
      pnlcredito.setBorder(BorderFactory.createTitledBorder(null, getBundle().getString("credito.paibelc.title"),
         	TitledBorder.CENTER, TitledBorder.TOP, new Font("Lucida Sans",
         			Font.BOLD, 16), cor1));
      
      
      lblcodpagamento = new JLabel(getBundle().getString("credito.paibelc.lblcodpagamento"));
      lblcodpagamento.setBounds(10,30,120,30);
      txtcodlocacao = new JTextField(String.valueOf(pagamento.getLocacao().getLccode()));
      txtcodlocacao.setBounds(10,60,120,30);
      txtcodlocacao.setEnabled(false);
      txtcodlocacao.setBorder(BorderFactory.createCompoundBorder(txtcodlocacao.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnlcredito.add(lblcodpagamento);
      pnlcredito.add(txtcodlocacao);
      
      lblclinome = new JLabel(getBundle().getString("credito.paibelc.lblclinome"));
      lblclinome.setBounds(140,30,250,30);
      txtclinome = new JTextField(String.valueOf(pagamento.getLocacao().getCliente().getNome()));
      txtclinome.setBounds(140,60,250,30);
      txtclinome.setEnabled(false);
      txtclinome.setBorder(BorderFactory.createCompoundBorder(txtclinome.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnlcredito.add(lblclinome);
      pnlcredito.add(txtclinome);
      
      
      lblnumcartao = new JLabel(getBundle().getString("credito.paibelc.lblnumcartao"));
      lblnumcartao.setBounds(10,90,150,30);
      txtnumcartao = new JTextField(String.valueOf(pagamento.getPgnumerocartao()));
      txtnumcartao.setBounds(10,120,150,30);
      if(txtnumcartao.getText().equals("null"))
         txtnumcartao.setText("");
      txtnumcartao.setBorder(BorderFactory.createCompoundBorder(txtnumcartao.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnlcredito.add(lblnumcartao);
      pnlcredito.add(txtnumcartao);
      
      
      lbldigitocartao = new JLabel(getBundle().getString("credito.paibelc.lbldigitocartao"));
      lbldigitocartao.setBounds(160,90,100,30);
      txtdigitocartao = new JTextField(String.valueOf(pagamento.getPgcodigoseguranca()));
      txtdigitocartao.setBounds(185,120,50,30);
      if(txtdigitocartao.getText().equals("null"))
         txtdigitocartao.setText("");
      txtdigitocartao.setBorder(BorderFactory.createCompoundBorder(txtdigitocartao.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnlcredito.add(lbldigitocartao);
      pnlcredito.add(txtdigitocartao);
      
      lblvalidade = new JLabel(getBundle().getString("credito.paibelc.lblvalidade"));
      lblvalidade.setBounds(290,90,130,30);
      txtvalidade = new JTextField(String.valueOf(pagamento.getPgdatavalidade()));
      if(txtvalidade.getText().equals("null"))
         txtvalidade.setText("");
      txtvalidade.setBorder(BorderFactory.createCompoundBorder(txtvalidade.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      txtvalidade.setBounds(290,120,90,30);
      pnlcredito.add(lblvalidade);
      pnlcredito.add(txtvalidade);
      
      
      lblcpf = new JLabel(getBundle().getString("credito.paibelc.lblcpf"));
      lblcpf.setBounds(10,150,120,30);
      txtcpf = new JTextField(String.valueOf(pagamento.getLocacao().getCliente().getCpf()));
      txtcpf.setBounds(10,180,120,30);
      txtcpf.setEnabled(false);
      txtcpf.setBorder(BorderFactory.createCompoundBorder(txtcpf.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnlcredito.add(lblcpf);
      pnlcredito.add(txtcpf);
      
          
      
      lblvalor = new JLabel(getBundle().getString("credito.paibelc.lblvalor"));
      lblvalor.setBounds(140,150,120,30);
      txtvalor = new JTextField();
      if(pagaJuros){
         txtvalor.setText(valorJuros);
      }else{
         txtvalor.setText(String.valueOf(pagamento.getLocacao().getValor()));
      }
      txtvalor.setEnabled(false);
      txtvalor.setBounds(140,180,120,30);
      txtvalor.setBorder(BorderFactory.createCompoundBorder(txtvalor.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnlcredito.add(lblvalor);
      pnlcredito.add(txtvalor);
      
      
      
      lblreferente = new JLabel("Pagamento referente a:");
      lblreferente.setBounds(10,210,WIDTH-50,30);
      String msg = "";
      if(pagaJuros){
         msg = "Juros da locação de número: "+String.valueOf(pagamento.getLocacao().getLccode());
      }else{
         msg = "Locação de número: "+String.valueOf(pagamento.getLocacao().getLccode());
      }
      lblreferente2 = new JLabel(msg);
      lblreferente2.setBounds(10,230,WIDTH-50,30);
      pnlcredito.add(lblreferente);
      pnlcredito.add(lblreferente2);
      
      add(pnlcredito);
      //================================================================================
      
      //================================================================================
      //BOTOES
      btvoltar = new JButton(getBundle().getString("credito.btvoltar"));
      btvoltar.setBounds(20,310,120,40);
      btvoltar.addActionListener(this);
      
      btfinalizar = new JButton(getBundle().getString("credito.btfinalizar"));
      btfinalizar.setBounds(WIDTH-140,310,120,35);
      btfinalizar.addActionListener(this);
      
      add(btvoltar);
      add(btfinalizar);
      //================================================================================
      
      
      
      //CORES
      cor1 = new Color(0,0,255);
      
      //FONTES
      negrito = new Font("Arial",Font.BOLD,16);
      normal = new Font("Courier New",Font.PLAIN,14);
      
      setTitle(getBundle().getString("credito.title"));
      setLayout(null);
      setResizable(false);
      setSize(WIDTH,HEIGHT);
      setLocationRelativeTo(frame);
      setIconImage(new ImageIcon(getClass().getResource("images/logo2.png")).getImage());
      setVisible(true);  
   }
   
      
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == btvoltar){
         String msg = "Tem certeza que deseja cancelar a operação?";
         String[] options = {"  SIM  ","  NÃO  "};
         int op = JOptionPane.showOptionDialog(null, msg, "Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
         if(op == 0)
            this.dispose();
      }else if(e.getSource() == btfinalizar){
         JTextField a[] = {txtnumcartao,txtvalidade,txtdigitocartao};
         boolean vazio = false;
         for(int i = 0; i < a.length; i++){
            if(a[i].getText().equals("")){
               String msg = "Preencha todos os dados para prosseguir!";
               String[] options2 = {"  OK  "};
               JOptionPane.showOptionDialog(null, msg, "Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
               a[i].requestFocus();
               vazio = true;
               break;
            }
         }
         if(!vazio){
            PagamentoDAO pDAO = new PagamentoDAO();
            pagamento.setPgnumerocartao(txtnumcartao.getText());
            pagamento.setPgdatavalidade(txtvalidade.getText());
            pagamento.setPgcodigoseguranca(txtdigitocartao.getText());
            pagamento.setPgvalortot(txtvalor.getText());
            pagamento.setPgtipopag("C");
            
            //SIGINIFICA QUE ESTOU PAGANDO O VALOR DO JUROS, E QUE JA VOU DAR BAIXA EM TUDO
            if(pagaJuros){
               String codpag = "(select pg_code from locacao where lc_code = "+txtcodlocacao.getText()+")";
               if(pDAO.finalizaPagamento(codpag,txtcodlocacao.getText(),"C",pagamento.getPgvalortot())){
                  String msg = "Pagamento do juros realizado com sucesso!";
                  String[] options = {"  OK  "};
                  JOptionPane.showOptionDialog(null, msg, "Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                  dispose();
               }else{
                  String msg = "Ocorreu uma falha ao realizar o pagamento do juros.\nPor favor confira as informações e tente novamente!";
                  String[] options = {"  OK  "};
                  JOptionPane.showOptionDialog(null, msg, "Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
               }
            }
            
            //SIGINIFICA QUE ESTOU PAGANDO O VALOR DA LOCACAO ANTES DE SAIR COM O CARRO
            else{
               if(pDAO.realizaPagamentoLocacao(pagamento,"C")){//C - CREDITO
                  String msg = "Pagamento da locação realizado com sucesso!";
                  String[] options = {"  OK  "};
                  JOptionPane.showOptionDialog(null, msg, "Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                  dispose();
               }else{
                  String msg = "Ocorreu uma falha ao realizar o pagamento da locação.\nPor favor confira as informações e tente novamente!";
                  String[] options = {"  OK  "};
                  JOptionPane.showOptionDialog(null, msg, "Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
               }
            }
         }
      }//befinalizar   
   }//listener
}//classe