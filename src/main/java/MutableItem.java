public class MutableItem {
    private Item item;

    public MutableItem(Item item) {
        this.item = item;
    }

    public void degrade() {
        if (isAgedBrie(item)) {

            incrementQuality(item);

            if (outOfDate()) {
                incrementQuality(item);
            }
        }

        if (isBackstagePasses(item)) {

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

        if (isPerishable(item)) {

            decrementQuality(item);

            if (outOfDate()) {
                decrementQuality(item);
            }
        }
    }

    private boolean outOfDate() {
        return item.sellIn < 0;
    }

    public void age() {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isPerishable(Item item) {
        return !isAgedBrie(item) && !isBackstagePasses(item);
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }
}
