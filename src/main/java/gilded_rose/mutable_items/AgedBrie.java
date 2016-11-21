package gilded_rose.mutable_items;

import gilded_rose.Item;

class AgedBrie extends MutableItem {

    AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        if (outOfDate()) {
            incrementQuality(2);
            return;
        }
        incrementQuality(1);
    }
}
