package de.hsMannheim.tpe.gruppe21.ab04.ThreadsTheory;

public class SafetyHazard{

	public static int kontostand = 1000;
	
	public static void main(String[] args) {
		System.out.println("Kontostand: " + kontostand);
		HazardThread abb500 = new HazardThread(-500);
		
	}
	
	/*
	1: Safety Hazards 
	Wenn mehrere Threads gleichzeitig auf Resoursen zugreifen wollen müssen diese synchornisiert werden. 
	Ansonsten kann es ein, dass zum Beispiel ein Thread eine Variable liest, 
	diese Verändert aber bevor er diese wieder in den Speicher schreiben kann ein anderer Thread die Varaible 
	liest und mit dem alten noch nicht akutalisierten Wert weiterrechnet. 
	Dadurch verhält sich das Programm in Anwesenheit von mehreren Threads nicht mehr wie erwartet korrekt.
	*/
	
}	
class HazardThread extends Thread{
	public int buchung;
	
	HazardThread(int buchung){
		this.buchung = buchung;
	}
	
	@Override
	public void run(){
		int speicher = kontostand;
		speicher += this.buchung;
		try {
			this.wait(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		kontostand = speicher;
	}
}

 