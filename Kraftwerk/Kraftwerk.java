package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;

public class Kraftwerk implements Runnable {
	/**
	 * Die Klasse stellt Funktionalität eines Atomkraftwerks vor,das
	 * hauptsetzlich aus einem Reaktor, einem Kühlkreislauf mit einer Pumpe und
	 * zwei Wäarmetauschern besteht.
	 * 
	 */

	private final Pumpe pumpe;
	private final WasserKreisLauf wasserKreislauf;
	private final Reaktor reaktor;
	private final Waermetauscher reaktorWaermetauscher;
	private final Waermetauscher flussWaermetauscher;

	/**
	 * Der Konstruktor erzeugt neues Kraftwerk
	 * 
	 * @param pumpe
	 * @param wasserKreislauf
	 * @param reaktor
	 * @param reaktorWaermetauscher
	 * @param flussWaermetauscher
	 */
	public Kraftwerk() {

		wasserKreislauf = new WasserKreisLauf();

		reaktor = new Reaktor(new WasserElement());

		reaktorWaermetauscher = new Waermetauscher();
		flussWaermetauscher = new Waermetauscher();

		pumpe = new Pumpe(1, wasserKreislauf, reaktor, reaktorWaermetauscher,
				flussWaermetauscher);

	}

	/**
	 * Die Methode ist vom Interface Runnable implementiert. Die startet 2
	 * Threads (vom Reaktor und von Pumpe), die zeigen, wie das Kraftwerk
	 * funktioniert.
	 */
	public synchronized void run() {
		int zaehler = 0;
		Thread reaktorThread = new Thread(reaktor);
		Thread pumpenThread = new Thread(pumpe);

		reaktorThread.start();
		pumpenThread.start();

		while (zaehler < 20 && reaktor.laeuft()) {

			zaehler++;

			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {

				break;
			}
		}
		reaktorThread.interrupt();
		pumpenThread.interrupt();
	}

}
