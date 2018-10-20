package haslingerCipher2;
/** This class writes the decrypted/encrypted text
 *  @author chris
 *  @version 20-10-2018
 */
import java.awt.*;
import javax.swing.*;
public class CiPanel extends JPanel {
	private CiModel m1;
	public CiPanel(CiModel m) {
		this.m1 = m;
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(this.m1.getOutText(), 0, this.getHeight()/2);
	}
}
