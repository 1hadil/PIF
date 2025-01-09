package tn.esprit.flouslab.Services;

import tn.esprit.flouslab.Entities.Forecast;
import tn.esprit.flouslab.Entities.PremiumEntry;

import java.util.List;
import java.util.Map;

public interface IForecastService {
    Forecast addForecast (Forecast f);
    public List<Forecast> getALLbyuser(int id);
    public Forecast addNewForecast(Forecast forecast, List<PremiumEntry> premiums, Integer userId);
    Forecast getForecastById (Long id);
    void deleteForecast (Long id);
    List<Forecast> getALL();
    Forecast updateForecast (Forecast f);
    Forecast addforecastandassigntoinsurance (Forecast f,Long idiinsurance);
    //Map<String, Object> getPredictedPremium(int userId, int stockId);
    public List<Map<String, Object>> getPredictedPremium(int userId, int stockId);
}


