package com.example.mywebapp.model;
import java.util.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Course {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String title;
  
  //@Column(name="DATE_CREATED")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  
  @Temporal(TemporalType.TIMESTAMP)
  private Date modified;
  
  
  public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Date getCreated() {
	return created;
}

public void setCreated(Date created) {
	this.created = created;
}

public Date getModified() {
	return modified;
}

public void setModified(Date modified) {
	this.modified = modified;
}
}
