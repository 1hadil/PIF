package tn.esprit.flouslab.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.flouslab.Entities.*;
import tn.esprit.flouslab.Repositories.InsuranceRepository;
import tn.esprit.flouslab.Repositories.OrderRepository;
import tn.esprit.flouslab.Repositories.PremiumRepository;
import tn.esprit.flouslab.Repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor

public class InsuranceServiceImpl implements IInsuranceService {

    @Autowired
    private OrderRepository orderrep;

    @Autowired
    private InsuranceRepository inrep;

    @Autowired
    private UserRepository userrep;
    @Override
    public Insurance addInsurance(Insurance i) {
        return inrep.save(i);
    }

    @Override
    public Insurance getInsuranceById(Long id) {
        return inrep.findById(id).orElse(null);
    }

    @Override
    public void deleteInsurance(Long id) {
        inrep.deleteById(id);

    }

    @Override
    public List<Insurance> getAll() {
        return (List<Insurance>) inrep.findAll();
    }

    @Override
    public Insurance updateInsurance(Insurance i) {
        Insurance insurance= inrep.findById(i.getIdInsurance()).orElse(null);
        insurance.setState(i.getState());
        insurance.setStartDate(i.getStartDate());
        insurance.setEndDate(i.getEndDate());
        insurance.setClientcoverageamount(i.getClientcoverageamount());
        insurance.setType(i.getType());
        insurance.setClientpremium(i.getClientpremium());
        insurance.setPolicy(i.getPolicy());
        return inrep.save(insurance);

    }

    @Override
    public Insurance addinsuranceandassigntouser(Insurance insurance, Integer iduser) {
        inrep.save(insurance);
        User user = userrep.findById(iduser).orElse(null);
        insurance.setUser(user);
        return  inrep.save(insurance);

    }

    @Override
    public Insurance assigninsurancetouser(Long idinsurance, Integer iduser) {
        Insurance i=inrep.findById(idinsurance).orElse(null);
        User u=userrep.findById(iduser).orElse(null);
        i.setUser(u);
        return inrep.save(i);
    }

    @Override
    public Long gettotalinsurance() {
        return inrep.count();
    }
    @Override
    public List<Insurance> getallbyuser(Integer iduser) {
        User user = userrep.findById(iduser).orElse(null);
        return inrep.findByUser(user);
    }
    @Override
    public Insurance createInsurance(Integer iduser,Long idorder ) {
        Insurance insurance = new Insurance();
        Orders order = orderrep.findById(idorder).get();
        LocalDate currentDate = LocalDate.now();
        insurance.setStartDate(currentDate);
        insurance.setEndDate(null);
        insurance.setClientcoverageamount(0);
        insurance.setClientpremium(0);
        insurance.setState(InStatus.Pending);
        insurance.setType(order.getType());



        User user = userrep.findById(iduser).orElse(null);

        insurance.setUser(user);
        return inrep.save(insurance);
    }

    /*@Override
    public Insurance updatedInsurance(Long insuranceId) {
        Insurance insurance= inrep.findById(insuranceId).get();
        insurance.setState(InStatus.Accepted);
        Iterable<Insurance> insurances = inrep.findAll();
        int calcul=0;
        float total=0;
        for (Insurance insurance1 : insurances
        ){
            if (insurance1.getInsuranceP().getId().equals(insurance.getInsuranceP().getId()) && insurance.getInsuranceP().getType().equals(insurance1.getInsuranceP().getType())){
                calcul++;
                total+=insurance1.getInsuranceP().getCoverageAmount();
            }
        }
        float pourcentageclaim=calculatePercentage(insurance.getUser(),insurance.getInsuranceP().getType(),insurance.getId())/100;
        //float moyenne = total/calcul;
        float averageclaimamount = total / calcul;

        float clientcovergeamount = (((pourcentageclaim * averageclaimamount)+insurance.getInsuranceP().getCoverageAmount())/2);

        insurance.setClientcoverageamount(clientcovergeamount);
        insurance.setClientpremium(clientcovergeamount/12);
        LocalDate currentDate = LocalDate.now();
        insurance.setStartDate(currentDate);
        LocalDate endDate = currentDate.plusYears(1);
        insurance.setEndDate(endDate);


        for (int i = 0; i <= 11; i++) {
            Premium premium = new Premium();
            premium.setAmount(clientcovergeamount/12);
            premium.setStatus(false);
            premium.setDate(currentDate.plusMonths(i));
            premium.setInsurance(insurance);
            premium.setAccumulatedInterest(20f);
            PremiumRepository.save(premium);
        }
        System.out.println("clientcovergeamount = " + clientcovergeamount);
        System.out.println("totalcoverageamount = " + total);
        System.out.println("averageclaimamount = " + averageclaimamount);
        System.out.println("countInsurances = "  +calcul);
        System.out.println("pourcentageclaim = "  +pourcentageclaim);

        return inrep.save(insurance);
    }
    public Float calculatePercentage(User userInfo, IType type,Long id) {
        Float percentage = 0f;
        int nbr=0;
        Iterable<Claim> claims = claimRepository.findAll();
        for (Claim claim : claims
        ){
            if (claim.getInsurance().getId().equals(id)){
                nbr++;
            }
        }
        switch (nbr){
            case 1:
                percentage +=2f;
                break;
            case 2:
                percentage +=4f;
                break;
            case 3:
                percentage +=6f;
                break;
            default:
                percentage +=2f;
                break;
        }
        if (userInfo != null) {
            if ("Doctor".equalsIgnoreCase(userInfo.getJob())) {
                percentage += 10f;
            } else if ("Engineer".equalsIgnoreCase(userInfo.getJob())) {
                percentage += 5f;
            } else {
                percentage += 2.5f;
            }

            int age = calculateAge(userInfo.getBirthDate());
            if (age >= 18 && age <= 30) {
                percentage += 5f;
            } else if (age > 30 && age <= 50) {
                percentage += 8f;
            } else if (age > 50) {
                percentage += 10f;
            }

            if (type != null) {
                switch (type) {
                    case Property_Insurance:
                        percentage += 5f;
                        break;
                    case Health_Insurance:
                        percentage += 7.5f;
                        break;
                    case Auto_Insurance:
                        percentage += 3f;
                        break;
                    case Liability_Insurance:
                        percentage += 6f;
                        break;
                    case Business_Insurance:
                        percentage += 10f;
                        break;
                    default:
                        break;
                }
            }
        }
        return percentage;
    }

    private int calculateAge(LocalDate birthDate) {
        if (birthDate == null) {
            return 0;
        }
        LocalDate currentDate = LocalDate.now();
        return currentDate.getYear() - birthDate.getYear();
    }
*/

}
