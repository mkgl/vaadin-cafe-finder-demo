package me.mkgl.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.PageConfigurator;

@HtmlImport("styles/shared-styles.html")
@PWA(name = "Café Finder", shortName = "CaféFinder")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=no")
public class AppLayout extends VerticalLayout implements RouterLayout, PageConfigurator {

    public AppLayout() {
        setSizeFull();

        Image logo = new Image("café-logo.png", "Café Finder logo");
        logo.addClassName("logo");
        logo.getElement().addEventListener("click", domEvent -> UI.getCurrent().navigate(LoginView.class));

        TextField findBar = new TextField();
        findBar.setPlaceholder("Find...");

        FlexLayout header = new FlexLayout();
        header.setWidth("100%");
        header.add(logo, findBar);
        header.setAlignItems(Alignment.CENTER);
        header.setFlexGrow(1, findBar);

        add(header);
    }

    @Override
    public void configurePage(InitialPageSettings settings) {
        settings.addMetaTag("apple-mobile-web-app-capable", "yes");
        settings.addMetaTag("apple-mobile-web-app-status-bar-style", "black-translucent");
    }
}
