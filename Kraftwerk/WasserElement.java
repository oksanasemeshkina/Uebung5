package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;

import ws2014.tpe.gruppe_1415349_1410206.uebung5.Token.Token;

/**
 * Die klasse beschreibt, wie ein Wasserelement im Wasserkreislauf aussieht. Die
 * Temperatur von jedem Element betr�gt zu Beginn 10�.
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
	 * Setzt neue Temperatur in Wasserelement
	 * 
	 * @param temp
	 */
	public void setTemperatur(int temp) {
		synchronized (Token.temp) {
			this.temperatur = temp;
		}
	}

	/**
	 * Gibt Temperatur vom Wasserelement zur�ck
	 * 
	 * @return
	 */
	public int getTemperatur() {
		return this.temperatur;
	}
}