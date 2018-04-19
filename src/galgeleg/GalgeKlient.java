package galgeleg;


import java.net.MalformedURLException;
import java.util.Scanner;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import brugerautorisation.data.Bruger;


public class GalgeKlient {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        Scanner keyboard = new Scanner(System.in);  
        String Input, Username, Password;
        
        GalgeKlientLogik kLogik = new GalgeKlientLogik(); 
        
        //log in to login server
        Bruger b = kLogik.BrugerLogin();
        
        //starting game
        kLogik.spilspil();    
    }//end of main   
}
