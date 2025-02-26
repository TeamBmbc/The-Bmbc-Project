package net.matty.bmbc.item;

import net.matty.bmbc.element.Element;
import net.matty.bmbc.element.ElementRegister;

import java.util.List;

public class Compound {
    public static final Compound EMPTY = new Compound(ElementRegister.UNKNOWN);
    private final List<Element> compoundElements;

    private final List<Element> elements;
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

    public List<Element> getElements() {
        return compoundElements;
    }

    public Compound(Element element, String series, String stateAtZeroC, double weight, int energyLevels,
                    double electronegativity, double meltingPoint, double boilingPoint, double electronAffinity,
                    double ionizationEnergy, double radius, double hardness, double modulus, double density,
                    double thermalConductivity, double specificHeat, String discoveryTime) {
        this.elements = Collections.singletonList(element);
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

        /* do i need this?
        if (elements.length>0) {
            compoundElements = List.of(elements);
        } else {
            compoundElements = EMPTY.compoundElements;
        }
        */
    }

    public List<Element> getElements() {
        return elements;
    }

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
}
