package de.hsMannheim.tpe.gruppe21.ab04.ThreadsTheory;

public class LivenessHazard extends Thread{

	public static int zahl = 10;
	
	
	public static void main(String[] args) {
		System.out.println("Zahl: " + zahl);
		LivenessHazard ersterThread;
		LivenessHazard zweiterThread;
		ersterThread  = new LivenessHazard(zweiterThread);
		zweiterThread = new LivenessHazard(ersterThread);
		ersterThread.start();
		zweiterThread.start();
		System.out.println("Zahl: " + zahl);
	}
	
	/*
	2. Liveness	Hazards	
	
	*/
	
	public void run(){
		
	}
}
