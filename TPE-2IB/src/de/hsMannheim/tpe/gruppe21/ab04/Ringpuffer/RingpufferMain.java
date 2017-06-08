package de.hsMannheim.tpe.gruppe21.ab04.Ringpuffer;

public class RingpufferMain {

	public static void main(String[] args) throws InterruptedException {
		TimerThread timer = new TimerThread(5000);
		
		ThreadRingpuffer ringpuffer = new ThreadRingpuffer(20);
		
		RingPufferThreadPutter erzeugerEins = new RingPufferThreadPutter(ringpuffer,1000);
		RingPufferThreadPutter erzeugerZwei = new RingPufferThreadPutter(ringpuffer,3000);
		RingPufferThreadPutter erzeugerDrei = new RingPufferThreadPutter(ringpuffer,5000);
	
		RingPufferThreadGetter verbraucherEins = new RingPufferThreadGetter(ringpuffer);
		RingPufferThreadGetter verbraucherZwei = new RingPufferThreadGetter(ringpuffer);	
		
		timer.start();
		erzeugerEins.start();
		erzeugerZwei.start();
		erzeugerDrei.start();
		verbraucherEins.start();
		verbraucherZwei.start();
		
		timer.join();
		
		if(timer.interuptAll){
			erzeugerEins.interrupt();
			erzeugerZwei.interrupt();
			erzeugerDrei.interrupt();
			verbraucherEins.interrupt();
			verbraucherZwei.interrupt();
		}		
	}

}
