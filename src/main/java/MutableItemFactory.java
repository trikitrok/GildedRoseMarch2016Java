public class MutableItemFactory {
    private static boolean isPerishable(Item item) {
        return !isAgedBrie(item) && !isBackstagePasses(item);
    }

    private static boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private static boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    public static MutableItem createFrom(Item item) {
        if (isAgedBrie(item)) {
            return new AgedBrie(item);
        }

        if (isBackstagePasses(item)) {
            return new BackstageConcertPasses(item);
        }

        if (isPerishable(item)) {
            return new PerishableItem(item);
        }

        throw new RuntimeException("Unknown item type");
    }
}
