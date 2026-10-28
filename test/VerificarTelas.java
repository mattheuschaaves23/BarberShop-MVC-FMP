import javax.swing.*;
import java.awt.*;
import View.*;
public class VerificarTelas {
    static int n;
    static void ok(boolean v) { n++; if(!v) throw new AssertionError("Falha de tela " + n); }
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            for(JFrame f:new JFrame[]{new Login(),new MenuPrincipal(),new Agenda()}) {
                try { ok(f.getContentPane().getLayout() instanceof org.netbeans.lib.awtextra.AbsoluteLayout);
                    ok(f.getWidth()>900 && f.getHeight()>600);
                    if(f instanceof MenuPrincipal) { ok(f.getJMenuBar().getMenuCount()==2); ok(f.getJMenuBar().getMenu(0).getItemCount()==2); }
                    for(Component c:f.getContentPane().getComponents()) {
                        ok(c.getX()>=0 && c.getY()>=0 && c.getX()+c.getWidth()<=940 && c.getY()+c.getHeight()<=620);
                        if(c instanceof JLabel && ((JLabel)c).getIcon()!=null) ok(((JLabel)c).getIcon().getIconWidth()>0);
                        if(c instanceof JScrollPane && ((JScrollPane)c).getViewport().getView() instanceof JTable) ok(((JTable)((JScrollPane)c).getViewport().getView()).getColumnCount()==7);
                    }
                } finally { f.dispose(); }
            }
        });
        System.out.println(n+" verificações de telas e recursos aprovadas.");
    }
}
