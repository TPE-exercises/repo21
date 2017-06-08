package de.hsMannheim.tpe.gruppe21.ab04.Ringpuffer;

public class TimerThread extends Thread{

	private long delay;
	public boolean interuptAll = false;
	
	TimerThread(long delay){
		this.delay = delay;
	}
	
	@Override
	public void run(){
		try {
			sleep(delay);
		} catch (InterruptedException e) {e.printStackTrace();}
		interuptAll = true;
	}
	
}
