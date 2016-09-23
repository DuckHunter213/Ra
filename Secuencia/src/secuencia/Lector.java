package secuencia;

import Fachada.Asignatura;
import Fachada.ContenidosAgregados;
import Fachada.ContenidosFijos;
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
import java.util.ArrayList;

public class Lector {
    private static ContenidosAgregados contenidosAgregados;
    private static ContenidosFijos contenidosFijos;
    private static Asignatura asignatura;
    
    private static String convertirArrayToString(ArrayList<String> contenidos){
        String cadena= " ";
        if (contenidos.isEmpty())
            return " ";
        for (String contenido : contenidos) {
            cadena = cadena + contenido + "\n";
        }
        return cadena;
    }
    
    public Lector(ContenidosAgregados contenidosAgregados, ContenidosFijos contenidosFijos, Asignatura asignatura){
        this.contenidosAgregados = contenidosAgregados;
        this.contenidosFijos = contenidosFijos;
        this.asignatura = asignatura;
    }
    
    public void crearArchivo(){
        Document documento = new Document(PageSize.LETTER, -40, -40, 40, 40);
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("Ejemplo1.pdf"));
            documento.open();
            Font estiloContenidoCelda = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
            Phrase contenido = new Phrase("Asignatura", estiloContenidoCelda);

            PdfPTable table;
            PdfPCell cell = new PdfPCell(new Phrase(" "));
            //Encabezado con imágenes
            table = new PdfPTable(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Image imagen = Image.getInstance("Encabezado.png");
            cell = new PdfPCell(imagen, true);
            cell.setBorder(0);
            imagen.setBorder(0);
            table.addCell(cell);
            documento.add(table);

            //Primera parte rellenable
            table = new PdfPTable(8);
            
            cell = new PdfPCell(new Phrase(" "));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(5);

            contenido = new Phrase("Asignatura", estiloContenidoCelda);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPhrase(contenido);
            cell.setColspan(4);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            contenido = new Phrase("Docente(s)", estiloContenidoCelda);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPhrase(contenido);
            cell.setColspan(4);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(" "));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(4);
            cell.setBackgroundColor(BaseColor.WHITE);       
                                 
            contenido = new Phrase(asignatura.getAsignatura(), estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);
            cell.setColspan(4);
            
            contenido = new Phrase(asignatura.getNombreCompletoMaestro(), estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);
            documento.add(table);

            //Parte baja Primera parte rellenable
            table = new PdfPTable(8);
            estiloContenidoCelda = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
            cell.setPaddingBottom(5);

