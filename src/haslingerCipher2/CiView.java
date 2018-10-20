package haslingerCipher2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CiView extends JFrame{
	private CiModel m1;
	private CiController c1;
	private CiPanel p1;
	private JButton enc, dec;
	private JRadioButton shift, subst, key;
	private JTextField text, secretAlphabet;
	private JTextField value, keyword;
	private JPanel south, north, radio;
	private JLabel iT, iV, iA, iK;
	private Container co1, co2, co3, co4;
	private ButtonGroup rbg;
	
	public CiView(CiController c, CiModel m) {
		this.m1 = m;
		this.c1 = c;
		this.p1 = new CiPanel(this.m1);
		this.setSize(500, 500);
		this.setTitle("Encrypt3");
		
		this.enc = new JButton("encrypt");
		this.dec = new JButton("decrypt");
		
		this.subst = new JRadioButton("SubstitutionCipher", true);
		this.shift = new JRadioButton("ShiftCipher");
		this.key = new JRadioButton("KeywordCipher");
		
		this.text = new JTextField();
		this.secretAlphabet = new JTextField();
		this.value = new JTextField();
		this.keyword = new JTextField();
		
		this.south = new JPanel();
		this.north = new JPanel();
		this.radio = new JPanel();
		
		this.iT = new JLabel("Message: ");
		this.iV = new JLabel("Shift value: ");
		this.iA = new JLabel("secretAlphabet: ");
		this.iK = new JLabel("keyword: ");
		
		this.co1 = new Container();
		this.co2 = new Container();
		this.co3 = new Container();
		this.co4 = new Container();
		
		this.rbg = new ButtonGroup();
		
		
		this.rbg.add(this.shift);
		this.rbg.add(this.subst);
		this.rbg.add(this.key);
		
		this.enc.addActionListener(this.c1);
		this.dec.addActionListener(this.c1);
		this.subst.addActionListener(this.c1);
		this.shift.addActionListener(this.c1);
		this.key.addActionListener(this.c1);
		
		
		this.setLayout(new BorderLayout());
		this.south.setLayout(new GridLayout(3,1));
		this.north.setLayout(new BorderLayout());
		this.radio.setLayout(new GridLayout());
		this.co1.setLayout(new GridLayout());
		this.co2.setLayout(new GridLayout());
		this.co3.setLayout(new GridLayout());
		this.co4.setLayout(new GridLayout());
		
		
		this.co1.add(this.iT);
		this.co1.add(this.text);
		this.co2.add(this.iV);
		this.co2.add(this.value);
		this.co3.add(this.iA);
		this.co3.add(this.secretAlphabet);
		this.co4.add(this.iK);
		this.co4.add(this.keyword);
		
		this.radio.add(this.shift);
		this.radio.add(this.subst);
		this.radio.add(this.key);
		
		this.north.add(this.radio, BorderLayout.NORTH);
		this.north.add(this.co1, BorderLayout.SOUTH);
		
		this.south.add(this.co2);
		this.south.add(this.co3);
		this.south.add(this.co4);
		
		this.add(this.p1);
		this.add(this.north, BorderLayout.NORTH);
		this.add(this.south, BorderLayout.SOUTH);
		this.add(this.enc, BorderLayout.WEST);
		this.add(this.dec, BorderLayout.EAST);
		this.setVisible(true);
	}
	public void refresh() {
		this.p1.repaint();
	}
	public boolean isEncPressed(ActionEvent e) {
		if(e.getSource()==this.enc) return true;
		return false;
	}
	public boolean isDecPressed(ActionEvent e) {
		if(e.getSource()==this.dec) return true;
		return false;
	}
	public boolean isShiftChecked() {
		if(this.shift.isSelected()) return true;
		return false;
	}
	public boolean isSubstChecked() {
		if(this.subst.isSelected()) return true;
		return false;
	}
	public boolean isKeyChecked() {
		if(this.key.isSelected()) return true;
		return false;
	}
	public String getKeyword() {
		return this.keyword.getText();
	}
	public String getValue() {
		return this.value.getText();
	}
	public String getSecretAlphabet() {
		return this.secretAlphabet.getText();
	}
	public String getText() {
		return this.text.getText();
	}
}
