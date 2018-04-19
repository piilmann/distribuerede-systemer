package brugerautorisation.transport.rmi;

import brugerautorisation.data.Diverse;
import brugerautorisation.data.Bruger;
import java.rmi.Naming;



public class Brugeradminklient {
	public static void main(String[] arg) throws Exception {
//		Brugeradmin ba =(Brugeradmin) Naming.lookup("rmi://localhost/brugeradmin");
		Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");

                //ba.sendGlemtAdgangskodeEmail("s123456", "Dette er en test, husk at skifte kode");
                //ba.ændrAdgangskode("s153795", "kodea9fun", "1234");
                //System.out.println("test");
                
                
		Bruger b = ba.hentBruger("s153795", "1234");
		System.out.println("Fik bruger = " + b);
		System.out.println("Data: " + Diverse.toString(b));
		ba.sendEmail("s153795", "1234", "Du har fået mail", "Indsæt tekst her");

		//Object ekstraFelt = ba.getEkstraFelt("s153795", "kodea9fun", "Test");
		//System.out.println("Brugerens hobby er: " + ekstraFelt);

		//ba.setEkstraFelt("s153795", "xxx", "Test", "Hurr Durr"); // Skriv noget andet her

		//String webside = (String) ba.getEkstraFelt("s153795", "xxx", "webside");
		//System.out.println("Brugerens webside er: " + webside);
	}
}
