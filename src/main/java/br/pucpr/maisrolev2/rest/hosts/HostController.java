package br.pucpr.maisrolev2.rest.hosts;

import br.pucpr.maisrolev2.lib.exception.AlreadyExistsException;
import br.pucpr.maisrolev2.lib.exception.ExceptionHandlers;
import br.pucpr.maisrolev2.lib.exception.NotFoundException;
import br.pucpr.maisrolev2.lib.security.JWT;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hosts")
public class HostController {
    private final HostService service;
    private final ExceptionHandlers exceptionHandlers;
    private final JWT jwt;

    public HostController(HostService service, ExceptionHandlers exceptionHandlers, JWT jwt) {this.service = service;
        this.exceptionHandlers = exceptionHandlers;
        this.jwt = jwt;
    }

    @GetMapping("{id}")
    @Transactional
    public ResponseEntity<Object> searchHost(@PathVariable(value = "id") Long id){
        try {
            return ResponseEntity.ok(service.getHost(id));
        } catch (NotFoundException e) {
            return exceptionHandlers.handleNotFoundException(e);
        }
    }
    @GetMapping("/all")
    @Transactional
    public ResponseEntity<Object> showAllHosts() {
        try {
            return ResponseEntity.ok(service.getAllHosts());
        } catch (NotFoundException e) {
            return exceptionHandlers.handleNotFoundException(e);
        }
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<Object> add(@Valid @RequestBody Host host, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()){
                throw new MethodArgumentNotValidException( new MethodParameter(
                        service.getClass().getDeclaredMethod("add", Host.class), 0),
                bindingResult);
            }
            service.add(host);
            return new ResponseEntity<>(host, HttpStatus.CREATED);
        } catch (AlreadyExistsException e) {
            return exceptionHandlers.handleAlreadyExistsException(e);
        } catch (MethodArgumentNotValidException e) {
            return exceptionHandlers.handleValidationException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody HostLoginRequest req) {
        try {
            var host = service.logHost
        }
    }


}
