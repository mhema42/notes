package notes;

public class Input {

	public static String setText(String headline, String subHeadline, String note) {
		 
		Text text = new Text(headline, subHeadline, note);
		
		String concatText = text.concatText();
		
		return concatText;
	}
	
	public static void main(String[] args) {
		System.out.println(setText("Hej", "hur mår", " du?"));
	}	
}
	