package View;
import java.awt.*;
import java.net.URL;
import javax.swing.*;

/** Recursos locais no classpath, inclusive dentro do JAR. */
final class Ui {
    private Ui() { }
    static ImageIcon icone(String nome, int w, int h) {
        URL url = Ui.class.getResource("/View/Imagens/" + nome);
        if (url == null) throw new IllegalStateException("Recurso ausente: " + nome);
        return new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
    }
    static void tema(JFrame tela) {
        for (Component c : tela.getContentPane().getComponents()) {
            c.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            if (c instanceof JLabel) c.setForeground(Color.WHITE);
            if (c instanceof JLabel && ((JLabel)c).getIcon() instanceof ImageIcon) {
                JLabel label=(JLabel)c;
                ImageIcon im=(ImageIcon)label.getIcon();
                label.setIcon(new ImageIcon(im.getImage().getScaledInstance(c.getWidth(),c.getHeight(),Image.SCALE_SMOOTH)));
            }
        }
        tela.setLocationRelativeTo(null);
    }
    static void abrir(JFrame tela) { tela.setVisible(true); }
    static void iniciar(Runnable r) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (ReflectiveOperationException | UnsupportedLookAndFeelException e) { System.err.println(e.getMessage()); }
        EventQueue.invokeLater(r);
    }
}
