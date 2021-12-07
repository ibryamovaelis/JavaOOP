package glacialExpedition.models.explorers;

import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import java.util.Collection;

public abstract class BaseExplorer implements Explorer {
    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.suitcase = new Carton();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO );
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canSearch() {
        return getEnergy() > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
//        if (canSearch()) {
//            this.energy -= 15;
//        }
//        if (getEnergy() < 0) {
//            setEnergy(0);
//        }

        this.energy = Math.max(0, this.energy - 15);
//        if (this.energy <= 15) {
//            this.energy = 0;
//        } else {
//            this.energy -= 15;
//        }
    }
}
