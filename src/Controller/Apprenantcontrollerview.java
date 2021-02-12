package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import Dao.Dao;
import Dao.UserSession;
import Models.AbsenceRecord;
import Models.Apprenant;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Apprenantcontrollerview implements Initializable {
	 @FXML
	    private Button logout;
	@FXML private  Label namelabel;
	@FXML private  Label promotion;
	
	@FXML private  DatePicker date1;
	@FXML private  DatePicker date2;
	@FXML private  String num;
	 
	
	@FXML private  String date;
	
	  @FXML
	    private TableView<AbsenceRecord> absence;

	    @FXML
	    private TableColumn<AbsenceRecord, Integer> absencenum;

	    @FXML
	    private TableColumn<AbsenceRecord, String> type;

	    @FXML
	    private TableColumn<AbsenceRecord, Date> dateabs;
	    ObservableList <AbsenceRecord> listm;
	   
	   
	
	private Apprenant app;
	public void initdata(Apprenant ap) {
		app=ap;
		namelabel.setText(app.getnomuser());
		promotion.setText(String.valueOf(app.getIdPromotion()));
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			
			
			app=Dao.getApprenant(Integer.parseInt(UserSession.getID()));
			
			initdata(app);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void filtrer() throws SQLException {	
		 absencenum.setCellValueFactory(new PropertyValueFactory <AbsenceRecord, Integer>("absencenum"));
		 type.setCellValueFactory(new PropertyValueFactory <AbsenceRecord, String>("type"));
		 dateabs.setCellValueFactory(new PropertyValueFactory <AbsenceRecord,Date>("dateabs"));
		 
		 listm=Dao.getabsence(date1.getValue().toString(), date2.getValue().toString(), app.getId());
		absence.setItems(listm);

	}
	public void logout(ActionEvent event) throws IOException {
		Parent PageApprenant = FXMLLoader.load(getClass().getResource("../View/pageLogin.fxml"));
		Scene s = new Scene(PageApprenant);
		Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
		page.setScene(s);
		page.show();
	}


}
