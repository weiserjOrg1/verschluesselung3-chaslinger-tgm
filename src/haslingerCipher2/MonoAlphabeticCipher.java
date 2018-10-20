package haslingerCipher2;
/** This class is used for decrypting and encrypting secret messages
 * 
 * @author Christoph Haslinger
 * @version 11-10-2018
 */
public class MonoAlphabeticCipher implements Cipher{
	private String secretAlphabet;
	
	public MonoAlphabeticCipher() {
		this.secretAlphabet="abcdefghijklmnopqrstuvwxyzäöüß";
	}
	/** returns the secret alphabet
	 * 
	 * @return the secret alphabet
	 */
	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}
	/** sets the secret alphabet
	 * 
	 * @param secretAlphabet 
	 */
	protected void setSecretAlphabet(String secretAlphabet) throws AlphaException{
		this.secretAlphabet = testSecretAlphabet(secretAlphabet);
	}
	/** This method encrypts the text
	 * @param text String which should be encrypted
	 */
	public String encrypt(String text) {
		String defaultAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		text = text.toLowerCase();
		String eText = "";
		for(int i = 0; i < text.length(); i++) {
			char letter = text.charAt(i);
			int place = defaultAlphabet.indexOf(letter);
			if(place == -1) {
				eText = eText + letter;
			}else{
				eText = eText + this.secretAlphabet.charAt(place);
			}
		}
		return eText;
	}
	/** This method decrypts the text
	 * @param text String which should be decrypted
	 */
	public String decrypt(String text) {
		String dText = "";
		String defaultAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		text = text.toLowerCase();
		for(int i = 0; i < text.length(); i++) {
			char letter = text.charAt(i);
			int place = this.secretAlphabet.indexOf(letter);
			if(place == -1) {
				dText = dText + letter;
			}else{
				dText = dText + defaultAlphabet.charAt(place);
			}
		}
		return dText;
	}
	/** This method checks the secret alphabet and throws exceptions if it is not okay
	 * 
	 * @param secretAlphabet secret alphabet
	 * @return the secret alphabet
	 * @throws AlphaExceptions exceptions for invalid secret alphabets
	 */
	public String testSecretAlphabet(String secretAlphabet) throws AlphaException {
		secretAlphabet = secretAlphabet.toLowerCase();
		//30 characters
		if(secretAlphabet.length() == 30) {
			
		}else {
			throw new AlphaException("The alphabet is too short/long");
		}
		//every character only once
		for(int i = 0; i < secretAlphabet.length(); i++) {
			char letter = secretAlphabet.charAt(i);
			if(secretAlphabet.indexOf(letter) == secretAlphabet.lastIndexOf(letter)) {
				
			}else {
				throw new AlphaException("One letter must be only once in the secret alphabet");
			}
		}
		//no special characters
		for(int i = 0; i < 30; i++) {
			char letter = secretAlphabet.charAt(i);
			if((letter > 'a'-1 && letter < 'z'+1) || letter == 'ä' || letter == 'ö' || letter == 'ü' || letter=='ß') {
				
			}else {
				throw new AlphaException("The alphabet must not contain any special characters");
			}
		}
		
		return secretAlphabet;
	}
}
