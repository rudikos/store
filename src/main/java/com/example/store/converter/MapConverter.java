package com.example.store.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Map;

/**
 * @author rudolf.shakhgaldyan on 2/20/2021.
 */
@Converter(autoApply = true)
public class MapConverter implements AttributeConverter<Map<String, Object>, String> {

	private final static ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Map<String, Object> customerInfo) {

		String customerInfoJson = null;
		try {
			customerInfoJson = objectMapper.writeValueAsString(customerInfo);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("JSON writing error", e);
		}
		return customerInfoJson;
	}

	@Override
	public Map<String, Object> convertToEntityAttribute(String customerInfoJSON) {

		Map<String, Object> customerInfo = null;
		try {
			customerInfo = objectMapper.readValue(customerInfoJSON, Map.class);
		} catch (IOException e) {
			throw new RuntimeException("JSON reading error", e);
		}
		return customerInfo;
	}

}
