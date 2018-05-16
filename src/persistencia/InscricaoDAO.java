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

/**
 *
 * @author rodri
 */
public class InscricaoDAO {
    public void incluir(Inscricao inscricao) throws SQLException{
        
        String sql = "INSERT INTO inscricao(torneio, jogador)"
                + " VALUES(?, ?);";
        
        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, inscricao.getTorneio().getId());
        prd.setInt(2, inscricao.getJogador().getId());
        
        prd.execute();
        
        String sql2 = "SELECT currval('inscricao_id_inscricao_seq') as id_inscricao";
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql2);
        if (rs.next()) {
            inscricao.setIdInscricao(rs.getInt("id_inscricao"));
        }
    }
    
    public Inscricao consultar(int id) throws SQLException{
        String sql = "SELECT * FROM inscricao WHERE id_inscricao = ?;";
        
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, id);
        
        ResultSet rs = prd.executeQuery();
        
        if(rs.next()){
            return new Inscricao(rs.getInt(1), 
                    new TorneioDAO().consultar(rs.getInt(2)), 
                    new JogadorDAO().consultar(rs.getInt(3)));
        }
        return null;
        
    }
    
//    public void alterar(Inscricao inscricao) throws SQLException{
//        
//        //Cria o SQL aser executado
//        String sql = "UPDATE inscricao SET torneio = ?, categoria = ?, cpf = ? WHERE id = ?;";
//        
//        //Cria a conexão com o banco a partir da classe utilitária
//        Connection cnn = util.Conexao.getConexao();
//        
//        //Cria o procedimento armazenado a partir do sql gerado
//        PreparedStatement prd = cnn.prepareStatement(sql);
//        
//        //Seta os valores a serem injetados no código
//        prd.setString(1, inscricao.getNome());
//        prd.setInt(2, inscricao.getCategoria().getIdCat());
//        prd.setString(3, inscricao.getCpf());
//        prd.setInt(4, inscricao.getId());
//        
//        //Executa 
//        prd.execute();
//    }
    
    public void excluir(int id) throws SQLException{
        
        String sql = "DELETE FROM inscricao WHERE id_inscricao = ?";
        
        Connection cnn = util.Conexao.getConexao();
        
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, id);

        prd.execute();
    }
    
    public ArrayList<Inscricao> listar() throws SQLException{
        
        String sql = "SELECT * FROM inscricao ORDER BY id_inscricao;";
        
        Connection cnn = util.Conexao.getConexao();
        Statement prd = cnn.createStatement();
        
        ResultSet rs = prd.executeQuery(sql);
        ArrayList<Inscricao> lista = new ArrayList<>();
        
        while(rs.next()){
            lista.add(new Inscricao(rs.getInt(1), 
                    new TorneioDAO().consultar(rs.getInt(2)), 
                    new JogadorDAO().consultar(rs.getInt(3))));
        }
        return lista;
    }
}
