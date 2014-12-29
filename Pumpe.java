package ws2014.tpe.gruppe_1415349_1410206.uebung5;

public class Pumpe extends Thread {
	WasserKreisLauf kreis;
	public int pumpkoeffizient;
	boolean run;

	public Pumpe(int wert) {
		pumpkoeffizient = wert;
		run = true;
	}

	public void run() {
		while (run) {
			kreis.pump();
			sleep(1000 / pumpkoeffizient);
		}
	}
}
