package Secuencia;

import Fachada.*;
import Interfaz.MenuRubrica;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
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
        Lector lector = new Lector(contenidoAgregados, contenidosFijos, asignatura);
    }

    public void finalize() throws Throwable{

    }

}
