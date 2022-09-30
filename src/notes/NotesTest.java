package notes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NotesTest {
	
	@Test
	void setTextTest() {
		assertEquals(Input.setText("Rubrik", "underrubrik", " anteckning"), "\nRubrik - underrubrik:  anteckning;");
	}
	
}
