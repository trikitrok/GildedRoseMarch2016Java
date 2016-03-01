public class BackstageConcertPasses extends MutableItem {
    public BackstageConcertPasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        incrementQuality();

        if (item.sellIn < 10) {
            incrementQuality();
        }

        if (item.sellIn < 5) {
            incrementQuality();
        }

        if (outOfDate()) {
            item.quality = 0;
        }
    }
}
