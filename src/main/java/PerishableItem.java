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
}
