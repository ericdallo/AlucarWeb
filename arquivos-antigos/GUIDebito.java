import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.Color;
import java.awt.Font;
import java.util.Locale;
import java.util.ResourceBundle;

public class GUIDebito extends JDialog implements ActionListener{
   static final int WIDTH = 455;
	static final int HEIGHT = 400;
   private JPanel pnldebito;
   private JLabel lblcodlocacao, lblclinome, lblagencia,lblbanco, lblconta, lbltelefone, lblcpf, lblvalor,lblreferente,lblreferente2;
   private JTextField txtcodlocacao, txtclinome, txtagencia,txtbanco, txtconta, txttelefone, txtcpf, txtvalor;
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
   
   public GUIDebito(JFrame f){
      super(f,true);
      frame = f;
      pagaJuros = false;
      valorJuros = "";
   }
   public GUIDebito(JFrame f, Pagamento p,boolean juros,String valor){
      super(f,true);
      pagamento = p;
      pagaJuros = juros;
      valorJuros = valor;
      frame = f;
   } 
   
   
   public void init(JFrame fr){
      //PAINEL DE DEBITO
      pnldebito = new JPanel(null);
      pnldebito.setBounds(20,5,WIDTH - 40, 290);
      pnldebito.setBorder(BorderFactory.createTitledBorder(null, getBundle().getString("debito.paibelc.title"),
         	TitledBorder.CENTER, TitledBorder.TOP, new Font("Lucida Sans",
         			Font.BOLD, 16), cor1));
      
      
      lblcodlocacao = new JLabel(getBundle().getString("debito.paibelc.lblcodlocacao"));
      lblcodlocacao.setBounds(10,30,120,30);
      txtcodlocacao = new JTextField(String.valueOf(pagamento.getLocacao().getLccode()));
      txtcodlocacao.setBounds(10,60,120,30);
      txtcodlocacao.setEnabled(false);
      txtcodlocacao.setBorder(BorderFactory.createCompoundBorder(txtcodlocacao.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnldebito.add(lblcodlocacao);
      pnldebito.add(txtcodlocacao);
      
      lblclinome = new JLabel(getBundle().getString("debito.paibelc.lblclinome"));
      lblclinome.setBounds(140,30,250,30);
      txtclinome = new JTextField(String.valueOf(pagamento.getLocacao().getCliente().getNome()));
      txtclinome.setBounds(140,60,250,30);
      txtclinome.setEnabled(false);
      txtclinome.setBorder(BorderFactory.createCompoundBorder(txtclinome.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnldebito.add(lblclinome);
      pnldebito.add(txtclinome);
      
      
      lblagencia = new JLabel(getBundle().getString("debito.paibelc.lblagencia"));
      lblagencia.setBounds(10,90,70,30);
      txtagencia = new JTextField();
      txtagencia.setBounds(10,120,70,30);
      txtagencia.setBorder(BorderFactory.createCompoundBorder(txtagencia.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnldebito.add(lblagencia);
      pnldebito.add(txtagencia);
      
      
      lblconta = new JLabel(getBundle().getString("debito.paibelc.lblconta"));
      lblconta.setBounds(90,90,170,30);
      txtconta = new JTextField();
      txtconta.setBounds(90,120,170,30);
      txtconta.setBorder(BorderFactory.createCompoundBorder(txtconta.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnldebito.add(lblconta);
      pnldebito.add(txtconta);
      
      
      lblbanco = new JLabel(getBundle().getString("debito.paibelc.lblbanco"));
      lblbanco.setBounds(270,90,120,30);
      txtbanco = new JTextField();
      txtbanco.setBounds(270,120,120,30);
      txtbanco.setBorder(BorderFactory.createCompoundBorder(txtbanco.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnldebito.add(lblbanco);
      pnldebito.add(txtbanco);
      
      
      lbltelefone = new JLabel(getBundle().getString("debito.paibelc.lbltelefone"));
      lbltelefone.setBounds(270,150,120,30);
      txttelefone = new JTextField(String.valueOf(pagamento.getLocacao().getCliente().getTelefone()));
      txttelefone.setBounds(270,180,120,30);
      txttelefone.setEnabled(false);
      txttelefone.setBorder(BorderFactory.createCompoundBorder(txttelefone.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnldebito.add(lbltelefone);
      pnldebito.add(txttelefone);
      
      
      lblcpf = new JLabel(getBundle().getString("debito.paibelc.lblcpf"));
      lblcpf.setBounds(10,150,120,30);
      txtcpf = new JTextField(String.valueOf(pagamento.getLocacao().getCliente().getCpf()));
      txtcpf.setBounds(10,180,120,30);
      txtcpf.setEnabled(false);
      txtcpf.setBorder(BorderFactory.createCompoundBorder(txtcpf.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnldebito.add(lblcpf);
      pnldebito.add(txtcpf);
               
      
      lblvalor = new JLabel(getBundle().getString("debito.paibelc.lblvalor"));
      lblvalor.setBounds(140,150,120,30);
      txtvalor = new JTextField(String.valueOf(pagamento.getLocacao().getValor()));
      txtvalor.setBounds(140,180,120,30);
      txtvalor.setEnabled(false);
      txtvalor.setBorder(BorderFactory.createCompoundBorder(txtvalor.getBorder(), BorderFactory.createEmptyBorder(0, 2, 0, 2)));//BORDA INTERNA
      pnldebito.add(lblvalor);
      pnldebito.add(txtvalor);
      
      lblreferente = new JLabel("Pagamento referente a");
      lblreferente.setBounds(10,220,WIDTH-50,30);
      String msg = "";
      if(pagaJuros){
         //msg = "Juros da locação de número: "+String.valueOf(pagamento.getLocacao().getLccode());
         msg = "Juros da locação de número: ";
      }else{
         //msg = "Locação de número: "+String.valueOf(pagamento.getLocacao().getLccode());
         msg = "Locação de número: ";
      }
      lblreferente2 = new JLabel(msg);
      lblreferente2.setBounds(10,240,WIDTH-50,30);
      pnldebito.add(lblreferente);
      pnldebito.add(lblreferente2);
      
      add(pnldebito);
      
      //BOTOES
      btvoltar = new JButton(getBundle().getString("debito.btvoltar"));
      btvoltar.setBounds(20,310,120,40);
      btvoltar.addActionListener(this);
      
      btfinalizar = new JButton(getBundle().getString("debito.btfinalizar"));
      btfinalizar.setBounds(WIDTH-140,310,120,35);
      btfinalizar.addActionListener(this);
      
      add(btvoltar);
      add(btfinalizar);
      
      
      //CORES
      cor1 = new Color(0,0,255);
      
      //FONTES
      negrito = new Font("Arial",Font.BOLD,16);
      normal = new Font("Courier New",Font.PLAIN,14);
      
      setTitle(getBundle().getString("debito.title"));
      setLayout(null);
      setResizable(false);
      setSize(WIDTH,HEIGHT);
      setLocationRelativeTo(null);
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
      }   
      else if(e.getSource() == btfinalizar){
         JTextField a[] = {txtbanco,txtconta,txtagencia};
         boolean vazio = false;
         System.out.println(a[0].getText()+"\n"+a[1].getText()+"\n"+a[2].getText());
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
            pagamento.setPgbanco(txtbanco.getText());
            pagamento.setPgagencia(txtagencia.getText());
            pagamento.setPgconta(txtconta.getText());
            pagamento.setPgvalortot(txtvalor.getText());
            pagamento.setPgtipopag("D");
            
            //SIGINIFICA QUE ESTOU PAGANDO O VALOR DO JUROS, E QUE JA VOU DAR BAIXA EM TUDO
            if(pagaJuros){
               System.out.println("paga juros");
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
               System.out.println("paga juros");
               if(pDAO.realizaPagamentoLocacao(pagamento,"D")){//D - DEBITO
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
         
         }//if(!vazio)
      }
   }
   
}