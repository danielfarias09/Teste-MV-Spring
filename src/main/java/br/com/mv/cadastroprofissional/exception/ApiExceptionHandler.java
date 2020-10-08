package br.com.mv.cadastroprofissional.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice//Diz para o spring que esta classe será responsável por manipular as exceções. Podem ser criados vários métodos
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = {ApiRequestException.class} ) //Diz para o Spring que este método sserá responsável por manipular as exceções do tipo ApiRequestException
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
		//Criação de um payload contendo os detalhes da exceção
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		
		ApiException apiException = new ApiException(
				e.getMessage(),
				badRequest,
				ZonedDateTime.now(ZoneId.of("Z"))
		);
		
		//Retorno do ResponseEntity
		return new ResponseEntity<Object>(apiException, badRequest);		
	}

}
