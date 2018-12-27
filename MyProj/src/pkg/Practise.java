package pkg;

public class Practise {

	public static void main(String[] args) {
		Thr thr = new Thr();
		thr.start();		
		try {
			synchronized (thr) {
				thr.wait(10000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}			
		Runnable rc2 = () -> {System.out.println("This is a print");};
		System.out.println("Waiting");
		new Thread(rc2).start();
	}
	
}
class Thr extends Thread{
	
	@Override
	public void run() {
		System.out.println("start in thread");
		long count =0L;
		while(count<9990453574452L){
			System.out.println(1);
			count++;
		}
		System.out.println("End in thread");		
	}
}

class Thr1 implements Runnable{

	@Override
	public void run() {
			System.out.println("Runn 222");		
	}
	
}
