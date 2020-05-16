package br.com.fec.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.fec.model.enums.Sexo;

@Entity(name = "TB_PERSON")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person extends AuditModel {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull
	@Size(min = 50, message = "First Name should have atleast 2 characters")
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@NotNull
	@Size(min = 50, message = "Last Name should have atleast 2 characters")
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Email
	@NotBlank
	private String email;
	private Date birthday;
	private Boolean status;
	private Sexo sexo;
	@NotNull
	@Size(min = 30, message = "Profession should have atleast 2 characters")
	private String profession;
	@NotNull
	@Size(min = 11, message = "CPF should have atleast 11 characters")
	private String cpf;
	@NotNull
	@Size(min = 100, message = "Address should have atleast 50 characters")
	private String address;
	@NotNull
	@Size(min = 10, message = "CEP should have atleast 2 characters")
	private String cep;
	private String photo;
	@NotNull
	@Size(min = 13, message = "Phone should have atleast 2 characters")
	private String phone;

	public Person() {

	}

	public Person(Integer id, String firstName, String lastName, String email, Date birthday, Boolean status, Sexo sexo,
			String profession, String cpf, String address, String cep, String photo, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.status = status;
		this.sexo = sexo;
		this.profession = profession;
		this.cpf = cpf;
		this.address = address;
		this.cep = cep;
		this.photo = photo;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", birthday=" + birthday + ", status=" + status + ", sexo=" + sexo + ", profession=" + profession
				+ ", cpf=" + cpf + ", address=" + address + ", cep=" + cep + ", photo=" + photo + ", phone=" + phone
				+ "]";
	}

}
