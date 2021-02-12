package test;

import java.util.Scanner;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class task{
	String str;
	public task(String str) {
		this.str=str;
	}
}


class RunThread implements Runnable{

	Exchanger<task> exchange;
	public RunThread(Exchanger<task> exchange) {
		this.exchange=exchange;
	}
	@Override
	public void run() {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter data to exchange");
			String str="-1",str1="2";
			while(!str.equals(str1)) {
			System.out.println("-----");
			str1=sc.next();
			task taskDetail=exchange.exchange(new task(str),10,TimeUnit.SECONDS);
			System.out.println("task"+taskDetail.str+Thread.currentThread().getName());
			System.out.println(str+"    "+str1);
			}
			//Thread.sleep(5);
		} catch (InterruptedException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class xyz {
	
	
   public static void main(String[] args) {
	   Exchanger<task> exchange=new Exchanger<task>(); 
	Thread t=new Thread(new RunThread(exchange));
	Thread t1=new Thread(new RunThread(exchange));
	 t.start();
	 t1.start();
   
   }

}
