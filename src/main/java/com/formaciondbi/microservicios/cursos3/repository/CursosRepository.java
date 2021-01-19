package com.formaciondbi.microservicios.cursos3.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.formaciondbi.microservicios.cursos3.entity.Cursos;

@Repository
public interface CursosRepository extends BaseRepository<Cursos,Long> {
	
	@Query("select c from Cursos c join fetch c.alumno a where a.id=?1")
	public Cursos findCursoByAlumnoId(Long id);

}
