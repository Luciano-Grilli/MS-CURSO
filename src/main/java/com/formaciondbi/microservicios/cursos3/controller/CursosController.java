package com.formaciondbi.microservicios.cursos3.controller;

import com.formaciondbi.microservicios.cursos3.entity.Cursos;
import com.formaciondbi.microservicios.cursos3.services.CursosServiceImpl;
import com.formaciondbi.microservicios.generics.examenes.Examen;
import com.formaciondbi.microservicios.generics.models.entity.Alumno;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CursosController extends BaseControllerImpl<Cursos, CursosServiceImpl> {
 
	
	
	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@PathVariable Long id,@RequestBody List<Alumno> alumnos) throws Exception{
			Cursos op;
			try {
				op = this.servicio.findById(id);
				
			} catch (Exception e) {
				
				return ResponseEntity.notFound().build();
			}	

			Cursos dbCurso = op;
			alumnos.forEach(a ->{
				dbCurso.addAlumno(a);
			});
			
			return ResponseEntity.status(HttpStatus.CREATED).body(this.servicio.save(dbCurso));
			
			
	}
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) throws Exception{
			Cursos op;
			try {
				op = this.servicio.findById(id);
			} catch (Exception e) {
				
				return ResponseEntity.notFound().build();
			}	

			Cursos dbCurso = op;
			dbCurso.removeAlumno(alumno);
			return ResponseEntity.status(HttpStatus.CREATED).body(this.servicio.save(dbCurso));
	}
	
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> buscarPorAlumnoId(@PathVariable Long id){
		Cursos curso = servicio.findCursoByAlumnoId(id);
		
		if (curso != null) {
			List<Long> examenesId = (List<Long>) servicio.examenesIdsRespondidosPorAlumno(id);
			
			List<Examen> examenes = curso.getExamenes().stream().map(examen -> {
				if (examenesId.contains(examen.getId())) {
					examen.setRespondido(true);
				}
				return examen;
			}).collect(Collectors.toList());
			curso.setExamenes(examenes);
		}
		return ResponseEntity.ok(curso);
	}
	
	
	@PutMapping("/{id}/asignar-examenes")
	public ResponseEntity<?> asignarExamenes(@PathVariable Long id,@RequestBody List<Examen> examenes) throws Exception{
		Cursos op;
			try {
				op = this.servicio.findById(id);
				
			} catch (Exception e) {
				
				return ResponseEntity.notFound().build();
			}	

			Cursos dbCurso = op;
			examenes.forEach(e ->{
				dbCurso.addExamen(e);
			});
			
			return ResponseEntity.status(HttpStatus.CREATED).body(this.servicio.save(dbCurso));
			
			
	}
	
	@PutMapping("/{id}/eliminar-examen")
	public ResponseEntity<?> eliminarExamen(@PathVariable Long id, @RequestBody Examen examen) throws Exception{
			Cursos op;
			try {
				op = this.servicio.findById(id);
			} catch (Exception e) {
				
				return ResponseEntity.notFound().build();
			}	

			Cursos dbCurso = op;
			dbCurso.removeExamen(examen);
			return ResponseEntity.status(HttpStatus.CREATED).body(this.servicio.save(dbCurso));
	}
	
}
