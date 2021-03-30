package bstorm.akimts.CorrectionExo1.rapport;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class RapportValidation extends Rapport {

    private List<String> globalErrors = new ArrayList<>();
    private List<String> fieldErrors = new ArrayList<>();

    public RapportValidation(String message, int code, String chemin) {
        super(message, code, chemin);
    }

}
