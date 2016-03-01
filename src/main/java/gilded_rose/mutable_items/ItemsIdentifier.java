package gilded_rose.mutable_items;

class ItemsIdentifier {
    public static boolean isPerishable(String name) {
        return !isAgedBrie(name) && !isBackstagePasses(name);
    }

    public static boolean isBackstagePasses(String name) {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public static boolean isAgedBrie(String name) {
        return name.equals("Aged Brie");
    }

    public static boolean isSulfuras(String name) {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    public static boolean isConjured(String name) {
        return name.contains("Conjured");
    }

    public static String extractNotConjuredName(String name) {
        return name.replace("Conjured", "").trim();
    }
}
