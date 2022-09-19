package online.ojail.exceptiondemo.controller;

import online.ojail.exceptiondemo.service.DummyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mo. Ojail
 * created: 2022-09-17
 */

@RestController @RequestMapping("/api")
public class DemoController {

    private final DummyService dummyService;

    public DemoController(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @GetMapping
    public ResponseEntity<Object> home(@RequestHeader Long id) {

        return new ResponseEntity<>(dummyService.getBlaBla(), HttpStatus.FOUND);

    }
}
