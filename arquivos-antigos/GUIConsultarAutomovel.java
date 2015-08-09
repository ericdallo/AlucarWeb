import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;


public class GUIConsultarAutomovel extends JFrame implements ActionListener{
	private JLabel lblconsulta,lblicone;
	private JButton btpesquisar,btincluir,btalterar,btexcluir,btdetalhar;
	private JComboBox combo;
	private JTable tabela;
	private JScrollPane pane;
	
	public GUIConsultarAutomovel(){
		
		lblicone = new JLabel(new ImageIcon(getClass().getResource("images/pesquisa.png")));
		lblconsulta = new JLabel("Como deseja Pesquisar");
		String[] op = {"Chassi","Placa","Modelo","Fabricante"};
		combo = new JComboBox(op);
		tabela = new JTable();
		pane = new JScrollPane(tabela);
		btpesquisar = new JButton("Pesquisar");
		btincluir = new JButton("Incluir");
		btexcluir = new JButton("Excluir");
		btalterar = new JButton("Alterar");
		btdetalhar = new JButton("Deltalhar");
		
		//Bounds
		lblicone.setBounds(130,65,100,40);
		lblconsulta.setBounds(20,20,150,30);
		combo.setBounds(170,20,150,30);
		btpesquisar.setBounds(20,70,120,30);
		btincluir.setBounds(20,325,120,30);
		btalterar.setBounds(160,325,120,30);
		btexcluir.setBounds(300,325,120,30);
		btdetalhar.setBounds(440,325,120,30);
		
		tabela.setBounds(20,125,540,190);
		pane.setBounds(20,125,540,190);
		
		//estilo
		tabela.setGridColor(Color.BLACK);
		tabela.setBorder(new LineBorder(Color.BLACK));
		tabela.setShowGrid(true);

		
		//adds
		add(lblicone);
		add(lblconsulta);
		add(btpesquisar);
		add(btincluir);
		add(btalterar);
		add(btexcluir);
		add(btdetalhar);
		add(combo);
		add(pane);
		//sets
		setLayout(null);
		setSize(600,400);
		setType(Type.UTILITY);
		setLocationRelativeTo(null);
      setIconImage(new ImageIcon(getClass().getResource("images/logo2.png")).getImage());
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
}
