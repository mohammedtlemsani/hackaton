package ma.enset.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Patient {
        private String id;
        private String name;
        private int age;
        private String sex;
        private String chestPainType;
        private int restingBloodPressure;
        private int serumCholesterol;
        private int fastingBloodSugar;
        private String restingElectrocardiographicResults;
        private int maximumHeartRateAchieved;
        private String exerciseInducedAngina;
        private double stDepressionInducedByExerciseRelativeToRest;
        private String slopeOfPeakExerciseSTSegment;
        private int numberOfMajorVesselsColoredByFlourosopy;
        private String thalassemia;
        private int heartDiseaseDiagnosis;
        private String card;
}
