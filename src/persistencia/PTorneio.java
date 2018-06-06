/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


import entidades.Torneio;
import fabricaabstrata.CategoriaAbstrata;
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
public class PTorneio extends TPersistencia<Torneio>{
    
    public void incluir(Torneio torneio) throws SQLException{
        
        String sql = "INSERT INTO torneio(descricao_torn, categoria, data_ini,"
                + " data_term, taxa)"
                + " VALUES(?, ?, ?, ?, ?);";
        
        String sql2 = "SELECT currval('torneio_id_torneio_seq') as identificador";
        
        this.alterarOuIncluir(torneio, sql, sql2);
    }
    
    public void alterar(Torneio torneio) throws SQLException {

        //Cria o SQL aser executado
        String sql = "UPDATE torneio SET"
                + " descricao_torn = ?,"
                + " categoria = ?,"
                + " data_ini = ?,"
                + " data_term = ?"
                + " taxa = ?"
                + " WHERE id_torneio = ?;";

        this.alterarOuIncluir(torneio, sql);
    }
    
    @Override
    public PreparedStatement prepararDeclaracao(Torneio torneio, Connection cnn, String sql) throws SQLException{
        PreparedStatement prd = cnn.prepareStatement(sql);

        
        prd.setString(1, torneio.getDescricao());
        prd.setInt(2, torneio.getCategoria().getIdCat());
        prd.setDate(3, torneio.getDataInicio());
        prd.setDate(4, torneio.getDataTermino());
        prd.setDouble(5, torneio.getTaxa());
        if(torneio.getId() > 0)
            prd.setInt(6, torneio.getId());
        
        return prd;
    }
    
    @Override
    public Torneio consultar(int id) throws SQLException{
        String sql = "SELECT * FROM torneio WHERE id_torneio = ?;";
        
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, id);
        
        ResultSet rs = prd.executeQuery();
        
        if(rs.next()){
            return new Torneio(rs.getInt(1), rs.getString(2),
                    CategoriaAbstrata.getInstance(rs.getInt(3)), rs.getDate(4),
                    rs.getDate(5), rs.getDouble(6));
        }
        return null;
        
    }
    
    @Override
    public void excluir(int id) throws SQLException{
        
        String sql = "DELETE FROM torneio WHERE id_torneio = ?";
        
        Connection cnn = util.Conexao.getConexao();
        
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, id);

        prd.execute();
    }
    
    @Override
    public Iterator<Torneio> listar() throws SQLException{
        
        String sql = "SELECT * FROM torneio ORDER BY id_torneio;";
        
        Connection cnn = util.Conexao.getConexao();
        Statement prd = cnn.createStatement();
        
        ResultSet rs = prd.executeQuery(sql);
        ArrayList<Torneio> lista = new ArrayList<>();
        
        while(rs.next()){
            lista.add(new Torneio(rs.getInt(1), rs.getString(2),
                    CategoriaAbstrata.getInstance(rs.getInt(3)), rs.getDate(4),
                    rs.getDate(5), rs.getDouble(6)));
        }
        return lista.iterator();
    }
    
    @Override
    public Iterator<Torneio> listarDescricao(int idCategoria) throws SQLException{
        
        String sql = "SELECT * FROM torneio WHERE categoria = ? ORDER BY id_torneio;";
        
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, idCategoria);
        
        ResultSet rs = prd.executeQuery();
        ArrayList<Torneio> lista = new ArrayList<>();
        
        while(rs.next()){
            lista.add(new Torneio(rs.getInt(1), rs.getString(2),
                    CategoriaAbstrata.getInstance(rs.getInt(3)), rs.getDate(4),
                    rs.getDate(5), rs.getDouble(6)));
        }
        
        return lista.iterator();
    }
}
