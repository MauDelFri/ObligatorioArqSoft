package JMS;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;

public class ProductorMensajes {

    public static void ProducirMensaje(String mensaje, String nombreTopic) {
        try {
            //Seteo las Properties para el contexto
            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            //Creo el Contexto para obtener los recursos del servidor
            InitialContext ic = new InitialContext(props);
            // Obtenemos a traves del servicio JNDI la ConnectionFactory del
            // servidor de aplicaciones
            ConnectionFactory connectionFactory = (ConnectionFactory) ic.lookup("ConnectionFactory");
            // Obtenemos a traves del servicio JNDI la "destination" que vamos
            // a utilizar, en este caso una Queue
            Topic topic = (Topic) ic.lookup(nombreTopic);
            //Creo la Connection mediante la ConnectionFactory
            Connection connection = connectionFactory.createConnection();
            //Creo la Session mediante la Connection
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //Creo la MessageProducer mediante la Session
            MessageProducer messageProducer = session.createProducer(topic);
            //Creo la TextMessage mediante la Session
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText(mensaje);
            //Envío el mensaje mediante MessageProducer
            messageProducer.send(textMessage);
        } catch (Exception ex) {
            Logger.getLogger(ProductorMensajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
