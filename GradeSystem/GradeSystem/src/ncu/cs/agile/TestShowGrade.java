/**************************************************************
class TestShowGrade
test case 1: assert 凌宗廷 total grade equals 90
test case 2: assert 李威廷 total grade equals 89
**************************************************************/
package ncu.cs.agile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestShowGrade {

	@Test
	public void testshowGrade1() throws IOException {
		GradeSystems aGradeSystem = new GradeSystems();
		assertEquals (aGradeSystem.showGrade("962001044"), 88);
	}
	
	@Test
	public void testshowGrade2() throws IOException {
		GradeSystems aGradeSystem = new GradeSystems();
		assertEquals (aGradeSystem.showGrade("962001051"), 91);
	}

}
