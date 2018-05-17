/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricasconcretas;

import entidades.Jogador;
import entidades.Torneio;
import java.util.ArrayList;
import persistencia.PJogador;
import fabricaabstrata.CategoriaAbstrata;
import persistencia.PTorneio;

/**
 *
 * @author rodri
 */
public class CategoriaC extends CategoriaAbstrata{
    
    public CategoriaC(){
        idCat = 3;
        descricao = "C";
    }

    @Override
    public ArrayList<Jogador> getListaJogadores() {
        try {
            return new PJogador().listarNomes(idCat);
        } catch (Exception e) {
            return null;
        } 
    }

    @Override
    public ArrayList<Torneio> getListaTorneios() {
        try {
            return new PTorneio().listarDescricao(idCat);
        } catch (Exception e) {
            return null;
        }
    }
    
}
