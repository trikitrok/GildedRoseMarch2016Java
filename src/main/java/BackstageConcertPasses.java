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

        if(daysToBeSold() >= 10) {
            incrementQualityBy(1);
        }

        if (5 <= daysToBeSold() && daysToBeSold() < 10) {
            incrementQualityBy(2);
        }

        if (0 <= daysToBeSold() && daysToBeSold() < 5) {
            incrementQualityBy(3);
        }
    }
}
