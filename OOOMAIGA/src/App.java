import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Interface.IPersonaController;
import Interface.IPersona;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            IPersonaController personaController = (IPersonaController) Naming
                    .lookup("rmi://localhost/personaController");


        
           IPersona persona = personaController.newInstance();
           persona.setNombre("Daniel"); 
           persona.setEmail("pepulince@gmail.com");
           persona.setTelefono("92312932912");
    /* 
        //agregar
        personaController.add(persona);
*/


           List<IPersona> lista =  personaController.list();
           for( IPersona personaTemp : lista){
            System.out.println(personaTemp.getString());
           }

         IPersona persona3 =   personaController.findOne(1);
         System.out.println("findONe: "+persona3.getString());

        
         persona3.setNombre("pancho");
         persona3.setTelefono("9234321233");
         int respuesta = personaController.update(persona3);
         if(respuesta == IPersonaController.UPADATE_EXITO ){
            System.out.println("actualizado con exito");
         }

        } catch (NotBoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
