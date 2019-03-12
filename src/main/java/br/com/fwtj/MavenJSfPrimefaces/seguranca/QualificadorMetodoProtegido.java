package br.com.fwtj.MavenJSfPrimefaces.seguranca;

import org.apache.deltaspike.security.api.authorization.SecurityBindingType;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(value = RUNTIME)
@Target({TYPE, METHOD})
@Documented
@SecurityBindingType
public @interface QualificadorMetodoProtegido {
}
