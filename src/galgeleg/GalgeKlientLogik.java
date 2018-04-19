/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


/**
 *
 * @author mikkel
 */
public class GalgeKlientLogik {
    Scanner keyboard = new Scanner(System.in);  
    String Input, Username, Password;
        
    public Bruger BrugerLogin() throws NotBoundException, RemoteException, MalformedURLException{
        
             
        Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin"); //connecting to server
        System.out.println("Du skal nu logge ind på Jakobs linux server");
        System.out.println("Skriv dit studienummer");
        Username = keyboard.nextLine();
        System.out.println("Skriv dit password");
        Password = keyboard.nextLine();
        //Bruger b = ba.hentBruger("s153795", "1234"); //hardcoded login, should work
        Bruger b = ba.hentBruger(Username, Password); //login with user information
        System.out.println("Du er logget ind som " + b);
        
        return b; 
    }
    
    public void spilspil() throws MalformedURLException{

        //Attempt to connect to game server        
        //URL url = new URL("http://localhost:4443/GalgeTest?WSDL");        //on local host
        URL url = new URL("http://ubuntu4.saluton.dk:4443/GalgeTest?WSDL"); //on ubunto server
        QName qname = new QName("http://galgeleg/", "GalgelogikService");
        Service service = Service.create(url, qname);
        
        QName port_name = new QName("http://galgeleg/", "GalgelogikPort");
        
        GalgeI spil = service.getPort(port_name,GalgeI.class);

        spil.nulstil();
        boolean play = true;

        try {
          spil.hentOrdFraDr();
        } catch (Exception e) {
          e.printStackTrace();
        }
        spil.logStatus();

        while(play){
            while(!spil.erSpilletSlut()){
                System.out.println("\n\n\n\n\nGæt på et bogstav");
                Input = keyboard.nextLine();

                spil.gætBogstav(Input);
                spil.logStatus();   //printing server side
                
                printHangMan(spil.getAntalForkerteBogstaver());
                

                System.out.println("Du har gættet forkert: " + spil.getAntalForkerteBogstaver() + " gange");
                System.out.println("Du har gættet på: " + spil.getBrugteBogstaver());
                System.out.println("" + spil.getSynligtOrd());
            }//end of while(!spil.erSpilletSlut())

            System.out.println("\n\n\n\nSpillet er slut\n\n\n\n");

            if(spil.erSpilletVundet()){
                System.out.println("Du vandt!");
            }else{
                System.out.println("Du tabte!");
            }
            System.out.println("Ordet var:\t" + spil.getOrdet());

            try { Thread.sleep(2000); } catch (InterruptedException ex) { } // transaktionen gemmes      
            System.out.println("\n\n\n\nDo you wanna play again?\t (yes) (no)");
            Input = keyboard.nextLine();
            if(Input.equals("yes")||Input.equals("y")){
                play = true;
                spil.nulstil();
            }else{
                play = false;
                System.out.println("Spillet er nu slut");
                System.exit(0);
            }//end of if else
        }//end of while(play)        
    }
    
    public void printHangMan(int param){
      
      if(param == 0){
        System.out.println("   ____________");
        System.out.println("   |          |");
        System.out.println("   |          o");
        System.out.println("   |          ");
        System.out.println("   |");
        System.out.println("   |");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        System.out.println("/     \\");
          
      }else if(param == 1){
        System.out.println("   ____________");
        System.out.println("   |          |");
        System.out.println("   |          o");
        System.out.println("   |          |");
        System.out.println("   |");
        System.out.println("   |");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        System.out.println("/     \\");
          
      }else if(param == 2){
        System.out.println("   ____________");
        System.out.println("   |          |");
        System.out.println("   |          o");
        System.out.println("   |          |");
        System.out.println("   |          O");
        System.out.println("   |");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        System.out.println("/     \\");
      }else if(param == 3){
        System.out.println("   ____________");
        System.out.println("   |          |");
        System.out.println("   |          o");
        System.out.println("   |          |");
        System.out.println("   |          O´");
        System.out.println("   |");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        System.out.println("/     \\");
      }else if(param == 4){
        System.out.println("   ____________");
        System.out.println("   |          |");
        System.out.println("   |          o");
        System.out.println("   |          |");
        System.out.println("   |         `O´");
        System.out.println("   |");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        System.out.println("/     \\");
      }else if(param == 5){
        System.out.println("   ____________");
        System.out.println("   |          |");
        System.out.println("   |          o");
        System.out.println("   |          |");
        System.out.println("   |         `O´");
        System.out.println("   |           \\");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        System.out.println("/     \\");
      }else if(param == 6){
        System.out.println("   ____________");
        System.out.println("   |          |");
        System.out.println("   |          o");
        System.out.println("   |          |");
        System.out.println("   |         `O´");
        System.out.println("   |         / \\");
        System.out.println("   |");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        System.out.println("/     \\");
      }else if(param == 7){
        System.out.println("   ____________");
        System.out.println("   |          |");
        System.out.println("   |          o");
        System.out.println("   |          |");
        System.out.println("   |         `O´");
        System.out.println("   |         / \\");
        System.out.println("   |        -");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        System.out.println("/     \\");
      }
      else if(param >= 8){
        System.out.println("   ____________");
        System.out.println("   |          |");
        System.out.println("   |          o");
        System.out.println("   |          |");
        System.out.println("   |         `O´");
        System.out.println("   |         / \\");
        System.out.println("   |        -   -");
        System.out.println("  / \\");
        System.out.println(" /   \\");
        System.out.println("/     \\");
      }
  }
    
}
