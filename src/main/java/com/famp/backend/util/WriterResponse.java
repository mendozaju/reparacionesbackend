package com.famp.backend.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class WriterResponse {
	
	private PrintWriter printWriter;

	public void writeResponse(HttpServletResponse response, String message) throws IOException{		
		printWriter = response.getWriter();
		printWriter.print(message);
		printWriter.flush();		
	}
	
}
