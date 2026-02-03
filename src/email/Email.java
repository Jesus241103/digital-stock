package email; // Tu paquete según lo solicitado

import java.io.File;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane; // Puedes optar por eliminarlo si no usas Swing para notificaciones

public class Email {

    private static final String EMAIL_FROM = "digitalstock2025ve@gmail.com"; // Tu dirección de correo de remitente
    private static final String PASSWORD_FROM = "bjyk wpbj wtni tpzm"; // Tu contraseña (de aplicación si usas 2FA)

    private Properties mProperties;
    private Session mSession;

    public Email() {
        mProperties = new Properties();
        // Configuración estándar para Gmail SMTP
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587"); // Puerto estándar para STARTTLS
        mProperties.setProperty("mail.smtp.user", EMAIL_FROM);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); // Protocolo de seguridad
        mProperties.setProperty("mail.smtp.auth", "true"); // Habilitar autenticación

        mSession = Session.getDefaultInstance(mProperties);
    }

    public boolean enviarEmailConPdf(String emailTo, String pdfFilePath, String subject, String content) {
        try {
            // Crear el mensaje de correo
            MimeMessage mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(EMAIL_FROM)); // Remitente
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo)); // Destinatario
            mCorreo.setSubject(subject); // Asunto

            // Crear el cuerpo del mensaje que puede contener múltiples partes (texto y adjuntos)
            MimeMultipart multipart = new MimeMultipart();

            // Parte 1: El contenido de texto/HTML del correo
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(content, "text/html; charset=ISO-8859-1"); // Ajusta a "text/plain" si no es HTML
            multipart.addBodyPart(messageBodyPart);

            // Parte 2: El archivo adjunto (PDF)
            MimeBodyPart attachPart = new MimeBodyPart();
            File file = new File(pdfFilePath);

            if (!file.exists()) {
                // Notificar si el archivo no existe
                JOptionPane.showMessageDialog(null, "Error: El archivo PDF no se encontró en la ruta especificada: " + pdfFilePath);
                Logger.getLogger(Email.class.getName()).log(Level.SEVERE, "Archivo PDF no encontrado: {0}", pdfFilePath);
                return false;
            }

            // Adjuntar el archivo PDF
            FileDataSource fds = new FileDataSource(file);
            attachPart.setDataHandler(new DataHandler(fds));
            attachPart.setFileName(file.getName()); // Nombre que tendrá el archivo adjunto en el email
            multipart.addBodyPart(attachPart);

            // Establecer el contenido multipart al mensaje
            mCorreo.setContent(multipart);

            // Enviar el correo electrónico
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(EMAIL_FROM, PASSWORD_FROM); // Conectar con credenciales
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO)); // Enviar a los destinatarios "TO"
            mTransport.close(); // Cerrar la conexión

            // Notificación de éxito
            JOptionPane.showMessageDialog(null, "Factura enviada con éxito a: " + emailTo);
            return true;

        } catch (AddressException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, "Error en la dirección de correo", ex);
            JOptionPane.showMessageDialog(null, "Error en la dirección de correo: " + ex.getMessage());
            return false;
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, "Proveedor de correo no encontrado", ex);
            JOptionPane.showMessageDialog(null, "Error: No se encontró el proveedor de correo (SMTP).");
            return false;
        } catch (MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, "Error al enviar el mensaje", ex);
            JOptionPane.showMessageDialog(null, "Error al enviar el correo: " + ex.getMessage() + "\nVerifica tus credenciales y configuración del servidor.");
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, "Ocurrió un error inesperado al enviar el correo", ex);
            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + ex.getMessage());
            return false;
        }
    }

    public void generar_email(String entidad, String email, int id){
        String aux;
        if(entidad.equalsIgnoreCase("proveedor"))
            aux = "Compra";        
        else 
            aux = "Venta";
        String destinatarioPrueba = email; // <-- ¡CAMBIA ESTO AL CORREO DEL DESTINATARIO REAL!
        String rutaPdfPrueba = "PDF-FAC/Factura "+aux+" N-"+id+".pdf"; // <-- ¡CAMBIA ESTO A LA RUTA REAL DE UN PDF EN TU SISTEMA!
        // Asegúrate de que este archivo exista para la prueba.
        String asuntoPrueba = "Factura de Digital Stock - No. 148";
        String contenidoPrueba = "<html><body>"
                + "Estimado "+entidad+",<br><br>"
                + "Le adjuntamos su factura reciente de <b>Digital Stock</b>.<br>"
                + "Gracias por su preferencia.<br><br>"
                + "Saludos cordiales,<br>"
                + "El equipo de Digital Stock"
                + "</body></html>";
        // --- FIN PARÁMETROS DE PRUEBA ---

        System.out.println("Intentando enviar correo...");
        boolean enviadoExitosamente = enviarEmailConPdf(destinatarioPrueba, rutaPdfPrueba, asuntoPrueba, contenidoPrueba);

        if (enviadoExitosamente) {
            System.out.println("El correo de prueba ha sido enviado exitosamente.");
        } else {
            System.out.println("Fallo al enviar el correo de prueba. Revisa los logs y las credenciales.");
        }

    }
}
