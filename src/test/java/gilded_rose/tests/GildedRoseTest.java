package gilded_rose.tests;

import gilded_rose.GildedRose;
import org.junit.Assert;
import org.junit.Test;
import gilded_rose.Item;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {
    @Test
    public void sulfuras_is_inmutable() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        gildedRose = aGildedRoseWithItems(sulfuras);

        afterDays(10);

        assertItemsQuality(80, sulfuras);
        assertEquals(0, sulfuras.sellIn);
    }

    @Test
    public void sell_in_decreases_by_one_each_day() {
        Item notSulfuras = new Item("notSulfuras", 2, 0);
        gildedRose = aGildedRoseWithItems(notSulfuras);

        afterDays(10);

        assertEquals(-8, notSulfuras.sellIn);
    }

    @Test
    public void aged_brie_quality_increases_by_one_each_day_before_sell_date() {
        Item agedBrie = new Item("Aged Brie", 2, 0);
        gildedRose = aGildedRoseWithItems(agedBrie);

        afterDays(2);

        assertItemsQuality(2, agedBrie);
    }

    @Test
    public void aged_brie_quality_increases_by_two_each_day_after_sell_date() {
        Item agedBrie = new Item("Aged Brie", 0, 0);
        gildedRose = aGildedRoseWithItems(agedBrie);

        afterDays(2);

        assertItemsQuality(4, agedBrie);
    }

    @Test
    public void quality_Cannot_be_more_than_fifty() {
        Item agedBrie = new Item("Aged Brie", 2, 0);
        gildedRose = aGildedRoseWithItems(agedBrie);

        afterDays(300);

        assertItemsQuality(50, agedBrie);
    }

    @Test
    public void backstage_passes_quality_increases_by_one_each_day_before_ten_days_to_sell_date() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 0);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        afterDays(5);

        assertItemsQuality(5, backstagePasses);
    }

    @Test
    public void backstage_passes_quality_increases_by_two_each_day_between_ten_and_five_days_before_sell_date() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 0);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        afterDays(7);

        assertItemsQuality(9, backstagePasses);
    }

    @Test
    public void backstage_passes_quality_increases_by_three_each_day_between_five_days_and_the_sell_date() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 0);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        afterDays(15);

        assertItemsQuality(30, backstagePasses);
    }

    @Test
    public void backstage_passes_quality_Is_zero_after_the_sell_date() {
        Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        afterDays(16);

        assertItemsQuality(0, backstagePasses);
    }

    @Test
    public void perishable_items_quality_decreases_by_one_each_day_before_sell_date() {
        Item regularItem = new Item("+5 Dexterity Vest", 10, 20);
        gildedRose = aGildedRoseWithItems(regularItem);

        afterDays(10);

        assertItemsQuality(10, regularItem);
    }

    @Test
    public void perishable_items_quality_decreases_by_two_each_day_after_sell_date() {
        Item perishableItem = new Item("+5 Dexterity Vest", 10, 20);
        gildedRose = aGildedRoseWithItems(perishableItem);

        afterDays(15);

        assertItemsQuality(0, perishableItem);
    }

    @Test
    public void perishable_items_quality_cannot_be_less_than_zero() {
        Item perishableItem = new Item("+5 Dexterity Vest", 10, 20);
        gildedRose = aGildedRoseWithItems(perishableItem);

        afterDays(200);

        assertItemsQuality(0, perishableItem);
    }

    @Test
    public void conjured_items_quality_decreases_by_two_each_day_before_sell_date() {
        Item conjuredItem = new Item("Conjured Mana Cake", 3, 6);
        gildedRose = aGildedRoseWithItems(conjuredItem);

        afterDays(3);

        assertItemsQuality(0, conjuredItem);
    }

    @Test
    public void conjuredItemsQualityDecreasesByFourEachDayAfterSellDate() {
        Item conjuredItem = new Item("Conjured Mana Cake", 5, 18);
        gildedRose = aGildedRoseWithItems(conjuredItem);

        afterDays(7);

        assertItemsQuality(0, conjuredItem);
    }

    @Test
    public void conjuredItemsQualityCannotBeLessThanZero() {
        Item conjuredItem = new Item("Conjured Mana Cake", 5, 18);
        gildedRose = aGildedRoseWithItems(conjuredItem);

        afterDays(200);

        assertItemsQuality(0, conjuredItem);
    }

    @Test
    public void conjuredSulfurasIsInmutable() {
        Item conjuredSulfuras = new Item("Conjured Sulfuras, Hand of Ragnaros", 5, 18);
        gildedRose = aGildedRoseWithItems(conjuredSulfuras);

        afterDays(200);

        assertItemsQuality(18, conjuredSulfuras);
        assertEquals(5, conjuredSulfuras.sellIn);
    }

    @Test
    public void conjuredAgedBrieQualityIncreasesByTwoEachDayBeforeSellDate() {
        Item agedBrie = new Item("Conjured Aged Brie", 2, 0);
        gildedRose = aGildedRoseWithItems(agedBrie);

        afterDays(2);

        assertItemsQuality(4, agedBrie);
    }

    @Test
    public void conjuredBackstagePassesQualityIncreasesTwiceFaster() {
        Item backstagePasses = new Item("Conjured Backstage passes to a TAFKAL80ETC concert", 15, 0);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        afterDays(15);

        assertItemsQuality(50, backstagePasses);
    }

    @Test
    public void conjuredBackstagePassesQualityIsZeroAfterTheSellDate() {
        Item backstagePasses = new Item("Conjured Backstage passes to a TAFKAL80ETC concert", 15, 2);
        gildedRose = aGildedRoseWithItems(backstagePasses);

        afterDays(16);

        assertItemsQuality(0, backstagePasses);
    }

    private GildedRose gildedRose;

    private void afterDays(int numberOfDays) {
        for (int i = 0; i < numberOfDays; ++i) {
            gildedRose.updateQuality();
        }
    }

    private void assertItemsQuality(int quality, Item item) {
        assertEquals(quality, item.quality);
    }

    private GildedRose aGildedRoseWithItems(Item... items) {
        return new GildedRose(items);
    }
}
