package com.tavant.employee.utils;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

public class LowerCaseClassNameResolver implements TypeIdResolver {

	@Override
	public void init(JavaType baseType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String idFromValue(Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String idFromValueAndType(Object value, Class<?> suggestedType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String idFromBaseType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaType typeFromId(DatabindContext context, String id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescForKnownTypeIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Id getMechanism() {
		// TODO Auto-generated method stub
		return null;
	}

}
