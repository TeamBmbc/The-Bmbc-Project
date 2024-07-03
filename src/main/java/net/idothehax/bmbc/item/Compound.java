package net.matty.bmbc.item;

import net.matty.bmbc.element.Element;
import net.matty.bmbc.element.ElementRegister;

import java.util.List;

public class Compound {
    public static final Compound EMPTY = new Compound(ElementRegister.UNKNOWN);
    private final List<Element> compoundElements;

    public Compound(Element... elements) {
        if (elements.length>0) {
            compoundElements = List.of(elements);
        } else {
            compoundElements = EMPTY.compoundElements;
        }
    }

    public List<Element> getElements() {
        return compoundElements;
    }
}
