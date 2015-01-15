package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;

/**
 * Die Klasse stellt die Funktionalit�t der Pumpe dar. Sie sorgt daf�r, dass das
 * Wasser im Wasserkreislauf kontinuierlich gepumpt wird und dass die
 * w�rmetauscher arbeiten. Die Pumpe hat eine Pumpleistung L, die angibt, wie
 * viel Wasser pro Sekunde gepumpt wird.
 */
public class Pumpe extends Thread {

	private final Reaktor reaktor;
	private final Waermetauscher reaktorWaermetauscher;
	private final Waermetauscher flussWaermetauscher;
	private WasserKreisLauf kreis;
	private int pumpkoeffizient;
	public Kraftwerk kraftwerk;

	/**
	 * Der Konstruktor erzeugt Objekt von Pumpe
	 * 
	 * @param wert
	 * @param kreis
	 */
	public Pumpe(int wert, WasserKreisLauf kreis, Reaktor reaktor,
			Waermetauscher reaktorWaermetauscher,
			Waermetauscher flussWaermetauscher) {
		setPumpkoeffizient(wert);
		this.kreis = kreis;
		this.reaktor = reaktor;
		this.reaktorWaermetauscher = reaktorWaermetauscher;
		this.flussWaermetauscher = flussWaermetauscher;
	}

	/**
	 * Gibt Leistung der Pumpe zur�ck
	 * 
	 * @return pumpkoeffizient
	 */
	public int getPumpkoeffizient() {
		return pumpkoeffizient;
	}

	/**
	 * Methode um die Pumpenleistung auch nachtr�glich noch zu �ndern
	 * 
	 * @param pumpkoeffizient
	 */
	public void setPumpkoeffizient(int pumpkoeffizient) {
		this.pumpkoeffizient = pumpkoeffizient;
	}

	/**
	 * Gibt ein Element von Wasserkreislauf zur�ck
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
		waermeTauschen();
	}

	/**
	 * Methode, die neue Temperaturen nach der K�hlung setzt. F�r den
	 * K�hlkreislauf mit flusswasswe wird jedes mal ein neues Wasserelement
	 * erzeugt
	 */
	public void waermeTauschen() {
		reaktorWaermetauscher.waermeTauschen(
				kreis.getWasserKreisLauf().get(kreis.getReaktorPosition()),
				reaktor.getElement());
		flussWaermetauscher.waermeTauschen(
				kreis.getWasserKreisLauf().get(kreis.getFlusswasserPosition()),
				// Hier wird immer ein neues Wasserelement erzeugt(Weil
				// Flusswasser)
				new WasserElement());
	}

	/**
	 * Methode f�r die ausgabe der Reaktot Temperatur und der
	 * R�ckfludsstemperatur des K�hlwassers in den Rhein
	 */
	private void ausgabe() {
		System.out.println("Temperatur Reaktor: " + reaktor.getTemp() + ", "
				+ "Temperatur Rueckfluss in Rhein: "
				+ flussWaermetauscher.getTempAusgang());
	}

	/**
	 * Die Methode ist vom Interface Runnable implementiert. Die beschreibt, wie
	 * Thread von der Pumpe funktioniert.
	 */
	public synchronized void run() {
		while (reaktor.laeuft()) {
			pumpen();
			ausgabe();

			try {
				sleep(1000 / pumpkoeffizient);
			} catch (InterruptedException e) {
				System.out.println("Pumpe wurde gestoppt");
				break;
			}
		}
	}
}
