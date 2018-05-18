/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package observer;

import entidades.Jogador;
import observer.DadosDoTorneio;


public interface Observador {
    public void atualizar(DadosDoTorneio dados);
    public int getId();
}