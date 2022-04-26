package de.lubowiecki.jfx.firststeps;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import de.lubowiecki.jfx.firststeps.model.Product;
import de.lubowiecki.jfx.firststeps.model.ProductMapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
	private TextArea output;
	
	@FXML // macht Methoden und Eigenschaften für die GUI verwendbar
    private void sagHallo() throws IOException {
		
		Product p = new Product();
		p.setName(name.getText());
		p.setDescription(description.getText());
		// TODO: Validieren
		p.setAmount(Integer.parseInt(amount.getText()));
		
		try {
			mapper.insert(p);
			
			output.setText(showProducts());
			
		} catch (Exception e) {
			// TODO: Ausgabe der Exceptions in die GUI verlagern
			e.printStackTrace();
		}
        
    }
	
	private String showProducts() {
		
		List<Product> products;
		StringBuilder sb = new StringBuilder();
		
		try {
			products = mapper.findAll();
			
			for(Product p : products) {
	        	sb.append(p.getId()).append("\n");
	        	sb.append(p.getName()).append("\n");
	        	sb.append(p.getAmount()).append("\n\n");
	        }
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			mapper = new ProductMapper();
			output.setText(showProducts());
		}
		catch(Exception e) {
			// TODO: Ausgabe der Exceptions in die GUI verlagern
			e.printStackTrace();
		}
	}
	
}
