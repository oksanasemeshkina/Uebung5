package ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk;

import java.util.ArrayList;

/**
 * Die Klasse stellt einen Wasserkreislauf dar. Ein Wasserkreislauf besteht aus
 * 12 Wasserelementen, die nach jedem Pumpebewegung ein schritt weiterbewegen
 * und nehmen neue Temperatur an.
 */
public class WasserKreisLauf {

	private ArrayList<WasserElement> wasserKreisLauf = new ArrayList<>(12);

	private int reaktorPosition;
	private int flusswasserPosition;

	/**
	 * Konstruktor, der genau 12 Wasserelemente erzeugt und festlegt, welches
	 * element im ersten durchlauf in welschem Wärmetauscher.
	 */
	public WasserKreisLauf() {

		for (int i = 0; i < 12; i++) {

			wasserKreisLauf.add(new WasserElement());
		}
		this.reaktorPosition = 0;
		this.flusswasserPosition = 6;
	}

	/**
	 * gibt alle Elemente der Wasserkreislaufes als ArrayList zurück
	 * 
	 * @return wasserKreisLauf Lls ArrayList
	 */
	public ArrayList<WasserElement> getWasserKreisLauf() {
		return wasserKreisLauf;
	}

	/**
	 * Gibt die Position des Wasserelements zurück, das sich im Reaktor befindet
	 * 
	 * @return reaktorPosition
	 */
	public int getReaktorPosition() {
		return reaktorPosition;
	}

	/**
	 * Setzt neue Position für Wasserelement, das in Reaktor kommt
	 * 
	 * @param reaktorPosition
	 */
	public void setReaktorPosition(int reaktorPosition) {
		this.reaktorPosition = reaktorPosition;
	}

	/**
	 * Gibt die Position des Wasserelements zurück, das sich in der
	 * Flusswasserkühlung befindet.
	 * 
	 * @return flusswasserPosition
	 */
	public int getFlusswasserPosition() {
		return flusswasserPosition;
	}

	/**
	 * Setzt neue Position vom Wasserelement, das sich in der Flusswasserkühlung
	 * befindet.
	 * 
	 * @param flusswasserPosition
	 */
	public void setFlusswasserPosition(int flusswasserPosition) {
		this.flusswasserPosition = flusswasserPosition;
	}

	/**
	 * Bewegt Elemente im Wasserkreislauf einen Schritt weiter
	 */
	public synchronized void pumpen() {
		reaktorPosition = (reaktorPosition + 1) % 12;
		flusswasserPosition = (flusswasserPosition + 1) % 12;

	}

}
