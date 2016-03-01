import java.util.ArrayList;
import java.util.List;

public class MutableItems {
    private List<MutableItem> mutableItems;

    public MutableItems(List<MutableItem> mutableItems) {

        this.mutableItems = mutableItems;
    }

    public static MutableItems createFrom(Item[] items) {
        List<MutableItem> mutableItems = new ArrayList<MutableItem>();

        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (!isSulfuras(item)) {
                mutableItems.add(new MutableItem(item));
            }
        }

        return new MutableItems(mutableItems);
    }

    public void degrade() {
        for (MutableItem mutableItem : mutableItems) {
            mutableItem.age();
            mutableItem.updateQuality();
        }
    }

    private static boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

}
