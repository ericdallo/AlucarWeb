import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.Color;
import java.awt.Font;

public class GUIAlterarAutomovel extends JFrame implements ActionListener{
   private JPanel pnlautomovel;
   private ImageIcon img,img2;
   private JLabel lblcod,lblchassi,lblfabricante,lblmodelo,lblgrupo,lblinformacoes,lblplaca;
   private JLabel lblcidade,lblkm,lblestado,lblkmlivre,lblkmcontrolado,lblacessorios;
   private JTextField txtcod,txtchassi,txtfabricante,txtmodelo,txtplaca;
   private JTextField txtcidade,txtestado,txtkm,txtkmlivre,txtkmcontrolado;
   private JComboBox cmbgrupo,cmbacessorios;
   private JButton btvoltar,btsalvar,btlimpar;
   private Color cor1;
   private Font negrito,normal;
   
   public GUIAlterarAutomovel(){
      super("Alterar Dados do Automóvel");
      
      pnlautomovel = new JPanel();
      img = new ImageIcon(getClass().getResource("images/btsalvar.png"));
      img2 = new ImageIcon(getClass().getResource("images/btvoltar.png"));      
      //ESQUERDA no panel
      lblcod = new JLabel("Código");
      txtcod = new JTextField(5);
      lblchassi = new JLabel("Chassi");
      txtchassi = new JTextField(20);
      lblfabricante = new JLabel("Fabricante");
      txtfabricante = new JTextField(20);      
      lblmodelo = new JLabel("Modelo");
      txtmodelo = new JTextField(15);      
      lblgrupo = new JLabel("Grupo");  
      String[] op = {"Selecione o Grupo","A - Econômico","C – Econômico com Ar","F – Intermediário","G – Intermediário Wagon Especia"
                     ,"H – Executivo","I – Utilitário","K – Executivo Luxo","M – Intermediário Wagon","N – Pick-up"
                     ,"P – 4 x 4 Especial","R – Minivan","U – Furgão","Y – Blindado"};
      cmbgrupo = new JComboBox(op);
      lblplaca = new JLabel("Placa");  
      txtplaca = new JTextField(10);
      //DIREITA no panel
      lblcidade = new JLabel("Cidade");
      txtcidade = new JTextField(15);      
      lblestado = new JLabel("Estado");  
      txtestado = new JTextField(10);
      lblkm = new JLabel("Qtd. Kilometros");  
      txtkm = new JTextField(10);
      lblkmlivre = new JLabel("Tarifa Km Livre");
      txtkmlivre = new JTextField(15);      
      lblkmcontrolado = new JLabel("Tarifa Km Controlado");  
      txtkmcontrolado = new JTextField(10);
      lblacessorios = new JLabel("Acessórios");
      String[] op2 = {"Selectione o Acessório","Navegador GPS","Cadeira de Bebê","Motorista"};
      cmbacessorios = new JComboBox(op2);
      
      
      lblinformacoes = new JLabel("");
      
      btvoltar = new JButton("Voltar");
      btsalvar = new JButton("Salvar");      
      btlimpar = new JButton("Limpar campos");

      //Cores
      cor1 = new Color(255,119,0);
      
      //Fontes
      negrito = new Font("Arial",Font.BOLD,16);
      normal = new Font("Courier New",Font.PLAIN,14);
      lblcod.setFont(normal);
      lblchassi.setFont(normal);
      lblmodelo.setFont(normal);
      lblfabricante.setFont(normal);
      lblgrupo.setFont(normal);         
      lblplaca.setFont(normal);
      lblcidade.setFont(normal);
      lblestado.setFont(normal);
      lblkm.setFont(normal);
      lblkmlivre.setFont(normal);
      lblkmcontrolado.setFont(normal);
      lblacessorios.setFont(normal);
      lblinformacoes.setFont(negrito);
      
      //estilo
      pnlautomovel.setBorder(BorderFactory.createTitledBorder(null, "Informações do Automóvel",
         	TitledBorder.CENTER, TitledBorder.TOP, new Font("Lucida Sans",
         			Font.BOLD, 16), cor1));
      pnlautomovel.setLayout(null);
      
      btsalvar.setIcon(img);
      btvoltar.setIcon(img2);
      
      //Bounds
      
      pnlautomovel.setBounds(15,15,820,230);
      //ESQUERDA
      lblcod.setBounds(15,30,100,30);
      txtcod.setBounds(140,30,70,30);
      lblchassi.setBounds(15,60,100,30);
      txtchassi.setBounds(140,60,240,30);
      lblfabricante.setBounds(15,90,100,30);
      txtfabricante.setBounds(140,90,160,30);
      lblmodelo.setBounds(15,120,100,30);
      txtmodelo.setBounds(140,120,100,30);
      lblgrupo.setBounds(15,150,100,30);      
      cmbgrupo.setBounds(140,150,240,30);
      lblplaca.setBounds(15,180,100,30);
      txtplaca.setBounds(140,180,100,30);
      //DIREITA
      lblestado.setBounds(410,30,100,30);
      txtestado.setBounds(580,30,30,30);
      lblcidade.setBounds(410,60,100,30);
      txtcidade.setBounds(580,60,200,30);
      lblacessorios.setBounds(410,90,150,30);
      cmbacessorios.setBounds(580,90,200,30);
      lblkm.setBounds(410,120,150,30);
      txtkm.setBounds(580,120,120,30);
      lblkmlivre.setBounds(410,150,150,30);      
      txtkmlivre.setBounds(580,150,120,30);
      lblkmcontrolado.setBounds(410,180,180,30);
      txtkmcontrolado.setBounds(580,180,120,30);
      
      
      lblinformacoes.setBounds(300,250,300,30);
      
      btvoltar.setBounds(210,300,130,35);
      btlimpar.setBounds(370,300,130,35);            
      btsalvar.setBounds(530,300,130,35);
   
      
      //adds
      
      //ESQUERDA
      pnlautomovel.add(lblcod);
      pnlautomovel.add(txtcod);      
      pnlautomovel.add(lblchassi);
      pnlautomovel.add(txtchassi);
      pnlautomovel.add(lblmodelo);
      pnlautomovel.add(txtmodelo);
      pnlautomovel.add(lblfabricante);
      pnlautomovel.add(txtfabricante);
      pnlautomovel.add(lblgrupo);
      pnlautomovel.add(cmbgrupo);
      pnlautomovel.add(lblplaca);      
      pnlautomovel.add(txtplaca);
      //DIREITA
      pnlautomovel.add(lblcidade);
      pnlautomovel.add(txtcidade);      
      pnlautomovel.add(lblestado);
      pnlautomovel.add(txtestado);
      pnlautomovel.add(lblkm);
      pnlautomovel.add(txtkm);
      pnlautomovel.add(lblkmlivre);
      pnlautomovel.add(txtkmlivre);
      pnlautomovel.add(lblacessorios);
      pnlautomovel.add(cmbacessorios);
      pnlautomovel.add(lblkmcontrolado);      
      pnlautomovel.add(txtkmcontrolado);
      add(pnlautomovel);      
      add(lblinformacoes); 
                  
      add(btvoltar);
      add(btsalvar);
      add(btlimpar);      
      
      //addsAction
      btlimpar.addActionListener(this);
      btsalvar.addActionListener(this);
      btvoltar.addActionListener(this);
      
      
      //sets
      setLayout(null);
      setSize(865,380);
      setLocationRelativeTo(null);
      setIconImage(new ImageIcon(getClass().getResource("images/logo2.png")).getImage());
      setVisible(true);
      
      //listeners
      
      limpaLabel();
      
      //textos sem edit
      txtcod.setEnabled(false);
   }
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == btlimpar){
         limpar();
      }
      else if(e.getSource() == btsalvar){
         if(estaVazio()){
            //JOptionPane.showMessageDialog(null,"Preencha todos os campos corretamente");
            lblinformacoes.setText("Preencha todas as informações");
            repaint();
         }
         else{
            //dados salvos no DB
         }
      }
      else if(e.getSource() == btvoltar){
         //new GUIAutomovel();
      }
      
      
   }
   
   public void limpar(){
      txtchassi.setText("");
      txtmodelo.setText("");
      txtfabricante.setText("");
      cmbgrupo.setSelectedIndex(0);
      txtplaca.setText("");
      txtcidade.setText("");
      txtestado.setText("");
      txtkm.setText("");
      txtkmlivre.setText("");
      txtkmcontrolado.setText("");
      cmbacessorios.setSelectedIndex(0);
      //System.out.println("x " + getWidth() + "\ny "+getHeight() );
   }
   
   public boolean estaVazio(){
      if(txtcod.getText().equals("") || txtchassi.getText().equals("") ||
       txtmodelo.getText().equals("") || txtfabricante.getText().equals("") ||
        cmbgrupo.getSelectedItem().toString().equals("Selecione o Grupo") || txtplaca.getText().equals("")
        ||txtcidade.getText().equals("") || txtestado.getText().equals("") || txtkm.getText().equals("") ||
         txtkmlivre.getText().equals("") || txtkmcontrolado.getText().equals("") ||
          cmbacessorios.getSelectedItem().toString().equals("Selecione o Acessório")){
         return true;
      }
      return false;
   }
   //Listener para limpar lblinformacoes
   public void limpaLabel(){
      txtcod.addKeyListener(
            new KeyListener(){
               @Override
               public void keyPressed(KeyEvent e){
                  lblinformacoes.setText("");
               }
               
               @Override
               public void keyReleased(KeyEvent arg0) {
                  
               }
            
               @Override
               public void keyTyped(KeyEvent arg0) {
               
               }
            });
      txtchassi.addKeyListener(
            new KeyListener(){
               @Override
               public void keyPressed(KeyEvent e){
                  lblinformacoes.setText("");
               }
               
               @Override
               public void keyReleased(KeyEvent arg0) {
                  
               }
            
               @Override
               public void keyTyped(KeyEvent arg0) {
               
               }
            });
      txtmodelo.addKeyListener(
            new KeyListener(){
               @Override
               public void keyPressed(KeyEvent e){
                  lblinformacoes.setText("");
               }
               
               @Override
               public void keyReleased(KeyEvent arg0) {
                  
               }
            
               @Override
               public void keyTyped(KeyEvent arg0) {
               
               }
            });
      txtfabricante.addKeyListener(
            new KeyListener(){
               @Override
               public void keyPressed(KeyEvent e){
                  lblinformacoes.setText("");
               }
               
               @Override
               public void keyReleased(KeyEvent arg0) {
                  
               }
            
               @Override
               public void keyTyped(KeyEvent arg0) {
               
               }
            });
      txtplaca.addKeyListener(
            new KeyListener(){
               @Override
               public void keyPressed(KeyEvent e){
                  lblinformacoes.setText("");
               }
               
               @Override
               public void keyReleased(KeyEvent arg0) {
                  
               }
            
               @Override
               public void keyTyped(KeyEvent arg0) {
               
               }
            });
      
      txtcidade.addKeyListener(
            new KeyListener(){
               @Override
               public void keyPressed(KeyEvent e){
                  lblinformacoes.setText("");
               }
               
               @Override
               public void keyReleased(KeyEvent arg0) {
                  
               }
            
               @Override
               public void keyTyped(KeyEvent arg0) {
               
               }
            });
      txtestado.addKeyListener(
            new KeyListener(){
               @Override
               public void keyPressed(KeyEvent e){
                  lblinformacoes.setText("");
               }
               
               @Override
               public void keyReleased(KeyEvent arg0) {
                  
               }
            
               @Override
               public void keyTyped(KeyEvent arg0) {
               
               }
            });
      txtkm.addKeyListener(
            new KeyListener(){
               @Override
               public void keyPressed(KeyEvent e){
                  lblinformacoes.setText("");
               }
               
               @Override
               public void keyReleased(KeyEvent arg0) {
                  
               }
            
               @Override
               public void keyTyped(KeyEvent arg0) {
               
               }
            });
      txtkmlivre.addKeyListener(
            new KeyListener(){
               @Override
               public void keyPressed(KeyEvent e){
                  lblinformacoes.setText("");
               }
               
               @Override
               public void keyReleased(KeyEvent arg0) {
                  
               }
            
               @Override
               public void keyTyped(KeyEvent arg0) {
               
               }
            });
      txtkmcontrolado.addKeyListener(
            new KeyListener(){
               @Override
               public void keyPressed(KeyEvent e){
                  lblinformacoes.setText("");
               }
               
               @Override
               public void keyReleased(KeyEvent arg0) {
                  
               }
            
               @Override
               public void keyTyped(KeyEvent arg0) {
               
               }
            });      
   }
}