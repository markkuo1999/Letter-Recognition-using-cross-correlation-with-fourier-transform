/*****************************************************************************-
class TestCalculateTotalGrade
aGrade: name李威廷 lab1 81  lab2 98  lab3 84  midtermExam 90 finalExam 93

test case 1: lab1 0.1  lab2 0.1  lab3 0.1  midtermExam 0.3  finalExam 0.4
test case 2: lab1 0.2  lab2 0.2  lab3 0.2  midTermExam 0.2  finalExam 0.2
test case 3: lab1 0.1  lab2 0.1  lab3 0.0  midtermExam 0.4  finalExam 0.4
**************************************************************************** */
/*
public testCalculateTotalGrade1() 
	1.	手算 expected result (81*0.1+98*0.1+84*0.1+90*0.3+93*0.4=90.5四捨五入91)
	2.	aGrade call calculateTotalGrade (weights) 算actual result
	3.	assert equal of the two results 

public testCalculateTotalGrade2() 
	1.	手算 expected result (81*0.2+98*0.2+84*0.2+90*0.2+93*0.2四捨五入89)
	2.	aGrade call calculateTotalGrade (weights) 算actual result
	3.	assert equal of the two results

public testCalculateTotalGrade3()  { … …}
	// end of class TestCalculateTotalGrade
*/
package ncu.cs.agile;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalculateTotalGrade {
	
	public TestCalculateTotalGrade() {
		
	}		

	@Test
	public void testCalculateTotalGrade1(){
		Grades aGrade = new Grades();
		double[] weights = {0.1, 0.1, 0.1, 0.3, 0.4};
		aGrade.name = "李威廷";
		aGrade.lab1 = 81;
		aGrade.lab2 = 98;
		aGrade.lab3 = 84;
		aGrade.midtermExam = 90;
		aGrade.finalExam = 93;
		assertEquals(aGrade.calculateTotalGrade(weights), 91);
	}
	
	@Test
	public void testCalculateTotalGrade2(){
		Grades aGrade = new Grades();
		double[] weights = {0.2, 0.2, 0.2, 0.2, 0.2};
		aGrade.name = "李威廷";
		aGrade.lab1 = 81;
		aGrade.lab2 = 98;
		aGrade.lab3 = 84;
		aGrade.midtermExam = 90;
		aGrade.finalExam = 93;
		assertEquals(aGrade.calculateTotalGrade(weights), 89);
	}
	
	@Test
	public void testCalculateTotalGrade3(){
		Grades aGrade = new Grades();
		double[] weights = {0.1, 0.1, 0.2, 0.2, 0.4};
		aGrade.name = "李威廷";
		aGrade.lab1 = 81;
		aGrade.lab2 = 98;
		aGrade.lab3 = 84;
		aGrade.midtermExam = 90;
		aGrade.finalExam = 93;
		assertEquals(aGrade.calculateTotalGrade(weights), 90);
	}

}
