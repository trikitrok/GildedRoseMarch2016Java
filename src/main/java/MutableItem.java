abstract public class MutableItem {
    public static final int MAXIMUM_QUALITY = 50;
    protected Item item;

    protected MutableItem(Item item) {
        this.item = item;
    }

    abstract public void updateQuality();

    public void age() {
        item.sellIn = daysToBeSold() - 1;
    }

    protected boolean outOfDate() {
        return daysToBeSold() < 0;
    }

    protected int daysToBeSold() {
        return item.sellIn;
    }

    protected void decrementQualityBy(int num) {
        for(int i = 0; i<num; ++i) {
            decrementQuality();
        }
    }

    protected void incrementQualityBy(int num) {
        for(int i = 0; i<num; ++i) {
            incrementQuality();
        }
    }

    protected void vanishQuality() {
        item.quality = 0;
    }

    private void incrementQuality() {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality += 1;
        }
    }

    private void decrementQuality() {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }
}
