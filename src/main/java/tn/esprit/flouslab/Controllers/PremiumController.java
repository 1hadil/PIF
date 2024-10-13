package tn.esprit.flouslab.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.Premium;
import tn.esprit.flouslab.Services.IPremiumService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Premium")
@CrossOrigin(origins = "*")

public class PremiumController {
    private IPremiumService premiumservice;

    @PostMapping("/save")
    public Premium addPremium(@RequestBody Premium premium ){
        return premiumservice.addPremium(premium);

    }
    @GetMapping("/findbyid/{idpremium}")
    public Premium findpremiumbyid(@PathVariable Long idpremium){
        return premiumservice.getPremiumById(idpremium);
    }

    @DeleteMapping("deletepremium/{idp}")
    public String deletePremium(@PathVariable Long idp){
        premiumservice.deletePremium(idp);
        return "premium deleted !";
    }
    @GetMapping("/all")
    public List<Premium> getallpremiums(){
        return premiumservice.getALL();
    }
    @PutMapping("/updatepremium")
    public Premium updateprmium(@RequestBody Premium p)
    {
        return premiumservice.updatePremium(p);
    }
    @GetMapping("/allpr")
    public List<Premium> getallpremiumstns(@RequestParam("id") Long id){
        return premiumservice.getALLpr(id);
    }
    @PostMapping("/payment/{idPremium}")
    public Premium payment (@PathVariable Long idPremium ){
        return premiumservice.payment(idPremium);
    }
    @GetMapping("/gettotalpremiums")
    public Long getTotalPremiumCount()

    {
        return premiumservice.getTotalPremiumCount();
    }
    @GetMapping("/findallpremiumsofuser/{iduser}")
    public List<Premium> findallpremiumsofuser(@PathVariable Long iduser)
    {
        return premiumservice.findallpremiumsofuser(iduser);}
        @PutMapping("/assignpremiumtoinsurance/{idpremium}/{idinsurance}")
        public Premium assignpremiumtoinsurance(@PathVariable Long idpremium,@PathVariable Long idinsurance)
        {
            return premiumservice.assignpremiumtoinsurance(idpremium,idinsurance);
        }



}
