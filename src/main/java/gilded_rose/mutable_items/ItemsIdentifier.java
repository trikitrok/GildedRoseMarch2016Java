package gilded_rose.mutable_items;

class ItemsIdentifier {
    private static final String CONJURED_MARK = "Conjured";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    static boolean isPerishable(String name) {
        return !isAgedBrie(name) && !isBackstagePasses(name);
    }

    static boolean isBackstagePasses(String name) {
        return name.equals(BACKSTAGE_PASSES_TO_CONCERT);
    }

    static boolean isAgedBrie(String name) {
        return name.equals(AGED_BRIE);
    }

    static boolean isSulfuras(String name) {
        return name.contains(SULFURAS_HAND_OF_RAGNAROS);
    }

    static boolean isConjured(String name) {
        return name.contains(CONJURED_MARK);
    }

    static String extractNotConjuredName(String name) {
        return name.replace(CONJURED_MARK, "").trim();
    }
}
