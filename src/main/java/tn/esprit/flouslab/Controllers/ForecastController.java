package tn.esprit.flouslab.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.Forecast;
import tn.esprit.flouslab.Services.IForecastService;

import java.util.List;

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




}
