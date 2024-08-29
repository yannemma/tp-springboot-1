package yoyama.imc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class  ImcService {
    public Map<String, String> calculate(ImcDTO data){
        double imc= data.poids()/Math.pow(data.taille(), 2);
        imc= Math.round(imc * 100) /100;
        String advise = this.analyse(imc);
        return Map.of(
                "imc" , String.valueOf(imc),
                "avis", advise
        );
    }

    private String analyse(double imc) {
        if (imc < 16.5) return "ELEVE";
        if (imc >= 16.5 && imc < 18.5) return "ACCRU";
        if (imc >= 18.5 && imc < 25) return "NORMALE";
        if (imc >= 25 && imc < 30) return "SURPOIDS";
        if (imc >= 30 && imc < 35) return "SEVERE";
        if (imc >= 40) return "OBESE";
        return "RAS";


    }

    ;
}
