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
    
    private static Asignatura asignatura = new Asignatura();
    private static ContenidosAgregados contenidoAgregados = new ContenidosAgregados();
    private static ContenidosFijos contenidosFijos = new ContenidosFijos();
    
    
    public GeneradorSecuencia() throws IOException{
        MenuRubrica menuRubrica = new MenuRubrica(asignatura, contenidoAgregados, contenidosFijos);
        menuRubrica.setVisible(true);
    }
    
    public void recuperarDatos(){
        System.out.println(this.asignatura.getAsignatura());
        System.out.println("Salida");
    }

    public void finalize() throws Throwable{

    }

}
