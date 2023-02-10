package controle;

import DAO.FuncionarioDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Funcionario;

public class FuncionarioControle {
    
    public boolean Cadastrar(Funcionario funcionario){
        boolean error = false;
         if(funcionario.getSituacao().equals("A") || funcionario.getSituacao().equals("I")){
            error = false;
        }else{
           JOptionPane.showMessageDialog(null, "O campo situacao aceita somente A - Ativo e I - Inativo");
            error = true;
        }
        if(!error){
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String data = formatter.format(new Date());
            
            funcionario.setAlteracao(data);
            funcionarioDAO.Cadastrar(funcionario);
        }
        return error;
    }
    public Funcionario Consultar(int id_funcionario) throws ClassNotFoundException{
        Funcionario funcionario = new Funcionario();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionario = funcionarioDAO.consultaId(id_funcionario);
        return funcionario;
        
    }
    public void Alterar(Funcionario funcionario) throws ClassNotFoundException{
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        if(funcionarioDAO.Alterar(funcionario)){
            JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao alterar funcionario.");
        }
        
        
    }
    
}
