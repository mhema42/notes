package notes;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class NotesTest {
	
	@Test
	@Order(1)
	void setTextTest() {
		
		String headline = "Rubrik";
		String subHeadline = "underrubrik";
		String notes = "anteckning";
		String path = ".\\test.txt";
		
		assertEquals(Text.textHandler(headline, subHeadline, notes, path), "\nRubrik - underrubrik: anteckning;");
	}
	
	@Test
	@Order(2)
	void fileExistTest() {
		
		File file = new File(".\\test.txt");
		
		assertTrue(file.exists());
		
		if (file.exists()) {
			file.delete();
		}
	}
	
}
