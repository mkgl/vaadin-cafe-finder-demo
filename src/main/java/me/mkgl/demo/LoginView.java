package me.mkgl.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

/**
 *
 */
@Route(value = "", layout = AppLayout.class)
@RouteAlias("login")
public class LoginView extends VerticalLayout {
    public LoginView() {
        H3 welcome = new H3("Welcome to Café Finder");
        TextField userName = new TextField("User name");
        Button signIn = new Button("Sign in", click -> {
            UI.getCurrent().navigate(CafeListView.class);
        });
        signIn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        signIn.addClassName("sign-in");

        add(welcome, userName, signIn, new Checkbox("Remember me", true));
    }
}
