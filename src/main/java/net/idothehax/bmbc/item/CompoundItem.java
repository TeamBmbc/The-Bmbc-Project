package net.matty.bmbc.item;

import net.matty.bmbc.element.Element;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompoundItem extends Item {
    private static Map<Item, Compound> compatibleItems = new HashMap<>();
    private final Compound compound;

    public CompoundItem(Properties pProperties, Element element){
        super(pProperties);
        this.compound = new Compound(element);
    }

    public CompoundItem(Properties pProperties, Compound compound) {
        super(pProperties);
        this.compound = compound;
    }

    public static void addCompatibleItem(Item item, Compound compound) {
        compatibleItems.put(item, compound);
    }

    public Compound getCompound() {
        return compound;
    }

    public List<Element> getCompoundElements() {
        return compound.getElements();
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity){
        new Thread(() -> {
            if(((CompoundItem) stack.getItem()).compound.getElements().size()==1&&((CompoundItem) stack.getItem()).compound.getElements().get(0)==ElementItems.LITHIUM) {
                if(entity.isInWater()) entity.getServer().overworld().explode(null, entity.getX(), entity.getY(), entity.getZ(), 2, true, Level.ExplosionInteraction.NONE);
            }
        }).start();
        return super.onEntityItemUpdate(stack, entity);
    }
    public static List<Element> getCompoundElementsOf(Item item) {
        if (item instanceof CompoundItem compoundItem) {
            return compoundItem.getCompoundElements();
        } else if (compatibleItems.getOrDefault(item, Compound.EMPTY) != Compound.EMPTY) {
            return compatibleItems.getOrDefault(item, Compound.EMPTY).getElements();
        } else {
            return Compound.EMPTY.getElements();
        }
    }
}
