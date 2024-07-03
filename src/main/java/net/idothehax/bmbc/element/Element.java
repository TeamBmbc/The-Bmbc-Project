package net.matty.bmbc.element;

import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;

public class Element {
    private final Element.Data data;
    private final double meltingPoint;
    private final double boilingPoint;

    /**
     * @apiNote Temperature in Celsius
     */
    public Element(Element.Data data, double meltingPoint, double boilingPoint) {
        this.data = data;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
    }

    public static class Data {
        private final ResourceLocation id;
        private final String symbol;
        private final int number;
        public Data(ResourceLocation id, String atomicSymbol, int atomicNumber) {
            this.id = id;
            this.symbol = atomicSymbol;
            this.number = atomicNumber;
        }

        public ResourceLocation getId() {
            return this.id;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public int getNumber() {
            return this.number;
        }

    }

    public Element.Data getData() {
        return data;
    }

    public String getName() {
        return new TranslatableContents("element."+ data.id.getNamespace()+"."+ data.id.getPath(), data.id.getPath(), TranslatableContents.NO_ARGS).getKey();
    }

    public enum State {
        UNKNOWN,
        SOLID,
        LIQUID,
        GAS,
        PLASMA
    }

    public State getState(float temperature) {
        if (temperature >= meltingPoint) {
            if (temperature >= boilingPoint) {
                if (temperature > 150000000) return State.PLASMA;
                return State.GAS;
            } else {
                return State.SOLID;
            }
        } else if (temperature < meltingPoint) {
            return State.LIQUID;
        } else {
            return State.UNKNOWN;
        }
    }
}
