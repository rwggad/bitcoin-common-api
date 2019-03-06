package com.henry.bitcoin.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

public class SecondTimeJsonDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        long millionSeconds = parser.getLongValue() * 1000;

        return new Date(millionSeconds);
    }
}