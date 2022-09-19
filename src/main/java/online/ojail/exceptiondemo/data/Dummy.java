package online.ojail.exceptiondemo.data;

import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Mo. Ojail
 * created: 2022-09-17
 */

@Component
public class Dummy{
    public static Optional<Object> getBlaBla(){return Optional.empty();}
}
