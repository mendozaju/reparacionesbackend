package com.famp.backend.services
;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.famp.backend.domain.ProductBean;
import com.famp.backend.services.entities.Product;
import com.famp.backend.services.repository.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	ProductRepository repository;	
	ApplicationContext context =new ClassPathXmlApplicationContext("application-context.xml");
	Logger log = Logger.getLogger(ProductServices.class.getName());
	
	/**
	 * Retorna todos los productos existentes 
	 * @author juan eduardo mendoza
	 * @return
	 */
	public List<ProductBean> getProducts(){
		log.info("Inicio de metodo");
		
		List<Product> entityProducts = repository.findAll();
		Iterator<Product> it = entityProducts.iterator();
		
		List<ProductBean> response = new ArrayList<ProductBean>(); 
		
		while(it.hasNext()){
			
			Product myEntityProduct= it.next();
			
			ProductBean product = (ProductBean) context.getBean("product");
			product.setId(myEntityProduct.getId());
			product.setName(myEntityProduct.getName());
			product.setPrice(myEntityProduct.getPrice());
			product.setStock(myEntityProduct.getStock());
			
			response.add(product);
		}
		
		log.info("Fin de metodo");
		return response;		
	}

	/**
	 * Guarda un producto
	 * @author juan mendoza
	 * @param product
	 */
	public int saveProduct(ProductBean product){
		
		//Conviert mi objeto de dominio a una entidad
		Product aProduct = this.convertToEntity(product);
		
		//Guardo mi producto
		Product savedProduct = repository.save(aProduct);
		
		//Retorno el id del producto guardado
		return savedProduct.getId();
	}

	/**
	 * Convierte un producto de dominio a un producto de entidad
	 * @author Erwin_PC
	 * @param product
	 * @return
	 */
	private Product convertToEntity(ProductBean product) {
		
		//Creo un producto entidad
		Product myProduct = (Product) context.getBean("productEntity");
		
		//Seteo los valores
		myProduct.setName(product.getName());
		myProduct.setPrice(product.getPrice());
		myProduct.setStock(product.getStock());
		
		//Retorno el producto entidad
		return myProduct;
	}
}
