package myutil;

public class ExceptionTheorie {

	public static void main(String[] args) {
		/*
		 * wird in der unmittelbaren try-Umgebung kein passender catch gefunden,
		 * wird in der nächstäußeren Umgebung gesucht
		 */
		try{
			try{
				int b = 5/0;
			}catch(NullPointerException npe){
				System.out.println("Innerer gesicherter Block");
			}
		}catch(ArithmeticException a){
			System.out.println("Äuserer gesicherter Block");
		}
	}
}
