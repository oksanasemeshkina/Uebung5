package ws2014.tpe.gruppe_1415349_1410206.uebung5.Simulation;

import static org.junit.Assert.*;

import org.junit.Test;

import ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk.Kraftwerk;
import ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk.Pumpe;
import ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk.Reaktor;
import ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk.Waermetauscher;
import ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk.WasserElement;
import ws2014.tpe.gruppe_1415349_1410206.uebung5.Kraftwerk.WasserKreisLauf;

public class KraftwerkTest {
	WasserKreisLauf kreis = new WasserKreisLauf();

	Reaktor reaktor = new Reaktor(new WasserElement());

	Waermetauscher waermetauscher1 = new Waermetauscher();
	Waermetauscher waermetauscher2 = new Waermetauscher();

	Pumpe pumpe = new Pumpe(1, kreis, reaktor, waermetauscher1, waermetauscher2);
	Kraftwerk kraftwerk = new Kraftwerk(pumpe, kreis, reaktor, waermetauscher1,
			waermetauscher2);
	WasserElement element1 = new WasserElement();
	WasserElement element2 = new WasserElement();
	WasserElement element3 = new WasserElement();
	WasserElement element4 = new WasserElement();

	@Test
	public void waermetauscherTest() {
		element1.setTemperatur(10);
		element2.setTemperatur(52);
		element3.setTemperatur(-10);
		element4.setTemperatur(128);
		waermetauscher1.waermeTauschen(element1, element1);
		assertEquals(10, element1.getTemperatur());
		waermetauscher1.waermeTauschen(element1, element2);
		assertEquals(31, element1.getTemperatur());
		assertEquals(31, element2.getTemperatur());
		waermetauscher1.waermeTauschen(element1, element3);
		assertEquals(10, element1.getTemperatur());
		assertEquals(10, element3.getTemperatur());
		waermetauscher1.waermeTauschen(element1, element4);
		assertEquals(69, element1.getTemperatur());
		assertEquals(69, element4.getTemperatur());
		waermetauscher1.waermeTauschen(element2, element4);
		assertEquals(50, element2.getTemperatur());
		assertEquals(50, element4.getTemperatur());
		waermetauscher1.waermeTauschen(element3, element4);
		assertEquals(30, element3.getTemperatur());
		assertEquals(30, element4.getTemperatur());
	}

	@Test
	public void pumpeTest() {
		assertEquals(6, kreis.getFlusswasserPosition());
		assertEquals(0, kreis.getReaktorPosition());
		pumpe.pumpen();
		assertEquals(7, kreis.getFlusswasserPosition());
		assertEquals(1, kreis.getReaktorPosition());
		pumpe.pumpen();
		pumpe.pumpen();
		pumpe.pumpen();
		pumpe.pumpen();
		pumpe.pumpen();
		assertEquals(0, kreis.getFlusswasserPosition());
		assertEquals(6, kreis.getReaktorPosition());
		pumpe.pumpen();
		pumpe.pumpen();
		pumpe.pumpen();
		pumpe.pumpen();
		pumpe.pumpen();
		pumpe.pumpen();
		assertEquals(6, kreis.getFlusswasserPosition());
		assertEquals(0, kreis.getReaktorPosition());
	}

	@Test
	public void wasserKreisLaufTest() {
		assertEquals(6, kreis.getFlusswasserPosition());
		assertEquals(0, kreis.getReaktorPosition());
		kreis.pumpen();
		assertEquals(7, kreis.getFlusswasserPosition());
		assertEquals(1, kreis.getReaktorPosition());
		kreis.pumpen();
		kreis.pumpen();
		kreis.pumpen();
		kreis.pumpen();
		kreis.pumpen();
		assertEquals(0, kreis.getFlusswasserPosition());
		assertEquals(6, kreis.getReaktorPosition());
		kreis.pumpen();
		kreis.pumpen();
		kreis.pumpen();
		kreis.pumpen();
		kreis.pumpen();
		kreis.pumpen();
		assertEquals(6, kreis.getFlusswasserPosition());
		assertEquals(0, kreis.getReaktorPosition());
	}
}
