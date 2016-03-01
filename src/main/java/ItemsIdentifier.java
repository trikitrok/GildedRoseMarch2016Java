public class ItemsIdentifier {
    public static boolean isPerishable(Item item) {
        return !isAgedBrie(item) && !isBackstagePasses(item);
    }

    public static boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public static boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    public static boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}
