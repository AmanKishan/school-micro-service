package com.dummy.schoolmicroservice.configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Retryer;

@Configuration
//We provide scanning of the package where we kept all feign client
//It can also work without providing the scan package
@EnableFeignClients("com.dummy.schoolmicroservice.feignservice")
@Import(FeignClientsConfiguration.class)
public class FeignConfiguration {
	/**
	 * Set the Feign specific log level to log client REST requests.
	 */
	@Bean
	feign.Logger.Level feignLoggerLevel() {
		return feign.Logger.Level.FULL;
	}

	@Bean
	public Retryer retryer() {
		return new Retryer.Default(1000, 8000, 3);
	}

	@Bean
	public Request.Options timeoutConfiguration() {
		return new Request.Options(20, TimeUnit.SECONDS, 90, TimeUnit.SECONDS, true);
	}

	/**
	 * Intercept the fiegn Request
	 * @return
	 */
	@Bean
	public RequestInterceptor requestLoggingInterceptor() {
		return new RequestInterceptor() {
			@Override
			public void apply(RequestTemplate template) {
				template.header("testHeader", "testHeaderValue");
			}
		};
	}

}
