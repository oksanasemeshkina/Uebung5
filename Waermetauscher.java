package ws2014.tpe.gruppe_1415349_1410206.uebung5;

/**
 *
 */
public class Waermetauscher {
	
	public void waermeTauschen(WasserElement kuehlung, WasserElement zuKuehlen) {
		zuKuehlen.setTemperatur(berechne(kuehlung,zuKuehlen));
	}

	/**
	 * 
	 * @param kuehlung
	 * @param zuKuehlen
	 * @return
	 */
	private int berechne(WasserElement kuehlung, WasserElement zuKuehlen) {
		int tempEingang = zuKuehlen.getTemperatur();
		int tempKuehlwasser = kuehlung.getTemperatur();
		int tempAusgang = (tempEingang + tempKuehlwasser) / 2;

		return tempAusgang;
	}
}
