package ws2014.tpe.gruppe_1415349_1410206.uebung5;

/**
 * 
 * @author Friederike
 *
 */
public class WasserElement {
	private int temperatur;
	WasserElement next;

	/**
	 * 
	 */
	public WasserElement() {
		temperatur = 10;
		next = null;
	}
	/**
	 * 
	 * @param temp
	 */
	public void setTemperatur(int temp){
		this.temperatur=temp;
	}
	/**
	 * 
	 * @return
	 */
	public int getTemperatur(){
		return this.temperatur;
	}
}