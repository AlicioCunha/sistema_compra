package br.com.sistemacompra.data;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConexaoJDBC {

    Connection getConnection();

    void close();

    void commit() throws SQLException;

    void rollback();

}