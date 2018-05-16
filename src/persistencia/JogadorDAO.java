/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


import entidades.Jogador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fabricaabstrata.CategoriaAbstrata;

/**
 *
 * @author rodri
 */
public class JogadorDAO {
    
    public void incluir(Jogador jogador) throws SQLException{
        
        String sql = "INSERT INTO jogador(nome, categoria, cpf)"
                + " VALUES(?, ?, ?);";
        
        Connection cnn = util.Conexao.getConexao();

        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, jogador.getNome());
        prd.setInt(2, jogador.getCategoria().getIdCat());
        prd.setString(3, jogador.getCpf());
        
        prd.execute();
        
        String sql2 = "SELECT currval('jogador_id_seq') as id";
        Statement stm = cnn.createStatement();
        ResultSet rs = stm.executeQuery(sql2);
        if (rs.next()) {
            jogador.setId(rs.getInt("id"));
        }
    }
    
    public Jogador consultar(int id) throws SQLException{
        String sql = "SELECT * FROM jogador WHERE id = ?;";
        
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, id);
        
        ResultSet rs = prd.executeQuery();
        
        if(rs.next()){
            return new Jogador(rs.getInt(1), rs.getString(2), 
            CategoriaAbstrata.getInstance(rs.getInt(3)), rs.getString(4));
        }
        return null;
        
    }
    
    public void alterar(Jogador jogador) throws SQLException{
        
        //Cria o SQL aser executado
        String sql = "UPDATE jogador SET nome = ? , categoria = ?, cpf = ? WHERE id = ?;";
        
        //Cria a conexão com o banco a partir da classe utilitária
        Connection cnn = util.Conexao.getConexao();
        
        //Cria o procedimento armazenado a partir do sql gerado
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        //Seta os valores a serem injetados no código
        prd.setString(1, jogador.getNome());
        prd.setInt(2, jogador.getCategoria().getIdCat());
        prd.setString(3, jogador.getCpf());
        prd.setInt(4, jogador.getId());
        
        //Executa 
        prd.execute();
    }
    
    public void excluir(int id) throws SQLException{
        
        String sql = "DELETE FROM jogador WHERE id = ?";
        
        Connection cnn = util.Conexao.getConexao();
        
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, id);

        prd.execute();
    }
    
    public ArrayList<Jogador> listar() throws SQLException{
        
        String sql = "SELECT * FROM jogador ORDER BY id;";
        
        Connection cnn = util.Conexao.getConexao();
        Statement prd = cnn.createStatement();
        
        ResultSet rs = prd.executeQuery(sql);
        ArrayList<Jogador> lista = new ArrayList<>();
        
        while(rs.next()){
            lista.add(new Jogador(rs.getInt(1), rs.getString(2), 
            CategoriaAbstrata.getInstance(rs.getInt(3)), rs.getString(4)));
        }
        return lista;
    }
    
    public ArrayList<Jogador> listarNomes(int idCategoria) throws SQLException{
        
        String sql = "SELECT * FROM jogador WHERE categoria = ? ORDER BY id;";
        
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, idCategoria);
        
        ResultSet rs = prd.executeQuery();
        ArrayList<Jogador> lista = new ArrayList<>();
        
        while(rs.next()){
            lista.add(new Jogador(rs.getInt(1), rs.getString(2), 
            CategoriaAbstrata.getInstance(rs.getInt(3)), rs.getString(4)));
        }
        
        return lista;
    }
}
