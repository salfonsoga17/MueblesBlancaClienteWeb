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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import mueblesblanca.dao.Conexion;
import mueblesblanca.dao.ConexionSQL;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Alexis Holguin github:MoraHol
 */
public class PDFCreator {
//        static { /* works fine! ! */
//            System.setProperty("java.awt.headless", "true");
//            System.out.println(java.awt.GraphicsEnvironment.isHeadless());
//            /* ---> prints true */
//          }

    public void reporteOrdenCompra(int pIdOrdenCompra) {
        try {

            try {
                Connection conection;
//                Drive de conexión
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                Colocamos el servidor sql, nombre de nuestra base de datos, usuario y password
//                String conectionURL = "jdbc:sqlserver://SERGIO:1433;databasename=Bd_MueblesBlanca";
//                this.usuario = "root"; this.password = "";
                String conectionURL = "jdbc:sqlserver://SERGIO:1433;databasename=Bd_MueblesBlanca";
//                String conectionURL = "jdbc:sqlserver://172.16.1.64:1433;databasename=Bd_MueblesBlanca";
                String usuario = "blanca";
                String password = "123456";

                conection = DriverManager.getConnection(conectionURL, usuario, password);
                //Genera reporte 
                File reporte = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/OrdenCompra.jasper")) ;
                
                Map<String,Object> parametro = new HashMap<String,Object>();
                parametro.put("IdOrdenCompra", pIdOrdenCompra);
                
                JasperPrint j = JasperFillManager.fillReport(reporte.getPath(), parametro, conection);

                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                response.addHeader("Content-disposition", "attachment; filename=jsfReporte.pdf");
                ServletOutputStream stream = response.getOutputStream();
                JasperExportManager.exportReportToPdfStream(j, stream);
                
                stream.flush();
                stream.close();
                FacesContext.getCurrentInstance().responseComplete();
                conection.close();
                
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("ConexionSQL - ERROR: " + e.getMessage());
                throw e;
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar el reporte " + e);
        }
    }   
    
    
    public void VerOrdenCompra(int pIdOrdenCompra) {
        try {

            try {
                Connection conection;
//                Drive de conexión
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String conectionURL = "jdbc:sqlserver://SERGIO:1433;databasename=Bd_MueblesBlanca";
                String usuario = "blanca";
                String password = "123456";

                conection = DriverManager.getConnection(conectionURL, usuario, password);
                //Genera reporte 
                File reporte = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/OrdenCompra.jasper")) ;
                
                Map<String,Object> parametro = new HashMap<String,Object>();
                parametro.put("IdOrdenCompra", pIdOrdenCompra);
                
                byte[] bytes= JasperRunManager.runReportToPdf(reporte.getPath(), parametro,conection);

                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream outStream = response.getOutputStream();
                outStream.write(bytes,0,bytes.length);
                outStream.flush();
                outStream.close();
                
                FacesContext.getCurrentInstance().responseComplete();
                conection.close();
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("ConexionSQL - ERROR: " + e.getMessage());
                throw e;
            }

        } catch (Exception e) {
            System.out.println("Error al mostrar el reporte " + e);
        }
    }

}
