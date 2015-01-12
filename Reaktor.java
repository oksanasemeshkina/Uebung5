package ws2014.tpe.gruppe_1415349_1410206.uebung5;

/**
 * 
 *
 *
 */
public class Reaktor extends Thread implements Runnable {
	private int temperatur;
	private static final long warteZeit = (1000 / 42);
	
	private WasserElement element;

	public Reaktor(WasserElement element) {
		
		this.element=element;
	}

	public WasserElement getElement() {
		return element;
	}

	public void setElement(WasserElement element) {
		this.element = element;
	}
	/**
	 * 
	 */
	public synchronized void run() {
		boolean run=true;
		while (run) {
			try {
				element.setTemperatur(element.getTemperatur()+ 1);
				if (element.getTemperatur() >= 2878) {
					throw new KernschmelzeException();
					
				}
					sleep(warteZeit);
			} catch (InterruptedException e) {
				run = false;
			} catch (KernschmelzeException e) {
				System.out
						.println("Es kommt zu einem GAU, hätten Sie das Schloss doch"
								+ " stehen Lassen!!!!");
				run=false;
			}
		}
	}
}
