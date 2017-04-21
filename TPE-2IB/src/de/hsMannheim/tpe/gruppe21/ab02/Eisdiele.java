package de.hsMannheim.tpe.gruppe21.ab02;

public class Eisdiele {

	public void bestellen(String typ){
		begruessen();
		
		if(eisZubereiten(typ)){
			kassieren();
		}else{
			entschuldigen();
		}
		
		verabschieden();
	};
	
	protected boolean eisZubereiten(String typ){return false;}
	protected void begruessen(){}
	protected void kassieren(){}
	protected void verabschieden(){}
	protected void entschuldigen(){}
}
