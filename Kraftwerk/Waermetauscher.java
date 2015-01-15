package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;

/**
 * Die Klasse realisiert die Wärmertauscher. Hauptsetzlich berechnet sie die
 * Temperaturen nach der Kühlung ändern.
 */
public class Waermetauscher {
	private int tempAusgang;

	/**
	 * Die Methode setzt neue Temperaturen in Wasserelemente nach der Kühlung
	 * 
	 * @param kuehlung
	 *            "kaltes" Element
	 * @param zuKuehlen
	 *            "warmes" Element
	 */
	public void waermeTauschen(WasserElement kuehlung, WasserElement zuKuehlen) {

		int neuTemp = 0;
		neuTemp = berechne(kuehlung, zuKuehlen);
		zuKuehlen.setTemperatur(neuTemp);
		kuehlung.setTemperatur(neuTemp);

	}

	/**
	 * Die Methode berechnet neue Temperaturen
	 * 
	 * @param kuehlung
	 *            "kaltes" Element
	 * @param zuKuehlen
	 *            "warmes" Element
	 * @return tempAusgang neue Temperatur des Wasserelements
	 */
	private int berechne(WasserElement kuehlung, WasserElement zuKuehlen) {
		int tempEingang = zuKuehlen.getTemperatur();
		int tempKuehlwasser = kuehlung.getTemperatur();
		tempAusgang = (tempEingang + tempKuehlwasser) / 2;

		return tempAusgang;
	}

	/**
	 * Gibt neue Temperaturen zurück
	 * 
	 * @return
	 */
	public int getTempAusgang() {
		return this.tempAusgang;

	}
}
