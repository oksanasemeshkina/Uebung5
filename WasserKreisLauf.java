package ws2014.tpe.gruppe_1415349_1410206.uebung5;
import java.util.ArrayList;
/**
 * 
 * 
 *
 */
public class WasserKreisLauf {
	
private ArrayList<WasserElement> wasserKreisLauf = new ArrayList<>(12);
	
	private int reaktorPosition = 0;
	private int flusswasserPosition = 11;
	
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
		if(reaktorPosition==11 ||flusswasserPosition==11 ){
			reaktorPosition=0;
			flusswasserPosition=0;
		}
		reaktorPosition++;
		flusswasserPosition++;
		
		
		
	}
	
}
	