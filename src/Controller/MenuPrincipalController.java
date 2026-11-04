package Controller;

import View.Agenda;
import View.MenuPrincipal;

/** Adaptação do controller fornecido no material da Aula 12. */
public class MenuPrincipalController {
    private final MenuPrincipal view;
    private Agenda agenda;

    public MenuPrincipalController(MenuPrincipal view) { this.view = view; }

    public void navegarParaAgenda() {
        if (agenda == null || !agenda.isDisplayable()) {
            agenda = new Agenda();
            agenda.setLocationRelativeTo(view);
        }
        agenda.setVisible(true);
        agenda.toFront();
    }
}
