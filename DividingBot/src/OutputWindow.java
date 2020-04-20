import java.awt.*;
import java.awt.event.*;
//import java.applet.*;

public class OutputWindow extends Frame{
	
	private static final long serialVersionUID = 1L;
	String output = DividingBot.finalOutput;
	public OutputWindow() {
		addWindowListener(new ThisWindowAdapter());
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString(output, 10, 10);
	}
	
	class ThisWindowAdapter extends WindowAdapter{
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	}
}
