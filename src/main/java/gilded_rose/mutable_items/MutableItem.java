package gilded_rose.mutable_items;

import gilded_rose.Item;

abstract class MutableItem {
    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;
    private Item item;

    MutableItem(Item item) {
        this.item = item;
    }

    abstract protected void updateQuality();

    void degrade() {
        age();
        updateQuality();
    }

    private void age() {
        item.sellIn = daysToBeSold() - 1;
    }

    protected Item item() {
        return item;
    }

    boolean outOfDate() {
        return daysToBeSold() < 0;
    }

    int daysToBeSold() {
        return item.sellIn;
    }

    void decrementQuality(int times) {
        for(int i = 0; i<times; ++i) {
            decrementQualityOnce();
        }
    }

    void incrementQuality(int times) {
        for(int i = 0; i<times; ++i) {
            incrementQualityOnce();
        }
    }

    void vanishQuality() {
        item.quality = 0;
    }

    private void incrementQualityOnce() {
        if (item.quality >= MAXIMUM_QUALITY) {
            return;
        }
        item.quality += 1;
    }

    private void decrementQualityOnce() {
        if (item.quality <= MINIMUM_QUALITY) {
            return;
        }
        item.quality -= 1;
    }
}
