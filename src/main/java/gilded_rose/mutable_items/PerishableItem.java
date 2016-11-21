package gilded_rose.mutable_items;

import gilded_rose.Item;

class PerishableItem extends MutableItem {

    PerishableItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        if (outOfDate()) {
            decrementQuality(2);
            return;
        }
        decrementQuality(1);
    }
}
