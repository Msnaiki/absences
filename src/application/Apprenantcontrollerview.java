package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class Apprenantcontrollerview implements Initializable {
	@FXML private  Label namelabel;
	@FXML private  Label promotion;
	@FXML private  Label absence;
	@FXML private  DatePicker date1;
	@FXML private  DatePicker date2;
	private Apprenant app;
	public void initdata(Apprenant ap) {
		app=ap;
		namelabel.setText(app.getNom());
		promotion.setText(String.valueOf(app.getPromotion()));
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			app=Dao.getApprenant("mehdi@gmail");
			initdata(app);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void filtrer() throws SQLException {
		int abs=Dao.getabsence(date1.getValue().toString(), date2.getValue().toString(), app.getId());
		absence.setText(String.valueOf(abs));
		
	}

}
