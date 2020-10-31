package br.com.sistemacompra.model.dao;

import br.com.sistemacompra.data.ConexaoJDBC;
import br.com.sistemacompra.data.ConexaoMysqlJDBC;
import br.com.sistemacompra.model.Mercado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Mercado> listar() throws SQLException, ClassNotFoundException {
        String sqlQuery = "select * from mercado ORDER BY id";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            ResultSet rs = stmt.executeQuery();

            List<Mercado> mercados = new ArrayList<>();

            while (rs.next()) {
                mercados.add(parser(rs));
            }

            return mercados;
        } catch (SQLException e) {
            throw e;
        }
    }


    private Mercado parser(ResultSet resultSet) throws SQLException {
        Mercado mercado = new Mercado();
        mercado.setId(resultSet.getLong("id"));
        mercado.setDescricao(resultSet.getString("descricao"));
        return mercado;
    }



    public int excluir(long id) throws SQLException, ClassNotFoundException {
        int linhasAlfetadas = 0;
        String sqlQuery = "DELETE FROM mercado WHERE id = ?";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
            stmt.setLong(1, id);
            linhasAlfetadas = stmt.executeUpdate();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }

        return linhasAlfetadas;
    }
}
