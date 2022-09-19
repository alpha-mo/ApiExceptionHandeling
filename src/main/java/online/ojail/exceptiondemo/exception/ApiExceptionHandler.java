package online.ojail.exceptiondemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * @author Mo. Ojail
 * created: 2022-09-17
 */

@ControllerAdvice
public record ApiExceptionHandler() {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception e, HttpServletResponse response){

        HttpStatus httpStatus = HttpStatus.resolve(response.getStatus());

        if (httpStatus == null) httpStatus = HttpStatus.CHECKPOINT;

        String simpleMessage = generateSimpleMessage(e);

        CauseException causeException = new CauseException(
                e.getClass().getSimpleName(),
                e.getClass().getPackageName(),
                e.getMessage()
        );

        ApiException apiException = new ApiException(
                simpleMessage,
                causeException,
                httpStatus,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException, httpStatus);
    }

    private String generateSimpleMessage(Exception e){

        switch (e.getClass().getSimpleName()){
            case "NoHandlerFoundException", "ResourceNotFoundException" -> {return e.getMessage();}
            case "MissingRequestHeaderException" -> {return "Request header missing argument.";}
            case "MethodArgumentTypeMismatchException" -> {
                assert e instanceof MethodArgumentTypeMismatchException;
                String parameterName =  ((MethodArgumentTypeMismatchException) e).getParameter().getParameterName();

                /* to get a list of All parameters:
                Parameter[] parameters = Objects.requireNonNull(((MethodArgumentTypeMismatchException) e).getParameter().getMethod()).getParameters();
                List<String> strings = Arrays.stream(parameters).map(Parameter::getName).toList();
                strings.forEach(System.out::println);*/

                return String.format("Request argument: {%s} type mismatch.", parameterName);
            }
            default -> {return "Unknown error";}
        }

    }

}
record ApiException (String error_message, CauseException causeException, HttpStatus httpStatus, LocalDateTime timestamp){}
record CauseException(String name, String location, String internal_message){}

