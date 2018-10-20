package haslingerCipher2;
/** This class handles the Action Listener of the Buttons
 *  @author chris
 *  @version 20-10-2018
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;
public class CiController implements ActionListener {
	private CiModel m1;
	private CiView v1;
	public CiController() {
		this.m1 = new CiModel();
		this.v1 = new CiView(this, this.m1);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.v1.isDecPressed(e)) {
			if(this.v1.isSubstChecked()) {
				this.m1.setNumber(1);
				try {
					this.m1.setSubCipher(this.v1.getSecretAlphabet());
				}catch(AlphaException e1) {
					JOptionPane.showMessageDialog(null, e1.toString(), "Secret alphabet Exception", JOptionPane.ERROR_MESSAGE);
				}
				this.m1.setDecryptedText(this.v1.getText());
			}
			
			if(this.v1.isShiftChecked()) {
				this.m1.setNumber(2);
				try {
					int value = Integer.parseInt(this.v1.getValue());
					this.m1.setShiftCipher(value);
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Shift value must be a number", "Number Exception", JOptionPane.ERROR_MESSAGE);
				}
				this.m1.setDecryptedText(this.v1.getText());
			}
			
			if(this.v1.isKeyChecked()) {
				this.m1.setNumber(3);
				try {
					this.m1.setKeywordCipher(this.v1.getKeyword());
				}catch(AlphaException e1) {
					JOptionPane.showMessageDialog(null, e1.toString(), "keyword Exception", JOptionPane.ERROR_MESSAGE);
				}
				this.m1.setDecryptedText(this.v1.getText());
			}
			
			if(this.v1.isTransChecked()) {
				this.m1.setNumber(4);
				int level = 0;
				try {
					level = Integer.parseInt(this.v1.getTransposition());
					this.m1.setTranspositionLevel(level);
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Transposition level must be a number", "Transposition Exception", JOptionPane.ERROR_MESSAGE);
				}catch(AlphaException e1) {
					JOptionPane.showMessageDialog(null, e1.toString(), "Transposition Exception", JOptionPane.ERROR_MESSAGE);
				}
				this.m1.setDecryptedText(this.v1.getText());
			}
		}
		
		if(this.v1.isEncPressed(e)) {
			if(this.v1.isSubstChecked()) {
				this.m1.setNumber(1);
				try {
					this.m1.setSubCipher(this.v1.getSecretAlphabet());
				}catch(AlphaException e1) {
					JOptionPane.showMessageDialog(null, e1.toString(), "Secret alphabet Exception", JOptionPane.ERROR_MESSAGE);
				}
				this.m1.setEncryptedText(this.v1.getText());
			}
			if(this.v1.isShiftChecked()) {
				this.m1.setNumber(2);
				try {
					int value = Integer.parseInt(this.v1.getValue());
					this.m1.setShiftCipher(value);
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Shift value must be a number", "Number Exception", JOptionPane.ERROR_MESSAGE);
				}
				this.m1.setEncryptedText(this.v1.getText());
			}
			
			if(this.v1.isKeyChecked()) {
				this.m1.setNumber(3);
				try {
					this.m1.setKeywordCipher(this.v1.getKeyword());
				}catch(AlphaException e1) {
					JOptionPane.showMessageDialog(null, e1.toString(), "keyword Exception", JOptionPane.ERROR_MESSAGE);
				}
				this.m1.setEncryptedText(this.v1.getText());
			}
			
			if(this.v1.isTransChecked()) {
				this.m1.setNumber(4);
				int level = 0;
				try {
					level = Integer.parseInt(this.v1.getTransposition());
					this.m1.setTranspositionLevel(level);
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Transposition level must be a number", "Transposition Exception", JOptionPane.ERROR_MESSAGE);
				}catch(AlphaException e1) {
					JOptionPane.showMessageDialog(null, e1.toString(), "Transposition Exception", JOptionPane.ERROR_MESSAGE);
				}
				this.m1.setEncryptedText(this.v1.getText());
			}
		}
		this.v1.refresh();
	}
}
