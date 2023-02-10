
package controle;

import DAO.TicketDAO;
import javax.swing.JOptionPane;
import modelo.Ticket;

public class TicketControle {
    public boolean Cadastrar(Ticket ticket){
        boolean error = false;
         if(ticket.getSituacao().equals("A") || ticket.getSituacao().equals("I")){
            error = false;
        }else{
           JOptionPane.showMessageDialog(null, "O campo situacao aceita somente A - Ativo e I - Inativo");
            error = true;
        }
        if(!error){
            TicketDAO ticketDAO = new TicketDAO();
            ticketDAO.Cadastrar(ticket);
        }
        return error;
    }
    public Ticket Consultar(int id_ticket) throws ClassNotFoundException{
        Ticket ticket = new Ticket();
        TicketDAO ticketDAO = new TicketDAO();
        ticket = ticketDAO.consultaId(id_ticket);
        return ticket;
        
    }
    public void Alterar(Ticket ticketParametro) throws ClassNotFoundException { 
        TicketDAO ticketDAO = new TicketDAO();
        if(ticketDAO.Alterar(ticketParametro)){
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao alterar ticket");
        }
        
    }
    
}
