import java.util.ArrayList;
import java.util.List;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        List<MutableItem> mutableItems = new ArrayList<MutableItem>();

        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (isSulfuras(item)) {
                return;
            }
            mutableItems.add(new MutableItem(item));
        }

        for (MutableItem mutableItem : mutableItems) {
            mutableItem.age();
            mutableItem.updateQuality();
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}