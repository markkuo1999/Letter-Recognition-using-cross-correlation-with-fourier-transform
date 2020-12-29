/*********************************************************************
class TestshowFinishMsg
test ending message
*********************************************************************/
package ncu.cs.agile;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class TestshowFinishMsg {
	
	@Test
	public void testshowFinishMsg() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut (new PrintStream (outContent));
		
		UI aUI = new UI();
		Boolean b = aUI.showFinishMsg();
		assertEquals("結束了\r\n", outContent.toString());
		assertEquals(true, b);
	}

	

}
