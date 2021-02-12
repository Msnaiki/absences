package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Models.AbsenceRecord;
import Models.Apprenant;
import Models.Presence;
import Models.Promo;
import Models.User;
import javafx.collections.ObservableList;

public interface InterfaceDb {
   User authentification(String email, String password);
   ArrayList<Promo> getPromotions();
   Promo getPromotionsByForrmateur(int idFormateur);
   ArrayList<Apprenant> getApprenant(int idPromo);
   int addAbsence(Presence presence);
   ArrayList<Presence> getListAbsence(int idApprenant);
   Apprenant getApprenant2(int id) throws SQLException;
   ObservableList<AbsenceRecord> getabsence(String string, String string2, int id) throws SQLException;
}