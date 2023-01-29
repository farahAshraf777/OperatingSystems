package prime_numbers;

public class Producer implements Runnable {
	Buffer B;
	int num;
	int numOfPrime;
	int maxPrime;
	public Producer(Buffer B, int num) {
		this.B = B;
		this.num = num;
	}
	public void setnumOfPrime(int numOfPrime) {
		this.numOfPrime = numOfPrime;
	}
	public int getnumOfPrime() {
		return numOfPrime;
	}
	@Override
	public void run() {
		try {
			produceprimenum();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        B.producerFinish();
        
	}
	public void produceprimenum() throws InterruptedException{
		int i = 0;
        int element = 0;
        
       
        for (element = 1; element <= num; element++) {
            int counter = 0;
            for (i = element; i >= 1; i--) {
               
                if (element % i == 0) {
                   
                    counter = counter + 1;
                }
            }
           
            if (counter <= 2) {
            	B.addElement(Integer.toString(element));
            	maxPrime = element;
            	numOfPrime += 1;
            	
            }
            
            
        }
        
        System.out.print(numOfPrime);
	}
	
		
}

