package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;

import ws2014.tpe.gruppe_1415349_1410206.uebung5.Token.Token;

public class Kraftwerk implements Runnable {
	/**
 * 
 * 
 */

	private final Pumpe pumpe;
	private final WasserKreisLauf wasserKreislauf;
	private final Reaktor reaktor;
	private final Waermetauscher reaktorWaermetauscher;
	private final Waermetauscher flussWaermetauscher;

	public Kraftwerk(Pumpe pumpe, WasserKreisLauf wasserKreislauf,
			Reaktor reaktor, Waermetauscher reaktorWaermetauscher,
			Waermetauscher flussWaermetauscher) {

		this.pumpe = pumpe;
		this.wasserKreislauf = wasserKreislauf;
		this.reaktor = reaktor;
		this.reaktorWaermetauscher = reaktorWaermetauscher;
		this.flussWaermetauscher = flussWaermetauscher;

	}

	public Pumpe getPumpe() {
		return pumpe;
	}

	public WasserKreisLauf getWasserKreisLauf() {
		return wasserKreislauf;
	}

	public Reaktor getReaktor() {
		return reaktor;
	}

	public Waermetauscher getReaktorWaermetauscher() {
		return reaktorWaermetauscher;
	}

	public Waermetauscher getFlussWaermetauscher() {
		return flussWaermetauscher;
	}

	public void waermeTauschen() {
		synchronized (Token.durchgang) {
			reaktorWaermetauscher.waermeTauschen(
					wasserKreislauf.getWasserKreisLauf().get(
							wasserKreislauf.getReaktorPosition()),
					reaktor.getElement());
			flussWaermetauscher.waermeTauschen(
					wasserKreislauf.getWasserKreisLauf().get(
							wasserKreislauf.getFlusswasserPosition()),
					new WasserElement());
		}
	}

	public synchronized void run() {
		int zaehler = 0;
		Thread reaktorThread = new Thread(reaktor);
		Thread pumpenThread = new Thread(pumpe);

		reaktorThread.start();
		pumpenThread.start();

		while (zaehler < 20 && reaktor.laeuft()) {
			waermeTauschen();
			System.out.println("Temperatur Reaktor: " + reaktor.getTemp()
					+ ", " + "Temperatur Rueckfluss in Rhein: "
					+ flussWaermetauscher.getTempAusgang());
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
