/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import fabricaabstrata.CategoriaAbstrata;
import interfaces.MostrarElementos;
import interfaces.Observador;
import interfaces.Sujeito;
import observer.DadosDoTorneio;

/**
 *
 * @author rodri
 */
public class Jogador implements Observador, MostrarElementos{
    
    private int id;
    private String nome;
    private CategoriaAbstrata categoria;
    private String cpf;
    private DadosDoTorneio dados;
    private Sujeito cbfv;
    
    public Jogador(Sujeito cbfv){
        this.cbfv = cbfv;
        this.cbfv.incluirObservador(this);
    }

    public Jogador(int cat) {
        categoria = CategoriaAbstrata.getInstance(cat);
    }

    public Jogador(int id, String nome, CategoriaAbstrata categoria, String cpf) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.cpf = cpf;
    }
    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaAbstrata getCategoria() {
        return categoria;
    }

    public void setCategoria(int idCat) {
        this.categoria = CategoriaAbstrata.getInstance(idCat);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void atualizar(DadosDoTorneio dados) {
        this.dados = dados;
        mostrar();
    }

    @Override
    public void mostrar() {
        System.out.println();
        System.out.println("-------------------//----------------//-----------------------");
        System.out.println("        Confederação Brasileira de Futevôlei");
        System.out.println("");
        System.out.println("Jogador " + dados.getInscricao().getJogador().getNome() + ",");
        System.out.print("faltam " + dados.getDiasRestantes() + " dias para o torneio \"");
        System.out.println(dados.getInscricao().getTorneio().getDescricao() + "\"");
        System.out.println("");
        System.out.println("-------------------//----------------//-----------------------");
    }
    
    
}
