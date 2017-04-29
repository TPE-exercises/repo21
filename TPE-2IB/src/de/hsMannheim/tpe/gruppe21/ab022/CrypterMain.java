package de.hsMannheim.tpe.gruppe21.ab022;
import static gdi.MakeItSimple.*;
public class CrypterMain {
	public static void main(String[] args) {
		CrypterReverse reverse = new CrypterReverse();

		String message = reverse.encrypt("Hallo");

		println(message);
	}
}
