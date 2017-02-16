package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


//import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = -1279579398457353579L;
	@Id @GeneratedValue
	@Column(name = "id")
	private Integer id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	public Gender gender;
	@Column(name = "dateOfBirth")
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private LocalDate dateOfBirth;
	@Column(name = "position")
	private String position;
	@Column(name = "comment")
	private String comment;
	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;
	@Column(name = "image")
	@Lob
	private byte[] image;
	@Transient
	@OneToMany(mappedBy="employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)//bidirectional association (hibernate will not create additional table to connect employee and task) )
	private List<Task> tasklist;
	
	
	/* 
	*/
	
	public Employee(){
		
	}
	public Employee(String firstName,String lastName,LocalDate dateOfBirth,Gender gender,String position,String login, String password){
		this.firstName=firstName;
		this.lastName=lastName;
		this.dateOfBirth=dateOfBirth;
		this.gender=gender;
		this.position=position;
		this.login=login;
		this.password=password;						
	}
	
	public List<Task> getTasklist() {
		return tasklist;
	}
	public void setTasklist(List<Task> tasklist) {
		this.tasklist = tasklist;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDate getDateOfBirth() {
		
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {

		this.dateOfBirth=dateOfBirth;
	}
}
