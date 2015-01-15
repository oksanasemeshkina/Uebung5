package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;

import ws2014.tpe.gruppe_1415349_1410206.uebung5.Exception.KernschmelzeException;

/**
 * Die Klasse beschreibt, wie Reaktor in Kernkraftwerk funktioniert. Der hat
 * eine Erwärmungskoeffizienten und darf seine kritische Temperatur (2878°)
 * nicht erreichen.
 */
public class Reaktor extends Thread implements Runnable {
	private static final int KRITISCHE_TEMP = 2878;
	private static final long WARTE_ZEIT = (1000 / 42);
	private volatile boolean run = true;
	private WasserElement element;

	/**
	 * Der Konstruktor erzeugt einen Reaktor
	 * 
	 * @param element
	 */
	public Reaktor(WasserElement element) {

		this.element = element;
	}

	/**
	 * Gibt ein Element vom Wasserkreislauf zurück, das sich im Reaktor
	 * befindet.
	 * 
	 * @return element
	 */
	public WasserElement getElement() {
		return element;
	}

	/**
	 * Setzt neue Element im Reaktor nach der Pumpebewegung
	 * 
	 * @param element
	 */
	public void setElement(WasserElement element) {
		this.element = element;
	}

	/**
	 * Gibt Temperatur vom Wasserelement zurück
	 * 
	 * @return temperatur
	 */
	public int getTemp() {
		return element.getTemperatur();
	}

	/**
	 * Die Methode stellt fest, ob der Reaktor noch läuft, oder ob die
	 * Kernschmelze bereits eingetreten ist und wir das wunderschöne renaissance
	 * Schloss (mit einem Fenster mehr als Versailles) umsonst abgerissen haben.
	 * 
	 * @return
	 */
	public boolean laeuft() {
		return run;
	}

	/**
	 * Die Methode ist vom Interface Runnable implementiert. Sie beschreibt, wie
	 * Thread vom Reaktor laufen soll
	 */
	public void run() {

		while (laeuft()) {
			try {
				element.setTemperatur(element.getTemperatur() + 1);
				if (element.getTemperatur() >= KRITISCHE_TEMP) {
					throw new KernschmelzeException();

				}
				sleep(WARTE_ZEIT);
			} catch (InterruptedException e) {
				System.out.println("Reaktor wurde heruntergefahren");
				break;
			} catch (KernschmelzeException e) {
				System.out.println("Es kommt zu einem GAU, hätten Sie das"
						+ " Schloss doch stehen Lassen!!!!");
				this.run = false;
			}
		}
	}
}
