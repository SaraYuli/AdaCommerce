# 🛒 Ada Commerce - E-Commerce

Projeto desenvolvido como parte da proposta da **Ada Tech** para a criação de um sistema de E-Commerce completo. O objetivo é permitir o cadastro de clientes e produtos, criação de pedidos, e controle de vendas com regras específicas de negócio.

---

## 📌 Descrição do Projeto

A Ada Tech contratou nossa equipe para desenvolver o fluxo completo de um E-Commerce. Este sistema permite:

- 📇 Cadastrar, listar e atualizar **clientes**.
- 📦 Cadastrar, listar e atualizar **produtos**.
- 🧾 Criar e gerenciar **vendas** com funcionalidades como:
  - Adicionar/remover itens (produtos).
  - Alterar a quantidade dos produtos no pedido.
  - Realizar o pagamento e acompanhar a entrega.

> **Nota:** A exclusão de clientes e produtos **não é permitida**. Eles devem permanecer na base de dados como histórico.

---

## 📋 Regras de Negócio

- Todo cliente deve possuir um **documento de identificação**.
- Todo pedido deve ter a **data de criação** registrada.
- Pedidos iniciam com o status **"Aberto"**.
- Pedidos com status "Aberto" podem:
  - Receber novos itens (produtos).
  - Ter itens removidos.
  - Ter quantidades ajustadas.
- Produtos adicionados ao pedido devem conter um **valor de venda**, que pode ser diferente do valor padrão do produto.
- Para **finalizar um pedido**, ele deve:
  - Ter ao menos **um item**.
  - Ter **valor total maior que zero**.
  - Ter o status de pagamento alterado para **"Aguardando pagamento"**.
  - Notificar o cliente via **e-mail**.
- O pagamento só pode ser realizado se o status do pedido for **"Aguardando pagamento"**:
  - Após pagamento, o status muda para **"Pago"**.
  - O cliente é notificado.
- A entrega só pode ser feita após o pagamento:
  - O status do pedido é alterado para **"Finalizado"**.
  - O cliente é novamente notificado.

---

## 💡 Dicas de Desenvolvimento

- Aplicar os princípios de **Programação Orientada a Objetos (POO)**.
- Utilizar boas práticas como os princípios **SOLID**.
- O projeto pode usar uma base de dados **em memória** (para simplificação).
- **[Bônus]** Opcional: persistência em arquivos locais.

---

## 🚀 Tecnologias Utilizadas

- Java
- IntelliJ IDEA
- Git & GitHub

---

## 📁 Organização do Projeto

src/
├── model/
│   ├── Cliente.java
│   ├── Produto.java
│   ├── Pedido.java
│   ├── ItemPedido.java
│
│
├── repositorio/
│   ├── Repositorio.java
│   └── RepositorioMemoria.java
│
└── main/
    └── App.java



