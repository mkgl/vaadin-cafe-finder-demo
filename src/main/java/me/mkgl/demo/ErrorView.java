package me.mkgl.demo;

import javax.servlet.http.HttpServletResponse;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.NotFoundException;

public class ErrorView extends VerticalLayout implements HasErrorParameter<NotFoundException> {
    private final Paragraph reason;

    public ErrorView() {
        addClassName("error-panel");

        H3 title = new H3("Got lost?");
        reason = new Paragraph();
        reason.setVisible(false);

        Button goHome = new Button("Go home", event -> {
            UI.getCurrent().navigate(LoginView.class);
        });
        goHome.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        goHome.setIcon(new Icon(VaadinIcon.HOME));

        add(title, reason, goHome);
    }

    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
        reason.setText("Could not navigate to '" + event.getLocation().getPath() + "'");
        reason.setVisible(true);
        return HttpServletResponse.SC_NOT_FOUND;
    }
}
