package com.java.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
 private int id;
 private String name;
 private float price;
 private int quantity;
 private String description;
 private String photo;
 private byte active;
 private LocalDateTime createiondate;
 
}
