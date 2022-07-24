package com.wipro.springboot.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Admin {
    private Integer id;
    private String admin_name;
    private String password;
 
    public Admin() {
    }

    public Admin(Integer id, String admin_name, String password) {
		super();
		this.id = id;
		this.admin_name = admin_name;
		this.password = password;
	}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", admin_name=" + admin_name + ", password=" + password + "]";
	}


}



   