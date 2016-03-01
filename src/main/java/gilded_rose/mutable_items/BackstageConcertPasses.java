package gilded_rose.mutable_items;

import gilded_rose.Item;

class BackstageConcertPasses extends MutableItem {
    public BackstageConcertPasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (outOfDate()) {
            vanishQuality();
            return;
        }

        if(daysToBeSold() >= 10) {
            incrementQuality(1);
        }

        if (5 <= daysToBeSold() && daysToBeSold() < 10) {
            incrementQuality(2);
        }

        if (0 <= daysToBeSold() && daysToBeSold() < 5) {
            incrementQuality(3);
        }
    }
}
