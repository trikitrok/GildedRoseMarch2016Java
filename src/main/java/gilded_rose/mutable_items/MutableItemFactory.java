package gilded_rose.mutable_items;

import gilded_rose.Item;

public class MutableItemFactory {
    public static MutableItem createFrom(Item item) {
        return createFrom(item.name, item);
    }

    private static MutableItem createFrom(String name, Item item) {
        if (ItemsIdentifier.isConjured(name)) {
            return new ConjuredItem(
                createFrom(ItemsIdentifier.extractNotConjuredName(name), item)
            );
        }

        if (ItemsIdentifier.isAgedBrie(name)) {
            return new AgedBrie(item);
        }

        if (ItemsIdentifier.isBackstagePasses(name)) {
            return new BackstageConcertPasses(item);
        }

        if (ItemsIdentifier.isPerishable(name)) {
            return new PerishableItem(item);
        }

        throw new RuntimeException("Unknown item type");
    }
}
