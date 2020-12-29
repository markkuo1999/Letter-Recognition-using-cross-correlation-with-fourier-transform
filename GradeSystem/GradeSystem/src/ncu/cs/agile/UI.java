/** ***********************************************************************
class UI (user interface)  aUI處理使用界面

checkID(ID) 
promptCommand()
promptID()
showFinishMsg()
showWelcomeMsg(name)
UI()  建構 aUI
************************************************************************ */


package ncu.cs.agile;

import java.util.Scanner;

public class UI {
	/*----------------------------------------------------------------------------------------------------------
	checkID(ID) throws IDExceptions1, IDExceptions2

	exception: IDExceptions1  print “這ID含字母 錯了!”
	         IDExceptions2  print “這ID長度不對 錯了!”
	return: boolean
	-------------------------------------------------------------------------------------------------------------- */

	/*1.	if a char in ID isLetter then throw an IDExceptions1 object end if
	  2.	if length of ID not equal 9 then throw an IDExceptions2 object end if
      3.	return true*/

	/*-------------------------------------------------------------------------------------------------------------
	promptCommand () 詢問指令

	return: command  G (Grade), R (Rank), W (Weights), or E (Exit)
	-----------------------------------------------------------------------------------------------------------------*/

	/*1.loop 
		prompt user for a command
		until command is G (Grade),R (Rank), W (Weights), or E (Exit),
		2.return command*/

	/*-----------------------------------------------------------------------------------------------------------
	promptID()  詢問ID

	return: ID  
	----------------------------------------------------------------------------------------------------------------*/

	/*1.	print “輸入ID或 Q (結束使用)？”
	  2.	read line, save it as ID
	  3.	return ID
	  注意：promptID() return ID 回傳值要命名為ID 或 IDorQ? 因回傳值絕大部分為ID，只有在最後使用者quit 時，才回傳Q，而method name又有ID，所以回傳值命名為ID。*/

	/*-----------------------------------------------------------------------------------------------------------
	showFinishMsg()  
	
	print("結束了\r\n")
	
	return: boolean  
	----------------------------------------------------------------------------------------------------------------*/
	
	/*-----------------------------------------------------------------------------------------------------------
	showWelcomeMsg(name) 
	
	print("Welcome name\r\n")
	
	return: boolean  
	----------------------------------------------------------------------------------------------------------------*/

	
	public boolean checkID(String ID) throws IDExceptions1, IDExceptions2 {
		int i;
		for(i = 0 ; i < ID.length() ; i ++) {
			if(ID.charAt(i) >= 'a' && ID.charAt(i) <= 'z' || (ID.charAt(i) >= 'A' && ID.charAt(i) <= 'Z')) {
				throw new IDExceptions1();
			}
		}
		if(ID.length() != 9)
			throw new IDExceptions2();
		
		return true;
	}
	
	public String promptCommand() {
	    System.out.print("使用者輸入: ");
		String Command;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			Command = scanner.next();
			if(Command.charAt(0) == 'G' ||  Command.charAt(0) == 'R' || Command.charAt(0) == 'W' ||  Command.charAt(0) == 'E')
				break;
		}	
		System.out.print("\n");
		return Command;
	}
	
	public String promptID() {
		//System.out.print("我 ");
		System.out.print("輸入ID 或 Q(結束使用)? ");
		String ID;
		Scanner scanner = new Scanner(System.in);
		ID = scanner.next();
		return ID;
	}
	
	public boolean showFinishMsg() {
		System.out.print("結束了" + "\r\n");
		return true;
	}
	
	public boolean showWelcomeMsg(String name) {
		System.out.print("Welcome "+ name + "\n");
		System.out.print("輸入指令 1) G 顯示成績 (Grade)\n");
		System.out.print("        2) R 顯示排名 (Rank)\n");
	    System.out.print("        3) W 更新配分 (Weight)\n"); 
	    System.out.print("        4) E 離開選單 (Exit)\n\n");
		return true;
	}
	
	public UI() {
		
	}
}
