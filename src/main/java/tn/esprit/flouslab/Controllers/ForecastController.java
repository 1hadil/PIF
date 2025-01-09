package tn.esprit.flouslab.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.Forecast;
import tn.esprit.flouslab.Entities.ForecastRequest;
import tn.esprit.flouslab.Entities.PremiumEntry;
import tn.esprit.flouslab.Services.IForecastService;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/Forecast")
@CrossOrigin(origins = "*")

public class ForecastController {
    @Autowired
    private IForecastService forecastservice;

    @PostMapping("/save")
    public Forecast addForecast(@RequestBody Forecast c ){
        return forecastservice.addForecast(c);

    }

    @GetMapping("/findbyid/{idforecast}")
    public Forecast findforecastbyid(@PathVariable Long idforecast){
        return forecastservice.getForecastById(idforecast);
    }
    @GetMapping("/getallbyuser/{id}")
    public List<Forecast> getallbyuser(@PathVariable int id){
        return forecastservice.getALLbyuser(id);
    }
    @DeleteMapping("deleteclaim/{idf}")
    public String deleteForecast(@PathVariable Long idf){
        forecastservice.deleteForecast(idf);
        return "forecast deleted !";
    }

    @GetMapping("/all")
    public List<Forecast> getallforecasts(){
        return forecastservice.getALL();
    }

    @PutMapping("/updateforecast")
    public Forecast updateforecast(@RequestBody Forecast f)
    {
        return forecastservice.updateForecast(f);
    }

    @PostMapping("/addforecastandassigntoinsurance/{idin}")
    public Forecast addforecastandassigntoinsurance (@RequestBody Forecast f,@PathVariable Long idin)
    {
        return forecastservice.addforecastandassigntoinsurance(f,idin);
    }


    @GetMapping("/stock/predict/{userId}/{stockId}")
    public List<Map<String, Object>> predictStock(@PathVariable int userId, @PathVariable int stockId) {
        System.out.println("Received request for userId: " + userId + ", stockId: " + stockId);
        return forecastservice.getPredictedPremium(userId, stockId);
    }
    @PostMapping("/add/{iduser}")
    public ResponseEntity<Forecast> addForecast(@RequestBody ForecastRequest forecastRequest, @PathVariable Integer iduser) {
        try {
            // Calling the service method to add the forecast
            Forecast forecast = forecastservice.addNewForecast(
                    forecastRequest.getForecast(),
                    forecastRequest.getPremiumEntries(),
                    iduser
            );
            return new ResponseEntity<>(forecast, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Handling the exception if user is not found
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }




}
