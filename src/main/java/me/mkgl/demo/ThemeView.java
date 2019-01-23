package me.mkgl.demo;

import org.vaadin.marcus.shortcut.Shortcut;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "theme")
@HtmlImport("styles/shared-styles.html")
public class ThemeView extends FormLayout {
    private static final String LOREM_IPSUM = "Nullam quis risus eget urna mollis ornare vel eu leo";

    public ThemeView() {
        FormLayout form = new FormLayout();

        addClassName("main");
        // FIXME ASIDE doesn't
        setResponsiveSteps(new ResponsiveStep("0", 1, ResponsiveStep.LabelsPosition.ASIDE));

        H3 title = new H3("Text fields");

        TextField textField = new TextField("Text field", LOREM_IPSUM, "");
        TextField hover = new TextField("Text field hover", LOREM_IPSUM, "");
        TextField focus = new TextField("Text field focus", "Nullam ", "");
        focus.focus();
        TextField disabled = new TextField("Text field disabled", LOREM_IPSUM, "");
        disabled.setEnabled(false);
        TextField invalid = new TextField("Text field validation", LOREM_IPSUM, "");
        TextField placeholder = new TextField("Placeholder field");
        placeholder.setPlaceholder("Add description here...");

        Button button = new Button("Field button", click -> Notification.show("Submitted", 3000, Position.TOP_CENTER));
        // FIXME should ignore text-area but doesn't
        Shortcut.add(this, Key.ENTER, button::click);
        button.setSizeUndefined();

        Button primary = new Button("Primary button");
        primary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button secondary = new Button("Register");
        secondary.addClassName("secondary");

        add(title, textField, hover, focus, disabled, invalid, placeholder,
                new TextArea("Text area"),
                new Div(button), new HorizontalLayout(primary, secondary));
    }
}