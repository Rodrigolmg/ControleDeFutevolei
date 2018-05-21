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
public class PJogador extends TPersistencia<Jogador> {
    
    public void incluir(Jogador jogador) throws SQLException{
        
        String sql = "INSERT INTO jogador(nome, categoria, cpf)"
                + " VALUES(?, ?, ?);";
        
        String sql2 = "SELECT currval('jogador_id_seq') as identificador";
        
        this.alterarOuIncluir(jogador, sql, sql2);
    }
    
    @Override
    public PreparedStatement prepararEstado(Jogador jogador, Connection cnn, String sql) throws SQLException {
        PreparedStatement prd = cnn.prepareStatement(sql);
        
        //Seta os valores a serem injetados no código
        prd.setString(1, jogador.getNome());
        prd.setInt(2, jogador.getCategoria().getIdCat());
        prd.setString(3, jogador.getCpf());
        if(jogador.getId() > 0)
            prd.setInt(4, jogador.getId());
        
        return prd;
    }
    
    @Override
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
        
        this.alterarOuIncluir(jogador, sql);
    }
    
    @Override
    public void excluir(int id) throws SQLException{
        
        String sql = "DELETE FROM jogador WHERE id = ?";
        
        Connection cnn = util.Conexao.getConexao();
        
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, id);

        prd.execute();
    }
    
    @Override
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
    
    @Override
    public ArrayList<Jogador> listarDescricao(int idCategoria) throws SQLException{
        
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
