package gilded_rose.mutable_items;

class ItemsIdentifier {
    public static final String CONJURED_MARK = "Conjured";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    public static boolean isPerishable(String name) {
        return !isAgedBrie(name) && !isBackstagePasses(name);
    }

    public static boolean isBackstagePasses(String name) {
        return name.equals(BACKSTAGE_PASSES_TO_CONCERT);
    }

    public static boolean isAgedBrie(String name) {
        return name.equals(AGED_BRIE);
    }

    public static boolean isSulfuras(String name) {
        return name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }

    public static boolean isConjured(String name) {
        return name.contains(CONJURED_MARK);
    }

    public static String extractNotConjuredName(String name) {
        return name.replace(CONJURED_MARK, "").trim();
    }
}
