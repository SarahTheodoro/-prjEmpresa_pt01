package com.sarah.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarah.prjEmpresa.entities.Departamento;
import com.sarah.prjEmpresa.entities.Funcionario;
import com.sarah.prjEmpresa.repoitories.DepartamentoRepository;
import com.sarah.prjEmpresa.repoitories.FuncionarioRepository;

@Service
public class FuncionarioService {
		private final FuncionarioRepository funcionarioRepository;

		@Autowired
		public  FuncionarioService( FuncionarioRepository funcionarioRepository) {
			this.funcionarioRepository = funcionarioRepository;
		}


		public  Funcionario saveFuncionario( Funcionario funcionario) {
			return funcionarioRepository.save(funcionario);
		}

	
		public  Funcionario getFuncionarioById(Long funcodigo) {
			return funcionarioRepository.findById(funcodigo).orElse(null);
		}

		public List< Funcionario> getAllFuncionarios() {
			return funcionarioRepository.findAll();
		}

	
		public void deleteFuncionario(Long funcodigo) {
			funcionarioRepository.deleteById(funcodigo);
		}
		public  Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {
	        Optional< Funcionario> funcionarioOptional = funcionarioRepository.findById(funcodigo);
	        if (funcionarioOptional.isPresent()) {
	        	Funcionario funcionarioExistente = funcionarioOptional.get();
	        	funcionarioExistente.setFunnome(novoFuncionario.getFunnome());
	        	funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
	        	funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());
	            return funcionarioRepository.save(funcionarioExistente); 
	        } else {
	            return null; 
	        }
	    }
}
