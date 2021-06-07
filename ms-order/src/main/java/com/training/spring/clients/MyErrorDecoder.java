package com.training.spring.clients;

import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.spring.rest.error.ErrorObj;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class MyErrorDecoder implements ErrorDecoder {

    @Override
    public MyRestException decode(final String methodKeyParam,
                                  final Response responseParam) {
        try {
            InputStream asInputStreamLoc = responseParam.body()
                                                        .asInputStream();
            ObjectMapper mapperLoc = new ObjectMapper();
            ErrorObj readValueLoc = mapperLoc.readValue(asInputStreamLoc,
                                                        ErrorObj.class);
            return new MyRestException(readValueLoc);
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
            return new MyRestException(null);
        }
    }

}
