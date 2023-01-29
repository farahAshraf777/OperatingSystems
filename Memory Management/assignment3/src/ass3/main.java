package ass3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		int choice=0;
		int compaction=0;
		Scanner num = new Scanner(System.in);	
		Partition part;
		process p;
		
		while(choice != 4) {
			System.out.println("Enter your choice: ");
			System.out.println("1. First Fit");
			System.out.println("2. Worst Fit");
			System.out.println("3. Best Fit");
			System.out.println("4. Exit");
			choice = num.nextInt();
			
			part=new Partition();
			p=new process();
			part.Partitionlist();
			p.processlist();
			policy pp=new policy(part,p);
			
			if(choice == 1) {
				pp.FirstFit();
			}else if(choice == 2) {
				pp.Worst();
			}
			else if(choice == 3) {
				pp.BestFit();
			}
			else if(choice == 4) {
				System.out.println("Exit");
				break;
			}
			System.out.println();
			System.out.println("Do you want to compact? ");
			System.out.print("1. yes");
			System.out.println(" 2. no");
			Scanner num2 = new Scanner(System.in);
			compaction = num2.nextInt();
			
			if(compaction == 1) {
				pp.Compaction();
			}
			System.out.println();
			
		}

	}

}