package ws2014.tpe.gruppe_1415349_1410206.uebung5;

/**
 *
 */
public class Waermetauscher {
	private int tempAusgang;
	
	public void waermeTauschen(WasserElement kuehlung, WasserElement zuKuehlen) {
		zuKuehlen.setTemperatur(berechne(kuehlung,zuKuehlen));
		kuehlung.setTemperatur(berechne(kuehlung,zuKuehlen));
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
		 tempAusgang = (tempEingang + tempKuehlwasser) / 2;
		
		
		 
		return tempAusgang;
	}
		public int getTempAusgang(){
			return this.tempAusgang;
		
	}
}
