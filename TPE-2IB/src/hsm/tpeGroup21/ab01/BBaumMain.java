package hsm.tpeGroup21.ab01;
import static gdi.MakeItSimple.*;

public class BBaumMain {

	public static void main(String[] args) {
		BBaum[] bt = new BTree[3];
		int[] ordnung = new int[3];
		println("Ordnung des ersten BBaum: ");
		ordnung[0]=readInt();
		println("Ordnung des zweiten BBaum: ");
		ordnung[1]=readInt();
		println("Ordnung des dritten BBaum: ");
		ordnung[2]=readInt();
		
		for(int i = 0; i<bt.length; i++){
			bt[i] = new BTree(ordnung[i]);
		}
		int wn = 0;
		int inp = 0;
		String inpstr;
		boolean goOn = true;
		while(goOn){
			println("-------------------------");
			println("|Working Tree: " + wn + "\t" + "|");
			printMainMenu();
			int input = readInt();
			switch(input){
				case(0): 
					print("Number to insert: ");
					break; //insert number
				
				case(20): 
					do{
						println("Change to: ");
						inp = readInt();
					}
					while(inp<0 || inp>=3);
					wn = inp;
					break; //change wn
				case(50): 
					goOn = false;
					println("Stoped");
					break; //stop
			
			}	
		}
	}
	
	public static void printMainMenu(){
		println("|Das ist ein tolles Menü|");
		println("|0:  insert number      |");
		println("|20: change wl to:      |");
		println("|50: STOP               |");
		print("|???Watcha gonna do???: ");
	}

}
