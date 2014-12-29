package ws2014.tpe.gruppe_1415349_1410206.uebung5;

public class ReaktorTest {

	public static void main(String[] args) {
		Reaktor reaktor = new Reaktor();
		for(int index=0; index< 100; index++){
			reaktor.nächsteSekunde();
			System.out.println(reaktor.getTempReaktor());
			System.out.println(reaktor.getWasser());
			System.out.println(" ");
		}

	}

}
