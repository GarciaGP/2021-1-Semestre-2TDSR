package br.com.fiap.tds.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Teste.java - compilar -> Teste.class (bytecode) -> Interpretar (JVM)  

//Define aonde a anotação pode ser utilizada
//FIELD -> atributos
@Target( { ElementType.FIELD, ElementType.METHOD } )

@Retention(RetentionPolicy.RUNTIME)
//SOURCE -> até o código
//CLASS -> até a compilação (padrão)
//RUNTIME -> até a execução

public @interface Coluna {

	String nome(); //parâmetro da anotação
	int tamanho() default 255;
	boolean unico() default false;
	
}
