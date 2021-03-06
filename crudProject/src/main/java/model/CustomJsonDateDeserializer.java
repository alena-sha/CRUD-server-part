package model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

	public class CustomJsonDateDeserializer extends JsonDeserializer<LocalDate> {

	    @Override
	    public LocalDate deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext) throws IOException {

	        String string = jsonparser.getText();

	        if(string.length() > 20) {
	            ZonedDateTime zonedDateTime = ZonedDateTime.parse(string);
	            return zonedDateTime.toLocalDate();
	        }

	        return LocalDate.parse(string);
	    }
	  }

