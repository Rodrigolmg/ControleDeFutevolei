/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodri
 */
public class CBFV implements Sujeito{
    
    public List<Observador> observers;
    public DadosDoTorneio dados;

    public CBFV() {
        observers = new ArrayList<>();
    }

    @Override
    public void incluirObservador(Observador o) {
        observers.add(o);
    }

    @Override
    public void removerObservador(Observador o) {
        observers.forEach(observador -> {
            if(o.getId() == observador.getId())
                observers.remove(o);
        });
    }

    @Override
    public void notificarObservador() {
        for (int i = 0; i < observers.size(); i++) {
            Observador observer = observers.get(i);
            observer.atualizar(dados);
        }
    }

    @Override
    public List<Observador> listarObservador() {
        return observers;
    }
    
    public void setDados(DadosDoTorneio dados){
        this.dados = dados;
        notificarObservador();
    }
}
