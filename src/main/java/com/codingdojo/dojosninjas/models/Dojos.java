package com.codingdojo.dojosninjas.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dojos")
public class Dojos {

			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY) // Primarikey
			private Long id;

			@NotBlank(message="Por favor llena el nombre del dojo")
			@Size(min = 3, max = 20)
			private String nombre;

			@Column(updatable = false)
			@DateTimeFormat(pattern = "dd-MM-yyyy")
			private Date createdAt;

			@DateTimeFormat(pattern = "dd-MM-yyyy")
			private Date updatedAt;
			
			@OneToMany(mappedBy="dojos", fetch = FetchType.LAZY)
		    private List<Ninjas> ninjas;


			// Contructores
			
			public Dojos() {
			}

			// Getters and Setters
			
			public List<Ninjas> getNinjas() {
				return ninjas;
			}

			public void setNinjas(List<Ninjas> ninjas) {
				this.ninjas = ninjas;
			}
			
			public Long getId() {
				return id;
			}
			public void setId(Long id) {
				this.id = id;
			}
			public String getNombre() {
				return nombre;
			}
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}
			public Date getCreatedAt() {
				return createdAt;
			}
			public void setCreatedAt(Date createdAt) {
				this.createdAt = createdAt;
			}
			public Date getUpdatedAt() {
				return updatedAt;
			}
			public void setUpdatedAt(Date updatedAt) {
				this.updatedAt = updatedAt;
			}
			@PrePersist
			protected void onCreate() {
				this.createdAt = new Date();
			}
			@PreUpdate
			protected void onUpdate() {
				this.updatedAt = new Date();
			}
		}
