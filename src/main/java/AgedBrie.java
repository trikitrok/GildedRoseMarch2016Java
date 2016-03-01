public class AgedBrie extends MutableItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        incrementQuality(item);

        if (outOfDate()) {
            incrementQuality(item);
        }
    }
}
