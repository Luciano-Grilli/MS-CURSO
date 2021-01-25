package com.formaciondbi.microservicios.cursos3.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository <E ,ID extends Serializable>extends PagingAndSortingRepository<E,ID> {
}
