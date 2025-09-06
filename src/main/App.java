package main;

import model.*;
import repository.RepositorioMemoria;

public class App {
    public static void main(String[] args) {
        // Criando repositórios com função para extrair ID

        var clientes = new RepositorioMemoria<Cliente>(Cliente::getId);
        var produtos = new RepositorioMemoria<Produto>(Produto::getId);
        var pedidos = new RepositorioMemoria<Pedido>(Pedido::getId);

        // Criar cliente
        Cliente cliente1 = new Cliente("c1", "Maria", "12345678900");
        Cliente cliente2 = new Cliente("c2", "Sara", "123123123");
        clientes.salvar(cliente1);
        clientes.salvar(cliente2);

        // Criar produtos
        Produto p1 = new Produto("p1", "Notebook", 3000.00);
        Produto p2 = new Produto("p2", "Mouse", 150.00);
        Produto p3 = new Produto("p3", "Teclado", 30.00);
        Produto p4 = new Produto("p4", "Celular", 350.00);
        produtos.salvar(p1);
        produtos.salvar(p2);
        produtos.salvar(p3);
        produtos.salvar(p4);


        // Criar pedido

        Pedido pedido2 = new Pedido("v2", cliente2);
        pedido2.adicionarItem(p1, 1, 2900.00);
        pedido2.adicionarItem(p2, 2, 140.00);
        pedido2.setStatus(Pedido.Status.AGUARDANDO_PAGAMENTO);
        pedidos.salvar(pedido2);


        // Mostrar pedido
        System.out.println("----- PEDIDOS -----");
        for (Pedido p : pedidos.listar()) {
            System.out.println("Cliente: " + p.getCliente().getNome());
            System.out.println("Status: " + p.getStatus());
            System.out.println("Total: R$ " + p.getTotal());
        }
    }
}
