/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import entidades.Torneio;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.TorneioDAO;

/**
 *
 * @author rodri
 */
public class NTorneio {
    
    public void incluir(Torneio torneio) throws SQLException{
        if(torneio.getId() != 0) new TorneioDAO().alterar(torneio);
        else new TorneioDAO().incluir(torneio);
    }
    
    public void excluir(int codigo) throws SQLException{
        new TorneioDAO().excluir(codigo);
    }
    
    public Torneio consultar(int codigo) throws SQLException{
        return new TorneioDAO().consultar(codigo);
    }
    
    public ArrayList<Torneio> listar() throws SQLException{
        return new TorneioDAO().listar();
    } 
}
