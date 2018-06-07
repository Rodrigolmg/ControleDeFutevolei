/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class Conexao {
    
    private static Connection conexao;
    
    private Conexao(){}
    
    public static Connection getConexao(){
        try{
            if(conexao == null || conexao.isClosed()){
                conexao = conectar();
            }
        }catch(Exception e){
            System.out.printf("Erro: %s\n", e.getMessage());
        }
        return conexao;
    }

    private static Connection conectar() throws ClassNotFoundException, SQLException{
        try{
            
            Class.forName("org.postgresql.Driver");
        
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/futevolei","postgres","123456");
        }catch(ClassNotFoundException e){
            System.out.println("Não foi encontrada a biblioteca postgres!");
            return null;
        }catch(SQLException e){
            System.out.println("Banco/Usuário/Senha estão errados. Verifique.");
            return null;
        }
    }
}
