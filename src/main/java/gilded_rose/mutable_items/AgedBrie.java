package gilded_rose.mutable_items;

import gilded_rose.Item;

class AgedBrie extends MutableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (outOfDate()) {
            incrementQualityBy(2);
            return;
        }
        incrementQualityBy(1);
    }
}
