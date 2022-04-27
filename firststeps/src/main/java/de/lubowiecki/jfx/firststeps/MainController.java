package de.lubowiecki.jfx.firststeps;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.lubowiecki.jfx.firststeps.model.Product;
import de.lubowiecki.jfx.firststeps.model.ProductMapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
	
	private ProductMapper mapper;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextArea description;
	
	@FXML
	private TextField amount;
	
	@FXML
	private TableView<Product> output;
	
	@FXML
	private Label errors;
	
	@FXML
	private Button btnEdit;
	
	private boolean update;
	
	@FXML // macht Methoden und Eigenschaften für die GUI verwendbar
    private void save() throws IOException {
		
		errors.setText("");
		
		
		Product p = null;
		
		if(update) {
			p = output.getSelectionModel().getSelectedItem();
		}
		else {
			p = new Product();
		}
		
		p.setName(name.getText());
		p.setDescription(description.getText());
		
		try {
			p.setAmount(Integer.parseInt(amount.getText()));
			
			if(update) {
				mapper.update(p);
			}
			else {
				mapper.insert(p);
			}
			
			showProducts();
			clearFields();
		} 
		catch(NumberFormatException e) {
			errors.setText("Die Anzahl ist keine gültige Zahl.");
		}
		catch (Exception e) {
			// TODO: Ausgabe der Exceptions in die GUI verlagern
			e.printStackTrace();
		}
        
    }
	
	@FXML
    private void edit() throws IOException {
		
		if(btnEdit.getText().equals("Abbrechen")) {
			clearFields();
			return;
		}
		
		try {
			Product p = output.getSelectionModel().getSelectedItem();
			name.setText(p.getName());
			description.setText(p.getDescription());
			amount.setText(p.getAmount() + "");
			update = true;
			btnEdit.setText("Abbrechen");
			
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	@FXML
    private void delete() throws IOException {
		
		errors.setText(""); // Fehleranzeige zurücksetzen
		
		try {
			// Ausgewählte Zeile im TableView liefert ein passendes Product
			Product p = output.getSelectionModel().getSelectedItem();
			mapper.delete(p);
			showProducts();
			clearFields();
		}
		catch (NullPointerException e) {
			errors.setText("Es wurde kein Produkt ausgewählt.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	private void showProducts() {
		
		try {
//			List<Product> products = mapper.findAll();
//			// List wird in ObservableList konvertiert
//			ObservableList<Product> oList = FXCollections.observableList(products);
//			// und dem TableView zugewiesen
//			output.setItems(FXCollections.observableList(products));
			
			output.setItems(FXCollections.observableList(mapper.findAll()));
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	private void clearFields() {
		name.setText("");
		description.setText("");
		amount.setText("");
		output.getSelectionModel().clearSelection();
		errors.setText("");
		update = false;
		btnEdit.setText("Bearbeiten");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			mapper = new ProductMapper();
			showProducts();
		}
		catch(Exception e) {
			// TODO: Ausgabe der Exceptions in die GUI verlagern
			e.printStackTrace();
		}
	}
	
}
