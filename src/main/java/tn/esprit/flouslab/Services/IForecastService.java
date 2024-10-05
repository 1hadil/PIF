package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Forecast;

import java.util.List;

public interface IForecastService {
    Forecast addForecast (Forecast f);
    Forecast getForecastById (Long id);
    void deleteForecast (Long id);
    List<Forecast> getALL();
    Forecast updateForecast (Forecast f);
}


