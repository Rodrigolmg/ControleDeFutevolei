/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


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
public class PCategoria{
    
    public CategoriaAbstrata consultar(int id) throws SQLException{
        String sql = "SELECT * FROM categoria WHERE id = ?;";
        
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, id);
        
        ResultSet rs = prd.executeQuery();
        
        if(rs.next()){
            return CategoriaAbstrata.getInstance(rs.getInt(1));
        }
        return null;
        
    }
    
    public ArrayList<CategoriaAbstrata> listar() throws SQLException{
        
        String sql = "SELECT * FROM categoria ORDER BY id;";
        
        Connection cnn = util.Conexao.getConexao();
        Statement prd = cnn.createStatement();
        
        ResultSet rs = prd.executeQuery(sql);
        ArrayList<CategoriaAbstrata> lista = new ArrayList<>();
        
        while(rs.next()){
            lista.add(CategoriaAbstrata.getInstance(rs.getInt(1)));
        }
        return lista;
    }
    
    public ArrayList<String> listarDescricao() throws SQLException{
        
        String sql = "SELECT descricao FROM categoria ORDER BY id;";
        
        Connection cnn = util.Conexao.getConexao();
        Statement prd = cnn.createStatement();
        
        ResultSet rs = prd.executeQuery(sql);
        ArrayList<String> lista = new ArrayList<>();
        
        while(rs.next()){
            lista.add(rs.getString("descricao"));
        }
        
        return lista;
    }
}
