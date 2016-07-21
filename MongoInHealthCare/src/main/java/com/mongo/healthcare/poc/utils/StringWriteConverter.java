package com.mongo.healthcare.poc.utils;

import org.springframework.core.convert.converter.Converter;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class StringWriteConverter implements Converter<String, DBObject> {

    public DBObject convert(String source) {
            DBObject dbo = (DBObject) JSON.parse(source);
            return dbo;
    }

}