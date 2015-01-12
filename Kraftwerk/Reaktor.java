package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;

import ws2014.tpe.gruppe_1415349_1410206.uebung5.Exception.KernschmelzeException;

/**
 * 
 *
 *
 */
public class Reaktor extends Thread implements Runnable {
	private static final int KRITISCHE_TEMP=2878;
	private static final long WARTE_ZEIT = (1000 / 42);
	private volatile boolean run = true;

	private WasserElement element;

	public Reaktor(WasserElement element) {

		this.element = element;
	}

	public WasserElement getElement() {
		return element;
	}

	public void setElement(WasserElement element) {
		this.element = element;
	}
	public int getTemp(){
		return element.getTemperatur();
	}
	public boolean laeuft(){
		return run;
	}
	

	/**
	 * 
	 */
	public synchronized void run() {
		
		while (run) {
			try {
				element.setTemperatur(element.getTemperatur() + 1);
				if (element.getTemperatur() >= KRITISCHE_TEMP) {
					throw new KernschmelzeException();

				}
				sleep(WARTE_ZEIT);
			} catch (InterruptedException e) {
				System.out.println("Reaktor wurde heruntergefahren");
				break;
			} catch (KernschmelzeException e) {
				System.out.println("Es kommt zu einem GAU, hätten Sie das"
						+ " Schloss doch stehen Lassen!!!!");
				this.run=false;
			}
		}
	}
}
