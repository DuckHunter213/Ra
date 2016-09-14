package Secuencia;

import Fachada.*;
import java.io.IOException;

/**
 *
 * @author Luis Fernando
 */
public class Secuencia{
    Asignatura asignatura = new Asignatura();
    ContenidosAgregados contenidoAgregados = new ContenidosAgregados();
    ContenidosFijos contenidosFijos = new ContenidosFijos();

    public void main(String[] args) throws IOException{
        GeneradorSecuencia generador = new GeneradorSecuencia(asignatura, contenidoAgregados, contenidosFijos);
    }
}
