abstract public class MutableItem {
    public static final int MAXIMUM_QUALITY = 50;
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

    protected void incrementQuality(Item item) {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;
        }
    }
}
