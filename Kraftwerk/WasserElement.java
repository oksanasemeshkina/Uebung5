package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;

/**
 * Die klasse beschreibt, wie ein Wasserelement im Wasserkreislauf aussieht. Die
 * Temperatur von jedem Element beträgt zu Beginn 10°.
 * 
 */
public class WasserElement {
	private int temperatur;

	/**
	 * Erzeugt ein Wasserelement
	 */
	public WasserElement() {
		temperatur = 10;

	}

	/**
	 * Setzr neue Temperatur in Wasserelement
	 * @param temp
	 */
	public void setTemperatur(int temp) {
		this.temperatur = temp;
	}

	/**
	 * Gibt Temperatur vom Wasserelement zurück
	 * @return
	 */
	public int getTemperatur() {
		return this.temperatur;
	}
}