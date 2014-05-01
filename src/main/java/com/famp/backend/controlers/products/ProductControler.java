package com.famp.backend.controlers.products;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.famp.backend.domain.Response;
import com.famp.backend.domain.ProductBean;
import com.famp.backend.services.ProductServices;
import com.famp.backend.services.entities.Product;

@Controller
public class ProductControler {
	
	static Logger log = Logger.getLogger(ProductControler.class.getName());
	ApplicationContext context =new ClassPathXmlApplicationContext("application-context.xml"); 
	
	@Autowired
	ProductServices service;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	@ResponseBody
	/**
	 * @author juan eduardo mendoza
	 * @param response
	 * @return
	 */
	public Response getProducts(HttpServletResponse servletResponse){
		log.info("Inicio del metodo");
		
		//Creo la respuesta
		Response response = (Response)context.getBean("dataResponse");
		
		//Obtengo todos los productos del servicio
		List<ProductBean> products =  service.getProducts();
		
		response.setData(products);
		
		log.info("Fin del metodo");
		//Retorno los productos
		return response;		
	}
	
	@RequestMapping(value="/products/save")
	@ResponseBody
	/**
	 * @author juan eduardo mendoza
	 * @param request
	 * @param response
	 * @return
	 */
	public int saveProduct(HttpServletRequest request, HttpServletResponse response){
		log.info("Inicio del metodo");	
		
		//TODO: Se tiene que construir el producto con los datos del request
		ProductBean productBean = (ProductBean) context.getBean("product");
		productBean.setId(100);
		productBean.setName("Producto de prueba");
		productBean.setPrice(10.20);
		productBean.setStock(8);		
		
		//Guardo el producto
		int idProduct = service.saveProduct(productBean);
		
		log.info("Fin del metodo");
		//Retorno el id del producto guardado
		return idProduct;				
	}

}
