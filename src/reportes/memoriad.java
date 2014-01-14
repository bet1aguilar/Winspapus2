/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
 

 
import java.sql.*;
import javax.swing.ImageIcon;

public class memoriad extends PdfPageEventHelper{
    String mpres;
    Connection conex;
    private String strNombreDelPDF;
    String strRotuloPDF;
   String sql,memo,timemo,fecmemo,nombrep,nombrec,ubicac;
   byte[] leidos;
   Image im=null;
   Blob bytes=null;
   ImageIcon image=null;
    Color grisClaro = new Color( 230,230,230); 
    Color azulClaro = new Color( 124,195,255 );
    private Font fuenteAzul25= new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD);
    
    public memoriad(String mpres, Connection conex){
        try {
            this.mpres=mpres;
            this.conex=conex;
            fuenteAzul25.setColor(BaseColor.BLUE);
            generarpdf();
            
        } catch (DocumentException ex) {
            Logger.getLogger(presupuestogeneral.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    public final void generarpdf() throws DocumentException{
        FileOutputStream archivo = null;
        try {
            
            sql="select p.memo,p.timemo,p.fecmemo,p.nombre,p.ubicac,c.nombre, c.logo"
                    + " from mpres p, mconts c where p.id='"+mpres+"' "
                    + "and p.codcon=c.id";
            try {
                Statement st=(Statement) conex.createStatement();
                ResultSet rst=st.executeQuery(sql);
                while(rst.next()) {
                   memo=rst.getString(1);
                   timemo=rst.getString(2);
                   fecmemo=rst.getString(3);
                   nombrep=rst.getString(4);
                   nombrec=rst.getString(5);  
                   bytes = rst.getBlob("c.logo");
                }              
            } catch (SQLException ex) {
                Logger.getLogger(memoriad.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if(bytes!=null){
                leidos = bytes.getBytes(1, (int) bytes.length());
                image = new ImageIcon(leidos);
                
                try {
                    
                    im = Image.getInstance(leidos);
                    //im.setAbsolutePosition(5,5);
                } catch (BadElementException ex) {
                    Logger.getLogger(memoriad.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(memoriad.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(memoriad.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            } catch (SQLException ex) {
                Logger.getLogger(memoriad.class.getName()).log(Level.SEVERE, null, ex);
            }
            archivo = new FileOutputStream("memoria.pdf");
            Document documento = new Document();
            PdfWriter writer = PdfWriter.getInstance(documento, archivo);
            writer.setPageEvent(this);
            documento.open();
            agregarContenido(documento, writer);
            documento.close();
            PdfReader reader;
            try {
                reader = new PdfReader("memoria.pdf");
            } catch (IOException ex) {
                Logger.getLogger(presupuestogeneral.class.getName()).log(Level.SEVERE, null, ex);
            }
           File file = new File("memoria.pdf");
            try {
                Desktop.getDesktop().open(file);
                file.deleteOnExit();
            } catch (IOException ex) {
                Logger.getLogger(presupuestogeneral.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(presupuestogeneral.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
   private void agregarContenido(Document document, PdfWriter writer) throws DocumentException
    {
        Paragraph ParrafoHoja = new Paragraph();
           Paragraph ParrafoHoja1 = new Paragraph();     
           Rectangle page = document.getPageSize();
           
           im.setAlignment(Image.TEXTWRAP);
         
          document.right();
           ParrafoHoja1.add(im);
           
        // Agregamos una linea en blanco al principio del documento
       if(bytes!=null)
        agregarLineasEnBlanco(ParrafoHoja1, 5);
       
        ParrafoHoja1.setAlignment(0);
        ParrafoHoja1.add(new Paragraph(timemo.toUpperCase (), fuenteAzul25) );
        document.add(ParrafoHoja1);
        agregarLineasEnBlanco(ParrafoHoja, 1);
        ParrafoHoja.setAlignment(0);
        // 1.- AGREGAMOS LA TABLA
     ParrafoHoja.add(new Paragraph(fecmemo, fuenteAzul25));
     
        agregarLineasEnBlanco(ParrafoHoja, 2);
         ParrafoHoja.add(new Paragraph(memo, fuenteAzul25) );
        // 2.- AGREGAMOS LA IMAGEN
        try
        {
           /* Image im = Image.getInstance("logo_mysql.gif");
            im.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP );
            im.setWidthPercentage (50);
          ParrafoHoja.add(im);*/
        }
        catch(Exception e)
        {
        }
         
        document.add(ParrafoHoja);
 
    }
    private static void agregarLineasEnBlanco(Paragraph parrafo, int nLineas)
    {
        for (int i = 0; i < nLineas; i++)
            parrafo.add(new Paragraph(" "));
    }
    
}
