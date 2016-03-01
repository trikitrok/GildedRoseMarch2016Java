public class PerishableItem extends MutableItem {

    public PerishableItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decrementQuality();

        if (outOfDate()) {
            decrementQuality();
        }
    }

    private void decrementQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