            contenido = new Phrase("Semestre", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(1);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            contenido = new Phrase("Periodo escolar", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            contenido = new Phrase("No. de secuencia", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            contenido = new Phrase("No. de sesiones", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            contenido = new Phrase("Fecha de inicio de aplicación", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            contenido = new Phrase("Bloque(s) que comprende", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            contenido = new Phrase(" ");
            cell.setPhrase(contenido);
            cell.setBackgroundColor(BaseColor.WHITE);
            
            contenido = new Phrase(Integer.toString(asignatura.getSemestre()), estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(1);
            table.addCell(cell);
            contenido = new Phrase(" ");
            cell.setPhrase(contenido);
            
            contenido = new Phrase(contenidosAgregados.getPeriodoEscolar(), estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(1);
            table.addCell(cell);
            
            contenido = new Phrase(Integer.toString(contenidosAgregados.getNumeroSecuencia()), estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(1);
            table.addCell(cell);
            
            contenido = new Phrase(Integer.toString(contenidosAgregados.getNumeroSesiones()), estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(1);
            table.addCell(cell);
            
            contenido = new Phrase(contenidosAgregados.getFechaInicio(), estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(2);
            table.addCell(cell);            
            
            contenido = new Phrase(asignatura.getBloque(), estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(2);
            table.addCell(cell);
            
            documento.add(table);
            documento.add(new Paragraph("\n"));

            //Segunda parte Datos secuencia
            table = new PdfPTable(8);
            estiloContenidoCelda = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
            cell.setPaddingBottom(5);

            contenido = new Phrase("Propósito de la secuencia", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(2);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            contenido = new Phrase(contenidosAgregados.getPropositoSecuencia(), estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(6);
            cell.setBackgroundColor(BaseColor.WHITE);
            table.addCell(cell);

            contenido = new Phrase("Otras asignaturas con las que se relaciona la secuencia", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(2);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            contenido = new Phrase(contenidosAgregados.getAsignaturasRelacionadas(), estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(6);
            cell.setBackgroundColor(BaseColor.WHITE);
            
            
            table.addCell(cell);
            documento.add(table);

            //Saberes de la materia
            table = new PdfPTable(3);
            cell.setPaddingBottom(5);

            contenido = new Phrase("Saberes necesarios para el desarrollo de competencias", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(3);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);

            contenido = new Phrase("Contenidos declarativos", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(1);
            table.addCell(cell);

            contenido = new Phrase("Contenidos procedimentales", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(1);
            table.addCell(cell);

            contenido = new Phrase("Contenidos actitudinales", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(1);
            table.addCell(cell);

            contenido = new Phrase(" ");
            
            cell.setPhrase(contenido);
            cell.setColspan(1);
            cell.setBackgroundColor(BaseColor.WHITE);
            contenido = new Phrase(convertirArrayToString(contenidosFijos.getContenidosDeclarativos()), estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);
            
            contenido = new Phrase(convertirArrayToString(contenidosFijos.getContenidosProcedimentales()), estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(1);
            table.addCell(cell);
            
            contenido = new Phrase(convertirArrayToString(contenidosFijos.getContenidosActitudinales()), estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(1);
            table.addCell(cell);
            documento.add(table);

            //Actividades para el desarrollo INICIO
            table = new PdfPTable(16);
            cell.setPaddingBottom(5);

            contenido = new Phrase("Actividades para el desarrollo de competencias", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(16);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
            contenido = new Phrase("Inicio", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(6);
            table.addCell(cell);
            contenido = new Phrase("Competencias a las que contribuye", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(6);
            table.addCell(cell);
            contenido = new Phrase("Evidencias de aprendizaje", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(2);
            cell.setRowspan(2);
            table.addCell(cell);
            contenido = new Phrase("Instrumentos de evaluación", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(2);
            cell.setRowspan(2);
            table.addCell(cell);

            contenido = new Phrase("Enseñanza", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(3);
            cell.setRowspan(1);
            table.addCell(cell);
            contenido = new Phrase("Aprendizaje", estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);
            estiloContenidoCelda = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
            contenido = new Phrase("Disciplinares", estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);
            contenido = new Phrase("Genéricas(Atributos)", estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);

            contenido = new Phrase(" ");
            cell.setBackgroundColor(BaseColor.WHITE);
            estiloContenidoCelda = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
            cell.setPhrase(contenido);
            cell.setColspan(3);
            
            
            table.addCell(cell);
            
            table.addCell(cell);
            
            table.addCell(cell);
            
            table.addCell(cell);
            
            cell.setColspan(2);
            table.addCell(cell);
            
            table.addCell(cell);
            documento.add(table);

            //Actividades para el desarrollo DESARROLLO
            table = new PdfPTable(16);
            cell.setPaddingBottom(5);

            contenido = new Phrase("Actividades para el desarrollo de competencias", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(16);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
            contenido = new Phrase("Desarrollo", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(6);
            table.addCell(cell);
            contenido = new Phrase("Competencias a las que contribuye", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(6);
            table.addCell(cell);
            contenido = new Phrase("Evidencias de aprendizaje", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(2);
            cell.setRowspan(2);
            table.addCell(cell);
            contenido = new Phrase("Instrumentos de evaluación", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(2);
            cell.setRowspan(2);
            table.addCell(cell);

            contenido = new Phrase("Enseñanza", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(3);
            cell.setRowspan(1);
            table.addCell(cell);
            contenido = new Phrase("Aprendizaje", estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);
            estiloContenidoCelda = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
            contenido = new Phrase("Disciplinares", estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);
            contenido = new Phrase("Genéricas(Atributos)", estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);

            contenido = new Phrase(" ");
            cell.setBackgroundColor(BaseColor.WHITE);
            estiloContenidoCelda = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
            cell.setPhrase(contenido);
            cell.setColspan(3);
            
            table.addCell(cell);
            
            table.addCell(cell);
            
            table.addCell(cell);
            
            table.addCell(cell);
            
            cell.setColspan(2);
            table.addCell(cell);
            
            table.addCell(cell);
            documento.add(table);

            //Actividades para el desarrollo CIERRE
            table = new PdfPTable(16);
            cell.setPaddingBottom(5);

            contenido = new Phrase("Actividades para el desarrollo de competencias", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(16);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
            contenido = new Phrase("Cierre", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(6);
            table.addCell(cell);
            contenido = new Phrase("Competencias a las que contribuye", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(6);
            table.addCell(cell);
            contenido = new Phrase("Evidencias de aprendizaje", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(2);
            cell.setRowspan(2);
            table.addCell(cell);
            contenido = new Phrase("Instrumentos de evaluación", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(2);
            cell.setRowspan(2);
            table.addCell(cell);

            contenido = new Phrase("Enseñanza", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(3);
            cell.setRowspan(1);
            table.addCell(cell);
            contenido = new Phrase("Aprendizaje", estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);
            estiloContenidoCelda = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
            contenido = new Phrase("Disciplinares", estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);
            contenido = new Phrase("Genéricas(Atributos)", estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);

            contenido = new Phrase(" ");
            cell.setBackgroundColor(BaseColor.WHITE);
            estiloContenidoCelda = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
            cell.setPhrase(contenido);
            cell.setColspan(3);
            
            table.addCell(cell);
            
            table.addCell(cell);
            
            table.addCell(cell);
            
            table.addCell(cell);
            
            cell.setColspan(2);
            table.addCell(cell);
            
            table.addCell(cell);
            documento.add(table);
            documento.add(new Paragraph("\n"));

            //RECURSOS
            table = new PdfPTable(2);
            cell.setPaddingBottom(5);

            contenido = new Phrase("Recursos materiales", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(1);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
            contenido = new Phrase("Fuentes de información", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(1);
            table.addCell(cell);
            cell.setColspan(1);
            cell.setBackgroundColor(BaseColor.WHITE);
            contenido = new Phrase(" ");
            cell.setPhrase(contenido);
            
            
            table.addCell(cell);
            table.addCell(cell);

            cell.setColspan(2);
            contenido = new Phrase("Observaciones y/o reflexiones", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
            cell.setColspan(2);
            cell.setBackgroundColor(BaseColor.WHITE);
            contenido = new Phrase(" ");
            cell.setPhrase(contenido);
            
            
            table.addCell(cell);
            documento.add(table);

            //FOOTERs
            table = new PdfPTable(3);
            cell.setColspan(3);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            contenido = new Phrase("Validación", estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);
            cell.setColspan(1);
            cell.setBackgroundColor(BaseColor.WHITE);
            estiloContenidoCelda = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.NORMAL);
            cell.setPaddingTop(50);
            contenido = new Phrase("NOMBRE Y FIRMA DEL DOCENTE(S)", estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);
            contenido = new Phrase("Vo. Bo. PRESIDENTE DE ACADEMIA", estiloContenidoCelda);
            cell.setPhrase(contenido);
            cell.setColspan(1);
            table.addCell(cell);
            contenido = new Phrase("Vo. Bo. DIRECTOR", estiloContenidoCelda);
            cell.setPhrase(contenido);
            table.addCell(cell);
            documento.add(table);

            documento.close();

        } catch (DocumentException e) {
            System.out.println("Documento repetido");
        } catch (IOException e) {
            System.out.println("Error en el archivo de salida");
        }
    }

}
