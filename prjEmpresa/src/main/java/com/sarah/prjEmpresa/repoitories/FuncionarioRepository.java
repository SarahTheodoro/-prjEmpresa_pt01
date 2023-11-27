package com.sarah.prjEmpresa.repoitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarah.prjEmpresa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
}
