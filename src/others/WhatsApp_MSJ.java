package others;

import java.awt.Desktop;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public class WhatsApp_MSJ {

    public void generarMensajeFactura(String numeroTelefono) {
        // Mensaje predeterminado listo para ser enviado
        String mensaje = "Estimado usuario,\na continuación se le adjuntará la factura, le agradecemos por su preferencia, el equipo de Digital Stock.";

        try {
            // Codificar el mensaje para que sea seguro en la URL
            String mensajeCodificado = URLEncoder.encode(mensaje, "UTF-8");

            // Construir la URL completa de WhatsApp "Click to Chat"
            String urlWhatsApp = "https://wa.me/" + numeroTelefono + "?text=" + mensajeCodificado;

            // Intentar abrir la URL en el navegador predeterminado
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(urlWhatsApp));
                System.out.println("WhatsApp abierto para el número: " + numeroTelefono + ". Mensaje listo para enviar.");
            } else {
                // En caso de que Desktop API no sea compatible (ej. entorno sin GUI)
                System.out.println("No se pudo abrir el navegador. Por favor, abre la siguiente URL manualmente:");
                System.out.println(urlWhatsApp);
            }

        } catch (UnsupportedEncodingException e) {
            System.err.println("Error al codificar el mensaje: " + e.getMessage());
        } catch (IOException | URISyntaxException e) {
            System.err.println("Error al intentar abrir WhatsApp: " + e.getMessage());
        }
    }

}
