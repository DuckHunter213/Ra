package Secuencia;

import Fachada.Asignatura;
import Fachada.ContenidosAgregados;
import Fachada.ContenidosFijos;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Luis Fernando
 * @version 1.0
 * @created 08-sep.-2016 11:44:55 p. m.
 */
public class GeneradorSecuencia {

    private ContenidosAgregados contenidosAgregados;
    private ContenidosFijos contenidosFijos;
    private Asignatura asignatura;

    public GeneradorSecuencia(Asignatura asignatura) {
        asignatura.getAsignatura();
    }

    public void finalize() throws Throwable {

    }

}
