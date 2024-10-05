package tn.esprit.flouslab.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.flouslab.Entities.Claim;
import tn.esprit.flouslab.Services.IClaimService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Claim")
@CrossOrigin(origins = "*")

public class ClaimController {
    @Autowired
    private IClaimService claimservice;

    @PostMapping("/save")
    public Claim addClaim(@RequestBody Claim c ){
        return claimservice.addClaim(c);

    }

    @GetMapping("/findbyid/{idclaim}")
    public Claim findclaimbyid(@PathVariable Long idclaim){
        return claimservice.getClaimbyid(idclaim);
    }

    @DeleteMapping("deleteclaim/{idc}")
    public String deleteClaim(@PathVariable Long idc){
        claimservice.deleteClaim(idc);
        return "claim deleted !";
    }

    @GetMapping("/all")
    public List<Claim> getallclaims(){
        return claimservice.getALL();
    }

    @PutMapping("/updateclaim")
    public Claim updateclaim(@RequestBody Claim c)
    {
        return claimservice.updateclaim(c);
    }



}
