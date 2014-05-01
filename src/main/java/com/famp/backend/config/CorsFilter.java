package com.famp.backend.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author juan.eduardo.mendoza
 * Clase filtro encargada de adicionar todas laa cabeceras a los request para entregar al cliente.
 */
@Component
public class CorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
            response.addHeader("Access-Control-Allow-Origin", "*");          
            response.addHeader("Access-Control-Allow-Methods","GET, POST, PUT");
            response.addHeader("Access-Control-Allow-Headers","accept, content-type");
            response.addHeader("Access-Control-Allow-Credentials","true");
           
            filterChain.doFilter(request, response);
    }

}
