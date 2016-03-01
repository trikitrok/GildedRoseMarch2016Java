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

        for (Item item : items) {
            if (!ItemsIdentifier.isSulfuras(item.name)) {
                MutableItem mutableItem = MutableItemFactory.createFrom(item);
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
