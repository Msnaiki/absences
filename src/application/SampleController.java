package application;

import java.io.IOException;

import java.sql.SQLException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SampleController  {
	public void testing() {
		System.out.println("hi");
	}
	
	public void nextscene(ActionEvent event) throws IOException, SQLException {
		

	
		AnchorPane nroot = (AnchorPane)FXMLLoader.load(getClass().getResource("sample.fxml"));
		
		Scene nscene = new Scene(nroot,800,600);
		nscene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(nscene);
		
		window.show();
		
		System.out.println("it works");
		
		
	}
	

	

	
	
}
