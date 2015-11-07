
package Obligatorio.beans;

import Obligatorio.entidades.Ambulancia;
import Obligatorio.entidades.Emergencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class AccesoDatos implements AccesoDatosLocal {
    private Connection conexion;
    
    public Connection getConexion() {
        return conexion;
    }

    
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public AccesoDatos Conectar() {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
            conexion= DriverManager.getConnection(BaseDeDatos,"admin","admin");
            if(conexion!=null) {
                System.out.println("Conexion exitosa a esquema admin");
            }
            else {
                System.out.println("Conexion fallida");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return this;
    }
    
    public void AltaEmergencia(Emergencia nuevaEmergencia) {
        if(conexion == null){
            Conectar();
        }
        String fechaSolicitada = DateFormat.getDateInstance().format(new Date());
        String query = "INSERT INTO EMERGENCIA(emergencia_personaid,emergencia_FechaSolicitada,emergencia_CalcPerfil,emergencia_UrgenciaSolicitada,emergencia_ambulanciaID,emergencia_UrgenciaResuelta) VALUES(";
        query += nuevaEmergencia.getPersona().getPersonaID() + "," + fechaSolicitada + ",1,1,1,0)";
        try{
            Statement sentencia = conexion.createStatement();
            sentencia.execute(query);
            sentencia.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
