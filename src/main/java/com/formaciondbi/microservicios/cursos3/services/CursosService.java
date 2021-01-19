package com.formaciondbi.microservicios.cursos3.services;

import com.formaciondbi.microservicios.cursos3.entity.Cursos;


public interface CursosService extends BaseService<Cursos,Long> {
	
	public Cursos findCursoByAlumnoId(Long id);
   
    
}
