package com.example.resume.util;

import com.example.resume.model.Resume;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeserialize extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String dateStr = jsonParser.readValueAs(String.class);
        try {
            return new SimpleDateFormat(Resume.DATE_FORMAT).parse(dateStr);
        }
        catch (ParseException ex) {
            throw new IllegalArgumentException("Wrong date format");
        }
    }
}
