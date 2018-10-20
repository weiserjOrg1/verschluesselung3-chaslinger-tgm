package haslingerCipher2;

/**
 * This class encrypts/decrypts a Text based on the transposition cipher principle 
 * @author chris
 * @version 20-10-2018
 */
public class TranspositionCipher implements Cipher{
	
	private int transpositionLevel; 	

	public TranspositionCipher(int level) throws AlphaException{
		if(level < 1) {
			throw new AlphaException("The transposition level must be above 1");
		}
		this.transpositionLevel = level;
	}
	public void setTranspositionLevel(int level) throws AlphaException{
		if(level < 1) {
			throw new AlphaException("The transposition level must be above 1");
		}
		this.transpositionLevel = level;
	}

	@Override
	public String decrypt(String text) {
		// check if \n == translvl
		int count = text.length() - text.replace(" ", "").length();
		if(count != this.transpositionLevel) {
			return text;
		}
		
		
		String usedText = text;
		String[] textFragments = new String[this.transpositionLevel];
		
		String decryptedText = "";
		
		for(int i = 0; i < textFragments.length; i++) {
			textFragments[i] = "";
		}
		for(int i = 0; i < this.transpositionLevel;) {
			int help = usedText.indexOf(" ");
			textFragments[i] = usedText.substring(0, usedText.indexOf(" "));
			i++;
			if(i < this.transpositionLevel) {
				usedText = usedText.substring(usedText.indexOf(" ")+1, usedText.length());
			}
		}
		int counter = 0;
		int[] counters = new int[this.transpositionLevel];
		for(int i = 0; i < text.length()-this.transpositionLevel; i++) {
			int resetVal = counter%this.transpositionLevel;
			if(resetVal == 0) {
				counter = 0;
			}
			decryptedText = decryptedText + textFragments[counter].charAt(counters[counter]);
			counters[counter] = counters[counter] + 1;
			counter++;
		}
		return decryptedText;
	}

	@Override
	public String encrypt(String text) {
		text = text.replace(" ", "");
		String[] placeHolder = new String[this.transpositionLevel];
		for(int i = 0; i < placeHolder.length; i++) {
			placeHolder[i] = "";
		}
		String encryptedText = "";
		
		int counter = 0;
		for(int i = 0; i < text.length(); i++) {
			int resetVal = counter%this.transpositionLevel;
			if(resetVal == 0) {
				counter = 0;
			}
			placeHolder[counter] = placeHolder[counter] + text.charAt(i);
			counter++;
		}
		for(int i = 0; i < placeHolder.length; i++) {
			encryptedText = encryptedText + placeHolder[i] + " "; 
		}
		return encryptedText;
	}

}
