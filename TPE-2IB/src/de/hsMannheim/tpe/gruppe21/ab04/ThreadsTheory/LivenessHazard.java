package de.hsMannheim.tpe.gruppe21.ab04.ThreadsTheory;

public class LivenessHazard extends Thread{
	
	public static void main(String[] args) {
		LivenessHazard ersterThread = new LivenessHazard();
		LivenessHazard zweiterThread = new LivenessHazard();
		ersterThread.start();
		zweiterThread.start();
	}
	
	/*
	2. Liveness	Hazards	
	
	*/
	
	public boolean isFinished = false;
	
	public void run(){
		
	}
}
