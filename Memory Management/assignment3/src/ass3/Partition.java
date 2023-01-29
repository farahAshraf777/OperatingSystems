package ass3;
import java.util.*;
public class Partition {

	String Partname;
	int Partsize;
	List<Partition> partitions = new ArrayList<> (); 
	public List<Partition> getpartitions() {
		return partitions;
	}
	public String getPartname() {
		return Partname;
	}
	public void setPartname(String partname) {
		Partname = partname;
	}
	public int getPartsize() {
		return Partsize;
	}
	public void setPartsize(int partsize) {
		Partsize = partsize;
	}
	public void Partitionlist() {
		Scanner s=new Scanner(System.in);
		int num_of_part;
		System.out.println("Enter number of partition: ");
		num_of_part=s.nextInt();
		for(int i=0;i<num_of_part;i++) {
			System.out.println("Enter number of partition: ");
			String Partname=s.nextLine();
			Partname=s.nextLine();
			int Partsize=s.nextInt();
			Partition p =new Partition();
			p.setPartname(Partname);
			p.setPartsize(Partsize);
			partitions.add(i,p);
		}
	}
	
	
}
