package notes;

public class Text {
	
	public String headline;
	public String subHeadline;
	public String note;
	
	public Text(String hl, String shl, String n) {
		
		headline = hl;
		subHeadline = shl;
		note = n;
	}
	
	public String concatText() {
		return "\n" + headline + " - " + subHeadline + ": " + note + ";";
	}
}
