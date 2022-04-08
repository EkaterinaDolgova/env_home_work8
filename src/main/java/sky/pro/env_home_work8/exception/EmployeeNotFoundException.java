package sky.pro.env_home_work8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String s) {
        super(s);
    }
}

