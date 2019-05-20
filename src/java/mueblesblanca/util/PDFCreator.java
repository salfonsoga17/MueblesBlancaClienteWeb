/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mueblesblanca.util;

import mueblesblanca.vo.OrdenCompraVO;
import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.layout.Document; 
import com.itextpdf.layout.element.Paragraph;  
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Alexis Holguin github:MoraHol
 */
public class PDFCreator {
    public void generateBill(String route, OrdenCompraVO ordenCompra) throws FileNotFoundException, IOException{
        try (PdfWriter writer = new PdfWriter(route); PdfDocument pdf = new PdfDocument(writer); Document document = new Document(pdf)) {
            String para1 = "Tutorials Point originated from the idea that there exists"
                    + " a class of readers who respond better to online content and prefer to learn "
                    + "new skills at their own pace from the comforts of their drawing rooms.";
            Paragraph p1 = new Paragraph(para1);
            
            document.add(p1);
        }
        System.out.println("document saved");
    }
}
