package gilded_rose;

import gilded_rose.mutable_items.MutableItems;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void degradeItems() {
        degrade(mutableItems());
    }

    private MutableItems mutableItems() {
        return MutableItems.createFrom(items);
    }

    private void degrade(MutableItems mutableItems) {
        mutableItems.degrade();
    }
}