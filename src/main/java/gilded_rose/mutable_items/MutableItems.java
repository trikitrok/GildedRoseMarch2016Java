package gilded_rose.mutable_items;

import gilded_rose.Item;

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
            if (!ItemsIdentifier.isSulfuras(item)) {
                MutableItem mutableItem = MutableItem.createFrom(item);
                mutableItems.add(mutableItem);
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
}
