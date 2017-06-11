package de.hsMannheim.tpe.gruppe21.ab04.Ringpuffer;

public class TimerThread extends Thread{

	private static final long TIMEDELAY = 2000;
	public boolean interruptAll = false;
	
	/**
	 * sleeps the delay, then interrupts all
	 */
	@Override
	public void run(){
		try {
			sleep(TIMEDELAY);
		} catch (InterruptedException e) {return;}
		interruptAll = true;
		System.out.println("Zeit ist um");
	}
	
}
