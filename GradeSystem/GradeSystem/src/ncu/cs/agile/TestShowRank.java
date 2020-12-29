/****************************************************************************
class TestShowRank
aGradeSystem 僅含凌宗廷及李威廷

test case 1: assert 凌宗廷 rank equals 2	
test case 2: assert 李威廷 rank equals 1
***************************************************************************/
package ncu.cs.agile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestShowRank {

	@Test
	public void testshowRank1() throws IOException {
		GradeSystems aGradeSystem = new GradeSystems();
		assertEquals (aGradeSystem.showRank("962001044"), 38);
	}
	
	@Test
	public void testshowRank2() throws IOException {
		GradeSystems aGradeSystem = new GradeSystems();
		assertEquals (aGradeSystem.showRank("985002515"), 1);
	}

}
