package tn.esprit.flouslab.Services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import tn.esprit.flouslab.Entities.Forecast;
import tn.esprit.flouslab.Entities.Insurance;
import tn.esprit.flouslab.Repositories.ForecastRepository;
import tn.esprit.flouslab.Repositories.InsuranceRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ForecastServiceImpl implements IForecastService {
    private ForecastRepository forecastrep;
    private InsuranceRepository inrep;


    @Override
    public Forecast addForecast(Forecast f) {
        return forecastrep.save(f);
    }

    @Override
    public Forecast getForecastById(Long id) {
        return forecastrep.findById(id).orElse(null);
    }

    @Override
    public void deleteForecast(Long id) {
        forecastrep.deleteById(id);

    }

    @Override
    public List<Forecast> getALL() {
        return (List<Forecast>) forecastrep.findAll();
    }

    @Override
    public Forecast updateForecast(Forecast f) {
        Forecast forecast = forecastrep.findById(f.getIdForecast()).orElse(null);
        forecast.setDate(f.getDate());
        forecast.setPremiummargin(f.getPremiummargin());
        forecast.setEstimated_Compensation_Amount(f.getEstimated_Compensation_Amount());
        forecast.setClaimProbability(f.getClaimProbability());
        return forecastrep.save(forecast);
    }

    @Override
    public Forecast addforecastandassigntoinsurance(Forecast f, Long idiinsurance) {
           forecastrep.save(f);
        Insurance insurance= inrep.findById(idiinsurance).orElse(null);
        f.setInsurance(insurance);
        return forecastrep.save(f);

    }

}
