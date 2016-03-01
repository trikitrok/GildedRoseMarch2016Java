public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (isSulfuras(item)) {
            return;
        }

        if (isAgedBrie(item) || isBackstagePasses(item)) {
            incrementQuality(item);

            if (isBackstagePasses(item)) {
                if (item.sellIn < 11) {
                    incrementQuality(item);
                }

                if (item.sellIn < 6) {
                    incrementQuality(item);
                }
            }
        }

        if (!isAgedBrie(item) && !isBackstagePasses(item)) {
            decrementQuality(item);
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (!isAgedBrie(item)) {
                if (!isBackstagePasses(item)) {
                    decrementQuality(item);
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                incrementQuality(item);
            }
        }
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }
}