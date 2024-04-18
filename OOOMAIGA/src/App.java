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
            persona.setId(2);

            List<IPersona> lista = personaController.find(persona);
            for (IPersona personaTemp : lista) {
                System.out.println(personaTemp.getString());
            }

           
            
            /*
             * //agregar
             * personaController.add(persona);
             */

          

        } catch (NotBoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
