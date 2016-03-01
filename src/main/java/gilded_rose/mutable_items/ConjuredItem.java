package gilded_rose.mutable_items;

class ConjuredItem extends MutableItem {
    private MutableItem mutableItem;

    public ConjuredItem(MutableItem item) {
        super(item.item());
        this.mutableItem = item;
    }

    @Override
    public void updateQuality() {
        mutableItem.updateQuality();
        mutableItem.updateQuality();
    }

    public void age() {
        mutableItem.age();
    }
}
