package com.foodwala.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer addressId;
  private String buildingName;
  private Integer streetNo;
  private String area;
  private String city;
  private String state;
  private String country;
  private String pincode;
  
  @JsonIgnore
  @OneToOne(cascade = CascadeType.ALL)
  private Customer customer;
  
  @JsonIgnore
  @OneToOne(cascade = CascadeType.ALL)
  private Restaurant restaurant;
  
  
  
  



  
	
	
	
}
