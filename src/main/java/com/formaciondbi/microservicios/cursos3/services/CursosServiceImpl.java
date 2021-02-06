package com.formaciondbi.microservicios.cursos3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formaciondbi.microservicios.cursos3.clients.AlumnoFeingClient;
import com.formaciondbi.microservicios.cursos3.clients.RespuestaFeingClient;
import com.formaciondbi.microservicios.cursos3.entity.Cursos;
import com.formaciondbi.microservicios.cursos3.repository.BaseRepository;
import com.formaciondbi.microservicios.cursos3.repository.CursosRepository;
import com.formaciondbi.microservicios.generics.models.entity.Alumno;


@Service
public class CursosServiceImpl extends BaseServiceImpl<Cursos,Long> implements CursosService {

	@Autowired
    private CursosRepository cursoRepository;
	
	@Autowired
	private RespuestaFeingClient client;
	
	@Autowired
	private AlumnoFeingClient clientAlumno;
	
	public CursosServiceImpl(BaseRepository<Cursos,Long> baseRepository){
        super(baseRepository);
    }

	
	@Override
	@Transactional(readOnly = true)
	public Cursos findCursoByAlumnoId(Long id) {
		
		return cursoRepository.findCursoByAlumnoId(id);
	}


	@Override
	public Iterable<Long> examenesIdsRespondidosPorAlumno(Long alumnoId) {
		
		return client.examenesIdsRespondidosPorAlumno(alumnoId);
	}


	@Override
	public Iterable<Alumno> obtenerAlumnosPorCurso(List<Long> ids) {
		return clientAlumno.obtenerAlumnosPorCurso(ids);
	}


	@Override
	@Transactional(readOnly = true)
	public Page<Cursos> findAll(Pageable pageable) throws Exception {
		
		return cursoRepository.findAll(pageable);
	}


	@Override
	@Transactional
	public void eliminarCursoAlumnoPorId(Long id) {
		cursoRepository.eliminarCursoAlumnoPorId(id);
		
	}

	


}
