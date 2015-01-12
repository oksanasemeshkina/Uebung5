package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;

/**
 * Die Klasse stellt Funktionalität der Pumpe. Die sorgt dafür, dass das Wasser
 * im Wasserkreislauf kontinuierlich gepumpt wird. Die Pumpe hat eine
 * Pumpleistung L, die angibt, wie viel Wasser pro Sekunde gepumpt wird.
 */
public class Pumpe extends Thread {
	private WasserKreisLauf kreis;
	private int pumpkoeffizient;
	private boolean run = true;
	public Kraftwerk kraftwerk;

	/**
	 * Der Konstruktor erzeugt Objekt von Pumpe
	 * 
	 * @param wert
	 * @param kreis
	 */
	public Pumpe(int wert, WasserKreisLauf kreis) {
		pumpkoeffizient = wert;
		this.kreis = kreis;
	}

	/**
	 * Gibt Leistung der Pumpe zurück
	 * 
	 * @return pumpkoeffizient
	 */
	public int getPumpkoeffizient() {
		return pumpkoeffizient;
	}

	/**
	 * Setzt neue Pumpeleistung
	 * 
	 * @param pumpkoeffizient
	 */
	public void setPumpkoeffizient(int pumpkoeffizient) {
		this.pumpkoeffizient = pumpkoeffizient;
	}

	/**
	 * Gibt ein Element von Wasserkreislauf zurück
	 * 
	 * @return kreis
	 */
	public WasserKreisLauf getWasserKreisLauf() {
		return kreis;
	}

	/**
	 * Die Methode bewegt Elemente im Wasserkreislauf bei jedem Schritt weiter.
	 */
	public void pumpen() {

		kreis.pumpen();
		// kraftwerk.waermeTauschen();
	}

	/**
	 * Die Methode ist vom Interface Runnable implementiert. Die beschreibt, wie
	 * Thread von der Pumpe funktioniert.
	 */
	public synchronized void run() {
		while (run) {
			pumpen();

			try {
				sleep(1000 / pumpkoeffizient);
			} catch (InterruptedException e) {
				System.out.println("Pumpe wurde gestoppt");
				break;
			}
		}
	}
}
