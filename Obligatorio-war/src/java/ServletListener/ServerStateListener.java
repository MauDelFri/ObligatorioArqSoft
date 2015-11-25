/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletListener;

import Negocio.AuditoriaSBLocal;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.ejb.EJB;
import javax.ws.rs.client.Client;

import javax.ws.rs.client.WebTarget;

/**
 *
 * @author martinintroini
 */
public class ServerStateListener implements Runnable {

    private Client client;
    private WebTarget target;

    public static boolean ejecutando = false;

    @EJB
    private static AuditoriaSBLocal aSessionBean;

    ServerStateListener(AuditoriaSBLocal x) {
        aSessionBean = x;
    }

    @Override
    public void run() {
        Long l = new Long("999");
        System.out.println("entra");
        this.ejecutando = true;
        while (ejecutando) {
            try {
                Thread.sleep(new Long("30000"));
                try {
                    System.out.println("entro al try");
                    URL url = new URL("http://localhost:8080/Obligatorio-war/Consultas/consultaEstado");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept", "application/json");
                    if (conn.getResponseCode() != 200) {
                        //logueo respuesta error
                        aSessionBean.logArchivo(this, l, "run", "Servidor & BBDD", false);
                    }
                        /*else{
                         // no logueo nada, lo loguea el resultado del check!
                         //aSessionBean.logArchivo(this, l, "run", "Servidor & BBDD", true);

                         }
                         */
                        conn.disconnect();

                    }catch (Exception e) {
                    System.err.println("entro al exception e");
                    try {
                        //logueo exception
                        aSessionBean.logArchivo(this, l, "run", e.getMessage(), false);
                    } catch (Exception ee) {
                        System.err.println("entro a exception en exception e");
                    }
                }

                } catch (Exception ex) {
                    System.err.println("entro al exception ex");
                    // ejecutando = false;

                }
            }
        }

    }
