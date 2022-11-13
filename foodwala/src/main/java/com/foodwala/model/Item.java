package com.foodwala.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.NonFinal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	
	@NonNull
	private String itemName;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;
	@NotNull(message =" quantity should not be more then 10")
	@Size(min = 1, max = 10)
	private Integer quantity;
	@NotNull
	private double cost;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Restaurant> restaurants;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private FoodCart foodCart;
	
}
