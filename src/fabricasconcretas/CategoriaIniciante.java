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
import java.util.Iterator;
import persistencia.PTorneio;

/**
 *
 * @author rodri
 */
public class CategoriaIniciante extends CategoriaAbstrata{
    
    public CategoriaIniciante(){
        idCat = 4;
        descricao = "Iniciante";
    }

    @Override
    public Iterator<Jogador> getListaJogadores() {
        try {
            return new PJogador().listarDescricao(idCat);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Iterator<Torneio> getListaTorneios() {
        try {
            return new PTorneio().listarDescricao(idCat);
        } catch (Exception e) {
            return null;
        }
    }
    
}
