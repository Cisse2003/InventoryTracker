import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class EventHandlers {
    private ArrayList<Product> products;
    private TextField nameField, quantityField;
    private ListView<String> productListView;
    private Button button;

    public EventHandlers(ArrayList<Product> products, TextField nameField, TextField quantityField, ListView<String> productListView, Button button) {
        this.products = products;
        this.nameField = nameField;
        this.quantityField = quantityField;
        this.productListView = productListView;
        this.button = button;
    }

    public void addEventHandlers() {
        addButtonHandler();
        listViewHandler();
    }

    private void addButtonHandler() {
        button.setOnAction(e -> addProduct());
    }

    private void listViewHandler() {
        productListView.setOnMouseClicked(event -> {
            String selectedItem = productListView.getSelectionModel().getSelectedItem();
        });
    }

    private void addProduct() {
        String name = nameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        Product product = new Product(name, quantity);
        products.add(product);
        updateProductListView();
        nameField.clear();
        quantityField.clear();
    }

    private void updateProductListView() {
        productListView.getItems().clear();
        for (Product product : products) {
            productListView.getItems().add("Nom : " + product.name + ", Quantité : " + product.quantity);
        }
    }
}
