package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;

import ws2014.tpe.gruppe_1415349_1410206.uebung5.Token.Token;

;

/**
 * Die Klasse beschreibt, wie Wärmertauscher funktionieren. Hauptsetzlich zeigt
 * sie, wie sich Temperaturen nach der Kühlung ändern.
 */
public class Waermetauscher {
	private int tempAusgang;
/**
 * Die Methode setzt neue Temperaturen in Wasserelemente nach der Kühlung
 * @param kuehlung
 * @param zuKuehlen
 */
	public void waermeTauschen(WasserElement kuehlung, WasserElement zuKuehlen) {
		synchronized (Token.tausch) {
			zuKuehlen.setTemperatur(berechne(kuehlung, zuKuehlen));
			kuehlung.setTemperatur(berechne(kuehlung, zuKuehlen));
		}
	}

	/**
	 *Die Methode berechnet neue Temperaturen  
	 * @param kuehlung
	 * @param zuKuehlen
	 * @return
	 */
	private int berechne(WasserElement kuehlung, WasserElement zuKuehlen) {
		int tempEingang = zuKuehlen.getTemperatur();
		int tempKuehlwasser = kuehlung.getTemperatur();
		tempAusgang = (tempEingang + tempKuehlwasser) / 2;

		return tempAusgang;
	}
/**
 * Gibt neue Temperaturen zurück
 * @return
 */
	public int getTempAusgang() {
		return this.tempAusgang;

	}
}
