public class MutableItemFactory {
    public static MutableItem createFrom(Item item) {
        if (ItemsIdentifier.isAgedBrie(item)) {
            return new AgedBrie(item);
        }

        if (ItemsIdentifier.isBackstagePasses(item)) {
            return new BackstageConcertPasses(item);
        }

        if (ItemsIdentifier.isPerishable(item)) {
            return new PerishableItem(item);
        }

        throw new RuntimeException("Unknown item type");
    }
}
