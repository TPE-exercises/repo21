package de.hsMannheim.tpe.gruppe21.ab04.Ringpuffer;

import java.util.Random;

public class RingPufferThreadPutter extends Thread{

	private ThreadRingpuffer ringpuffer;
	private Random generator;
	private long delay = 20;
	
	RingPufferThreadPutter(ThreadRingpuffer ringpuffer, long seed){
		this.ringpuffer = ringpuffer;
		this.generator = new Random(seed);
	}
	
	@Override
	public void run(){
		while(!isInterrupted()){		
			int p = generator.nextInt();
			try {
				sleep(delay);
			} catch (InterruptedException e2) {interrupt();}
			try {
				ringpuffer.put(p);
			} catch (OverflowException e) {
				try {
					sleep(50);
				} catch (InterruptedException e1) {interrupt();}
				this.run();
			}
		}
	}
}
