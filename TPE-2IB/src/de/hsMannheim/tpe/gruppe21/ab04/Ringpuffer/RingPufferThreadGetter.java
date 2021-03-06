package de.hsMannheim.tpe.gruppe21.ab04.Ringpuffer;

public class RingPufferThreadGetter extends Thread{
	
	private ThreadRingpuffer ringpuffer;
	private static final long DELAY = 100;
	
	RingPufferThreadGetter(ThreadRingpuffer ringpuffer){
		this.ringpuffer = ringpuffer;
	}
	
	/**
	 * sleeps and gets elements out of the ringbuffer till time is over
	 */
	@Override
	public void run(){
		while(!isInterrupted()){
			try {
				sleep(DELAY);
			} catch (InterruptedException e) {
				System.out.println("Finished "+ this.getName());
				return;
			}
			get();
		}	
		System.out.println("Finished "+ this.getName());
	}
	
	/**
	 * prints a object of ringbuffer in console out
	 */
	public synchronized void get(){
		if(ringpuffer.isEmpty()){
			try {
				wait();
			} catch (InterruptedException e) {return;}
		}
		try {
			int output = (int) ringpuffer.get();
			System.out.println("" + this.getName() + " holte: " + output);
		} catch (InterruptedException e) {get();}
	}
	
	
}
