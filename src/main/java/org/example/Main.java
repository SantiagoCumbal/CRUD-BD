package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/EstudiantesA24";
        String usser = "root";
        String pass = "123456";
        PreparedStatement pstmt=null;
        Connection connection =null;
        try {
            connection = DriverManager.getConnection(url,usser,pass);
            System.out.println("Conexion establecida");
            String sql="Update estudiantesA set b1 = ? where cedula = ?";
            pstmt=connection.prepareStatement(sql);
            //seteamos los valores de la sentencia previa
            pstmt.setInt(1,0);
            pstmt.setString(2,"3300010840");
            pstmt.executeUpdate();

            //cuenta las lineas de codigo
            int n=pstmt.getUpdateCount();
            System.out.println("Se modificaron estas lineas de codigo: "+n);


        }catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            //Cerrar la conexion
            try{
                if(pstmt!=null){
                    pstmt.close();
                }
                if (connection!=null){
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }

    }
}