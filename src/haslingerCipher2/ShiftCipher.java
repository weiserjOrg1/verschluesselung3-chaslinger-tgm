package haslingerCipher2;
/** This class extends the MonoAlphabeticCipher with an constructor for Cesar encryption.
 * 
 * @author Christoph Haslinger
 * @version 12-10-2018
 */
public class ShiftCipher extends MonoAlphabeticCipher{
	public ShiftCipher(int value) throws AlphaException {
		this.setShiftValue(value);
	}
	public void setShiftValue(int value) throws AlphaException{
		String defaultAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		String shiftAlphabet = "";
		while(value >= defaultAlphabet.length()) {
			value = value - 30;
		}
		while(value < 0) {
			value = value + 30;
		}
		for(int i = 0; i < defaultAlphabet.length() ;i++) {
			shiftAlphabet = shiftAlphabet + defaultAlphabet.charAt(value);
			value++;
			if(value >= defaultAlphabet.length()) {
				value = value - 30;
			}
		}
		this.setSecretAlphabet(shiftAlphabet);
	}
}
