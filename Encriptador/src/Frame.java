import javax.swing.JFrame;

public class Frame extends JFrame {

	private PanelMenu pnlMenu;

	public Frame() {
		super("String encryption");
		setSize(420, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnlMenu = new PanelMenu();
		add(pnlMenu);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}