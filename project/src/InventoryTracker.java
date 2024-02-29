import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class InventoryTracker extends Application {
    private ArrayList<Product> products = new ArrayList<>();
    private TextField nameProduct, quantityProduct; // text field
    private ListView<String> productListView; // to manage the products in a list
    private EventHandlers eventHandlers;
    private Button button;


    @Override
    public void start(Stage primaryStage) throws Exception {
        // initialisation of graphic elements
        nameProduct = new TextField();
        quantityProduct = new TextField();
        productListView = new ListView<>();
        button = new Button("Ajouter");

        eventHandlers = new EventHandlers(products, nameProduct, quantityProduct, productListView, button);
        eventHandlers.addEventHandlers();

        // creating the layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Nom du produit : ");
        GridPane.setConstraints(nameLabel, 0, 0);
        GridPane.setMargin(nameLabel, new Insets(0, 0, 5, 0)); // margin at the bottom for the label

        GridPane.setConstraints(nameProduct, 1, 0);

        Label quantityLabel = new Label("Quantité:");
        GridPane.setConstraints(quantityLabel, 0, 1);
        GridPane.setMargin(quantityLabel, new Insets(0, 0, 5, 0)); // margin at the bottom for the label

        GridPane.setConstraints(quantityProduct, 1, 1);

        GridPane.setConstraints(button, 1, 2);

        GridPane.setConstraints(productListView, 0, 3, 2, 1);
        productListView.setPrefHeight(200);

        grid.getChildren().addAll(nameLabel, nameProduct, quantityLabel, quantityProduct, button, productListView);

        // stage creation
        Scene scene = new Scene(grid, 300, 250);

        // scene setup and window display
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestion de stocks");
        primaryStage.show();
    }
}
