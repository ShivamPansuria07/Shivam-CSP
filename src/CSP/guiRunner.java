package CSP;
import javax.swing.JFrame;
public class guiRunner{
	JFrame frame;
	final static int WIDTH = 500;
	final static int HEIGHT = 800;
	GamePanel gp;
	public static void main(String[] args) {
		
	
		guiRunner gui = new guiRunner();
		gui.setup();


	}

	public guiRunner() {
		frame = new JFrame();
		gp = new GamePanel();
	}

	void setup() {
		frame.add(gp);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gp);


	}
}
