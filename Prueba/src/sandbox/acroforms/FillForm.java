package sandbox.acroforms;
 
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
 
/**
 * @author Bruno Lowagie (iText Software)
 */
public class FillForm {

    public static final String SRC = "C:\\Users\\gerar\\Documents\\GitHub\\Ra\\Prueba\\src\\archivos\\secuencia2.pdf";
    public static final String DEST = "C:\\Users\\gerar\\Documents\\GitHub\\Ra\\Prueba\\src\\archivos\\certificate2.pdf";
 
    public static void main(String[] args) throws DocumentException, IOException {
        try{
            File file = new File(DEST);
            file.getParentFile().mkdirs();
            new FillForm().manipulatePdf(SRC, DEST);            
        }catch (DocumentException | IOException ex){
            System.out.print("a");            
        }
    }
    public void manipulatePdf(String src, String dest) throws DocumentException, IOException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        AcroFields form = stamper.getAcroFields();
        form.setField("numeroSecuenciaTextField", "no funciona :c ");
        stamper.setFormFlattening(true);
        stamper.close();
    }
 
}
