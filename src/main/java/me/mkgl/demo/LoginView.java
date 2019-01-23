package me.mkgl.demo;

import org.vaadin.marcus.shortcut.Shortcut;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("Café Finder")
public class LoginView extends VerticalLayout {
    private static final String APP_TITLE = "Café Finder";

    public LoginView() {
        TextField username = new TextField("Name");
        username.focus();

        Button signin = new Button("Coffee please!", click -> {
            UI.getCurrent().navigate(CafeListView.class);
        });

        Shortcut.add(username, Key.ENTER, signin::click);

        add(new H3(APP_TITLE), username, signin, new Checkbox("Remember me", true));
    }
}