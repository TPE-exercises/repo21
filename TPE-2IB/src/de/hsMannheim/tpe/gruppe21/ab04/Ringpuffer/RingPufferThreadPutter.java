package de.hsMannheim.tpe.gruppe21.ab04.Ringpuffer;

import java.util.Random;

public class RingPufferThreadPutter extends Thread{

	private ThreadRingpuffer ringpuffer;
	private Random generator;
	private static final long DELAY = 5;
	
	RingPufferThreadPutter(ThreadRingpuffer ringpuffer, long seed){
		this.ringpuffer = ringpuffer;
		this.generator = new Random(seed);
	}

	/**
	 * sleeps and puts elements in the ringbuffer till time is over
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
			int input = generator.nextInt();
			put(input);
		}	
		System.out.println("Finished "+ this.getName());
	}
	
	/**
	 * puts the element in the ringbuffer
	 * @param input to input
	 */
	public synchronized void put(int input){
		if(isInterrupted()){
			System.out.println("Interrupted");
		}
		if(ringpuffer.isFull()){
			try {
				wait();
			} catch (InterruptedException e) {return;}
		}
		try {
			ringpuffer.enter(input);
		} catch (OverflowException e) {
			put(input);
		}
		notifyAll();
	}
}