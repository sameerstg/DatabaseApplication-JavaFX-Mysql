package application;



public class StudentData {
	public String id, name,email,phonenumber;
	
	
	
	
	public StudentData(String id, String name, String email, String phonenumber) {
		super();
		this.id = id;
		this.name = name;
		this.email =email;
		this.phonenumber = phonenumber;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
}

	


