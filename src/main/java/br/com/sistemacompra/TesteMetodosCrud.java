package br.com.sistemacompra;

import br.com.sistemacompra.model.dao.MercadoDAO;

import java.sql.SQLException;

public class TesteMetodosCrud {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MercadoDAO mercadoDAO1 = new MercadoDAO();

        mercadoDAO1.inserir("Bistek");
    }
}
