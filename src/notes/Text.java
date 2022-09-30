package notes;

import java.io.FileWriter;
import java.io.IOException;

public class Text {
	
	public String headline;
	public String subHeadline;
	public String note;
	
	/**
	 * constructor to create headline, subHeadline and notes
	 * @param hl headline
	 * @param shl subHeadline
	 * @param n notes
	 */
	public Text(String hl, String shl, String n) {
		
		headline = hl;
		subHeadline = shl;
		note = n;
	}
	
	/**
	 * combines headline, subHeadline, note and separators
	 * @return concatenated text string
	 */
	public String setConcatText() {
		String concatText = "\n" + headline + " - " + subHeadline + ": " + note + ";";
			
		return concatText;
	}
	
	/**
	 * saves concatenated text string to text file
	 * @param path path to file
	 * @param text concatenated text
	 */
	public void saveText(String path, String text) {
		FileWriter fw;
		try {
			fw = new FileWriter(path, true);
		    fw.write(text + System.lineSeparator());
		    fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * initiates constructor, concatenate text method and save text method
	 * @param headline text containing headline
	 * @param subHeadline text containing subHeadline
	 * @param note text containing notes
	 * @param path path to file
	 * @return concatenated text string
	 */
	public static String textHandler(String headline, String subHeadline, String note, String path) {
		
		Text text = new Text(headline, subHeadline, note);
		
		String concatText = text.setConcatText();

		text.saveText(path, concatText);
		
		return concatText;
	}

}
