package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer {
    private static final double INITIAL_EXPLORER_ENERGY  = 40;

    public GlacierExplorer(String name) {
        super(name, INITIAL_EXPLORER_ENERGY);
    }
}
