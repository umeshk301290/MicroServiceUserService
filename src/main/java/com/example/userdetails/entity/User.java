package com.example.userdetails.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table(name = "userinfo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

	@Column(name = "userid")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	Long userId;
	
	@Column(name="name")
	@JsonProperty
	String name;
	
	@Column(name="age")
	@JsonProperty
	Integer age;
	
	@Column(name="email")
	@JsonProperty
	String email;
    
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	@JsonProperty
	List<Order> orders;
}
