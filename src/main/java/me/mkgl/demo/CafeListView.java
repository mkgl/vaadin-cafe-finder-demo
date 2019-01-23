package me.mkgl.demo;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

/**
 *
 */
@Route(value = "cafes", layout = AppLayout.class)
public class CafeListView extends VerticalLayout implements BeforeEnterObserver {

    private final CafeService service;
    private final Grid<Cafe> cafeList;

    public CafeListView() {
        service = new CafeService();

        H3 title = new H3("All cafés");
        cafeList = new Grid<>();
        cafeList.addColumn(Cafe::getName).setHeader("Café");
        cafeList.addColumn(new ComponentRenderer<>(cafe -> {
            Div ratings = new Div();
            for (int i = 0; i < 5; i++) {
                if (cafe.getEvaluation() > i) {
                    ratings.add(new Icon(VaadinIcon.STAR));
                } else {
                    ratings.add(new Icon(VaadinIcon.STAR_O));
                }
            }
            return ratings;
        })).setHeader("Rating");

        add(title, cafeList);

    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        cafeList.setDataProvider(DataProvider.ofCollection(service.getAllCafes()));
    }
}
