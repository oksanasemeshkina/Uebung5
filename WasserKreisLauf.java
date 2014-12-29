package ws2014.tpe.gruppe_1415349_1410206.uebung5;

public class WasserKreisLauf {
WasserElement zeiger1;
WasserElement zeiger2;
int L = 1;

public WasserKreisLauf(){
	zeiger1 = new WasserElement();
	WasserElement p=zeiger1;
	
	for(int index=0; index<11; index++){
		WasserElement q=new WasserElement();
		p.next = q;
		p = q;
		if(index == 5){
			zeiger2=q;
		}
	}
	p.next = zeiger1;
}
public void nächsteSchritt(){
	for(int index=1; index<=L; index++){
		zeiger1=zeiger1.next;
		zeiger2=zeiger2.next;
	}
}

public double get1Temp(){
	return zeiger1.temperatur;
}
public double get2Temp(){
	return zeiger2.temperatur;
}
public void set1Temp(double temp){
	 zeiger1.temperatur=temp;
}
public void set2Temp(double temp){
	 zeiger2.temperatur=temp;
}
}
