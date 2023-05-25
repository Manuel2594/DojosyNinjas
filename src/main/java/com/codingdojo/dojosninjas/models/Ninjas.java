package com.codingdojo.dojosninjas.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ninjas")
public class Ninjas {
	
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY) // Primarikey
			private Long id;

			@Size(min = 3, max = 20)
			private String nombre;

			@Size(min = 3, max = 20)
			private String apellido;

			private int edad;

			@Column(updatable = false)
			@DateTimeFormat(pattern = "dd-MM-yyyy")
			private Date createdAt;
			@DateTimeFormat(pattern = "dd-MM-yyyy")
			private Date updatedAt;

		    @ManyToOne(fetch = FetchType.LAZY)
		    @JoinColumn(name="dojo_id")
		    private Dojos dojos;

			// Contructores
			

			public Ninjas() {
			}

			// Getters and Setters
			
			public Dojos getDojos() {
				return dojos;
			}
			public void setDojos(Dojos dojos) {
				this.dojos = dojos;
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
			public String getApellido() {
				return apellido;
			}
			public void setApellido(String apellido) {
				this.apellido = apellido;
			}
			public int getEdad() {
				return edad;
			}
			public void setEdad(int edad) {
				this.edad = edad;
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

