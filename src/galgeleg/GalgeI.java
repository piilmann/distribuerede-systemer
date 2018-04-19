/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mikkel
 */
@WebService
public interface GalgeI
{
  @WebMethod ArrayList<String> getBrugteBogstaver();  
  @WebMethod String getSynligtOrd();
  @WebMethod String getOrdet();
  @WebMethod int getAntalForkerteBogstaver();
  @WebMethod boolean erSidsteBogstavKorrekt();
  @WebMethod boolean erSpilletVundet();
  @WebMethod boolean erSpilletTabt();
  @WebMethod boolean erSpilletSlut();

  //Galgelogik()                                throws java.rmi.RemoteException;
  @WebMethod void nulstil();
  @WebMethod void gætBogstav(String bogstav);
  @WebMethod void logStatus();
  @WebMethod String hentUrl(String url)                    throws IOException; 
  @WebMethod void hentOrdFraDr()                           throws Exception; 
}
