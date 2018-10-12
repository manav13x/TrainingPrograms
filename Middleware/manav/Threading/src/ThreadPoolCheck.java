import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;


class MThread implements Runnable{
	String name;
	MThread(String name)
	{
		this.name = name;
	}
	public void run(){
		System.out.println(this.name);
		try{
			Thread.sleep(3000);
		}catch(Exception e)
		{
			
		}
		System.out.println(this.name+"end");
	}
}
public class ThreadPoolCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	ExecutorService exe = Executors.newFixedThreadPool(5);
	//thread pool can hold  more than 5 thread but max 5 will be in running state
	
	for(int i=1;i<=10;i++){
		Runnable thread = new MThread("Thread-"+i);
		exe.execute(thread);
	}
	exe.shutdown();
	while(!exe.isTerminated());
		System.out.println("end");
	}
}
