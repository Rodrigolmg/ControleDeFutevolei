/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author rodri
 */
public interface Sujeito {
    public void incluirObservador(Observador o);
    public void removerObservador(Observador o);
    public void notificarObservador();
    public ArrayList listarObservador();
}
