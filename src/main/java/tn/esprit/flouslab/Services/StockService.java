package tn.esprit.flouslab.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.Stock;
import tn.esprit.flouslab.Repositories.StockRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Optional<Stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    public Stock updateStock(Long id, Stock stockDetails) {
        Optional<Stock> stockOptional = stockRepository.findById(id);
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            stock.setSymbol(stockDetails.getSymbol());
            stock.setCurrentPrice(stockDetails.getCurrentPrice());
            stock.setCompanyName(stockDetails.getCompanyName());
            stock.setMarketCap(stockDetails.getMarketCap());
            return stockRepository.save(stock);
        }
        return null;
    }
}
