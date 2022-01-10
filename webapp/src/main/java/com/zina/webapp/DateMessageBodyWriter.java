package com.zina.webapp;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static java.lang.System.out;

@Provider
@Produces("text/plain")
public class DateMessageBodyWriter implements MessageBodyWriter<Date> {

    @Override
    public boolean isWriteable(Class aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return Date.class.isAssignableFrom(aClass);
    }

    @Override
    public void writeTo(Date date,
                        Class<?> aClass,
                        Type type,
                        Annotation[] annotations,
                        MediaType mediaType,
                        MultivaluedMap<String, Object> multivaluedMap,
                        OutputStream outputStream) throws IOException, WebApplicationException {
        out.write(date.toString().getBytes());

    }
}
