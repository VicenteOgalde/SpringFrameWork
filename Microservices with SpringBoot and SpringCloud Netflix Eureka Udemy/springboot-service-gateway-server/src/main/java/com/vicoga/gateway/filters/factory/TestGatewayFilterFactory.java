package com.vicoga.gateway.filters.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class TestGatewayFilterFactory extends AbstractGatewayFilterFactory<TestGatewayFilterFactory.Configuration>{

	
	private final Logger log= LoggerFactory.getLogger(TestGatewayFilterFactory.class);


	public TestGatewayFilterFactory() {
		super(Configuration.class);
		
	}


	@Override
	public GatewayFilter apply(Configuration config) {
		
		return (exchange,chain)->{
			log.info("execute pre gateway filter factory: "+config.message);
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				log.info("execute post gateway filter factory: ".concat(config.message));
			}));
		};
	}

	
	public static class Configuration {
		
	
		private String message;
		private String cookieValue;
		private String cookieName;
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getCookieValue() {
			return cookieValue;
		}
		public void setCookieValue(String cookieValue) {
			this.cookieValue = cookieValue;
		}
		public String getCookieName() {
			return cookieName;
		}
		public void setCookieName(String cookieName) {
			this.cookieName = cookieName;
		}

	}
}
