package tn.esprit.flouslab.Services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import tn.esprit.flouslab.Entities.Forecast;
import tn.esprit.flouslab.Entities.Insurance;
import tn.esprit.flouslab.Entities.PremiumEntry;
import tn.esprit.flouslab.Entities.User;
import tn.esprit.flouslab.Repositories.ForecastRepository;
import tn.esprit.flouslab.Repositories.InsuranceRepository;
import tn.esprit.flouslab.Repositories.PremiumEntryRepository;
import tn.esprit.flouslab.Repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ForecastServiceImpl implements IForecastService {
    private ForecastRepository forecastrep;
    private InsuranceRepository inrep;
    private UserRepository userRepository ;
    private final RestTemplate restTemplate;
    @Autowired
    private PremiumEntryRepository premiumEntryRepository;

    public Forecast addNewForecast(Forecast forecast, List<PremiumEntry> premiums, Integer userId) {

        User user = userRepository.findById(userId).orElse(null);

        forecast.setUser(user);

        premiumEntryRepository.saveAll(premiums);
        forecast.setPremiums(premiums);

        return forecastrep.save(forecast);
    }

   // private final RestTemplate restTemplate = new RestTemplate();
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
    public List<Forecast> getALLbyuser(int id) {
        User user= userRepository.findById(id).orElse(null);
        return  forecastrep.findAllByUser(user);
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
       // f.setInsurance(insurance);
        return forecastrep.save(f);

    }

    //@Override
    //public Map<String, Object> getPredictedPremium(int userId, int stockId) {
       //String url = "http://127.0.0.1:5000/predict?user_id=" + userId + "&id_stock=" + stockId;
        //return restTemplate.getForObject(url, Map.class);
        //ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        //System.out.println("Raw response: " + response.getBody()); // Log the raw response

        // Adjust based on response structure (e.g., List or Map)
        //ObjectMapper mapper = new ObjectMapper();
        //return mapper.readValue(response.getBody(), new TypeReference<Map<String, Object>>() {});

    //}
    public List<Map<String, Object>> getPredictedPremium(int userId, int stockId) {
        String url = "http://127.0.0.1:5000/predict?user_id=" + userId + "&id_stock=" + stockId;

        // Capture the response as a List
        List<Map<String, Object>> response = restTemplate.getForObject(url, List.class);
        return response;
    }



}
