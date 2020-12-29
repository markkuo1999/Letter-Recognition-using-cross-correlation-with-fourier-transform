/*******************************************************************************
class TestContainID
test case 1: ID included
test case 2: ID not included
*******************************************************************************/
package ncu.cs.agile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestContainID {

	@Test
	public void testContainID1() throws IDExceptions3, IOException {
		GradeSystems aGradeSystem = new GradeSystems();
		aGradeSystem.containID("955002056");
	}
	
	@Test (expected = IDExceptions3.class)
	public void testContainID2() throws IDExceptions3, IOException {
		GradeSystems aGradeSystem = new GradeSystems();
		aGradeSystem.containID("955011111");
	}

}
