/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;

import javax.xml.ws.Endpoint;

 
/**
 *
 * @author mikkel
 */
public class GalgeServer {
    
    
    public static void main(String[] arg) throws Exception
    {
        GalgeI spil = new Galgelogik();
        Endpoint.publish("http://[::]:4443/GalgeTest", spil);
        System.out.println("GalgeSpilserver startet.");
    }
}

