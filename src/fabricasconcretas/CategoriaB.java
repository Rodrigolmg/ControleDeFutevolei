/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricasconcretas;

import entidades.Jogador;
import entidades.Torneio;
import java.util.ArrayList;
import persistencia.JogadorDAO;
import fabricaabstrata.CategoriaAbstrata;
import persistencia.TorneioDAO;

/**
 *
 * @author rodri
 */
public class CategoriaB extends CategoriaAbstrata{

    public CategoriaB() {
        idCat = 2;
        descricao = "B";
    }
    
    @Override
    public ArrayList<Jogador> getListaJogadores() {
        try {
            return new JogadorDAO().listarNomes(idCat);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Torneio> getListaTorneios() {
        try {
            return new TorneioDAO().listarDescricao(idCat);
        } catch (Exception e) {
            return null;
        }
    }
    
}
