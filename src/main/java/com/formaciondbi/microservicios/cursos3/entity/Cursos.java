
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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.formaciondbi.microservicios.generics.models.entity.Alumno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
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

	private Date createAt;
	
	
	public Cursos() {
		this.alumno = new ArrayList<>();
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
	
	
}
