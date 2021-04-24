package com.app.springwebappmingeso.services;
import com.app.springwebappmingeso.models.Adder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

@RestController
@RequestMapping("/adder")
@CrossOrigin(origins = "*")
public class AdderService {

    private final Gson gson;

    public Integer calculateSum(@RequestBody String request){
        Adder adder = gson.fromJson(request, Adder.class);
        Integer result = calculateSum(adder.getNumber1(), adder.getNumber2());
        adder.setResult(result);
        return result;
    }
}
