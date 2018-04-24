package model.annotation;

import service.contracts.RelationTableResolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Monzer Masri on 18.4.2018.
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SubEntityList {
    Class value() ;
    Class<? extends RelationTableResolver> relationResolver();
}
