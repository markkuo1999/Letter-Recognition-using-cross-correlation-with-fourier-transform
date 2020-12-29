/*******************************************************************************
class TestGetName
test case 1: ID 許文馨
test case 2: ID 凌宗廷
*******************************************************************************/
package ncu.cs.agile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestGetName {

	@Test
	public void testgetName1() throws IOException {
		GradeSystems aGradeSystem = new GradeSystems();
		String name = aGradeSystem.getName("955002056");
		assertEquals("許文馨", name);
	}
	
	@Test
	public void testgetName2() throws IOException {
		GradeSystems aGradeSystem = new GradeSystems();
		String name = aGradeSystem.getName("962001044");
		assertEquals("凌宗廷", name);
	}

}
