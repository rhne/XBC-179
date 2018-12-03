/**
 * 
 */
package com.spring.miniproject.mapper;

import java.io.IOException;
import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;


public class JsonViewResolver implements ViewResolver {

	public View resolveViewName(String viewName, Locale locale) throws Exception {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setPrettyPrint(true);      // Lay the JSON out to be nicely readable
		view.setObjectMapper(new MyObjectMapper());
		return view;
	}

	class MyObjectMapper extends ObjectMapper {
		private static final long serialVersionUID = 3972145386519236436L;

		public MyObjectMapper() {
			DefaultSerializerProvider sp = new DefaultSerializerProvider.Impl();
			sp.setNullValueSerializer(new NullSerializer());
			this.setSerializerProvider(sp);
		}
	}
	
	class NullSerializer extends JsonSerializer<Object> {

		@Override
		public void serialize(Object value, JsonGenerator jgen,
				SerializerProvider provider) throws IOException,
				JsonProcessingException {
			jgen.writeString("");
		}
		
	}
}
