package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;
import java.util.ArrayList;
/**
 * 
 * 
 *
 */
public class WasserKreisLauf {
	
private ArrayList<WasserElement> wasserKreisLauf = new ArrayList<>(12);
	
	private int reaktorPosition = 0;
	private int flusswasserPosition = 6;
	private Kraftwerk kraftwerk;
	
	public WasserKreisLauf(){
		
		for(int i = 0; i < 12; i++) {
			
			wasserKreisLauf.add(new WasserElement());
		}	
	}

	public ArrayList<WasserElement> getWasserKreisLauf() {
		return wasserKreisLauf;
	}
	
	public int getReaktorPosition() {
		return reaktorPosition;
	}

	public void setReaktorPosition(int reaktorPosition) {
		this.reaktorPosition = reaktorPosition;
	}

	public int getFlusswasserPosition() {
		return flusswasserPosition;
	}

	public void setFlusswasserPosition(int flusswasserPosition) {
		this.flusswasserPosition = flusswasserPosition;
	}
	
	public synchronized void pumpen(){
		reaktorPosition=(reaktorPosition+1)%12;
		flusswasserPosition=(flusswasserPosition+1)%12;
		
	}
	
}
	