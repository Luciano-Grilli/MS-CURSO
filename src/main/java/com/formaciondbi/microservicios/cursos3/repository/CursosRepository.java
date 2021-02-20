package com.formaciondbi.microservicios.cursos3.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.formaciondbi.microservicios.cursos3.entity.Cursos;

@Repository
public interface CursosRepository extends BaseRepository<Cursos, Long> {

	@Query("select c from Cursos c join fetch c.cursoAlumno a where a.alumnoId=?1")
	public Cursos findCursoByAlumnoId(Long id);

	@Modifying
	@Query("delete from CursoAlumno ca where ca.alumnoId=?1")
	public void eliminarCursoAlumnoPorId(Long id);

}
