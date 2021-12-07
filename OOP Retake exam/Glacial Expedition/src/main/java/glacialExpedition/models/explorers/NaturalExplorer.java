package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private static final double INITIAL_EXPLORER_ENERGY  = 60;

    public NaturalExplorer(String name) {
        super(name, INITIAL_EXPLORER_ENERGY);
    }

    @Override
    public void search() {
        if (getEnergy() <= 7) {
            super.setEnergy(0);
        } else {
            super.setEnergy(this.getEnergy() - 7);
        }
    }
}
