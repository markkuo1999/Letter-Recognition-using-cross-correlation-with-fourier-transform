/** ***************************************************
class GradeSystems  aGradeSystem儲存a tree of anEntry objects with key ID and value aGrade

containID (ID)  //看aGradeSystem有否含此ID
getName(ID)   //取得ID的name
GradeSystems () //建構 aGradeSystem
showGrade (ID)
showRank (ID)
updateWeights ()   
********************************************************/

package ncu.cs.agile;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class GradeSystems {
	/*
	double[5] weights;  //初始值 lab1 0.1, lab2 0.1, lab3 0.1, midTerm 0.3, finalExam 0.4
	//注意weights 之和須等於1.0

	TreeMap <String, Grades> aTree; 

	//String is the KEY (ID) class; Grades is the VALUE class
	/*用TreeMap class的object叫aTree來儲存anEntry objects. 它對應 KEY (ID) 到 VALUE (aGrade object)，見下面設計草圖*/

	/*  1. 開檔 input file “gradeInput.txt”
		2. 用Java TreeMap建構a tree of anEntry(key, value) objects叫 aTree
		3. read line
		4. while not endOfFile
		1. call Grades() 建構aGrade
		2. call Entry()  建構 anEntry
		3. 用Java Scanner scan line,ID存key 其餘存aGrade(value) (key,value)即anEntry
		4. aGrade call calculateTotalGrade(weights) return aTotalGrade把它存入aGrade
		5. 把 anEntry 存入 aTree
     	end while*/
	/*-------------------------------------------------------------------------------------------------------------
	containID(ID)  看aGradeSystem是否含此ID

	parameter: ID   a user ID  ex: 123456789
	exception: IDExceptions3   print “無這ID 錯了!”
	return: boolean
	time:  O(log n)  n is aGradeSystem 內全班人數

	-----------------------------------------------------------------------------------------------------------------*/
	/*1.for anEntry in aTree 
		 	if ID等於 ID of anEntry then return true 
		 	end if 
		  	end for 
	  2.throw an IDExceptions3 object*/
	/*----------------------------------------------------------------------------------------------------------------------------
	showGrade(ID)  show 此 ID 的 total grade 
	----------------------------------------------------------------------------------------------------------------------------*/
	/*
	  for anEntry in aTree
  	  if ID等於 ID of anEntry then return totalGrade 
  	  end if 
	  end for*/
	/*----------------------------------------------------------------------------------------------------------------------------
	showRank(ID)  show 此 ID的 rank
	----------------------------------------------------------------------------------------------------------------------------*/
	/*1. 取得這 ID 的 theTotalGrade
	  2. 令rank 為 1 
	  3. for anEntry in aTree 
			  if aTotalGrade > theTotalGrade then rank加1(退1名) end if 
			  end for
	  4. return rank
	  
	註：showGrade(ID) showRank(ID) 也可放在UI class，那將是另一種設計，軟體設計無唯一，
	但你是初次學習，所以請遵”守”此設計 (記得”守破離”?)。
	/*----------------------------------------------------------------------------------------------------------------------------
	updateWeights () 更新weights
	return boolean
	----------------------------------------------------------------------------------------------------------------------------*/
	/*1. showOldWeights() //注意：此三個為private methods，故不需做 test code
	  2. getNewWeights() 
	  3. setWeights(weights)
	  4. for anEntry in aGradeSystem calculateTotalGrade(weights) & save it end for
	  5. return true
	  end class GradeSystems*/

	/*-----------------------------------------------------------------------------------------------------------------------------
	getName(ID) 取得該ID的同學姓名 
	-----------------------------------------------------------------------------------------------------------------------------*/
	/*   for anEntry in aTree
	   		if ID等於 ID of anEntry then return name
	   		end if
	   	 end for
	*/
	double[] weights = {0.1, 0.1, 0.1, 0.3, 0.4};
	TreeMap <String, Grades> aTree;
	public GradeSystems() throws IOException {
		String pathname = "./gradeinput.txt";
		/*TreeMap <String, Grades> aTree = null;*/
		aTree = new TreeMap<String, Grades>();
		File filename = new File(pathname);	
		InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
		BufferedReader br = new BufferedReader(reader); 
		String line = "";
		line = br.readLine();
		while (line != null) {
			Grades aGrade = new Grades();
			Set<Map.Entry<String, Grades>> anEntry = aTree.entrySet();
			//Entry<String, Grades> anEntry = new Entry<>();
			String[] token = line.split("\\s+");
			aGrade.name = token[1];
			//System.out.println(token[1]);
			aGrade.lab1 = Integer.parseInt(token[2]);
			aGrade.lab2 = Integer.parseInt(token[3]);
			aGrade.lab3 = Integer.parseInt(token[4]);
			aGrade.midtermExam = Integer.parseInt(token[5]);
			aGrade.finalExam = Integer.parseInt(token[6]);
			aGrade.totalGrade = aGrade.calculateTotalGrade(weights);
			aTree.put(token[0], aGrade);
			line = br.readLine(); 
		}
	}
	
	
	
	public boolean containID(String ID) throws IDExceptions3 {
		Set<Map.Entry<String, Grades>> anEntry = aTree.entrySet(); 
		for (Map.Entry<String, Grades> it: anEntry) {
			//System.out.println(it.getKey() + "\n");
			if(ID.equals(it.getKey()))
				return true;
		}
			
		
		throw new IDExceptions3();
	}
	
	public String getName(String ID) {
		Set<Map.Entry<String, Grades>> anEntry = aTree.entrySet(); 
		for (Map.Entry<String, Grades> it: anEntry) {
			//System.out.println(it.getValue().name);
			if(ID.equals(it.getKey()))
				return it.getValue().name;
		} 
					
		return ID;
	}
		
	public int showGrade(String ID) {
		Set<Map.Entry<String, Grades>> anEntry = aTree.entrySet(); 
		for (Map.Entry<String, Grades> it: anEntry) {
			if(ID.equals(it.getKey())) {
				//it.getValue().totalGrade = it.getValue().calculateTotalGrade(weights[0], weights[1], weights[2], weights[3], weights[4]);
				System.out.println(it.getValue().name + " 成績:lab1:           " + it.getValue().lab1);
				System.out.println("           lab2:           " + it.getValue().lab2);
				System.out.println("           lab3:           " + it.getValue().lab3);
				System.out.println("           midterm exam:   " + it.getValue().midtermExam);
				System.out.println("           final exam:     " + it.getValue().finalExam);
				System.out.println("           total grade:    " + it.getValue().totalGrade);
				System.out.print("\n");
				return it.getValue().totalGrade;
			}
				
		}
				
		return 0;
		
	}
	
	public int showRank(String ID) {
		int TotalGrade = aTree.get(ID).totalGrade, rank = 1;
		
		Set<Map.Entry<String, Grades>> anEntry = aTree.entrySet(); 
		for (Map.Entry<String, Grades> it: anEntry) 
			if(it.getValue().totalGrade > TotalGrade) 
				rank ++;
	    System.out.println(aTree.get(ID).name + "排名第" + rank);
	    System.out.print("\n");
		return rank;
	}
	
	public boolean updateWeights() throws IDExceptions1 {
		String confirm = null;
		int i;
		double[] oldweights = new double[5];
		for(i = 0 ; i < 5 ; i ++)
			oldweights[i] = weights[i];
		boolean check = false;
		showOldWeights();
		while(check == false) {
			getNewWeights();
			setWeights(weights);
			Scanner scanner = new Scanner(System.in);
			System.out.print("以上正確嗎? Y (Yes) 或 N (No)\n");
			System.out.print("使用者輸入: ");
			confirm = scanner.next();
			while(!confirm.equals("Y") && !confirm.equals("N")) {
				confirm = scanner.next();
			}
			if(confirm.equals("Y"))
				check = true;
			else
				for(i = 0 ; i < 5 ; i ++)
					weights[i] = oldweights[i];
		}
		
		Set<Map.Entry<String, Grades>> anEntry = aTree.entrySet(); 
		for (Map.Entry<String, Grades> it: anEntry)
			it.getValue().totalGrade = it.getValue().calculateTotalGrade(weights);
		
		System.out.print("\n");
		return true;
	}
	
	private void showOldWeights() {
		System.out.println("舊配分");
		System.out.println("lab1           " + (int)(weights[0]*100)+ "%");
		System.out.println("lab2           " + (int)(weights[1]*100)+ "%");
		System.out.println("lab3           " + (int)(weights[2]*100)+ "%");
		System.out.println("midterm exam   " + (int)(weights[3]*100)+ "%");
		System.out.println("final exam     " + (int)(weights[4]*100)+ "%");
	}
	
	private void getNewWeights() {
		int i;
		boolean check = false;
		Scanner scanner = new Scanner(System.in);
		String grade;
		do {
			check = false;
			System.out.println("輸入新配分");
			System.out.print("lab1           ");
			grade = scanner.next();
			for(i = 0 ; i < grade.length() ; i ++) 
				if(grade.charAt(i) >= 'a' && grade.charAt(i) <= 'z' || (grade.charAt(i) >= 'A' && grade.charAt(i) <= 'Z')) {
					System.out.println("這分數含字母 錯了!");
					check = true;
					break;
				}		
			if(check == true)
				continue;
			weights[0] = Double.parseDouble(grade);
			//System.out.print("\n");
			System.out.print("lab2           ");
			grade = scanner.next();
			for(i = 0 ; i < grade.length() ; i ++) 
				if(grade.charAt(i) >= 'a' && grade.charAt(i) <= 'z' || (grade.charAt(i) >= 'A' && grade.charAt(i) <= 'Z')) {
					System.out.println("這分數含字母 錯了!");
					check = true;
					break;
				}	
			if(check == true)
				continue;
			weights[1] = Double.parseDouble(grade);
			//System.out.print("\n");
			System.out.print("lab3           ");
			grade = scanner.next();
			for(i = 0 ; i < grade.length() ; i ++) 
				if(grade.charAt(i) >= 'a' && grade.charAt(i) <= 'z' || (grade.charAt(i) >= 'A' && grade.charAt(i) <= 'Z')) {
					System.out.println("這分數含字母 錯了!");
					check = true;
					break;
				}	
			if(check == true)
				continue;
			weights[2] = Double.parseDouble(grade);
			//System.out.print("\n");
			System.out.print("midterm exam   ");
			grade = scanner.next();
			for(i = 0 ; i < grade.length() ; i ++) 
				if(grade.charAt(i) >= 'a' && grade.charAt(i) <= 'z' || (grade.charAt(i) >= 'A' && grade.charAt(i) <= 'Z')) {
					System.out.println("這分數含字母 錯了!");
					check = true;
					break;
				}	
			if(check == true)
				continue;
			weights[3] = Double.parseDouble(grade);
			//System.out.print("\n");
			System.out.print("final exam     ");
			grade = scanner.next();
			for(i = 0 ; i < grade.length() ; i ++) 
				if(grade.charAt(i) >= 'a' && grade.charAt(i) <= 'z' || (grade.charAt(i) >= 'A' && grade.charAt(i) <= 'Z')) {
					System.out.println("這分數含字母 錯了!");
					check = true;
					break;
				}	
			if(check == true)
				continue;
			weights[4] = Double.parseDouble(grade);
			//System.out.print("\n");
		}while(check == true);
		
	}
	
	private void setWeights(double[] weights) {
		weights[0] *= 0.01;
		weights[1] *= 0.01;
		weights[2] *= 0.01;
		weights[3] *= 0.01;
		weights[4] *= 0.01;
		System.out.println("請確認新配分");
		System.out.println("lab1           " + (int)(weights[0]*100)+ "%");
		System.out.println("lab2           " + (int)(weights[1]*100)+ "%");
		System.out.println("lab3           " + (int)(weights[2]*100)+ "%");
		System.out.println("midterm exam   " + (int)(weights[3]*100)+ "%");
		System.out.println("final exam     " + (int)(weights[4]*100)+ "%");
	}
}
	