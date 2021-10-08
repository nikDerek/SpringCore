package com.revature.model;

//import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import lombok.ToString;

//@Data?

@Getter
@Setter
//@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")

public class User {
	@Id
	@Column(name="userId")
	private String userId;
	@Column(name="userType")
	private String userType;
	@Column(name="name")
	private String name;
	@Column(name="userName", unique = true)
	private String userName;
	@Column(name="password")
	private String password;
	@Override
	
	public String toString() {
		return "User [userId=" + userId + ", userType=" + userType + ", name=" + name + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	

}
