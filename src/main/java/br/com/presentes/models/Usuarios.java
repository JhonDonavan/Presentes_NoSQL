package br.com.presentes.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuarios {
	
	private String id;
	
	private String username;
	
	//@JsonIgnore
	private String password;
	
	//@JsonIgnore
	private String passwordVerification;
	
	private Double salary;
	
	private Integer age;
	
	private List<Presente> presentes;

	public Usuarios(String id, String username, String password, String passwordVerification, Double salary, Integer age, List<Presente> presentes) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.passwordVerification = passwordVerification;
		this.salary = salary;
		this.age = age;
		this.presentes = presentes;
	}
	
	public Usuarios() {	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPasswordVerification() {
		return passwordVerification;
	}

	public void setPasswordVerification(String passwordVerification) {
		this.passwordVerification = passwordVerification;
	}

	public String getId() {
		return id;
	}
	
	public List<Presente> getPresentes() {
		return presentes;
	}

	public void setPresentes(List<Presente> presentes) {
		this.presentes = presentes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((passwordVerification == null) ? 0 : passwordVerification.hashCode());
		result = prime * result + ((presentes == null) ? 0 : presentes.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (passwordVerification == null) {
			if (other.passwordVerification != null)
				return false;
		} else if (!passwordVerification.equals(other.passwordVerification))
			return false;
		if (presentes == null) {
			if (other.presentes != null)
				return false;
		} else if (!presentes.equals(other.presentes))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", username=" + username + ", password=" + password + ", passwordVerification="
				+ passwordVerification + ", salary=" + salary + ", age=" + age + ", presentes=" + presentes + "]";
	}

	

}
