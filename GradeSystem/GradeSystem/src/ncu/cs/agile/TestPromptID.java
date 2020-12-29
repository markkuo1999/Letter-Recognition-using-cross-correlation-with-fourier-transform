/*******************************************************************************
class TestPromptID
test case 1: 輸入Q
test case 2: 輸入ID
*******************************************************************************/
package ncu.cs.agile;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TestPromptID {

	@Test
	public void testPromptID1() {
		
		ByteArrayInputStream inContent = new ByteArrayInputStream("Q".getBytes());
		System.setIn(inContent);

		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut (new PrintStream (outContent));

		
		UI aUI = new UI();
		String ID = aUI.promptID();  
		/*assertEquals("我 ", outContent.toString());*/
		assertEquals("輸入ID 或 Q(結束使用)? ", outContent.toString());
		assertEquals ("Q", ID);

	}
	
	@Test
	public void testPromptID2() {
		
		ByteArrayInputStream inContent = new ByteArrayInputStream("962001044".getBytes());
		System.setIn(inContent);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut (new PrintStream (outContent));

		UI aUI = new UI();
		String ID = aUI.promptID();  
		/*assertEquals("我 ", outContent.toString());*/
	    assertEquals("輸入ID 或 Q(結束使用)? ", outContent.toString());
		assertEquals ("962001044", ID);

	}

}
