package Models;

import java.util.Date;

public class AbsenceRecord {
private  int absencenum;
private String type;
private Date dateabs;
public AbsenceRecord(int absencenum, String type, Date dateabs) {
	super();
	this.absencenum = absencenum;
	this.type = type;
	this.dateabs = dateabs;
}
public int getAbsencenum() {
	return absencenum;
}
public  void setAbsencenum(int absencenum) {
	this.absencenum = absencenum;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Date getDateabs() {
	return dateabs;
}
public void setDateabs(Date dateabs) {
	this.dateabs = dateabs;
}

}
