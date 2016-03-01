public class PerishableItem extends MutableItem {

    public PerishableItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decrementQuality(item);

        if (outOfDate()) {
            decrementQuality(item);
        }
    }

    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
