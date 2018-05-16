/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author rodri
 */
public class Inscricao {
    
    private int idInscricao;
    private Torneio torneio;
    private Jogador jogador;

    public Inscricao() {
    }

    public Inscricao(int idInscricao, Torneio torneio, Jogador jogador) {
        this.idInscricao = idInscricao;
        this.torneio = torneio;
        this.jogador = jogador;
    }

    public int getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(int idInscricao) {
        this.idInscricao = idInscricao;
    }

    public Torneio getTorneio() {
        return torneio;
    }

    public void setTorneio(Torneio torneio) {
        this.torneio = torneio;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}
