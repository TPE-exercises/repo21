package de.hsMannheim.tpe.gruppe21.ab04.Ringpuffer;

public class RingPufferThreadGetter extends Thread{
	
	private ThreadRingpuffer ringpuffer;
	private long delay = 30;
	
	RingPufferThreadGetter(ThreadRingpuffer ringpuffer){
		this.ringpuffer = ringpuffer;
	}
	
	@Override
	public void run(){
		while(!isInterrupted()){		
			try {
				sleep(delay);
			} catch (InterruptedException e2) {interrupt();}
			try {
				if(!ringpuffer.isEmpty()){
					int element = (int)ringpuffer.get();
					System.out.println("ActualNumber: " + element);
				}	
				else{
					throw new UnderflowException("");
				}
			} catch (UnderflowException e) {
				try {
					sleep(50);
				} catch (InterruptedException e1) {interrupt();}
				this.run();
			}
		}
	}
}
