public class BackstageConcertPasses extends MutableItem {
    public BackstageConcertPasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (outOfDate()) {
            vanishQuality();
            return;
        }

        incrementQuality();

        if (daysToBeSold() < 10) {
            incrementQuality();
        }

        if (daysToBeSold() < 5) {
            incrementQuality();
        }
    }
}
