package haslingerCipher2;

public class CiModel {
	private String outText;
	private SubstitutionCipher s1;
	private ShiftCipher c1;
	private KeywordCipher k1;
	private int number;
	
	public CiModel() {
		this.number = 1;
		this.outText = "N.A.";
		try {
			this.s1 = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
			this.c1 = new ShiftCipher(0);
			this.k1 = new KeywordCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		}catch(AlphaException e) {
			
		}
	}
	public void setSubCipher(String alphabet) throws AlphaException{
		this.s1.setSecretAlphabet(alphabet);
	}
	public void setShiftCipher(int value) {
		try {
			this.c1.setShiftValue(value);
		}catch (AlphaException e) {
		}
	}
	public void setKeywordCipher(String keyword) throws AlphaException{
		this.k1.setKeyword(keyword);
	}
	public void setEncryptedText(String text) {
		switch(this.number) {
		case 1: this.outText = this.s1.encrypt(text);
			break;
		case 2: this.outText = this.c1.encrypt(text);
			break;
		case 3: this.outText = this.k1.encrypt(text);
			break;
		default:
			break;
		}
	}
	public void setDecryptedText(String text) {
		switch(this.number) {
		case 1: this.outText = this.s1.decrypt(text);
			break;
		case 2: this.outText = this.c1.decrypt(text);
			break;
		case 3: this.outText = this.k1.decrypt(text);
			break;
		default:
			break;
		}	
	}
	public void setNumber(int i) {
		this.number = i;
	}
	public int getNumber() {
		return this.number;
	}
	public String getOutText() {
		return this.outText;
	}
}
