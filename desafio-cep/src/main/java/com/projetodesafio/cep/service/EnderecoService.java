package com.projetodesafio.cep.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.projetodesafio.cep.model.Endereco;

@Service
public class EnderecoService {
	static String urlCep = "https://viacep.com.br/ws/";

	
	public ResponseEntity <?> getEnderecoCep(String cep) {
		try {
			if (cep.length() == 8) {
			String buscaCepJson = urlCep + cep + "/json";

			RestTemplate restTemplate = new RestTemplate();
			Endereco response = restTemplate.getForObject(buscaCepJson, Endereco.class);
			return new ResponseEntity<Endereco>(response,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("CEP não encontrado, por favor informe um CEP válido novamente.",HttpStatus.OK);
			
		}
			
		}catch (Exception e) {
			
		return new ResponseEntity<>("Erro ao buscar o CEP, por favor informe um CEP válido.",HttpStatus.OK);
		}
		
	}

}
