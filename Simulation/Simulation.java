package ws2014.tpe.gruppe_1415349_1410206.uebung5.Simulation;

import ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk.Kraftwerk;
import ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk.Pumpe;
import ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk.Reaktor;
import ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk.Waermetauscher;
import ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk.WasserElement;
import ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk.WasserKreisLauf;

public class Simulation {

	public static void main(String[] args) {
		WasserKreisLauf kreis = new WasserKreisLauf();
		Pumpe pumpe = new Pumpe(1, kreis);
		Reaktor reaktor = new Reaktor(new WasserElement());
		Waermetauscher waermetauscher1 = new Waermetauscher();
		Waermetauscher waermetauscher2 = new Waermetauscher();

		Kraftwerk kraftwerk = new Kraftwerk(pumpe, kreis, reaktor,
				waermetauscher1, waermetauscher2);

		Thread akw = new Thread(kraftwerk);
		akw.start();

	}

}
