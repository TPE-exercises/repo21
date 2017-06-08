package de.hsMannheim.tpe.gruppe21.ab04.ThreadsTheory;

public class LivenessHazard extends Thread{
	
	public static final boolean FIRSTTHREAD = true;
	public static final boolean SECONDTHREAD = false;
	
	public static void main(String[] args) throws InterruptedException {
		LivenessHazard ersterThread = new LivenessHazard(FIRSTTHREAD);
		LivenessHazard zweiterThread = new LivenessHazard(SECONDTHREAD);
		ersterThread.start();
		zweiterThread.start();
		
		ersterThread.join();
		zweiterThread.join();
	}
	
	
	/*
	2. Liveness	Hazards	
	
	*/
	
	public static boolean firstIsDone = false;
	public static boolean secondIsDone = false;
	
	
	public boolean whichThread;
	
	LivenessHazard(boolean whichThread){
		this.whichThread= whichThread;
	}
	/*
	 * solange beide noch nicht fertig sind warten beide Threads darauf,
	 * dass der jeweils andere seinen Flag auf true setzt, um seinen eigenen Flag zu setzen
	 */
	public void run(){
		while(!firstIsDone&&!secondIsDone){
			//der erste Thread wartet darauf dass der zweite fertig ist
			if(FIRSTTHREAD){
				if(secondIsDone){
					firstIsDone = true;
				}
			}
			//der zweite Thread wartet darauf dass der erste fertig ist
			else if(SECONDTHREAD){
				if(firstIsDone){
					secondIsDone = true;
				}
			}
		}
	}
}
