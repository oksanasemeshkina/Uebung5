package ws2014.tpe.gruppe_1415349_1410206.uebung5;

/**
 * 
 *
 *
 */
public class Reaktor extends Thread implements Runnable {
	WasserKreisLauf kreis;
	boolean run;

	public Reaktor() {
		run = true;
		kreis = new WasserKreisLauf();
	}

	/**
 * 
 */
	public void run() {
		while (run) {
			kreis.reaktor.temperatur += 1;
			sleep(1000 / 42);
		}
	}
}
