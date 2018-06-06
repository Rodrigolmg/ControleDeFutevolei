/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Jogador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import observer.CBFV;
import persistencia.PJogador;

/**
 *
 * @author rodri
 */
public class NJogador {
    
    public void incluir(Jogador jogador) throws SQLException{
        if(jogador.getId() != 0){
            new PJogador().alterar(jogador);
        }
        else{
            new PJogador().incluir(jogador);
        }
    }
    
    public void excluir(int codigo) throws SQLException{
        new PJogador().excluir(codigo);
    }
    
    public Jogador consultar(int codigo) throws SQLException{
        return new PJogador().consultar(codigo);
    }
    
    public Iterator<Jogador> listar() throws SQLException{
        return new PJogador().listar();
    }
}
