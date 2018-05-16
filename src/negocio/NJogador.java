/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Jogador;
import java.sql.SQLException;
import java.util.ArrayList;
import observer.CBFV;
import persistencia.JogadorDAO;

/**
 *
 * @author rodri
 */
public class NJogador {
    
    public void incluir(Jogador jogador) throws SQLException{
        if(jogador.getId() != 0){
            new JogadorDAO().alterar(jogador);
        }
        else{
            new JogadorDAO().incluir(jogador);
        }
    }
    
    public void excluir(int codigo) throws SQLException{
        new JogadorDAO().excluir(codigo);
    }
    
    public Jogador consultar(int codigo) throws SQLException{
        return new JogadorDAO().consultar(codigo);
    }
    
    public ArrayList<Jogador> listar() throws SQLException{
        return new JogadorDAO().listar();
    }
}
