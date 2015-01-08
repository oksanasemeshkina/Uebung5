package ws2014.tpe.gruppe_1415349_1410206.uebung5;

/**
 * 
 *
 *
 */
public class Reaktor extends Thread implements Runnable {
	private int temperatur;
	private static final long warteZeit = (1000 / 42);
	boolean run;

	public Reaktor() {
		run = true;
		temperatur = 10;
	}

	/**
	 * 
	 */
	public void run() {
		while (run&&runAll) {
			try {
				temperatur += 1;
				if (temperatur > 2878) {
					throw new KernschmelzeException();
				}
				sleep(warteZeit);
			} catch (InterruptedException e) {
				run = false;
			} catch (KernschmelzeException e) {
				System.out
						.println("Es kommt zu einem GAU, hätten Sie das Schloss doch"
								+ " stehen Lassen!!!!");
				runAll=false;
			}
		}
	}
}
