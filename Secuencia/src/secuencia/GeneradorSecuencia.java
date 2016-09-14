package Secuencia;

import Fachada.Asignatura;
import Fachada.ContenidosAgregados;
import Fachada.ContenidosFijos;
import Interfaz.MenuRubrica;
import java.io.IOException;

/**
 * @author Luis Fernando
 * @version 1.0
 * @created 08-sep.-2016 11:44:55 p. m.
 */
public class GeneradorSecuencia{

    GeneradorSecuencia(Asignatura asignatura, ContenidosAgregados contenidoAgregados, ContenidosFijos contenidosFijos) throws IOException{
        MenuRubrica menuRubrica = new MenuRubrica(asignatura, contenidoAgregados, contenidosFijos);
        menuRubrica.setVisible(true);
    }

    public void finalize() throws Throwable{

    }

}
