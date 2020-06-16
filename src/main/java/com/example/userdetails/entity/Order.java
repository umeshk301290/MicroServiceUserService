package com.example.userdetails.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table(name = "orderinfo")
public class Order {
	@Column(name = "orderid")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty
	Long orderId;
	
	@Column(name="amount")
	@JsonProperty
	BigDecimal orderAmount;
	
	@Column(name="date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@JsonProperty
	Date orderDate = new Date();
	
	@Column(name="userid")
	@JsonProperty
	@NotNull
	Long userId;
}
