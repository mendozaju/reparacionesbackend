package com.famp.backend.controlers.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.famp.backend.util.WriterResponse;


@Controller
@RequestMapping(value="/")
public class Login {

	@RequestMapping(value="/loginerror")
	public String errorLogin(HttpServletResponse response, HttpServletRequest request){
		System.out.println("Error en la autenticacion");
		
		WriterResponse writer = new WriterResponse();
		
		try {
			writer.writeResponse(response, "Error en la autenticacion");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return null;
	}
	
	@RequestMapping(value="/")
	public String home(HttpServletResponse response, HttpServletRequest request){
		
		WriterResponse writer = new WriterResponse();
		try {
			writer.writeResponse(response, "Aplicacion de backend");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
}
