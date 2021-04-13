package com.projetodesafio.cep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetodesafio.cep.model.Endereco;
import com.projetodesafio.cep.service.EnderecoService;

@RestController // indica que todos os métodos serão devolvidos em formato Json.
@RequestMapping(path = "/endereco") // responsável por devolver as Strings pro navegador.
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	

/*	@GetMapping
	public String teste() {
		return "teste de retorno";
	}
*/
	
	@GetMapping(path = "/{cep}")
	public ResponseEntity<?> getEndereco(@PathVariable("cep") String cep) throws Exception {
				
		return enderecoService.getEnderecoCep(cep);
		
	}
}
