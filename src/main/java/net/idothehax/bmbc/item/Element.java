public class Element extends Item {
    private final String series;
    private final String stateAtZeroC;
    private final double weight;
    private final int energyLevels;
    private final double electronegativity;
    private final double meltingPoint;
    private final double boilingPoint;
    private final double electronAffinity;
    private final double ionizationEnergy;
    private final double radius;
    private final double hardness;
    private final double modulus;
    private final double density;
    private final double thermalConductivity;
    private final double specificHeat;
    private final String discoveryTime;

    public Element(Properties properties, String series, String stateAtZeroC, double weight, int energyLevels,
                   double electronegativity, double meltingPoint, double boilingPoint, double electronAffinity,
                   double ionizationEnergy, double radius, double hardness, double modulus, double density,
                   double thermalConductivity, double specificHeat, String discoveryTime) {
        super(properties);
        this.series = series;
        this.stateAtZeroC = stateAtZeroC;
        this.weight = weight;
        this.energyLevels = energyLevels;
        this.electronegativity = electronegativity;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
        this.electronAffinity = electronAffinity;
        this.ionizationEnergy = ionizationEnergy;
        this.radius = radius;
        this.hardness = hardness;
        this.modulus = modulus;
        this.density = density;
        this.thermalConductivity = thermalConductivity;
        this.specificHeat = specificHeat;
        this.discoveryTime = discoveryTime;
    }

    // Getters for each property
    public String getSeries() { return series; }
    public String getStateAtZeroC() { return stateAtZeroC; }
    public double getWeight() { return weight; }
    public int getEnergyLevels() { return energyLevels; }
    public double getElectronegativity() { return electronegativity; }
    public double getMeltingPoint() { return meltingPoint; }
    public double getBoilingPoint() { return boilingPoint; }
    public double getElectronAffinity() { return electronAffinity; }
    public double getIonizationEnergy() { return ionizationEnergy; }
    public double getRadius() { return radius; }
    public double getHardness() { return hardness; }
    public double getModulus() { return modulus; }
    public double getDensity() { return density; }
    public double getThermalConductivity() { return thermalConductivity; }
    public double getSpecificHeat() { return specificHeat; }
    public String getDiscoveryTime() { return discoveryTime; }
}