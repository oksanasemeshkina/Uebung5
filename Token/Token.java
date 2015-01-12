package ws2014.tpe.gruppe_1415349_1410206.uebung5.Token;

/**
 * Die Klasse erzeugt beide Tokens Durchgang und Tausch, um Threads im Kraftwerk
 * zu synchronisieren.
 *
 */

public class Token {
	public static Tausch tausch = new Tausch();
	public static Durchgang durchgang = new Durchgang();
}
