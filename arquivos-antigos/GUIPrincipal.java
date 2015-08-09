import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.*;

public class GUIPrincipal extends JFrame implements ActionListener,MouseListener,ComponentListener{
	private ResourceBundle bn = null;
	private JPanel pnl,pnlBotoes,pnlFoot;
	private JDesktopPane pnlD;
	private JMenuBar menuBar;
	private JMenu menuCliente,menuLocacao, menuVeiculo,menuOpcoes;
	private JMenuItem itClieteManter,itLocaManter,itLocaDevolver,itConsultarVeiculo,itGerenciarVeiculo,itSair,itEncerrar,itTrocaIdioma;   
	private JButton btCliente, btLocacao, btDevolucao, btCar;
   private JLabel lbllogin, lblnivel,lbllogin2, lblnivel2, lblagencia, lblagencia2;
   private JLabel lblfundo;
   private Usuario user;
   private String agencia;
   private Image imgfundo;
   private boolean responsivo = false;
   
   //USUARIO QUE ESTA LOGADO   
   public void setUsuario(Usuario user){
      this.user = user;
   } 
   public Usuario getUsuario(){
      return this.user;
   }
    
   //AGENCIA EM QUE FOI FEITO O LOGIN
   public void setAgencia(String agencia){
      this.agencia = agencia;
   }
   public String getAgencia(){
      return this.agencia;
   }
   
   //IDIOMA   
	public void setBundle(ResourceBundle bn){
		this.bn = bn;
	} 
	public ResourceBundle getBundle(){
		return this.bn;
	}
   
    
	public GUIPrincipal(){ 	
	}
   
   public GUIPrincipal(String agencia, Usuario user){
      setUsuario(user);
      setAgencia(agencia);
   }
    
	public void init(){
		menuBar = new JMenuBar();
      
		menuCliente = new JMenu(getBundle().getString("principal.menuCliente"));
		itClieteManter = new JMenuItem(getBundle().getString("principal.menuCliente.item1"));
      itClieteManter.addActionListener(this);

		menuLocacao = new JMenu(getBundle().getString("principal.menuLocacao"));
		itLocaManter = new JMenuItem(getBundle().getString("principal.menuLocacao.item1"));
      itLocaManter.addActionListener(this);
		itLocaDevolver = new JMenuItem(getBundle().getString("principal.menuLocacao.item2"));
      itLocaDevolver.addActionListener(this);
      menuVeiculo = new JMenu(getBundle().getString("principal.menuVeiculo"));
      itGerenciarVeiculo = new JMenuItem(getBundle().getString("principal.menuVeiculo.item2"));
      itGerenciarVeiculo.addActionListener(this);
      menuOpcoes = new JMenu(getBundle().getString("principal.menuOpcoes"));
		itEncerrar = new JMenuItem(getBundle().getString("principal.menuOpcoes.itEncerrar"));
		itEncerrar.addActionListener(this);
      itTrocaIdioma = new JMenuItem(getBundle().getString("principal.menuOpcoes.itTrocaIdioma"));
      itTrocaIdioma.addActionListener(this);
      
		itSair = new JMenuItem(getBundle().getString("principal.menuOpcoes.itSair"));		
		itSair.addActionListener(this);		
      
      
      
		//PANELS
		pnl = new JPanel(new BorderLayout());
      imgfundo = new ImageIcon(getClass().getResource("images/fundos/background.png")).getImage();
      pnlD = new JDesktopPane(){
         public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(imgfundo,0,0,getWidth(),getHeight(),null);
         }
      };
		pnlBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlFoot = new JPanel(new FlowLayout(FlowLayout.LEFT));
      
		//BOTOES
		btCliente = new JButton();
      btCliente.setPreferredSize(new Dimension(50,50));
		btCliente.setIcon(new ImageIcon(this.getClass().getResource("images/usr-menu32.png")));
		btCliente.setToolTipText(getBundle().getString("principal.hint.btCliente"));
      btCliente.addActionListener(this);
      btCliente.addMouseListener(this);

		btLocacao = new JButton();
      btLocacao.setPreferredSize(new Dimension(50,50));
		btLocacao.setIcon(new ImageIcon(this.getClass().getResource("images/alugar-menu32.png")));
		btLocacao.setToolTipText(getBundle().getString("principal.hint.btLocacao"));
      btLocacao.addActionListener(this);
      btLocacao.addMouseListener(this);
            
      btDevolucao = new JButton();
      btDevolucao.setPreferredSize(new Dimension(50,50));
		btDevolucao.setIcon(new ImageIcon(this.getClass().getResource("images/dev-menu32.png")));
		btDevolucao.setToolTipText(getBundle().getString("principal.hint.btDevolucao"));
      btDevolucao.addActionListener(this);
      btDevolucao.addMouseListener(this);      
            
      btCar = new JButton();
      btCar.setPreferredSize(new Dimension(50,50));
		btCar.setIcon(new ImageIcon(this.getClass().getResource("images/car-menu32.png")));
		btCar.setToolTipText(getBundle().getString("principal.hint.btCar"));
      btCar.addActionListener(this);
      btCar.addMouseListener(this);
      
            
		//ADD
		menuCliente.add(itClieteManter);      
		menuLocacao.add(itLocaManter);
		menuLocacao.add(itLocaDevolver);
      menuVeiculo.add(itGerenciarVeiculo);
		menuOpcoes.add(itEncerrar);
		menuOpcoes.add(itSair);		
      menuOpcoes.add(itTrocaIdioma);
     
		menuBar.add(menuCliente);
		menuBar.add(menuLocacao);
      menuBar.add(menuVeiculo);
		menuBar.add(menuOpcoes);
      
