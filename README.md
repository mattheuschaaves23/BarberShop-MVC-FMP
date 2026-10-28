# BarberShop â€” View e Model

**Matheus Chaves Mina da Silva â€” FMP â€” 2026.2**  
Atividade 11 (19/10): NetBeans, Java com Ant, Swing e introduÃ§Ã£o ao MVC.

## Abrir e executar

1. JDK **21 ou superior**, Apache NetBeans com suporte Java SE.
2. Arquivo â†’ Abrir Projeto â†’ selecionar esta pasta `BarberShop` (contÃ©m `build.xml` e `nbproject`).
3. Executar Projeto (F6) executa `View.Main`, imprime os cinco objetos e abre Login.
4. Login â†’ **Abrir demonstraÃ§Ã£o** â†’ Menu principal â†’ OperaÃ§Ã£o â†’ Agenda. Cada tela tambÃ©m tem seu prÃ³prio `main` e pode ser executada com Shift+F6.

O projeto usa **Java com Ant**, nÃ£o requer Maven nem rede em execuÃ§Ã£o. `lib/AbsoluteLayout.jar` acompanha o projeto, referenciado por caminho relativo. As imagens e os Ã­cones sÃ£o recursos do classpath e tambÃ©m entram no JAR. Compilar com `ant clean jar`; executar com `java -jar dist/BarberShop.jar`. Testar modelos sem abrir telas: `java -cp build/classes View.Main --model-only`.

## OrganizaÃ§Ã£o e requisitos

```
src/Model/          Servico, Cliente, Usuario
src/View/           Main, Login, MenuPrincipal, Agenda, Ui
src/View/Imagens/   fundos e painÃ©is fornecidos pela disciplina
src/View/Imagens/icons/  Ã­cones fornecidos
test/               VerificarModelos e VerificarTelas
nbproject/          metadados NetBeans e build Ant
lib/                AbsoluteLayout.jar
```

As trÃªs telas sÃ£o `JFrame`, usam `AbsoluteLayout` e possuem `.form` editÃ¡vel no GUI Builder. Os componentes tÃªm nomes semÃ¢nticos (`txtUsuario`, `txtSenha`, `cmbCliente`, `btnAgendar`, `tblAgenda`). A barra Cadastro â†’ Cliente/ServiÃ§o e OperaÃ§Ã£o â†’ Agenda Ã© montada no mÃ©todo `configurarNavegacao` de MenuPrincipal. O bloco gerado da tela permanece separado desse cÃ³digo. Login utiliza `JPasswordField`; Agenda reÃºne nome, cliente, serviÃ§o, data, hora, valor, observaÃ§Ãµes, `JToggleButton` e tabela de sete colunas.

`Servico`: atributos privados id, descricao e valor; construtor completo; getters/setters apenas de descricao e valor, conforme o PDF. `Cliente`: nove atributos, construtor completo e reduzido de cinco parÃ¢metros; todos os getters/setters. `Usuario`: dez atributos, construtor completo e reduzido de trÃªs parÃ¢metros; getters/setters. `nivelAcesso` usa **int**, pois o roteiro omite o tipo (0 padrÃ£o do construtor reduzido; 1 no exemplo completo). `endereco` usa grafia Java sem acento. O pacote `View.Imagens.icons` segue o PDF e a capitalizaÃ§Ã£o de `View`; a grafia inicial `view` presente em um item do enunciado foi uniformizada para evitar dois pacotes distintos. `Date` Ã© `java.util.Date`, com cÃ³pia defensiva na entrada e na saÃ­da.

## Depurar no NetBeans

Abrir `View/Main.java`; colocar breakpoint na primeira linha `System.out.println`, apÃ³s os cinco construtores. Usar **Depurar Arquivo** (Ctrl+Shift+F5), abrir VariÃ¡veis e expandir `servico`, `cliente`, `usuario`, `clienteCompleto` e `usuarioCompleto`. Os construtores reduzidos permitem ver os valores padrÃ£o. Continuar (F5) imprime os objetos e abre as telas. `Usuario.toString` oculta a senha; todas as amostras sÃ£o fictÃ­cias.

## Escopo desta etapa

A atividade cobre **View e Model**. A navegaÃ§Ã£o entre janelas estÃ¡ conectada para demonstrar as telas. NÃ£o existe autenticaÃ§Ã£o, banco de dados ou cadastro/agendamento persistente nesta etapa. O botÃ£o de Login abre a demonstraÃ§Ã£o sem verificar credenciais; a tela informa isso. Agendar explica a etapa futura e nÃ£o afirma ter gravado dados. A tabela exibe um exemplo fictÃ­cio. A futura camada Controller deverÃ¡ validar entradas, autenticar, aplicar regras e coordenar a persistÃªncia; nenhuma dessas capacidades Ã© apresentada como pronta.

## VerificaÃ§Ã£o

`test/VerificarModelos.java` verifica construtores, campos privados, todos os pares de acesso de Cliente/Usuario, restriÃ§Ã£o de acesso a id em Servico, cÃ³pia defensiva de Date e omissÃ£o de senha na impressÃ£o. `test/VerificarTelas.java` abre e fecha instÃ¢ncias na EDT e confere layout, dimensÃµes, recursos, menus e colunas. Compilar os testes contra `build/classes` e `lib/AbsoluteLayout.jar`; executar `VerificarModelos` e `VerificarTelas` com essa mesma classpath. Resultados reais em `verificacao.txt`.

## Materiais

Rafael Novo da Rosa. *Tarefa Aula 11 â€” 0,5 pts*; *ConstruÃ§Ã£o da interface grÃ¡fica com Swing e Jframes*; *Construindo Modelos (Classes: Servico, Cliente e Usuario)*; pacote `View-Imagens.rar`, Classroom, FMP, 2026. Os assets originais acompanham o trabalho para uso acadÃªmico; nÃ£o se atribui licenÃ§a prÃ³pria a imagens de terceiros. AbsoluteLayout Ã© a biblioteca distribuÃ­da com Apache NetBeans; veja `lib/ORIGEM.txt`.
