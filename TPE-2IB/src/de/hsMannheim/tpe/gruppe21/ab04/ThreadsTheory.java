package de.hsMannheim.tpe.gruppe21.ab04;

public class ThreadsTheory extends Thread{
	
	public static void main(String[] args) {
		ThreadsTheory eins = new ThreadsTheory(1);
		ThreadsTheory zwei = new ThreadsTheory(2);
		ThreadsTheory drei = new ThreadsTheory(3);
		ThreadsTheory vier = new ThreadsTheory(4);
		
		eins.start();
		zwei.start();
		drei.start();
		vier.start();
		
	}
	
	public int i;
	
	public ThreadsTheory(int i){
		this.i = i;
	}
	
	public void run(){
		System.out.println(""+ i + i);
		try {
			this.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished:" + i);		
	}
	
}