		pnlBotoes.add(btCliente);  
		pnlBotoes.add(btLocacao);
      pnlBotoes.add(btDevolucao);
      pnlBotoes.add(btCar);
      
      
      
      //RODAPE COM INFO DO USUARIO
      lbllogin = new JLabel("<HTML>"+getBundle().getString("principal.lbllogin")+": "+"</HTML>");
      lbllogin.setFont(new Font("CordiaUPC", Font.PLAIN, 26));
      lbllogin2 = new JLabel(user.getLogin());
      lbllogin2.setFont(new Font("CordiaUPC", Font.PLAIN, 26));
      pnlFoot.add(lbllogin);
      pnlFoot.add(lbllogin2);
      
      String nvl = "";
      String nivel = user.getNivel();
      if(nivel.compareToIgnoreCase("s") == 0){
         nvl = getBundle().getString("principal.supervisor");
      }else{
         nvl = getBundle().getString("principal.atendente");
      }
      lblnivel = new JLabel("<HTML>&nbsp;&nbsp;&nbsp;&nbsp;"+getBundle().getString("principal.lblnivel")+": "+"</HTML>");
      lblnivel.setFont(new Font("CordiaUPC", Font.PLAIN, 26));
      lblnivel2 = new JLabel(nvl);
      lblnivel2.setFont(new Font("CordiaUPC", Font.PLAIN, 26));
      pnlFoot.add(lblnivel);
      pnlFoot.add(lblnivel2);
      
      lblagencia = new JLabel("<HTML>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+getBundle().getString("principal.lblagencia")+": "+"</HTML>");
      lblagencia.setFont(new Font("CordiaUPC", Font.PLAIN, 26));
      lblagencia2 = new JLabel(getAgencia());
      lblagencia2.setFont(new Font("CordiaUPC", Font.PLAIN, 26));
      pnlFoot.add(lblagencia);
      pnlFoot.add(lblagencia2);      
      
		pnl.add(pnlBotoes,BorderLayout.NORTH);
		pnl.add(pnlD,BorderLayout.CENTER);
		pnl.add(pnlFoot,BorderLayout.SOUTH);
      
		//FRAME////////////////////////////////////////////////////////
      addComponentListener(this);
      setTitle(getBundle().getString("principal.title"));
		setContentPane(pnl);
		setJMenuBar(menuBar);
		setResizable(true);
		setSize(330,360);
		//setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
      setIconImage(new ImageIcon(getClass().getResource("images/logo2.png")).getImage());
		setVisible(true);
      ///////////////////////////////////////////////////////////////
      
	}//init
   
   //LISTENER
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btCliente || e.getSource() == itClieteManter){
			GUICliente c = new GUICliente(this);
         c.setUsuario(getUsuario());
         c.setBundle(this.getBundle());
         c.init(this);
		}else if(e.getSource() == btDevolucao || e.getSource() == itLocaDevolver){
         GUIDevolucao d = new GUIDevolucao(this,getUsuario());
         d.setBundle(this.getBundle());
         d.init(this);
      }else if(e.getSource() == btLocacao || e.getSource() == itLocaManter){
         GUILocacao l = new GUILocacao(this,getUsuario());
         l.setUsuario(getUsuario());
         l.setBundle(this.getBundle());
         l.init(this);
      }else if(e.getSource() == btCar || e.getSource() == itGerenciarVeiculo){
         GUIAutomovel c = new GUIAutomovel(this);
         c.setBundle(this.getBundle());
         c.setUsuario(getUsuario());
         c.init(this);
      }else if(e.getSource() == itEncerrar){
			this.dispose();
			GUILogin g = new GUILogin();
			g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			g.setBundle(getBundle());
			g.init();
		}else if(e.getSource() == itSair){
			System.exit(0);
		}else if(e.getSource() == itTrocaIdioma){
         GUIIdioma i = new GUIIdioma();
         i.init();
         dispose();
      }
	}
   
   //LISTENER
   public void mouseEntered(MouseEvent e){
      if(e.getSource() == btCliente){
         trocarFundo("images/fundos/background_cliente");
      }else if(e.getSource() == btLocacao){
         trocarFundo("images/fundos/background_locacao");
      }else if(e.getSource() == btDevolucao){
         trocarFundo("images/fundos/background_devolucao");
      }else if(e.getSource() == btCar){
         trocarFundo("images/fundos/background_automovel");
      }
   }
   
   public void mouseExited(MouseEvent e){
         trocarFundo("images/fundos/background");
   }
   
   public void componentResized(ComponentEvent e) {
      if(getWidth() <= 420 || getHeight() <= 340){
         responsivo = true;
      }else{
         responsivo = false;
      }
      trocarFundo("images/fundos/background");
      //System.out.println("width:"+getWidth() +"\nheight"+getHeight());
   }
   public void componentHidden(ComponentEvent e) {}
   public void componentShown(ComponentEvent e) {}
   public void componentMoved(ComponentEvent e) {}
   
   public void mouseClicked(MouseEvent e){}
   public void mousePressed(MouseEvent e){}
   public void mouseReleased(MouseEvent e){}
      
   //RESPONSIVO
   public void trocarFundo(String caminho){
      if(responsivo)
         imgfundo = new ImageIcon(getClass().getResource(caminho+"_pequeno.png")).getImage();
      else
         imgfundo = new ImageIcon(getClass().getResource(caminho+".png")).getImage();
      remove(pnlD);
      pnlD = new JDesktopPane(){
         public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(imgfundo,0,0,getWidth(),getHeight(),null);
         
         }
      };
      add(pnlD,BorderLayout.CENTER);
      pnlD.revalidate();
      repaint();
   }
   
}