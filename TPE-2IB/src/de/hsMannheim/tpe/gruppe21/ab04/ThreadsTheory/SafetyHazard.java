package de.hsMannheim.tpe.gruppe21.ab04.ThreadsTheory;

public class SafetyHazard extends Thread{

	public static int zahl = 10;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Zahl: " + zahl);
		SafetyHazard abb500 = new SafetyHazard(3);
		SafetyHazard zub500 = new SafetyHazard(-3);
		abb500.start();
		zub500.start();
		abb500.join();
		zub500.join();
		System.out.println("Zahl: " + zahl);
	}
	
	/*
	Safety Hazards 
	Wenn mehrere Threads gleichzeitig auf den selben Speicherplatz zugreifen ohne synchronisiert zu sein,
	kann es dazu führen, dass das Resultat unvorhersehbar wird. 
	*/
	
	public int addition;
	
	SafetyHazard(int addition){
		this.addition = addition;
	}
	
	@Override
	public void run(){
		int speicher = zahl;
		speicher += addition;
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		zahl = speicher;
	}	
}