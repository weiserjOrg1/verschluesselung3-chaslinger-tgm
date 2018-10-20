package haslingerCipher2;
/** This interface defines the methods encrypt and decrypt
 * 
 * @author Christoph Haslinger
 * @version 11-10-2018
 */
public interface Cipher {
	public String encrypt(String text);
	public String decrypt(String text);
}
