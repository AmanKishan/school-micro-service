package com.dummy.schoolmicroservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

//No need to for @Configuration, since its configure in main class i.e, SchoolmicroserviceApplication,java 
public class RibbonConfiguration {

	@Autowired
	IClientConfig ribbonClientConfig;

	@Bean
	public IPing ribbonPing(IClientConfig ribbonClientConfig) {
		return new PingUrl();
	}

	@Bean
	public IRule ribbonRule(IClientConfig ribbonClientConfig) {
		return new WeightedResponseTimeRule();
	}
}
