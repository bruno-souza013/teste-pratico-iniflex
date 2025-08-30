# Teste prático Iniflex

Este projeto foi desenvolvido como parte de um desafio de teste prático.

## 🚀 Sobre o Projeto

O objetivo principal é cunprir com os requisitos propostos:

- Inserir e remover funcionários de uma lista.
- Aplicar aumento salarial.
- Agrupar funcionários por função.
- Listar funcionários que fazem aniversário em meses específicos.
- Encontrar o funcionário mais velho.
- Calcular a soma total dos salários.
- Apresentar a quantidade de salários mínimos que cada funcionário recebe.

## 📂 Estrutura de Arquivos

O projeto está organizado em pacotes para melhor modularidade:

- **`br.com.industria.model`**: Contém as classes de modelo que representam os dados.
  - `Pessoa.java`: Classe base com atributos de nome e data de nascimento.
  - `Funcionario.java`: Classe que herda de `Pessoa` e adiciona atributos de salário e função.

- **`br.com.industria.service`**: Contém a lógica de negócio do projeto, com métodos estáticos para manipular a lista de funcionários.
  - `FuncionarioService.java`: Classe que gerencia todas as operações sobre os funcionários, como remoção, aumento, agrupamento, etc.

- **`br.com.industria.util`**: Contém classes auxiliares com funções utilitárias.
  - `Formatador.java`: Classe com métodos estáticos para formatar datas e valores de salário.

- **`br.com.industria.app`**: Contém a classe principal para a execução do programa.
  - `Principal.java`: Classe com o método `main` que orquestra a execução das operações, chamando os métodos da classe `FuncionarioService`.

## ▶️ Como Executar

Para executar este projeto, siga os passos abaixo:

1. Clone este repositório para a sua máquina local.
   ```bash
   git clone https://github.com/bruno-souza013/teste-pratico-iniflex.git
2. Abra o projeto em sua IDE de preferência.

3.Compile e execute a classe Principal.java. O programa exibirá os resultados de cada operação no console.
