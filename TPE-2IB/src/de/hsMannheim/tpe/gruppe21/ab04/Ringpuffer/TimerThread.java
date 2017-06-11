package de.hsMannheim.tpe.gruppe21.ab04.Ringpuffer;

public class TimerThread extends Thread{

	private static final long TIMEDELAY = 2000;
	public boolean interuptAll = false;
	
	@Override
	public void run(){
		try {
			sleep(TIMEDELAY);
		} catch (InterruptedException e) {return;}
		interuptAll = true;
		System.out.println("Zeit ist um");
	}
	
}
