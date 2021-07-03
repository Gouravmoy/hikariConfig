package com.example.hikariConfg.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_user")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	long id;
	@Column(name = "FIRST_NAME")
	String appName;
	@Column(name = "LAST_NAME")
	String lastName;

}
