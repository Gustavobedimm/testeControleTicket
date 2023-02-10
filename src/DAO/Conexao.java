package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    public ResultSet rs;
    public Connection con;
    private final String driver = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://localhost:5432/ticket_controle";
    private final String usuario = "postgres";
    private final String senha = "admin";
    
    public void Conectar() throws ClassNotFoundException {
    try {
            Class.forName("org.postgresql.Driver");
             System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public void Desconecta() {
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
