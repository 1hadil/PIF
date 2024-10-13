package tn.esprit.flouslab.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.Insurance;
import tn.esprit.flouslab.Services.IInsuranceService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Insurance")
@CrossOrigin(origins = "*")


public class InsuranceController {
    @Autowired
    private IInsuranceService insuranceservice;

    @PostMapping("/save")
    public Insurance addInsurance (@RequestBody Insurance insurance){
        return insuranceservice.addInsurance(insurance);
    }

    @PutMapping ("/updatedinc/{Idinsurance}")
    public Insurance updatedinsurance(@PathVariable Insurance insurance ){
        return insuranceservice.updateInsurance(insurance);

    }
    @GetMapping("/findbyid/{idinsurance}")
    public Insurance findinsurancebyid(@PathVariable Long idinsurance){
        return insuranceservice.getInsuranceById(idinsurance);
    }

    @DeleteMapping("deleteinsurance/{idinsurance}")
    public String deleteInsurance(@PathVariable Long idinsurance){
        insuranceservice.deleteInsurance(idinsurance);
        return "insurance deleted !";
    }

    @GetMapping("/all")
    public List<Insurance> getallinsurance(){
        return insuranceservice.getAll();
    }
    @PutMapping("/addinsuranceandassigntouser/{iduser}")
    public Insurance addinsuranceandassigntouser (@RequestBody Insurance insurance,@PathVariable Integer iduser)
    {
        return insuranceservice.addinsuranceandassigntouser(insurance,iduser);
    }
    @PutMapping("/assigninsurancetouser/{idinsurance}/{iduser}")
    public Insurance assigninsurancetouser(@PathVariable Long idinsurance,@PathVariable Integer iduser)
    {
        return insuranceservice.assigninsurancetouser(idinsurance,iduser);
    }
    @GetMapping("/gettotalinsurance")
    public Long gettotalinsurance()
    {
        return insuranceservice.gettotalinsurance();
    }

    @GetMapping("/allbyuser")
    public List<Insurance> getbyuser(@RequestParam("iduser") Integer iduser){
        return insuranceservice.getallbyuser(iduser);
    }
    @PostMapping("/saveorderinsurance/{iduser}/{idorder}")
    public Insurance saveorderinsurance(@PathVariable Integer iduser,@PathVariable Long idorder ){
        return insuranceservice.createInsurance(iduser,idorder);

    }



}
