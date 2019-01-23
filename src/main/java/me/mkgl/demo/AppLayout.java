package me.mkgl.demo;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;

/**
 *
 */
@HtmlImport("styles/shared-styles.html")
public class AppLayout extends VerticalLayout implements RouterLayout {
    public AppLayout() {
        add(new HorizontalLayout(
                new Image("café-logo.png", "Café Finder"),
                new H3("Café Finder")));
    }
}
