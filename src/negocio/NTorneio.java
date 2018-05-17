/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import entidades.Torneio;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PTorneio;

/**
 *
 * @author rodri
 */
public class NTorneio {
    
    public void incluir(Torneio torneio) throws SQLException{
        if(torneio.getId() != 0) new PTorneio().alterar(torneio);
        else new PTorneio().incluir(torneio);
    }
    
    public void excluir(int codigo) throws SQLException{
        new PTorneio().excluir(codigo);
    }
    
    public Torneio consultar(int codigo) throws SQLException{
        return new PTorneio().consultar(codigo);
    }
    
    public ArrayList<Torneio> listar() throws SQLException{
        return new PTorneio().listar();
    } 
}
