package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;

import ws2014.tpe.gruppe_1415349_1410206.uebung5.Token.Token;

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
	public Kraftwerk(Pumpe pumpe, WasserKreisLauf wasserKreislauf,
			Reaktor reaktor, Waermetauscher reaktorWaermetauscher,
			Waermetauscher flussWaermetauscher) {

		this.pumpe = pumpe;
		this.wasserKreislauf = wasserKreislauf;
		this.reaktor = reaktor;
		this.reaktorWaermetauscher = reaktorWaermetauscher;
		this.flussWaermetauscher = flussWaermetauscher;

	}

	/**
	 * Gibt Pumpe zurück
	 * 
	 * @return pumpe
	 */
	public Pumpe getPumpe() {
		return pumpe;
	}

	/**
	 * Gibt ein Element von WasserKreisLauf zurück
	 * 
	 * @return wasserKreislauf
	 */
	public WasserKreisLauf getWasserKreisLauf() {
		return wasserKreislauf;
	}

	/**
	 * Gibt Objekt Reaktor zurück
	 * 
	 * @return reaktor
	 */
	public Reaktor getReaktor() {
		return reaktor;
	}

	/**
	 * Gibt Waermetauscher, der sich im Reakor befindet
	 * 
	 * @return reaktorWaermetauscher
	 */
	public Waermetauscher getReaktorWaermetauscher() {
		return reaktorWaermetauscher;
	}

	/**
	 * Gibt Waermetauscher, der sich vor Rhein befindet.
	 * 
	 * @return flussWaermetauscher
	 */
	public Waermetauscher getFlussWaermetauscher() {
		return flussWaermetauscher;
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
