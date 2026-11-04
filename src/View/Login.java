package View;

import Controller.LoginController;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/** Tela Swing editável pelo GUI Builder; AbsoluteLayout solicitado no roteiro. */
public class Login extends javax.swing.JFrame {
    private final LoginController controller;

    public Login() {
        initComponents();
        Ui.tema(this);
        controller = new LoginController(this);
        configurarNavegacao();
    }
    @SuppressWarnings({"unchecked", "serial"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BarberShop | Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        lblTitulo = new javax.swing.JLabel();
        lblTitulo.setText("LOGIN");
        lblTitulo.setName("lblTitulo");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 300, 45));
        lblUsuario = new javax.swing.JLabel();
        lblUsuario.setText("Usuário");
        lblUsuario.setName("lblUsuario");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 280, 25));
        txtUsuario = new javax.swing.JTextField();
        txtUsuario.setName("txtUsuario");
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 205, 280, 38));
        lblSenha = new javax.swing.JLabel();
        lblSenha.setText("Senha");
        lblSenha.setName("lblSenha");
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 265, 280, 25));
        txtSenha = new javax.swing.JPasswordField();
        txtSenha.setName("txtSenha");
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 280, 38));
        btnEntrar = new javax.swing.JButton();
        btnEntrar.setText("Entrar");
        btnEntrar.setName("btnEntrar");
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 280, 42));
        lblAviso = new javax.swing.JLabel();
        lblAviso.setText("Demonstração • validação pelo DAO");
        lblAviso.setName("lblAviso");
        getContentPane().add(lblAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 320, 30));
        lblPainelLogin = new javax.swing.JLabel();
        lblPainelLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/painel-login.png")));
        lblPainelLogin.setName("lblPainelLogin");
        getContentPane().add(lblPainelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 370, 460));
        lblFundo = new javax.swing.JLabel();
        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagens/logo1.jpg")));
        lblFundo.setName("lblFundo");
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 620));
        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void configurarNavegacao() {
        getRootPane().setDefaultButton(btnEntrar);
        btnEntrar.addActionListener(e -> controller.entrarNoSistema());
    }

    public JTextField getTxtUsuario() { return txtUsuario; }
    public JPasswordField getTxtSenha() { return txtSenha; }
    public void setTxtUsuario(String usuario) { txtUsuario.setText(usuario); }
    public void setTxtSenha(String senha) { txtSenha.setText(senha); }
    public void mostrarMensagem(String mensagem) { lblAviso.setText(mensagem); }
    public static void main(String[] args) { Ui.iniciar(() -> Ui.abrir(new Login())); }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblPainelLogin;
    private javax.swing.JLabel lblFundo;
    // End of variables declaration//GEN-END:variables
}
