/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import fabricaabstrata.CategoriaAbstrata;
import interfaces.Identificador;
import java.sql.Date;

/**
 *
 * @author rodri
 */
public class Torneio implements Identificador{
    
    private int id;
    private String descricao;
    private CategoriaAbstrata categoria;
    private Date dataInicio;
    private Date dataTermino;
    private double taxa;

    public Torneio(int idCat) {
        categoria = CategoriaAbstrata.getInstance(idCat);
    }

    public Torneio(int id, String descricao, CategoriaAbstrata categoria, 
            Date dataInicio, Date dataTermino, double taxa) {
        this.id = id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.taxa = taxa;
    }

    public int getId() {
        return id;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaAbstrata getCategoria() {
        return categoria;
    }

    public void setCategoria(int idCat) {
        this.categoria = CategoriaAbstrata.getInstance(idCat);
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
    
    
}
