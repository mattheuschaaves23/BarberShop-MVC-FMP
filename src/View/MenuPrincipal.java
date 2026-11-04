package View;

import Controller.MenuPrincipalController;

/** Tela Swing editável pelo GUI Builder; AbsoluteLayout solicitado no roteiro. */
public class MenuPrincipal extends javax.swing.JFrame {
    private final MenuPrincipalController controller;

    public MenuPrincipal() {
        initComponents();
        Ui.tema(this);
        controller = new MenuPrincipalController(this);
        configurarNavegacao();
    }
    @SuppressWarnings({"unchecked", "serial"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BarberShop | Menu principal");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        lblTitulo = new javax.swing.JLabel();
        lblTitulo.setText("BARBERSHOP");
        lblTitulo.setName("lblTitulo");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 45, 720, 55));
        lblSubtitulo = new javax.swing.JLabel();
        lblSubtitulo.setText("Organize o cuidado. Valorize cada atendimento.");
        lblSubtitulo.setName("lblSubtitulo");
        getContentPane().add(lblSubtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 105, 780, 35));
        btnAgenda = new javax.swing.JButton();
        btnAgenda.setText("Abrir agenda");
        btnAgenda.setName("btnAgenda");
        getContentPane().add(btnAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 180, 245, 45));
        lblEtapa = new javax.swing.JLabel();
        lblEtapa.setText("Aula 12 • Login validado • dados de demonstração");
        lblEtapa.setName("lblEtapa");
        getContentPane().add(lblEtapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 535, 850, 30));
        lblFundo = new javax.swing.JLabel();
        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/fundomenu1.jpg")));
        lblFundo.setName("lblFundo");
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 600));
        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void configurarNavegacao() {
        javax.swing.JMenuBar barraMenu=new javax.swing.JMenuBar();
        javax.swing.JMenu menuCadastro=new javax.swing.JMenu("Cadastro");
        javax.swing.JMenu menuOperacao=new javax.swing.JMenu("Operação");
        javax.swing.JMenuItem itemCliente=new javax.swing.JMenuItem("Cliente",Ui.icone("icons/cliente32-icon.png",24,24));
        javax.swing.JMenuItem itemServico=new javax.swing.JMenuItem("Serviço",Ui.icone("icons/tesoura32-icon.png",24,24));
        javax.swing.JMenuItem itemAgenda=new javax.swing.JMenuItem("Agenda",Ui.icone("icons/agenda32-icon.png",24,24));
        menuCadastro.add(itemCliente); menuCadastro.add(itemServico); menuOperacao.add(itemAgenda);
        barraMenu.add(menuCadastro); barraMenu.add(menuOperacao); setJMenuBar(barraMenu); pack(); setLocationRelativeTo(null);
        itemCliente.addActionListener(e -> javax.swing.JOptionPane.showMessageDialog(this,"Os clientes de demonstração estão disponíveis na agenda."));
        itemServico.addActionListener(e -> javax.swing.JOptionPane.showMessageDialog(this,"Os serviços de demonstração estão disponíveis na agenda."));
        itemAgenda.addActionListener(e -> controller.navegarParaAgenda());
        btnAgenda.addActionListener(e -> controller.navegarParaAgenda());
    }
    public static void main(String[] args) { Ui.iniciar(() -> Ui.abrir(new MenuPrincipal())); }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JButton btnAgenda;
    private javax.swing.JLabel lblEtapa;
    private javax.swing.JLabel lblFundo;
    // End of variables declaration//GEN-END:variables
}
