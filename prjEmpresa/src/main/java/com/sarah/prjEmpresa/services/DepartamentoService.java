package com.sarah.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarah.prjEmpresa.entities.Departamento;
import com.sarah.prjEmpresa.repoitories.DepartamentoRepository;

@Service
public class DepartamentoService {
		private final DepartamentoRepository departamentoRepository;

		@Autowired
		public  DepartamentoService( DepartamentoRepository departamentoRepository) {
			this.departamentoRepository = departamentoRepository;
		}


		public  Departamento saveDepartamento( Departamento departamento) {
			return departamentoRepository.save(departamento);
		}

	
		public  Departamento getDepartamentoById(Long depcodigo) {
			return departamentoRepository.findById(depcodigo).orElse(null);
		}

		public List< Departamento> getAllDepartamentos() {
			return departamentoRepository.findAll();
		}

	
		public void deleteDepartamento(Long depcodigo) {
			departamentoRepository.deleteById(depcodigo);
		}
		public  Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
	        Optional< Departamento> departamentoOptional = departamentoRepository.findById(depcodigo);
	        if (departamentoOptional.isPresent()) {
	        	 Departamento departamentoExistente = departamentoOptional.get();
	        	 departamentoExistente.setDepname(novoDepartamento.getDepname());
	            return departamentoRepository.save(departamentoExistente); 
	        } else {
	            return null; 
	        }
	    }
}

		

