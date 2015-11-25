package consumidor.mensajes;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.InitialContext;
import llamadasWS.WSAmbulancias;

public class ConsumidorMensajes {

    public static void main(String[] args) {
        try {
            Properties propiedades = new Properties();
            propiedades.load(new FileInputStream("./src/consumidor/mensajes/ambulancia.properties"));
            int idAmbulancia = Integer.parseInt(propiedades.getProperty("idAmbulancia"));
            Listener.ambulancia = idAmbulancia;
            int[] colas = WSAmbulancias.GetColasSubscriptas(idAmbulancia);
            // Defino las propiedades que permiten instanciar el "contexto"
            // del servidor de aplicaciones Glassfish
            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            // Seteo las propiedades del contexto
            //Creo el Contexto para obtener los recursos del servidor
            InitialContext ic = new InitialContext(props);
            // Obtenemos a traves del servicio JNDI la ConnectionFactory del
            // servidor de aplicaciones
            ConnectionFactory connectionFactory = (ConnectionFactory) ic.lookup("ConnectionFactory");
            // Obtenemos a traves del servicio JNDI la "destination" que vamos
            // a utilizar, en este caso una Queue
            List<Connection> conexiones = new ArrayList<>();
            for (int cola : colas) {

                Topic topic = (Topic) ic.lookup("jms/Topic" + cola);
                //Creo la Connection mediante la ConnectionFactory
                Connection conexion = connectionFactory.createConnection();
                conexiones.add(conexion);
                //Creo la Session mediante la Connection
                Session session = conexion.createSession(false, Session.AUTO_ACKNOWLEDGE);
                //Creo la MessageConsumer mediante la Session
                MessageConsumer consumidorQueue = session.createConsumer(topic);
                Listener myListener = new Listener(cola);
                consumidorQueue.setMessageListener(myListener);
                // Iniciamos la recepcion de mensajes
                conexion.start();
            }
            Thread.sleep(60000);
            // Cerramos la conexion
            for (Connection conexion : conexiones) {
                conexion.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
