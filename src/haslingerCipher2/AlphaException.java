package haslingerCipher2;
/** This class creates new exceptions for secret alphabets
 * 
 * @author Christoph Haslinger
 * @version 11-10-2018
 */
public class AlphaException extends Exception {
	public AlphaException() {
		super("The secret alphabet does not match the requirements.");
	}
	public AlphaException(String emsg) {
		super(emsg);
	}
}
