package haslingerCipher2;
/** This class extends the MonoAlphabeticCipher with an constructor with parameters
 * 
 * @author Christoph Haslinger
 * @version 11-10-2018
 */
public class SubstitutionCipher extends MonoAlphabeticCipher {
	public SubstitutionCipher(String secretAlphabet) throws AlphaException {
		super.setSecretAlphabet(secretAlphabet);
	}
	public void setSecretAlphabet(String secretAlphabet) throws AlphaException {
		super.setSecretAlphabet(secretAlphabet);
	}
}
