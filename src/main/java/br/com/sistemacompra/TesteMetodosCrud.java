package br.com.sistemacompra;

import br.com.sistemacompra.model.dao.MercadoDAO;

import java.sql.SQLException;

public class TesteMetodosCrud {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*
        Inserir novo registro
         */
        MercadoDAO mercadoDAO1 = new MercadoDAO();
        mercadoDAO1.inserir("INFORMAR UM MERCADO AQUI");

        /*
        Listando tudo da tabela de mercado
         */
        MercadoDAO mercadoDAO = new MercadoDAO();
        mercadoDAO.listar();
        System.out.println( mercadoDAO.listar());

        MercadoDAO delmercado = new MercadoDAO();

        delmercado.excluir(7);

         /*
        Alterar registro
         */
        MercadoDAO mercadoAlterar = new MercadoDAO();
        mercadoAlterar.alterar("Mercado Thiago", 13L);

    }
}
