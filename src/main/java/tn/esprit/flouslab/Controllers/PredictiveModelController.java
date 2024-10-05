package tn.esprit.flouslab.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.PredictiveModel;
import tn.esprit.flouslab.Services.IPredicitiveModelService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/PredictiveModel")
@CrossOrigin(origins = "*")


public class PredictiveModelController {
    @Autowired
    private IPredicitiveModelService predmodservice;

    @PostMapping("/save")
    public PredictiveModel addPredictiveModel(@RequestBody PredictiveModel pm ){
        return predmodservice.addPredictiveModel(pm);

    }

    @GetMapping("/findbyid/{idpm}")
    public PredictiveModel findPredictiveModelbyid(@PathVariable Long idpm){
        return predmodservice.getPredictiveModelbyid(idpm);
    }

    @DeleteMapping("deletepm/{idpm}")
    public String deletePredictiveModel(@PathVariable Long idpm){
        predmodservice.deletePredictiveModel(idpm);
        return "PredictiveModel deleted !";
    }

    @GetMapping("/all")
    public List<PredictiveModel> getallPredictiveModels(){
        return predmodservice.getALL();
    }

    @PutMapping("/updatepm")
    public PredictiveModel updatepm(@RequestBody PredictiveModel pm)
    {
        return predmodservice.updatePredictiveModel(pm);
    }



}
