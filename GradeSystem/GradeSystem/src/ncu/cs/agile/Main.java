/* ##################################################################
A grade system 讓使用者取得他的總成績(total grade)及排名(rank)，
總成績依配分(weights)計算，而配分可更新(update)。

  Input file: 全班學生的分數 例如:
             962001044 凌宗廷 87 86 98 88 87
962001051 李威廷 81 98 84 90 93
           上面各欄位的名稱如下: 
          ID     name lab1 lab2 lab3 midtermExam finalExam
#################################################################### */
package ncu.cs.agile;

import java.io.IOException;

public class Main extends Object{

	public static void main(String[] args) throws IOException {
		
		/*------------------------------------------------------------------------------------------------------
		main()
		Exceptions: IDExceptions1, IDExceptions2, IDExceptions3
		---------------------------------------------------------------------------------------------------------*/
		/*1.call UI() 建構 aUI
		2.call GradeSystems() 建構 aGradeSystem

		3.loop1 until Q (Quit)
		try
		1.	aUI call promptID() to get user ID  輸入ID或 Q (結束使用)?
		2.	aUI call checkID(ID) 看 ID是否有2種異常 (異常1：ID含字母，異常2：ID長度不對)
		3.	aGradeSystem call containID(ID) 看 ID 是否在內(異常3：無此ID)
		4.	aGradeSystem call getName(ID) to get name
		5.	aUI call showWelcomeMsg (name)  ex. Welcome李威廷
		6.	loop2 until E (Exit)
		1.	aUI call promptCommand() to prompt user for a command 
		2.	if command is E (Exit) then break
		else: G aGradeSystem call showGrade(ID), R showRank(ID), W updateWeights() 
		end if
		    end loop2
		end try
		catch (IDExceptions1 e1) {print “這ID含字母 錯了!”}
		catch (IDExceptions2 e2) {print “這ID長度不對 錯了!”}
		catch (IDExceptions3 e3) {print “無這ID 錯了!”}
		 end loop1

		4. aUI call showFinishMsg()  結束了*/

		String ID, name, input;
		UI aUI = new UI();
		GradeSystems aGradeSystem = new GradeSystems();
		while(true) {
			try {
				ID = aUI.promptID();
				if(ID.equals("Q"))
					break;
				else {
					aUI.checkID(ID);
					aGradeSystem.containID(ID);
					name = aGradeSystem.getName(ID);
					aUI.showWelcomeMsg(name);
					while(true) {
						input = aUI.promptCommand();
						if(input.equals("E")) 
							break;
						else if(input.equals("G"))
							aGradeSystem.showGrade(ID);
						else if(input.equals("R"))
							aGradeSystem.showRank(ID);
						else if(input.equals("W"))
							aGradeSystem.updateWeights();
					}
				}
			}catch (IDExceptions1 e1) {
				System.out.println("這ID含字母 錯了!");
				}
			 catch (IDExceptions2 e2) {
				 System.out.println("這ID長度不對 錯了!");
				 }
			 catch (IDExceptions3 e3) {
				 System.out.println("無這ID 錯了!");
				 }
		}
		aUI.showFinishMsg();
		/*注意：checkID(ID) 或 containID(ID) 若發生異常，則不執行正常程式，而是跳至對應的catch()執行後，跳至end loop1，再跳回loop1執行 prompID()。
		此設計可讓 user重新輸入正確的 ID。*/

	}

}
;