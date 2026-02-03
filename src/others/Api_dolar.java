package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import java.time.OffsetDateTime;

public class Api_dolar {

    public Api_dolar() {
        mostrarDatosDolar();
    }

    private float precio_dolar;
    private String fecha;

    public float getPrecio_dolar() {
        return precio_dolar;
    }

    public void setPrecio_dolar(float precio_dolar) {
        this.precio_dolar = precio_dolar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void mostrarDatosDolar() {
        try {
            String apiUrl = "https://ve.dolarapi.com/v1/dolares/oficial";
            @SuppressWarnings("deprecation")
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Error HTTP: " + conn.getResponseCode());
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                response.append(linea);
            }

            conn.disconnect();

            // Parsear JSON con org.json
            JSONObject json = new JSONObject(response.toString());

            // Extraer valores
            float promedio = (float) json.getDouble("promedio");
            String fechaActualizacion = json.getString("fechaActualizacion");

            // Parsear la fecha ISO y extraer solo la parte de la fecha
            OffsetDateTime fechaISO = OffsetDateTime.parse(fechaActualizacion);
            String soloFecha = fechaISO.toLocalDate().toString(); // Resultado: "2025-07-08"

            // Asignar a atributos
            setPrecio_dolar(promedio);
            setFecha(soloFecha);

            // Mostrar en consola
            System.out.println("📊 Datos del dólar oficial:");
            System.out.println("Precio: " + getPrecio_dolar());
            System.out.println("Fecha: " + getFecha());

        } catch (IOException e) {
            System.out.println("❌ Error al consumir la API:");
        } catch (JSONException e) {
            System.out.println("❌ Error al procesar la respuesta:");
        }
    }
}