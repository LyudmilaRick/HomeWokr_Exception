package pro.sky.java.course2.homewokr_exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND  )
public class ValueNotFoundException extends Exception{
}