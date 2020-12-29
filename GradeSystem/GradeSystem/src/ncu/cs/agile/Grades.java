/** **********************************************************************
class Grades  aGrade儲存name, lab1, lab2, lab3, midtermExam, finalExam, totalGrade

calculateTotalGrade (weights)
Grades () { } 
************************************************************************/


package ncu.cs.agile;

public class Grades {
	/*String name; int lab1, lab2, lab3, midtermExam, finalExam, totalGrade;
	注意：input file內本來無 totalGrade，多加此欄位，可使某些演算法Big O較快。

	public Grades () { } 
	public calculateTotalGrade(weights)  注意: totalGrade須四捨五入
	end class Grades*/


	/*----------------------------------------------------------------------------------------------------------------------------
	calculateTotalGrade(weights) 
	
	return lab1*weights1+lab2*weights2+......
	----------------------------------------------------------------------------------------------------------------------------*/
	
	/*----------------------------------------------------------------------------------------------------------------------------
	Grades() constructor
	----------------------------------------------------------------------------------------------------------------------------*/
	String name; int lab1, lab2, lab3, midtermExam, finalExam, totalGrade;
	
	public Grades () {} 
	
	public int calculateTotalGrade(double[] weights) {
		return (int) Math.round(lab1*weights[0] + lab2*weights[1] + lab3*weights[2] + midtermExam*weights[3] + finalExam*weights[4]);
	}
	
}
