package ass3;

import java.util.ArrayList;
import java.util.List;

public class policy {
	Partition partition;
	process proce;
	// allocated process and external fragmentation
	List<String> AllocatedSeq = new ArrayList<> ();
	List<process> notAllocated = new ArrayList<> ();
	
	public  policy(Partition partition,process proce) {
		this.partition=partition;
		this.proce=proce;
		for(int i=0;i<((partition.getpartitions()).size());i++) {
			AllocatedSeq.add(i," ");
		
		}

	}
	public void Worst() {
		int p=0,index=0;
		int size1=0;
		while(size1<(proce.getprocesses()).size()) {
			int max=-1;
			for(int i=0;i<((partition.getpartitions()).size());i++){
				p=((partition.getpartitions()).get(i).getPartsize());
				if(p>max) {
					max=p;
					index=i;
				}
			}
			if(max>=(proce.getprocesses().get(size1)).getPsize()) {
				Partition o =new Partition();
				o.setPartname("Partition"+((partition.getpartitions()).size()));
				o.setPartsize(Math.abs(max-(proce.getprocesses().get(size1)).getPsize()));
				(partition.getpartitions()).add(index+1,o);
				(partition.getpartitions()).get(index).setPartsize((proce.getprocesses().get(size1)).getPsize());
				AllocatedSeq.add(index,((proce.getprocesses().get(size1)).getPname()));
			}
			else {
				notAllocated.add(proce.getprocesses().get(size1));
			}
			size1+=1;
		}
		for(int i=0;i<((partition.getpartitions()).size());i++) {
			if((AllocatedSeq.get(i)) == " ") {
				AllocatedSeq.set(i,"External fregmntation");
			}
		}
		for(int i=0;i<((partition.getpartitions()).size());i++) {
			System.out.print(((partition.getpartitions()).get(i).getPartname()+" "+((partition.getpartitions()).get(i).getPartsize())));
			System.out.println("\t"+"=> "+AllocatedSeq.get(i));

		}
		for(int i=0;i<(notAllocated.size());i++) {
			System.out.println(notAllocated.get(i).getPname() + " can not be allocated");
		}
	}
	
	public void BestFit() {
		int  proSize=0, parSize=0,index=0;
		int size1=0;
		while(size1<(proce.getprocesses()).size()) {
			int min=1000;
			for(int i=0;i<((partition.getpartitions()).size());i++){
				parSize = ((partition.getpartitions()).get(i).getPartsize());
				proSize = (proce.getprocesses().get(size1).getPsize());
				if(parSize<=min && parSize>=proSize) {
					min=parSize;
					index=i;
				}
			}
			if(min>=(proce.getprocesses().get(size1)).getPsize()) {
				
//				if (min!=(proce.getprocesses().get(size1)).getPsize()) {
					Partition o =new Partition();
					o.setPartname("Partition"+((partition.getpartitions()).size()));
					o.setPartsize(Math.abs(min-(proce.getprocesses().get(size1)).getPsize()));
					(partition.getpartitions()).add(index+1,o);
//				}
				(partition.getpartitions()).get(index).setPartsize((proce.getprocesses().get(size1)).getPsize());
				AllocatedSeq.add(index,((proce.getprocesses().get(size1)).getPname()));
				
			}
			else {
				notAllocated.add(proce.getprocesses().get(size1));
			}
			size1+=1;
		}
		for(int i=0;i<((partition.getpartitions()).size());i++) {
			if((AllocatedSeq.get(i)) == " ") {
				AllocatedSeq.set(i,"External fregmntation");
			}
		}
		for(int i=0;i<((partition.getpartitions()).size());i++) {
			System.out.print(((partition.getpartitions()).get(i).getPartname()+" "+((partition.getpartitions()).get(i).getPartsize())));
			System.out.println("\t"+"=> "+AllocatedSeq.get(i));

		}
		for(int i=0;i<(notAllocated.size());i++) {
			System.out.println(notAllocated.get(i).getPname() + " can not be allocated");
		}
	}
	
	public void FirstFit() {
		int size1=0, proSize=0, parSize=0, index=0;
		while(size1 < (proce.getprocesses()).size()) {
			for(int i=0;i<((partition.getpartitions()).size());i++) {
				parSize = ((partition.getpartitions()).get(i).getPartsize());
				proSize = (proce.getprocesses().get(size1).getPsize());
				if(parSize >= proSize) {
					index = i;
					break;
				}
			}
			if(parSize >= proSize) {
				Partition o =new Partition();
				o.setPartname("Partition"+((partition.getpartitions()).size()));
				o.setPartsize(Math.abs(parSize-(proce.getprocesses().get(size1)).getPsize()));
				(partition.getpartitions()).add(index+1,o);
				(partition.getpartitions()).get(index).setPartsize((proce.getprocesses().get(size1)).getPsize());
				AllocatedSeq.add(index,((proce.getprocesses().get(size1)).getPname()));
			}
			else {
				notAllocated.add(proce.getprocesses().get(size1));
			}
			size1+=1;
		}
		for(int i=0;i<((partition.getpartitions()).size());i++) {
			if((AllocatedSeq.get(i)) == " ") {
				AllocatedSeq.set(i,"External fregmntation");
			}
		}
		for(int i=0;i<((partition.getpartitions()).size());i++) {
			System.out.print(((partition.getpartitions()).get(i).getPartname()+" "+((partition.getpartitions()).get(i).getPartsize())));
			System.out.println("\t"+"=> "+AllocatedSeq.get(i));

		}
		for(int i=0;i<(notAllocated.size());i++) {
			System.out.println(notAllocated.get(i).getPname() + " can not be allocated");
		}
	}
	public void Compaction() {

		Partition o =new Partition();
		int Partition  = 0;
		int PartitionNum = (partition.getpartitions()).size();
		int i =0 ;
		while(i<((partition.getpartitions()).size())){
			if((AllocatedSeq.get(i)) == "External fregmntation") {
				Partition += ((partition.getpartitions()).get(i).getPartsize());
				(partition.getpartitions()).remove(i);
				AllocatedSeq.remove(i);
			}
			else {
				i+=1 ;
			}
			
			
		}
	    
	    for(int k=0 ; k<notAllocated.size();k++) {
	    	Partition p =new Partition();
	    	if((notAllocated.get(k).getPsize())<= Partition) {
	    		AllocatedSeq.add(notAllocated.get(k).getPname());
				p.setPartname("Partition"+PartitionNum);
				p.setPartsize(notAllocated.get(k).getPsize());
				(partition.getpartitions()).add(p);
				PartitionNum+=1 ;
				Partition-=notAllocated.get(k).getPsize();
	         }

	    }
	    if(Partition!=0) {
	    	AllocatedSeq.add("External fregmntation");
			o.setPartname("Partition"+PartitionNum);
			o.setPartsize(Partition);
			(partition.getpartitions()).add(o);
		}
	    
	    
	    System.out.println();
		for(int j=0;j<((partition.getpartitions()).size());j++) {
			System.out.print(((partition.getpartitions()).get(j).getPartname()+" "+((partition.getpartitions()).get(j).getPartsize())));
			System.out.println("\t"+"=> "+AllocatedSeq.get(j));

		}
		

		
	}

}