public class BackstageConcertPasses extends MutableItem {
    public BackstageConcertPasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        incrementQuality(item);

        if (item.sellIn < 10) {
            incrementQuality(item);
        }

        if (item.sellIn < 5) {
            incrementQuality(item);
        }

        if (outOfDate()) {
            item.quality = 0;
        }
    }
}
