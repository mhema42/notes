package notes;

public class Input {

	public static void main(String[] args) {
		
		String headline = "Rubrik";
		String subHeadline = "underrubrik";
		String notes = "anteckning";
		String path = ".\\text.txt";
		
		Text.textHandler(headline, subHeadline, notes, path);
	}	
}
	