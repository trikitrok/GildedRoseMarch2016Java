package gilded_rose.mutable_items;

class ConjuredItem extends MutableItem {
    private MutableItem mutableItem;

    ConjuredItem(MutableItem item) {
        super(item.item());
        this.mutableItem = item;
    }

    @Override
    protected void updateQuality() {
        mutableItem.updateQuality();
        mutableItem.updateQuality();
    }
}
