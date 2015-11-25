package llamadasWS;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class WSAmbulancias {

    public static boolean AtenderEmergencia(long ambulanciaID, long emergenciaID) {
        try {
            URL url = new URL("http://localhost:8080/Obligatorio-war/ambulancias/atenderEmergencia");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            DataOutputStream printout = new DataOutputStream(conn.getOutputStream());
            String content
                    = "idEmergencia=" + URLEncoder.encode(Encriptar("" + emergenciaID), "UTF-8")
                    + "&idAmbulancia=" + URLEncoder.encode(Encriptar("" + ambulanciaID), "UTF-8");
            printout.writeBytes(content);
            printout.flush();
            printout.close();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return false;
            }
            conn.disconnect();
            return true;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void EmergenciaResuelta(Date fechaResuelta, int urgenciaResuelta, long emergenciaID, long colaID) {
        try {
            URL url = new URL("http://localhost:8080/Obligatorio-war/ambulancias/emergenciaResuelta");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            DataOutputStream printout = new DataOutputStream(conn.getOutputStream());
            String content
                    = "fechaResuelta=" + URLEncoder.encode(Encriptar(new SimpleDateFormat("dd/MM/yyyy").format(fechaResuelta)), "UTF-8")
                    + "&urgenciaResuelta=" + URLEncoder.encode(Encriptar("" + urgenciaResuelta), "UTF-8")
                    + "&idEmergencia=" + URLEncoder.encode(Encriptar("" + emergenciaID), "UTF-8")
                    + "&idColaEmergencia=" + URLEncoder.encode(Encriptar("" + colaID), "UTF-8");
            printout.writeBytes(content);
            printout.flush();
            printout.close();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] GetColasSubscriptas(long ambulanciaID) {
        String output = "";
        try {
            URL url = new URL("http://localhost:8080/Obligatorio-war/ambulancias/getColasSubscripcion?idAmbulancia=" + ambulanciaID);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() != HttpURLConnection.HTTP_ACCEPTED) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String temp = "";
            while ((temp = br.readLine()) != null) {
                output += temp;
            }
            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        output = output.replace("[", "");
        output = output.replace("]", "");

        int[] retorno = Arrays.stream(output.split(",")).mapToInt(Integer::parseInt).toArray();;
        return retorno;
    }

    public static String Encriptar(String texto) {

        String secretKey = "arquitecturasoftware"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.getEncoder().encode(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
        }

        return base64EncryptedString;
    }
}
