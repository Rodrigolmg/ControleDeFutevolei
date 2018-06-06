/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Inscricao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author rodri
 */
public class PInscricao extends TPersistencia<Inscricao>{
    public void incluir(Inscricao inscricao) throws SQLException{
        
        String sql = "INSERT INTO inscricao(torneio, jogador)"
                + " VALUES(?, ?);";
        
        String sql2 = "SELECT currval('inscricao_id_inscricao_seq') as identificador";
        
        this.alterarOuIncluir(inscricao, sql, sql2);
    }
    
    @Override
    public PreparedStatement prepararDeclaracao(Inscricao inscricao, Connection cnn, String sql) throws SQLException {
        
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        prd.setInt(1, inscricao.getTorneio().getId());
        prd.setInt(2, inscricao.getJogador().getId());
        
        return prd;
    }
    
    @Override
    public Inscricao consultar(int id) throws SQLException{
        String sql = "SELECT * FROM inscricao WHERE id_inscricao = ?;";
        
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, id);
        
        ResultSet rs = prd.executeQuery();
        
        if(rs.next()){
            return new Inscricao(rs.getInt(1), 
                    new PTorneio().consultar(rs.getInt(2)), 
                    new PJogador().consultar(rs.getInt(3)));
        }
        return null;
        
    }
    
    @Override
    public void excluir(int id) throws SQLException{
        
        String sql = "DELETE FROM inscricao WHERE id_inscricao = ?";
        
        Connection cnn = util.Conexao.getConexao();
        
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, id);

        prd.execute();
    }
    
    @Override
    public Iterator<Inscricao> listar() throws SQLException{
        
        String sql = "SELECT * FROM inscricao ORDER BY id_inscricao;";
        
        Connection cnn = util.Conexao.getConexao();
        Statement prd = cnn.createStatement();
        
        ResultSet rs = prd.executeQuery(sql);
        ArrayList<Inscricao> lista = new ArrayList<>();
        
        while(rs.next()){
            lista.add(new Inscricao(rs.getInt(1), 
                    new PTorneio().consultar(rs.getInt(2)), 
                    new PJogador().consultar(rs.getInt(3))));
        }
        return lista.iterator();
    }

    @Override
    public Iterator<Inscricao> listarDescricao(int id) throws SQLException {
        return null;
    }

    
}