abstract public class MutableItem {
    public static final int MAXIMUM_QUALITY = 50;
    protected Item item;

    protected MutableItem(Item item) {
        this.item = item;
    }

    abstract public void updateQuality();

    protected boolean outOfDate() {
        return daysToBeSold() < 0;
    }

    protected int daysToBeSold() {
        return item.sellIn;
    }

    public void age() {
        item.sellIn = daysToBeSold() - 1;
    }

    protected void incrementQuality() {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;
        }
    }
}
