/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Inscricao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import persistencia.PInscricao;

/**
 *
 * @author rodri
 */
public class NInscricao {
    public void incluir(Inscricao inscricao) throws SQLException{
        new PInscricao().incluir(inscricao);
    }
    
    public void excluir(int codigo) throws SQLException{
        new PInscricao().excluir(codigo);
    }
    
    public Inscricao consultar(int codigo) throws SQLException{
        return new PInscricao().consultar(codigo);
    }
    
    public Iterator<Inscricao> listar() throws SQLException{
        return new PInscricao().listar();
    }
}
