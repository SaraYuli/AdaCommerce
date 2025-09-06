package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    public enum Status {
        ABERTO,
        AGUARDANDO_PAGAMENTO,
        PAGO,
        FINALIZADO
    }

    private String id;
    private Cliente cliente;
    private LocalDateTime dataCriacao;
    private Status status;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.dataCriacao = LocalDateTime.now();
        this.status = Status.ABERTO;
    }

    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public Status getStatus() { return status; }
    public List<ItemPedido> getItens() { return itens; }

    public void adicionarItem(Produto produto, int quantidade, double precoVenda) {
        if (status != Status.ABERTO) {
            System.out.println("Não pode adicionar item: pedido não está ABERTO.");
            return;
        }
        if (quantidade <= 0 || precoVenda <= 0) {
            System.out.println("Quantidade e preço devem ser maiores que zero.");
            return;
        }
        // Verifica se produto já existe no pedido

        for (ItemPedido item : itens) {
            if (item.getProduto().getId().equals(produto.getId())) {
                // Atualiza quantidade e preço
                item.setQuantidade(item.getQuantidade() + quantidade);
                item.setPrecoVenda(precoVenda);
                return;
            }
        }
        itens.add(new ItemPedido(produto, quantidade, precoVenda));
    }

    public void removerItem(String produtoId) {
        if (status != Status.ABERTO) {
            System.out.println("Não pode remover item: pedido não está ABERTO.");
            return;
        }
        itens.removeIf(item -> item.getProduto().getId().equals(produtoId));
    }

    public void alterarQuantidadeItem(String produtoId, int novaQuantidade) {
        if (status != Status.ABERTO) {
            System.out.println("Não pode alterar quantidade: pedido não está ABERTO.");
            return;
        }
        if (novaQuantidade <= 0) {
            System.out.println("Quantidade deve ser maior que zero.");
            return;
        }
        for (ItemPedido item : itens) {
            if (item.getProduto().getId().equals(produtoId)) {
                item.setQuantidade(novaQuantidade);
                return;
            }
        }
        System.out.println("Produto não encontrado no pedido.");
    }

    public double getTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getQuantidade() * item.getPrecoVenda();
        }
        return total;
    }

    public void finalizarPedido() {
        if (status != Status.ABERTO) {
            System.out.println("Pedido já foi finalizado ou está em outro status.");
            return;
        }
        if (itens.isEmpty()) {
            System.out.println("Pedido precisa ter pelo menos um item para finalizar.");
            return;
        }
        if (getTotal() <= 0) {
            System.out.println("Total do pedido deve ser maior que zero para finalizar.");
            return;
        }
        this.status = Status.AGUARDANDO_PAGAMENTO;
        notificarCliente("Seu pedido está aguardando pagamento.");
    }

    public void pagar() {
        if (status != Status.AGUARDANDO_PAGAMENTO) {
            System.out.println("Pagamento só pode ser feito se pedido estiver aguardando pagamento.");
            return;
        }
        this.status = Status.PAGO;
        notificarCliente("Pagamento recebido com sucesso!");
    }

    public void entregar() {
        if (status != Status.PAGO) {
            System.out.println("Entrega só pode ser feita se pagamento estiver concluído.");
            return;
        }
        this.status = Status.FINALIZADO;
        notificarCliente("Seu pedido foi entregue.");
    }

    // Método para mudar status manualmente com validação (exemplo extra)

    public void setStatus(Status novoStatus) {
        if (novoStatus == Status.AGUARDANDO_PAGAMENTO) {
            if (this.status != Status.ABERTO) {
                System.out.println("Pedido deve estar ABERTO para mudar para AGUARDANDO_PAGAMENTO.");
                return;
            }
            if (itens.isEmpty() || getTotal() <= 0) {
                System.out.println("Pedido precisa ter itens e valor maior que zero para finalizar.");
                return;
            }
            this.status = novoStatus;
            notificarCliente("Seu pedido está aguardando pagamento.");
        } else {
            System.out.println("Mudança de status direta só permitida para AGUARDANDO_PAGAMENTO.");
        }
    }

    private void notificarCliente(String mensagem) {
        System.out.println("Notificação para " + cliente.getNome() + ": " + mensagem);
    }

    // Classe interna para itens do pedido

    public static class ItemPedido {
        private Produto produto;
        private int quantidade;
        private double precoVenda;

        public ItemPedido(Produto produto, int quantidade, double precoVenda) {
            this.produto = produto;
            this.quantidade = quantidade;
            this.precoVenda = precoVenda;
        }

        public Produto getProduto() { return produto; }
        public int getQuantidade() { return quantidade; }
        public double getPrecoVenda() { return precoVenda; }

        public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
        public void setPrecoVenda(double precoVenda) { this.precoVenda = precoVenda; }
    }
}

