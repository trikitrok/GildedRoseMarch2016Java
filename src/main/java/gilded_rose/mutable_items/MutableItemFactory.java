package gilded_rose.mutable_items;

import gilded_rose.Item;

import static gilded_rose.mutable_items.ItemsIdentifier.*;

class MutableItemFactory {
    static MutableItem createFrom(Item item) {
        return createFrom(item.name, item);
    }

    private static MutableItem createFrom(String name, Item item) {
        if (isConjured(name)) {
            return new ConjuredItem(
                createFrom(extractNotConjuredName(name), item)
            );
        }

        if (isAgedBrie(name)) {
            return new AgedBrie(item);
        }

        if (isBackstagePasses(name)) {
            return new BackstageConcertPasses(item);
        }

        if (isPerishable(name)) {
            return new PerishableItem(item);
        }

        throw new RuntimeException("Unknown item type");
    }
}
