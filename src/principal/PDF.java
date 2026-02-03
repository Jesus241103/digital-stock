package principal;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import database.Metodos_Select;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

//GENERAR PDF PARA FACTURAS
public class PDF {

    private DefaultTableModel modelo;
    Number monto;

    //CARGA LA InFORMACION DE LOS DETALLES DE FACTURA EN EL MODELO DE LA TABLA
    public void cargarTabla(int num, String query) {
        modelo = new DefaultTableModel(new Object[]{"#", "Código", "Nombre", "Precio", "IVA %", "Cantidad"}, 0);
        Metodos_Select db = new Metodos_Select();
        db.get_det_factura(num, modelo, query);
    }

    //CARGAR LA CABECERA DE LA FACTURA, COMO FECHA, HORA, CEDULA...
    public void cargar_cabecera(Document doc, int num, String query2, String tipo) throws DocumentException {
        Object[] datos = new Metodos_Select().get_cabecera(num, query2);
        Paragraph titulo = new Paragraph("FACTURA", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));
        titulo.setAlignment(Element.ALIGN_CENTER); // esto lo centra
        doc.add(titulo);
        doc.add(new Paragraph(" "));
        doc.add(new Paragraph("Tipo: " + tipo));
        doc.add(new Paragraph("Numero de Factura: " + datos[0]));
        doc.add(new Paragraph("Fecha: " + datos[2]));
        doc.add(new Paragraph("Hora: " + datos[3]));
        doc.add(new Paragraph("Cedula: " + datos[1]));
        monto = (Number) datos[4];
        doc.add(new Paragraph(" "));
    }

    //CREAR PDF EN LA RUTA ESPECIFICADA
    public void generar(int num, String query, String query2, String tipo) {
        try {

            cargarTabla(num, query);

            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("PDF-FAC/Factura " + tipo + " N-" + num + ".pdf"));
            doc.open();
            insertarEncabezado(doc);
            cargar_cabecera(doc, num, query2, tipo); //CARGAR CABECERA

            // CREAR TABLA
            PdfPTable tabla = new PdfPTable(modelo.getColumnCount());
            tabla.setWidthPercentage(100);

            //MOSTRAR LA TABLA EN EL PDF
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                PdfPCell celda = new PdfPCell(new Paragraph(modelo.getColumnName(i)));
                celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(celda);
            }

            for (int i = 0; i < modelo.getRowCount(); i++) {
                for (int j = 0; j < modelo.getColumnCount(); j++) {
                    Object valor = modelo.getValueAt(i, j);
                    tabla.addCell(valor != null ? valor.toString() : "");
                }
            }

            doc.add(new Paragraph("Detalles de Factura:"));
            doc.add(new Paragraph(" "));
            doc.add(tabla);
            doc.add(new Paragraph(" "));
            Paragraph importe = new Paragraph("Monto total: $" + String.format("%.2f", monto.doubleValue()), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
            importe.setAlignment(Element.ALIGN_RIGHT);
            doc.add(importe);
            doc.close();

            System.out.println("PDF generado correctamente.");
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println("PDF error: " + e);
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //  CREAR LOGO E INSERTAR EN EL PDF
    public void insertarEncabezado(Document doc) throws DocumentException, IOException {
        // Ruta de las imágenes (ajústalas según tu estructura de carpetas)
        Image huawei = Image.getInstance("src/imagenes/huawei.png");
        Image walmart = Image.getInstance("src/imagenes/walmart.png");

        huawei.scaleAbsolute(50, 50);
        walmart.scaleAbsolute(50, 50);

        // Tabla para alinear imágenes y textos
        PdfPTable tabla = new PdfPTable(3);
        tabla.setWidthPercentage(100);
        tabla.setWidths(new float[]{1, 2, 1});

        // Celda 1: Huawei logo
        PdfPCell celdaHuawei = new PdfPCell(huawei, false);
        celdaHuawei.setBorder(Rectangle.NO_BORDER);
        celdaHuawei.setHorizontalAlignment(Element.ALIGN_LEFT);
        tabla.addCell(celdaHuawei);

        // Celda 2: Texto central
        Paragraph textoCentral = new Paragraph();
        BaseColor color = new BaseColor(255, 153, 0);
        textoCentral.add(new Chunk("DIGITAL ", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24)));
        textoCentral.add(new Chunk("STOCK", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, color)));

        PdfPCell celdaTexto = new PdfPCell(textoCentral);
        celdaTexto.setBorder(Rectangle.NO_BORDER);
        celdaTexto.setHorizontalAlignment(Element.ALIGN_CENTER);
        celdaTexto.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tabla.addCell(celdaTexto);

        // Celda logo
        PdfPCell celdaWalmart = new PdfPCell(walmart, false);
        celdaWalmart.setBorder(Rectangle.NO_BORDER);
        celdaWalmart.setHorizontalAlignment(Element.ALIGN_RIGHT);
        tabla.addCell(celdaWalmart);

        doc.add(tabla);

        // Línea separadora
        PdfPTable linea = new PdfPTable(1);
        linea.setWidthPercentage(100);
        PdfPCell separador = new PdfPCell();
        separador.setFixedHeight(5);
        separador.setBackgroundColor(color); // naranja
        separador.setBorder(Rectangle.NO_BORDER);
        linea.addCell(separador);
        doc.add(linea);

        // Subtítulo
        Paragraph subtitulo = new Paragraph("Control Total de tu Inventario",
                FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 14));
        subtitulo.setAlignment(Element.ALIGN_CENTER);
        doc.add(subtitulo);

        // Espacio
        doc.add(new Paragraph(" "));
    }

}
