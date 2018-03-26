package org.mycompany;

import javax.annotation.Resource;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class TestController {
	@Autowired
	CamelContext camelContext;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String getHello() {
		String name = "Hello woorldd";
		ProducerTemplate producer = camelContext.createProducerTemplate();
		String result = producer.requestBody("direct:hello", name, String.class);
		return result;
	}

}
