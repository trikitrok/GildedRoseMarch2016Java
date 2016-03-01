public class PerishableItem extends MutableItem {

    public PerishableItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (outOfDate()) {
            decrementQualityBy(2);
            return;
        }
        decrementQualityBy(1);
    }
}
