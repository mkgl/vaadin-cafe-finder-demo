package me.mkgl.demo;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
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
        cafeList.addColumn(Cafe::getEvaluation).setHeader("Evaluation");

        add(new H3("All cafés"), cafeList);
        expand(cafeList);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        cafeList.setDataProvider(DataProvider.ofCollection(service.getAllCafes()));
    }
}
