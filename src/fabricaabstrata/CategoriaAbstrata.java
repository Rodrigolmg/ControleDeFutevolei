/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricaabstrata;



import entidades.Jogador;
import entidades.Torneio;
import fabricasconcretas.SCategoria;
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
        return SCategoria.values()[categoria].getInstance();
    }
}
