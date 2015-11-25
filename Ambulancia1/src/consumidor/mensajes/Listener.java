package consumidor.mensajes;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import llamadasWS.WSAmbulancias;
import logger.Log;

public class Listener implements MessageListener {

    private static boolean disponible = true;
    private final Lock _mutex = new ReentrantLock(true);
    public static int ambulancia = 1;
    private int cola = 1;

    public Listener(int cola) {
        this.cola = cola;
    }

    @Override
    public void onMessage(Message msg) {
        try {
            //Verifico el tipo de mensaje
            if (msg instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) msg;
                //Asigno el procesamiento del mensaje
                _mutex.lock();
                if (disponible) {
                    disponible = false;

                    int emergencia = Integer.parseInt(textMessage.getText().split(" ")[1]);
                    Log.logArchivo(this, (long) cola, "onMessage", "Nueva emergencia: " + emergencia);
                    System.out.println("Nueva emergencia: " + emergencia);
                    disponible = !WSAmbulancias.AtenderEmergencia(ambulancia, emergencia);

                    if (!disponible) {
                        Log.logArchivo(this, (long) cola, "onMessage", "Tomé emergencia: " + emergencia);
                        System.out.println("Tomé emergencia: " + emergencia);
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        WSAmbulancias.EmergenciaResuelta(new Date(), ThreadLocalRandom.current().nextInt(1, 5 + 1), emergencia, cola);
                        Log.logArchivo(this, (long) cola, "onMessage", "Resolví emergencia: " + emergencia);
                        System.out.println("Resolví emergencia: " + emergencia);
                        disponible = true;
                    }
                }
                _mutex.unlock();
            }
        } catch (JMSException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
