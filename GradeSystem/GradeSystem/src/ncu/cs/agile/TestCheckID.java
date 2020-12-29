/*****************************************************************************-
class TestCheckID  
test case 1: ID 96z001044 (2打成z)
test case 2: ID 96200104 (遺漏最後的4)
test case 3: ID 962001044 (正確，凌宗廷的ID)
**************************************************************************** */
/*
@Test (expected = IDExceptions1.class)
public testCheckID1() throws IDExceptions1, IDExceptions2 
aUI call checkID(96z001044) 

@Test (expected = IDExceptions2.class)
public testCheckID2() throws IDExceptions1, IDExceptions2
aUI call checkID(96200104)
注意： 上面二cases 丟出異常而無回傳值，故 test code寫法不同。

public testCheckID3() throws IDExceptions1, IDExceptions2
1.	手算 expected result: true
2.	aUI call checkID(962001044) 算actual result
3.	assert equal of the two results   
注意：上面測了 “凌宗廷” 還需測 “李威廷” 嗎? NO! 因二者屬相同狀況，即同一 test case
 */
package ncu.cs.agile;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCheckID {

	public TestCheckID() {
		
	}
	
	@Test (expected = IDExceptions1.class)
	public void testCheckID1() throws IDExceptions1, IDExceptions2{
		UI aUI = new UI();
		aUI.checkID("96z001044");
	}
	
	@Test (expected = IDExceptions2.class)
	public void testCheckID2() throws IDExceptions1, IDExceptions2{
		UI aUI = new UI();
		aUI.checkID("96200104");
	}
	
	@Test
	public void testCheckID3() throws IDExceptions1, IDExceptions2{
		UI aUI = new UI();
		assertEquals (aUI.checkID("962001044"), true);
	}

}
