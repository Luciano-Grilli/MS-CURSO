package com.formaciondbi.microservicios.cursos3.controller;

import com.formaciondbi.microservicios.cursos3.entity.Cursos;
import com.formaciondbi.microservicios.cursos3.services.CursosServiceImpl;
import com.formaciondbi.microservicios.generics.models.entity.Alumno;

import java.util.List;
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
		return ResponseEntity.ok(curso);
	}
	
}
