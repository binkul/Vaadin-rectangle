package com.vaadin.rectangleapp;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
@StyleSheet("frontend://styles/style.css")
public class RectangleGui extends VerticalLayout {

    private final RectangleRepo rectangleRepo;
    private TextField textFieldHeight;
    private TextField textFieldWidth;
    private Button button;

    public RectangleGui(final RectangleRepo rectangleRepo) {
        this.rectangleRepo = rectangleRepo;
        textFieldHeight = new TextField("Podaj wysokość");
        textFieldWidth = new TextField("Podaj szerokość");
        button = new Button("Dodaj!");
        button.addClassName("jacek");
        button.addClickListener(clickEvent -> addRectangle());

        add(textFieldHeight);
        add(textFieldWidth);
        add(button);
    }

    public void addRectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(Integer.parseInt(textFieldHeight.getValue()));
        rectangle.setWidth(Integer.parseInt(textFieldWidth.getValue()));
        rectangleRepo.save(rectangle);
    }

}
