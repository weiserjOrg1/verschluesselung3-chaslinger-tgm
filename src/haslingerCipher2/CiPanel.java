package haslingerCipher2;
import java.awt.*;
import javax.swing.*;
public class CiPanel extends JPanel {
	private CiModel m1;
	public CiPanel(CiModel m) {
		this.m1 = m;
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(this.m1.getOutText(), this.getWidth()/2, this.getHeight()/2);
	}
}
