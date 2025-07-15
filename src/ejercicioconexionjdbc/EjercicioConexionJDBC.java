package ejercicioconexionjdbc;

// Importa todo el paquete java.sql que contiene clases necesarias para trabajar con bases de datos
import java.sql.*; 
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjercicioConexionJDBC {

    public static void main(String[] args) {
        
        // Datos de conexión a la base de datos
        String usuario = "root"; // Usuario de la base de datos
        String password = ""; // Contraseña de la base de datos
        String url = "jdbc:mysql://localhost:3306/ejemplo_seguridad"; // URL de conexión MYSQL
        Connection conexion;  // Representa la conexión entre Java y la base de datos.
        Statement statement;  // Permite ejecutar sentencias SQL (como SELECT, INSERT, UPDATE, DELETE).
        ResultSet rs;         // Almacena los resultados devueltos por una consulta SELECT.
        
        try {
            //

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EjercicioConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // Establecer conexión con la base de datos
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
          
            // Inserta un nuevo artista en la tabla ARTISTA
            statement.executeUpdate("INSERT INTO ARTISTA(NOMBRE, GENERO_MUSICAL) VALUES('gisell', 'Saya')");
              // Ejecutar consulta para obtener todos los artistas
            rs = statement.executeQuery("SELECT * FROM ARTISTA");
            // Esto lanzará errore si no hay datos en la tabla
            rs.next(); // mover al primer registro
            
            do {
            // Imprime el ID del artista y su nombre desde el resultado de la consulta.
            System.out.println(rs.getInt("ID_Artista") + " : " + rs.getString("Nombre"));

            } while (rs.next()); // Avanza al siguiente registro. El ciclo continúa mientras haya más filas.


        } catch (SQLException ex) {
            Logger.getLogger(EjercicioConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
