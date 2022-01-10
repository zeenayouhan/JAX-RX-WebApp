package com.zina.webapp;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

@Provider
public class MyDateConverterProvider implements ParamConverterProvider {
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> aClass, Type type, Annotation[] annotations) {
       if(aClass.getName().equals(MyDate.class.getName()))
       {
           return new ParamConverter<T>() {
               @Override
               public T fromString(String s) {
                   Calendar cal = Calendar.getInstance();
                   if ("tomorrow".equalsIgnoreCase(s)) {
                       cal.add(Calendar.DATE, 1);
                   } else if ("yesterday".equalsIgnoreCase(s)) {
                       cal.add(Calendar.DATE, -1);
                   }
                   MyDate myDate = new MyDate();
                   myDate.setDate(cal.get(Calendar.DATE));
                   myDate.setMonth(cal.get(Calendar.MONTH));
                   myDate.setYear(cal.get(Calendar.YEAR));

                   return aClass.cast(myDate);

               }

               @Override
               public String toString(T t) {
                   if (t == null) {
                       return null;
                   }
                   return t.toString();
               }

           };
       }
        return null;
    }
}
