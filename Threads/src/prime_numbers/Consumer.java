package prime_numbers;


import java.io.FileWriter;
import java.io.IOException;



public class Consumer implements Runnable{
	Buffer B;
	String fileName;
	public Consumer(Buffer B, String fileName) {
		this.B = B;
		this.fileName = fileName;
	}
	@Override
	public void run() {
		try {
			FileWriter f = new FileWriter(fileName);
			while(!B.producer_finish || !B.emptyBuffer()) {
				String str = B.consume();
				f.write(str + ", ");
			}
			f.close();
			
		}
		catch (IOException | InterruptedException e) {}
		
	}
	
	
}
