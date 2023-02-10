
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Funcionario;




public class FuncionarioDAO {
    Conexao conexao = new Conexao();
    public void Cadastrar(Funcionario funcionario){
        
        try {
            conexao.Conectar();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o Banco de dados.");
        }
        try {
            PreparedStatement pst;
            pst = conexao.con.prepareStatement("insert into funcionario (id,nome,cpf,situacao,data_alteracao) values(?,?,?,?,?)");

            pst.setInt(1, funcionario.getId());
            pst.setString(2, funcionario.getNome());
            pst.setString(3, funcionario.getCpf());
            pst.setString(4, funcionario.getSituacao());
            pst.setString(5, funcionario.getAlteracao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar.\n Erro: " + ex.getMessage());
        }
        conexao.Desconecta();
        
    }
    public Funcionario consultaId(int id_funcionario) throws ClassNotFoundException {
        conexao.Conectar();
        Funcionario funcionario = new Funcionario();
        try {
            String query = "select * from funcionario where id = '" + id_funcionario + "'";
            PreparedStatement pst;
            ResultSet rs;
            pst = conexao.con.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setSituacao(rs.getString("situacao"));
                funcionario.setAlteracao(rs.getString("data_alteracao"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na Conexão com o Banco " + e);
        }
        conexao.Desconecta();
        return funcionario;
    }
    public boolean Alterar(Funcionario funcionario) throws ClassNotFoundException {
        conexao.Conectar();
        try {
            //CPF NOME SITUACAO
            String query = "update funcionario set nome = '" + funcionario.getNome()+ "' , cpf = '" + funcionario.getCpf()+"' , situacao = '"+funcionario.getSituacao() + "' where id = '" + funcionario.getId()+ "'";
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
    
}
