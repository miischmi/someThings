import java.util.ArrayList;
import java.util.List;

public class Aufgabe1 {

	public static void main(String[] args) {
		List<Integer> zahlen = new ArrayList<Integer>();

		for (int i = 0; i <= 1000; i++) {
			int zahl = randomNumber();
			if (zahlen.contains(zahl)) {
				i--;
				continue;
			} else {
				zahlen.add(zahl);
			}
		}
		for (int liste : zahlen) {
			System.out.print(liste + " ");
		}
	}

	public static int randomNumber() {
		int zahl = (int) (Math.random() * (90000 + 1));
		return zahl;
	}
}
