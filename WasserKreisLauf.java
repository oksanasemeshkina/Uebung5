package ws2014.tpe.gruppe_1415349_1410206.uebung5;

/**
 * 
 * 
 *
 */
public class WasserKreisLauf {
	WasserElement reaktor;
	WasserElement kuehlung;

	/**
	 * 
	 */
	public WasserKreisLauf() {
		reaktor = new WasserElement();
		// q= hlifselement zur realisierung des Kreises
		WasserElement p = reaktor;

		for (int index = 0; index < 11; index++) {
			WasserElement q = new WasserElement();
			p.next = q;
			p = q;
			if (index == 5) {
				kuehlung = q;
			}
		}
		p.next = reaktor;
	}

	/**
	 * 
	 */
	public void pump() {
		kuehlung = reaktor;
		reaktor = reaktor.next;
	}
}