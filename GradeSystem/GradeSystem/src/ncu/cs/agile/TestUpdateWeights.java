/*************************************************************************
class TestUpdatesWeights
assert updateWeights() equals true
*************************************************************************/
package ncu.cs.agile;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class TestUpdateWeights {

	@Test
	public void testupdateWeights1() throws IOException {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut (new PrintStream (outContent));
		
		ByteArrayInputStream inContent = new ByteArrayInputStream("Y".getBytes());
		System.setIn(inContent);
	
		assertEquals ("Y", inContent);
		assertEquals("以上正確嗎? Y (Yes) 或 N (No)\n", outContent.toString());
	}

}
