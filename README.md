# BarberShop — Aula 12

Matheus Chaves Mina da Silva · Programação I · FMP · 2026.2

## Executar no NetBeans

1. Use JDK 21 e Apache NetBeans com suporte a Java e Ant.
2. Abra esta pasta como projeto. Ela contém `build.xml`, `nbproject`, as bibliotecas locais e os formulários Swing.
3. Execute o projeto com F6. `View.Main` imprime os modelos e abre o Login.
4. Use **barbeiro** e **demo123**, credenciais fictícias definidas em `Model.DAO.Banco`.
5. No Menu Principal, clique em **Abrir agenda**. Escolha cliente e serviço, preencha data `dd/MM/aaaa` e hora `HH:mm`, e clique em **Agendar**.

## Organização

- `Model`: `Pessoa` abstrata, `Cliente`, `Usuario`, `Servico` e `Agendamento`.
- `Model.DAO`: `Banco` e quatro DAOs com operações em memória. O DAO de usuário valida a credencial e o DAO de agenda controla identificadores e horários repetidos.
- `Controller` e `Controller.Helper`: tradução dos campos de Login para o modelo, validação pelo DAO e navegação entre Login, Menu Principal e Agenda.
- `View`: telas Swing e `Main`. Os arquivos `.form` permitem abrir as telas no GUI Builder.
- `test`: verificações de modelos, telas, datas inválidas, autenticação e navegação.

## Depurar as datas

Em `src/View/Main.java`, coloque um breakpoint na primeira chamada a `System.out.println`, após a construção dos quatro objetos. Depure o arquivo e inspecione `cliente.dataNascimento`, `usuario.dataNascimento` e `agendamento.data`. O construtor de `Pessoa` recebe a data em `dd/MM/yyyy`. O de `Agendamento` combina data e hora e usa `dd/MM/yyyy HH:mm`. A conversão é estrita e usa `SimpleDateFormat`.

O banco é reiniciado ao abrir um novo processo. Os dados, endereços e credenciais são fictícios. Para executar somente os modelos após compilar, use `java -cp build/classes View.Main --model-only`. A interface usa o `AbsoluteLayout.jar` já incluído.

## Material da disciplina

Rafael Novo da Rosa. **Desafio Prático da Aula 12**, pacote DAO e fontes de LoginController, LoginHelper e MenuPrincipalController, Classroom, FMP, 2026. As assinaturas do Banco e as operações dos DAOs foram adaptadas ao projeto da Aula 11. A carga do material foi substituída por dados fictícios, com preservação da ordem dos parâmetros.

## Evidências da entrega

A demonstração usa capturas reais das telas e trechos da transcrição de uma sessão de depuração jdb. As saídas da Main e do depurador estão em evidencias/. Os resultados de testes estão em verificacao.txt.
