# BarberShop — View e Model

**Matheus Chaves Mina da Silva — FMP — 2026.2**  
Atividade 11 (19/10): NetBeans, Java com Ant, Swing e introdução ao MVC.

## Abrir e executar

1. JDK **21 ou superior**, Apache NetBeans com suporte Java SE.
2. Arquivo → Abrir Projeto → selecionar esta pasta `BarberShop` (contém `build.xml` e `nbproject`).
3. Executar Projeto (F6) executa `View.Main`, imprime os cinco objetos e abre Login.
4. Login → **Abrir demonstração** → Menu principal → Operação → Agenda. Cada tela também tem seu próprio `main` e pode ser executada com Shift+F6.

O projeto usa **Java com Ant**, não requer Maven nem rede em execução. `lib/AbsoluteLayout.jar` acompanha o projeto, referenciado por caminho relativo. As imagens e os ícones são recursos do classpath e também entram no JAR. Compilar com `ant clean jar`; executar com `java -jar dist/BarberShop.jar`. Testar modelos sem abrir telas: `java -cp build/classes View.Main --model-only`.

## Organização e requisitos

```
src/Model/          Servico, Cliente, Usuario
src/View/           Main, Login, MenuPrincipal, Agenda, Ui
src/View/Imagens/   fundos e painéis fornecidos pela disciplina
src/View/Imagens/icons/  ícones fornecidos
test/               VerificarModelos e VerificarTelas
nbproject/          metadados NetBeans e build Ant
lib/                AbsoluteLayout.jar
```

As três telas são `JFrame`, usam `AbsoluteLayout` e possuem `.form` editável no GUI Builder. Os componentes têm nomes semânticos (`txtUsuario`, `txtSenha`, `cmbCliente`, `btnAgendar`, `tblAgenda`). A barra Cadastro → Cliente/Serviço e Operação → Agenda é montada no método `configurarNavegacao` de MenuPrincipal. O bloco gerado da tela permanece separado desse código. Login utiliza `JPasswordField`; Agenda reúne nome, cliente, serviço, data, hora, valor, observações, `JToggleButton` e tabela de sete colunas.

`Servico`: atributos privados id, descricao e valor; construtor completo; getters/setters apenas de descricao e valor, conforme o PDF. `Cliente`: nove atributos, construtor completo e reduzido de cinco parâmetros; todos os getters/setters. `Usuario`: dez atributos, construtor completo e reduzido de três parâmetros; getters/setters. `nivelAcesso` usa **int**, pois o roteiro omite o tipo (0 padrão do construtor reduzido; 1 no exemplo completo). `endereco` usa grafia Java sem acento. O pacote `View.Imagens.icons` segue o PDF e a capitalização de `View`; a grafia inicial `view` presente em um item do enunciado foi uniformizada para evitar dois pacotes distintos. `Date` é `java.util.Date`, com cópia defensiva na entrada e na saída.

## Depurar no NetBeans

Abrir `View/Main.java`; colocar breakpoint na primeira linha `System.out.println`, após os cinco construtores. Usar **Depurar Arquivo** (Ctrl+Shift+F5), abrir Variáveis e expandir `servico`, `cliente`, `usuario`, `clienteCompleto` e `usuarioCompleto`. Os construtores reduzidos permitem ver os valores padrão. Continuar (F5) imprime os objetos e abre as telas. `Usuario.toString` oculta a senha; todas as amostras são fictícias.

## Escopo desta etapa

A atividade cobre **View e Model**. A navegação entre janelas está conectada para demonstrar as telas. Não existe autenticação, banco de dados ou cadastro/agendamento persistente nesta etapa. O botão de Login abre a demonstração sem verificar credenciais; a tela informa isso. Agendar explica a etapa futura e não afirma ter gravado dados. A tabela exibe um exemplo fictício. A futura camada Controller deverá validar entradas, autenticar, aplicar regras e coordenar a persistência; nenhuma dessas capacidades é apresentada como pronta.

## Verificação

`test/VerificarModelos.java` verifica construtores, campos privados, todos os pares de acesso de Cliente/Usuario, restrição de acesso a id em Servico, cópia defensiva de Date e omissão de senha na impressão. `test/VerificarTelas.java` abre e fecha instâncias na EDT e confere layout, dimensões, recursos, menus e colunas. Compilar os testes contra `build/classes` e `lib/AbsoluteLayout.jar`; executar `VerificarModelos` e `VerificarTelas` com essa mesma classpath. Resultados reais em `verificacao.txt`.

## Materiais

Rafael Novo da Rosa. *Tarefa Aula 11 — 0,5 pts*; *Construção da interface gráfica com Swing e Jframes*; *Construindo Modelos (Classes: Servico, Cliente e Usuario)*; pacote `View-Imagens.rar`, Classroom, FMP, 2026. Os assets originais acompanham o trabalho para uso acadêmico; não se atribui licença própria a imagens de terceiros. AbsoluteLayout é a biblioteca distribuída com Apache NetBeans; veja `lib/ORIGEM.txt`.

A tarefa Ant CopyLibs também acompanha `lib/`, permitindo empacotar o JAR em uma cópia sem configurações privadas do NetBeans. Uma cópia limpa, sem build, dist ou nbproject/private, foi compilada com sucesso.
