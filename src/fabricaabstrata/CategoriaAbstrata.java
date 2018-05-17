/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricaabstrata;


import fabricasconcretas.CategoriaA;
import entidades.Jogador;
import entidades.Jogador;
import entidades.Torneio;
import entidades.Torneio;
import fabricasconcretas.CategoriaB;
import fabricasconcretas.CategoriaC;
import fabricasconcretas.CategoriaIniciante;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PCategoria;

/**
 *
 * @author rodri
 */
public abstract class CategoriaAbstrata {
    
    protected int idCat;
    protected String descricao;
    
    public static ArrayList<String> getListaDeFabricas() throws SQLException{
        ArrayList<String> list = new PCategoria().listarDescricao();
        return list;
    }
    
    public int getIdCat(){ return idCat; }
    public String getDescricao(){ return descricao; }
    public abstract ArrayList<Jogador> getListaJogadores();
    public abstract ArrayList<Torneio> getListaTorneios();
    public static CategoriaAbstrata getInstance(int categoria){
        switch(categoria){
            case 1: return new CategoriaA();
            case 2: return new CategoriaB();
            case 3: return new CategoriaC();
            case 4: return new CategoriaIniciante();
            default: return null;
        }
    }
}
