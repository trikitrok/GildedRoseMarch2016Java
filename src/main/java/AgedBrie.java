public class AgedBrie extends MutableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        incrementQuality();

        if (outOfDate()) {
            incrementQuality();
        }
    }
}
