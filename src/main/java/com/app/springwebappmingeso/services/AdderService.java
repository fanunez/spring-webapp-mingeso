package com.app.springwebappmingeso.services;
import com.app.springwebappmingeso.models.Adder;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

@RestController
@RequestMapping("/adder")
@CrossOrigin(origins = "*")
public class AdderService {

    private final Gson gson;

    AdderService(){
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    @PostMapping("/sum")
    public ResponseEntity<String> calculateSum(@RequestBody String request){
        System.out.println(request);
        Adder adder = gson.fromJson(request, Adder.class);
        Integer result = adder.calculateSum(adder.getNumber1(), adder.getNumber2());
        adder.setResult(result);
        return new ResponseEntity<>(gson.toJson(adder), HttpStatus.OK);
    }

    @PostMapping("/subtraction")
    public ResponseEntity<String> calculateSub(@RequestBody String request){
        System.out.println(request);
        Adder subtraction = gson.fromJson(request, Adder.class);
        Integer result = subtraction.calculateSubtraction(subtraction.getNumber1(), subtraction.getNumber2());
        subtraction.setResult(result);
        return new ResponseEntity<>(gson.toJson(subtraction), HttpStatus.OK);
    }
}
