package logger;

import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

    public static void logArchivo(Object claseOrigen, Long colaID, String funcionalidad, String mensaje) {
        Logger logger2 = Logger.getLogger(claseOrigen.getClass());
        URL url = Log.class.getResource("Log4j.properties");
        PropertyConfigurator.configure(url);
        logger2.info("Cola: " + colaID + " Funcoinalidad: " + claseOrigen.getClass() + "." + funcionalidad + " Observacion: " + mensaje);
    }
}
