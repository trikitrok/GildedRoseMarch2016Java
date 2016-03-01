package gilded_rose.mutable_items;

import gilded_rose.Item;

class PerishableItem extends MutableItem {

    public PerishableItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (outOfDate()) {
            decrementQuality(2);
            return;
        }
        decrementQuality(1);
    }
}
