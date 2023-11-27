package com.sarah.prjEmpresa.repoitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarah.prjEmpresa.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
	
}
