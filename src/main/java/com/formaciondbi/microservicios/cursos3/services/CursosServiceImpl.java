package com.formaciondbi.microservicios.cursos3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formaciondbi.microservicios.cursos3.clients.RespuestaFeingClient;
import com.formaciondbi.microservicios.cursos3.entity.Cursos;
import com.formaciondbi.microservicios.cursos3.repository.BaseRepository;
import com.formaciondbi.microservicios.cursos3.repository.CursosRepository;


@Service
public class CursosServiceImpl extends BaseServiceImpl<Cursos,Long> implements CursosService {

	@Autowired
    private CursosRepository cursoRepository;
	
	@Autowired
	private RespuestaFeingClient client;
	
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
	

	


}
