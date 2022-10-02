package notes;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
	
	private static String error1 = "Unable to read file, begin with choice (1) and add text to file...";
	private static String error2 = "Unable to write to file, please enter correct and/or filename...";
	
	private String headline;
	private String subHeadline;
	private String note;
	
	/**
	 * constructor to create headline, subHeadline and notes
	 * @param hl headline
	 * @param shl subHeadline
	 * @param n notes
	 */
	private Text(String hl, String shl, String n) {
		
		headline = hl;
		subHeadline = shl;
		note = n;
	}
	
	/**
	 * combines headline, subHeadline, note and separators
	 * @return concatenated text string
	 */
	private String setConcatText() {
		String concatText = "\n" + headline + " - " + subHeadline + ": " + note + ";";
			
		return concatText;
	}
	
	/**
	 * saves concatenated text string to text file
	 * @param path path to file
	 * @param text concatenated text
	 */
	private void saveText(String path, String text) {
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
	protected static String textHandler(String headline, String subHeadline, String note, String path) {
		
		Text text = new Text(headline, subHeadline, note);
		
		String concatText = text.setConcatText();

		text.saveText(path, concatText);
		
		return concatText;
	}
	
	protected static String getFilteredText(String path, String text, String headline) {
		String filteredText = null;
			
		if (text != error1) {
			String filter = "";
			Pattern p = Pattern.compile(Pattern.quote(headline + " -") + "(.*?)" + Pattern.quote(";"));
			Matcher m = p.matcher(text);
			while (m.find()) {
				filter = filter + m.group(0);
			}
			
			List<String> listText = Arrays.asList(filter.split(";", -1));
			filteredText = String.join("\n", listText);			    
		}
		return filteredText; 
	}
	
	protected static String fileReader(String path) {
		String text;
		
		try {
			text = new String(Files.readAllBytes(Paths.get(path)));
		} catch (IOException e) {
			text = error1;
		}
		
		return text;
	}

}
