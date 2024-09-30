package com.toure.project.interceptor;

import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Interceptors implements StatementInspector {
	
	private Logger logger = LoggerFactory.getLogger(Interceptors.class);

	@Override
	public String inspect(String sql) {		
		
		
		  if(StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
			  
		  if(sql.contains("where")) { 
			  sql = sql + "and identreprise = 1";
		  }else{
			  sql = sql + "WHERE identreprise = 1"; } }
		 
		logger.info("This is the intercepted request : {}", sql);
		
		//System.out.println("This is the intercepted request : "+sql);
		
		return sql;
	}
	
	

}
