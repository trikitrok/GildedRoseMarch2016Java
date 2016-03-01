abstract public class MutableItem {
    protected Item item;

    protected MutableItem(Item item) {
        this.item = item;
    }

    abstract public void updateQuality();

    protected boolean outOfDate() {
        return item.sellIn < 0;
    }

    public void age() {
        item.sellIn = item.sellIn - 1;
    }

    private static boolean isPerishable(Item item) {
        return !isAgedBrie(item) && !isBackstagePasses(item);
    }

    protected void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private static boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private static boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    public static MutableItem createFrom(Item item) {
        if (isAgedBrie(item)) {
            return new AgedBrie(item);
        }

        if (isBackstagePasses(item)) {
            return new BackstageConcertPasses(item);
        }

        if (isPerishable(item)) {
            return new PerishableItem(item);
        }

        throw new RuntimeException("Unknown item type");
    }
}
