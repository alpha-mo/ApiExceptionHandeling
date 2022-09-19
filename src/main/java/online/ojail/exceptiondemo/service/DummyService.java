package online.ojail.exceptiondemo.service;

import online.ojail.exceptiondemo.data.Dummy;
import online.ojail.exceptiondemo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Mo. Ojail
 * created: 2022-09-17
 */

@Service
public class DummyService {
    public Object getBlaBla(){
        return Dummy.getBlaBla().orElseThrow(()-> new ResourceNotFoundException(Dummy.class));
    }
}
