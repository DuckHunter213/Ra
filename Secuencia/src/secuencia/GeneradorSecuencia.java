package Secuencia;

import Fachada.*;
import Interfaz.MenuRubrica;
import java.io.IOException;

/**
 * @author Luis Fernando
 * @version 1.0
 * @created 08-sep.-2016 11:44:55 p. m.
 */
public class GeneradorSecuencia{

    private static final Asignatura asignatura = new Asignatura();
    private static final ContenidosAgregados contenidoAgregados = new ContenidosAgregados();
    private static final ContenidosFijos contenidosFijos = new ContenidosFijos();

    public GeneradorSecuencia() throws IOException{
        MenuRubrica menuRubrica = new MenuRubrica(asignatura, contenidoAgregados, contenidosFijos);
        menuRubrica.setVisible(true);
    }
}
