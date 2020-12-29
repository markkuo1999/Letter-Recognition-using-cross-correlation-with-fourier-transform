/*****************************************************************************-
class TestGradeSystems
參閱下面細部設計中 GradeSystems class的設計草圖，測試用minimal input file建構的aGradeSystem object。

/*public  testGradeSystrems1()  /*測試aGradeSystem object凌宗廷的lab1。*/
/*1.	aGradeSystem = new GradeSystems();
2.	assert equality of: 1) 87 and  2) aGradeSystem.aTree.get(“962001044”).lab1*/

/*public  testGradeSystrems2()*/          /*測aGradeSystem object李威廷的lab1。*/
/*1.	aGradeSystem = new GradeSystems();
2.	assert equality of: 1) 81 and  2) aGradeSystem.aTree.(“962001051”).lab1*/
/******************************************************************************/

package ncu.cs.agile;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.TreeMap;

import org.junit.Test;

public class TestGradeSystems {

	@Test
	public void testGradeSystems1() throws IOException {
		GradeSystems aGradeSystem = new GradeSystems();
		
		assertEquals(aGradeSystem.aTree.get("962001044").lab1, 87);
	}
	
	@Test
	public void testGradeSystems2() throws IOException {
		GradeSystems aGradeSystem = new GradeSystems();
		//TreeMap <String, Grades> aTree;
		assertEquals(aGradeSystem.aTree.get("962001051").lab1, 81);
	}

}
