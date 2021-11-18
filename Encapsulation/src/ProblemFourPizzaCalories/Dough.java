package ProblemFourPizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy")
                && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight (double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double doughModifierFlourType = 0;
        switch (this.flourType) {
            case "White":
                doughModifierFlourType = 1.5;
                break;
            case "Wholegrain":
                doughModifierFlourType = 1.0;
                break;
        }
        double doughModifierBakingTechnique = 0;
        switch (this.bakingTechnique) {
            case "Crispy":
                doughModifierBakingTechnique = 0.9;
                break;
            case "Chewy":
                doughModifierBakingTechnique = 1.1;
                break;
            case "Homemade":
                doughModifierBakingTechnique = 1.0;
                break;
        }
        return (2 * this.weight) * doughModifierFlourType * doughModifierBakingTechnique;
    }
}
