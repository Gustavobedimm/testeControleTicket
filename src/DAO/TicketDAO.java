
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Ticket;



public class TicketDAO {
    Conexao conexao = new Conexao();
    public void Cadastrar(Ticket ticket){
        
        try {
            conexao.Conectar();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o Banco de dados.");
        }
        try {
            PreparedStatement pst;
            pst = conexao.con.prepareStatement("insert into ticket (id_ticket,id_func,quantidade,situacao,data_entrega) values(?,?,?,?,?)");

            pst.setInt(1, ticket.getId());
            pst.setInt(2, ticket.getIdFuncionario());
            pst.setInt(3, ticket.getQuantidade());
            pst.setString(4, ticket.getSituacao());
            pst.setString(5, ticket.getDataEntrega());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar.\n Erro: " + ex.getMessage());
        }
        conexao.Desconecta();
        
    }
    public Ticket consultaId(int id_ticket) throws ClassNotFoundException {
        conexao.Conectar();
        Ticket ticket = new Ticket();
        try {
            String query = "select * from ticket where id_ticket = '" + id_ticket + "'";
            PreparedStatement pst;
            ResultSet rs;
            pst = conexao.con.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                ticket.setId(rs.getInt("id_ticket"));
                ticket.setIdFuncionario(rs.getInt("id_func"));
                ticket.setQuantidade(rs.getInt("quantidade"));
                ticket.setSituacao(rs.getString("situacao"));
                ticket.setDataEntrega(rs.getString("data_entrega"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na Conexão com o Banco " + e);
        }
        conexao.Desconecta();
        return ticket;
    }
    public boolean Alterar(Ticket ticket) throws ClassNotFoundException {
        conexao.Conectar();
        try {
            String query = "update ticket set quantidade = '" + ticket.getQuantidade()+ "' , situacao = '" + ticket.getSituacao() +"' "
                    + ""
                    + ""
                    + ""
                    + ""+ "where id_ticket = '" + ticket.getId()+ "'";
            PreparedStatement pst;
            pst = conexao.con.prepareStatement(query);
            pst.executeUpdate();
            conexao.Desconecta();
            return true;
        } catch (SQLException e) {
            conexao.Desconecta();
            System.out.println("Erro na Conexão com o Banco " + e);
            return false;
        }
    }
    public ArrayList todosTickets() throws ClassNotFoundException {
        conexao.Conectar();
        ArrayList<Ticket> Alltickets = new ArrayList();
        try {
            String query = "SELECT * FROM ticket order by data_entrega";
            PreparedStatement pst;
            ResultSet rs;
            pst = conexao.con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket();

                ticket.setId(rs.getInt("id_ticket"));
                ticket.setIdFuncionario(rs.getInt("id_func"));
                ticket.setQuantidade(rs.getInt("quantidade"));
                ticket.setSituacao(rs.getString("situacao"));
                ticket.setDataEntrega(rs.getString("data_entrega"));

                Alltickets.add(ticket);
            }
        } catch (SQLException e) {
            System.out.println("Erro na Conexão com o Banco " + e);
        }
        conexao.Desconecta();
        return Alltickets;
    }
    public ArrayList todosTicketsPorFuncionario(int id_funcionario) throws ClassNotFoundException {
        conexao.Conectar();
        ArrayList<Ticket> Alltickets = new ArrayList();
        try {
            String query = "SELECT * FROM ticket where id_func = '"+id_funcionario+"'" +" order by data_entrega" ;
            PreparedStatement pst;
            ResultSet rs;
            pst = conexao.con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket();

                ticket.setId(rs.getInt("id_ticket"));
                ticket.setIdFuncionario(rs.getInt("id_func"));
                ticket.setQuantidade(rs.getInt("quantidade"));
                ticket.setSituacao(rs.getString("situacao"));
                ticket.setDataEntrega(rs.getString("data_entrega"));

                Alltickets.add(ticket);
            }
        } catch (SQLException e) {
            System.out.println("Erro na Conexão com o Banco " + e);
        }
        conexao.Desconecta();
        return Alltickets;
    }
}
