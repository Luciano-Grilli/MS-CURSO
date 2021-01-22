
package com.formaciondbi.microservicios.cursos3.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.formaciondbi.microservicios.generics.examenes.Examen;
import com.formaciondbi.microservicios.generics.models.entity.Alumno;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

@Entity
@Table(name="cursos")
public class Cursos {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "nombre")
    private String nombre;
	
	@OneToMany(fetch= FetchType.LAZY)
	private List<Alumno> alumno;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Examen> examenes;

	private Date createAt;
	
	
	public Cursos() {
		this.alumno = new ArrayList<>();
		this.examenes = new ArrayList<>();
	}

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	public void addAlumno(Alumno alumno) {
		this.alumno.add(alumno);
	}
	
	public void removeAlumno(Alumno alumno) {
		this.alumno.remove(alumno);
	}
	
	public void addExamen(Examen examen) {
		this.examenes.add(examen);
	}
	
	public void removeExamen(Examen examen) {
		this.examenes.remove(examen);
	}
	
	
	
	
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if (!(obj instanceof Alumno)) {
			return false;
			
		}
		
		Alumno a = new Alumno();
		
		return this.id != null && this.id.equals(a.getId());
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setAlumno(List<Alumno> alumno) {
		this.alumno = alumno;
	}

	public void setExamenes(List<Examen> examenes) {
		this.examenes = examenes;
	}
	
	
}
