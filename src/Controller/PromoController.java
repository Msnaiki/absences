package Controller;

import Dao.Database;
import Models.Apprenant;
import Models.Formateur;
import Models.TableModel;
import Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class PromoController {

    @FXML
    private ComboBox Bx_TeachID;

    ObservableList<Formateur> list = FXCollections.observableArrayList();


    @FXML
    public void initialize() throws ClassNotFoundException, SQLException {

        Database OpenConnection = new Database();
        Connection connectDB = OpenConnection.getConnection();
        String Query = "SELECT id FROM `user` where user.Role = 'formateur'";
        try {

            PreparedStatement ps2 = OpenConnection.getConnection().prepareStatement(Query);
            ResultSet rs2;
            rs2 = ps2.executeQuery();

            while(rs2.next()) {
                //list.addAll(db.getApprenant(promo.getId()));
                //comboBox.setItems(list);
            }
            Bx_TeachID.setItems(list);

        }
        catch (SQLException ex) {
            System.err.println("Error"+ex);
        }


    }
}
