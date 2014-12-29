package ws2014.tpe.gruppe_1415349_1410206.uebung5;

public class Reaktor {
double temperaturReaktor=10;
double wasserAus=10;
WasserKreisLauf kreis;

public Reaktor(){
	kreis = new WasserKreisLauf();
}

public void nächsteSekunde(){
	temperaturReaktor= temperaturReaktor+42;
	temperaturReaktor = (temperaturReaktor + kreis.get1Temp())/2;
	kreis.set1Temp(temperaturReaktor);
	wasserAus = (wasserAus + kreis.get2Temp())/2;
	kreis.set2Temp(wasserAus);
	kreis.nächsteSchritt();
}

public double getTempReaktor(){
	return temperaturReaktor;
}
public double getWasser(){
	return wasserAus;
}
}
