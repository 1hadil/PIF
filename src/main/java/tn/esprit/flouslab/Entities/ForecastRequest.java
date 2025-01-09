package tn.esprit.flouslab.Entities;

import java.util.List;

public  class ForecastRequest {
    private Forecast forecast;
    private List<PremiumEntry> premiumEntries;

    // Getters and Setters
    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public List<PremiumEntry> getPremiumEntries() {
        return premiumEntries;
    }

    public void setPremiumEntries(List<PremiumEntry> premiumEntries) {
        this.premiumEntries = premiumEntries;
    }
}
