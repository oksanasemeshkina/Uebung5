package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;

/**
 *
 */
public class Pumpe extends Thread {
	private WasserKreisLauf kreis;
	private int pumpkoeffizient;
	private boolean run=true;
	public Kraftwerk kraftwerk;

	public Pumpe(int wert, WasserKreisLauf kreis) {
		pumpkoeffizient = wert;
		this.kreis=kreis;
	}
	
	public int getPumpkoeffizient() {
		return pumpkoeffizient;
	}

	public void setPumpkoeffizient(int pumpkoeffizient) {
		this.pumpkoeffizient = pumpkoeffizient;
	}

	public WasserKreisLauf getWasserKreisLauf() {
		return kreis;
	}

	public void pumpen() {

		kreis.pumpen();
		//kraftwerk.waermeTauschen();
	}

	/**
	 * 
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
