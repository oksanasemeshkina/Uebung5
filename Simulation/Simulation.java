package ws2014.tpe.gruppe_1415349_1410206.uebung5.Simulation;

import ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk.Kraftwerk;


/**
 * Simulation des Kraftwers, erstellt die Objekte und startet den Kraftwers
 * Thread, der dann den rest erledigt
 *
 */
public class Simulation {

	public static void main(String[] args) {
		
		Kraftwerk kraftwerk = new Kraftwerk();

		Thread akw = new Thread(kraftwerk);
		akw.start();

	}

}
