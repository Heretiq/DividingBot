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

//System.out.println(finalOutput);
//OutputWindow w = new OutputWindow();
//System.out.print(w.output);
//w.setSize(new Dimension(300,300));
//w.setTitle("Деление столбиком");
//w.setVisible(true);

