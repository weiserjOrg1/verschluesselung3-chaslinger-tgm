package haslingerCipher2;
import javax.swing.*;
public class KeywordCipher extends MonoAlphabeticCipher{
	public KeywordCipher(String keyword) throws AlphaException {
		this.setKeyword(keyword);
	}
	public void setKeyword(String keyword) throws AlphaException {
		String secretAlphabet = "";
		String alphabet = "abcdefghijklmnopqrtsuvwxyzäöüß";
		keyword = keyword.toLowerCase();
		
		for(int i = 0; i < keyword.length(); i++) {
			char letter = keyword.charAt(i);
			if((letter > 'a'-1 && letter < 'z'+1) || letter == 'ä' || letter == 'ö' || letter == 'ü' || letter=='ß') {
				
			}else {
				throw new AlphaException("The keyword must not contain any special characters");
			}
		}
		
		boolean[] exist = new boolean[30];
		for(int i = 0; i < exist.length; i++) {
			exist[i] = false;
		}
		for(int i = 0; i < keyword.length(); i++) {
			for(int j = 0; j < alphabet.length(); j++) {
				if(keyword.charAt(i) == alphabet.charAt(j) && exist[j] == false) {
					exist[j] = true;
					secretAlphabet = secretAlphabet + keyword.charAt(i);
					break;
				}
			}
		}
		
		for(int i = 0; i < alphabet.length();i++) {
			boolean existing = false;
			for(int j = 0; j < secretAlphabet.length(); j++) {
				if(alphabet.charAt(i) == secretAlphabet.charAt(j)) {
					existing = true;
					break;
				}
			}
			if(existing == true) {
				
			}else{
				secretAlphabet = secretAlphabet + alphabet.charAt(i);
			}
		}
		JOptionPane.showMessageDialog(null, secretAlphabet);
		super.setSecretAlphabet(secretAlphabet);
	}
}
