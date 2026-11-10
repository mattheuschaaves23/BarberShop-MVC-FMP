package View;

import Controller.AgendaController;
import Model.Servico;
import javax.swing.DefaultListCellRenderer;

/** Tela Swing editável pelo GUI Builder; AbsoluteLayout solicitado no roteiro. */
public class Agenda extends javax.swing.JFrame {
    private final AgendaController controller;

    public Agenda() {
        initComponents();
        Ui.tema(this);
        controller = new AgendaController(this);
        configurarNavegacao();
    }
    @SuppressWarnings({"unchecked", "serial"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BarberShop | Agenda");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        lblTitulo = new javax.swing.JLabel();
        lblTitulo.setText("AGENDA DE ATENDIMENTOS");
        lblTitulo.setName("lblTitulo");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 25, 780, 42));
        lblNome = new javax.swing.JLabel();
        lblNome.setText("Cliente selecionado");
        lblNome.setName("lblNome");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 180, 25));
        txtNome = new javax.swing.JTextField();
        txtNome.setName("txtNome");
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 370, 35));
        lblCliente = new javax.swing.JLabel();
        lblCliente.setText("Cliente");
        lblCliente.setName("lblCliente");
        getContentPane().add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 90, 180, 25));
        cmbCliente = new javax.swing.JComboBox();
        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Selecione um cliente","Jorge • exemplo","Ana • exemplo"}));
        cmbCliente.setName("cmbCliente");
        getContentPane().add(cmbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 120, 420, 35));
        lblServico = new javax.swing.JLabel();
        lblServico.setText("Serviço");
        lblServico.setName("lblServico");
        getContentPane().add(lblServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 175, 180, 25));
        cmbServico = new javax.swing.JComboBox();
        cmbServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Selecione um serviço","Corte","Barba","Corte e barba"}));
        cmbServico.setName("cmbServico");
        getContentPane().add(cmbServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 205, 370, 35));
        lblData = new javax.swing.JLabel();
        lblData.setText("Data");
        lblData.setName("lblData");
        getContentPane().add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 175, 120, 25));
        txtData = new javax.swing.JTextField();
        txtData.setToolTipText("DD/MM/AAAA");
        txtData.setName("txtData");
        getContentPane().add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 205, 150, 35));
        lblHora = new javax.swing.JLabel();
        lblHora.setText("Hora");
        lblHora.setName("lblHora");
        getContentPane().add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 175, 100, 25));
        txtHora = new javax.swing.JTextField();
        txtHora.setToolTipText("HH:MM");
        txtHora.setName("txtHora");
        getContentPane().add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 205, 100, 35));
        lblValor = new javax.swing.JLabel();
        lblValor.setText("Valor (R$)");
        lblValor.setName("lblValor");
        getContentPane().add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 175, 100, 25));
        txtValor = new javax.swing.JTextField();
        txtValor.setName("txtValor");
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 205, 130, 35));
        lblObservacoes = new javax.swing.JLabel();
        lblObservacoes.setText("Observações");
        lblObservacoes.setName("lblObservacoes");
        getContentPane().add(lblObservacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 255, 500, 25));
        scrollObservacoes = new javax.swing.JScrollPane();
        txtObservacoes = new javax.swing.JTextArea();
        txtObservacoes.setColumns(20);
        txtObservacoes.setRows(3);
        txtObservacoes.setLineWrap(true); txtObservacoes.setWrapStyleWord(true);
        scrollObservacoes.setViewportView(txtObservacoes);
        scrollObservacoes.setName("scrollObservacoes");
        getContentPane().add(scrollObservacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 285, 600, 90));
        btnAgendar = new javax.swing.JToggleButton();
        btnAgendar.setText("Agendar");
        btnAgendar.setName("btnAgendar");
        getContentPane().add(btnAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 305, 195, 45));
        lblTabela = new javax.swing.JLabel();
        lblTabela.setText("Dados de demonstração • registros em memória");
        lblTabela.setName("lblTabela");
        getContentPane().add(lblTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 800, 25));
        scrollAgenda = new javax.swing.JScrollPane();
        tblAgenda = new javax.swing.JTable();
        tblAgenda.setModel(new javax.swing.table.DefaultTableModel(new Object[0][7], new String[] {"ID","Observação","Cliente","Serviço","Data","Hora","Valor (R$)"}) { @Override public boolean isCellEditable(int r,int col) { return false; } });
        tblAgenda.setRowHeight(28); tblAgenda.setAutoCreateRowSorter(true);
        scrollAgenda.setViewportView(tblAgenda);
        scrollAgenda.setName("scrollAgenda");
        getContentPane().add(scrollAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 425, 825, 140));
        lblPainelAgenda = new javax.swing.JLabel();
        lblPainelAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/Agenda-PainelFundo.png")));
        lblPainelAgenda.setName("lblPainelAgenda");
        getContentPane().add(lblPainelAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 78, 890, 510));
        lblFundo = new javax.swing.JLabel();
        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/fundoagendamento.jpg")));
        lblFundo.setName("lblFundo");
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 620));
        pack();
    }// </editor-fold>//GEN-END:initComponents
    @SuppressWarnings("unchecked")
    private void configurarNavegacao() {
        controller.atualizaCliente();
        controller.atualizaServico();
        cmbServico.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> lista, Object valor,
                    int indice, boolean selecionado, boolean foco) {
                return super.getListCellRendererComponent(lista, valor instanceof Servico servico
                        ? servico.getDescricao() : valor, indice, selecionado, foco);
            }
        });
        txtNome.setEditable(false);
        txtValor.setEditable(false);
        txtData.setText("");
        txtHora.setText("");
        txtData.setToolTipText("dd/MM/aaaa");
        txtHora.setToolTipText("HH:mm");
        cmbCliente.addActionListener(e -> controller.atualizarSelecao());
        cmbServico.addActionListener(e -> controller.atualizarSelecao());
        btnAgendar.addActionListener(e -> controller.agendar());
        controller.atualizarSelecao();
        controller.atualizaTabela();
        tblAgenda.getColumnModel().getColumn(0).setPreferredWidth(42);
        tblAgenda.getColumnModel().getColumn(1).setPreferredWidth(210);
    }

    public javax.swing.JComboBox getCmbCliente() { return cmbCliente; }
    public javax.swing.JComboBox getCmbServico() { return cmbServico; }
    public javax.swing.JTextField getTxtNome() { return txtNome; }
    public javax.swing.JTextField getTxtValor() { return txtValor; }
    public javax.swing.JTextField getTxtData() { return txtData; }
    public javax.swing.JTextField getTxtHora() { return txtHora; }
    public javax.swing.JTextArea getTxtObservacoes() { return txtObservacoes; }
    public javax.swing.JTable getTblAgenda() { return tblAgenda; }
    public javax.swing.JToggleButton getBtnAgendar() { return btnAgendar; }

    public static void main(String[] args) { Ui.iniciar(() -> Ui.abrir(new Agenda())); }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtNome;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JLabel lblServico;
    private javax.swing.JComboBox cmbServico;
    private javax.swing.JLabel lblData;
    private javax.swing.JTextField txtData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JTextField txtHora;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTextField txtValor;
    private javax.swing.JLabel lblObservacoes;
    private javax.swing.JScrollPane scrollObservacoes;
    private javax.swing.JTextArea txtObservacoes;
    private javax.swing.JToggleButton btnAgendar;
    private javax.swing.JLabel lblTabela;
    private javax.swing.JScrollPane scrollAgenda;
    private javax.swing.JTable tblAgenda;
    private javax.swing.JLabel lblPainelAgenda;
    private javax.swing.JLabel lblFundo;
    // End of variables declaration//GEN-END:variables
}
