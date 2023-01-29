package ass3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class process {

	String Pname ;
	int Psize;
	List<process> processes = new ArrayList<> (); 
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public int getPsize() {
		return Psize;
	}
	public void setPsize(int psize) {
		Psize = psize;
	}
	public List<process> getprocesses() {
		return processes;
	}
	public void processlist(){
		Scanner s=new Scanner(System.in);
		int num_of_proce;
		System.out.println("Enter number of processes: ");
		num_of_proce=s.nextInt();
		for(int i=0;i<num_of_proce;i++) {
			System.out.println("Process name and its size: ");
			String procname=s.nextLine();
			procname=s.nextLine();
			int procsize=s.nextInt();
			process process =new process();
			process.setPname(procname);
			process.setPsize(procsize);
			processes.add(i,process);
		}
	}
}
