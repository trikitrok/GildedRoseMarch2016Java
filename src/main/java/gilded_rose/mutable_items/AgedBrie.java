package gilded_rose.mutable_items;

import gilded_rose.Item;

class AgedBrie extends MutableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (outOfDate()) {
            incrementQuality(2);
            return;
        }
        incrementQuality(1);
    }
}
