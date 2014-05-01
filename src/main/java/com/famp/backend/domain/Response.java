package com.famp.backend.domain;

import java.util.List;

import com.famp.backend.domain.ProductBean;;

public class Response<T> {
	
	List<T> data;

	/**
	 * Retorna la informacion data del objeto response
	 * @return
	 */
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
