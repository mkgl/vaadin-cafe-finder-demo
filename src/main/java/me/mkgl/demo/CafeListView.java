package me.mkgl.demo;

import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "cafes", layout = AppLayout.class)
@PageTitle("All cafés - Café Finder")
public class CafeListView extends VerticalLayout implements BeforeEnterObserver {
    private final CafeService service;
    private final Grid<Cafe> cafeList;

    public CafeListView() {
        service = new CafeService();

        setSizeFull();
        addClassName("grid-panel");

        cafeList = new Grid<>();
        cafeList.addColumn(Cafe::getName).setHeader("Café");
        cafeList.addColumn(new ComponentRenderer<>(cafe -> {
            Div rating = new Div();
            for (int i = 0; i < 5; i++) {
                if (cafe.getEvaluation() <= i) {
                    rating.add(new Icon(VaadinIcon.STAR_O));
                } else {
                    rating.add(new Icon(VaadinIcon.STAR));
                }
            }
            return rating;
        })).setHeader("Evaluation");

        add(new H3("All cafés"), cafeList);
        expand(cafeList);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        try {
            cafeList.setDataProvider(DataProvider.ofCollection(service.getAllCafes()));
        } catch (ResourceAccessException e) {
            // FIXME cannot specifically style notifications atm; see https://github.com/vaadin/vaadin-notification-flow/issues/49
            Notification.show("Couldn't fetch cafés right now", 10000, Position.MIDDLE);
        } catch (RestClientException e) {
            Notification.show("Couldn't render cafés right now", 10000, Position.MIDDLE);
        }
    }
}
