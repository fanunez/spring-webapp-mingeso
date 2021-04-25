package com.app.springwebappmingeso.services;
import com.app.springwebappmingeso.models.Calculate;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

@RestController
@RequestMapping("/calculate")
@CrossOrigin(origins = "*")
public class CalculateService {

    private final Gson gson;

    CalculateService(){
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    @PostMapping("/sum")
    public ResponseEntity<String> calculateSum(@RequestBody String request){
        Calculate calculate = gson.fromJson(request, Calculate.class);
        Integer result = calculate.calculateSum(calculate.getNumber1(), calculate.getNumber2());
        calculate.setResult(result);
        return new ResponseEntity<>(gson.toJson(calculate), HttpStatus.OK);
    }

    @PostMapping("/subtraction")
    public ResponseEntity<String> calculateSub(@RequestBody String request){
        Calculate subtraction = gson.fromJson(request, Calculate.class);
        Integer result = subtraction.calculateSubtraction(subtraction.getNumber1(), subtraction.getNumber2());
        subtraction.setResult(result);
        return new ResponseEntity<>(gson.toJson(subtraction), HttpStatus.OK);
    }
}
