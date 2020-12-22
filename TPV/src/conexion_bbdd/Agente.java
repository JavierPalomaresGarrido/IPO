package conexion_bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase Agente
 */
public class Agente {
    //Atributos de la clase
    protected static Agente mInstancia=null;
    public Connection mBD;
    
    //Atributos pertenecientes a la conexión
    private static final String NOMBRE_BBDD="TPV_BBDD";

    
    /**
     * Constructor de la clase
     * @throws Exception
     */
    protected Agente() throws Exception {
        Class.forName("org.sqlite.JDBC").newInstance();
        mBD = DriverManager.getConnection("jdbc:sqlite:"+ NOMBRE_BBDD + ".db");
    }
    
    /**
     * Método destinado a la obtención del 
     * Objeto Agente desde otras clases
     * @return Objeto Agente
     * @throws Exception 
     */
    public static Agente getAgente() throws Exception {
        if (mInstancia==null) {
            mInstancia=new Agente();
        }
        return mInstancia;
    }
    
    public void desconectar(){
        try {
            mBD.close();
        } catch (SQLException ex) {
            System.out.println("[ Ambugest ] >> Error al desconectarse de la base de datos : "+ex.getMessage());
        }
    }
}
