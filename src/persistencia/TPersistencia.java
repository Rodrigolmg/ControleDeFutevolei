/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import interfaces.Identificador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe Template para persistências das classes: 
 * 
 * <ul>
 *  <li>Inscricao</li>
 *  <li>Jogador</li>
 *  <li>Torneio</li>
 * </ul>
 * 
 * @author Rodrigo Leite
 */
public abstract class TPersistencia<T>{
    
    
    public abstract void excluir(int cod) throws SQLException;
    public abstract T consultar(int cod) throws SQLException;
    public abstract ArrayList<T> listar() throws SQLException;
    public abstract ArrayList<T> listarDescricao(int id) throws SQLException;

    public abstract PreparedStatement prepararDeclaracao(T obj, Connection cnn, String sql) throws SQLException;
    
    public void alterarOuIncluir(T obj, String... sql) throws SQLException{
        
        String sql2 = sql[0];
        
        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = prepararDeclaracao(obj, cnn, sql2);
        
        prd.execute();
        
        if(sql.length > 1){
            String sql3 = sql[1];
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sql3);
            if (rs.next()) {
                ((Identificador)obj).setId(rs.getInt("identificador"));
            }
        }
    }
}
