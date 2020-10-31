package br.com.sistemacompra.model.dao;

import br.com.sistemacompra.data.ConexaoJDBC;
import br.com.sistemacompra.data.ConexaoMysqlJDBC;
import br.com.sistemacompra.model.Mercado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MercadoDAO {

    private final ConexaoJDBC conexao;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQuery="";

    public MercadoDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoMysqlJDBC();
    }

    public void inserir(String mercado) throws SQLException, ClassNotFoundException {

        String sqlQuery = "insert into mercado(descricao) values(?);";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setString(1, mercado);

            stmt.execute();

            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }


}
