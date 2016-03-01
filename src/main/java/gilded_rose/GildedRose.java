package gilded_rose;

import gilded_rose.mutable_items.MutableItems;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        MutableItems mutableItems = MutableItems.createFrom(items);
        mutableItems.degrade();
    }
}