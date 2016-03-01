package gilded_rose.mutable_items;

import gilded_rose.Item;

abstract class MutableItem {
    public static final int MAXIMUM_QUALITY = 50;
    public static final int MINIMUM_QUALITY = 0;
    private Item item;

    protected MutableItem(Item item) {
        this.item = item;
    }

    abstract public void updateQuality();

    public void age() {
        item.sellIn = daysToBeSold() - 1;
    }

    protected Item item() {
        return item;
    }

    protected boolean outOfDate() {
        return daysToBeSold() < 0;
    }

    protected int daysToBeSold() {
        return item.sellIn;
    }

    protected void decrementQuality(int times) {
        for(int i = 0; i<times; ++i) {
            decrementQualityOnce();
        }
    }

    protected void incrementQuality(int times) {
        for(int i = 0; i<times; ++i) {
            incrementQualityOnce();
        }
    }

    protected void vanishQuality() {
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
