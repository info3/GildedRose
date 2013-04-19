package gildedrose;

import static org.junit.Assert.assertEquals;
import gildedrose.original.GildedRose;
import gildedrose.original.Item;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * This tests the as-is specification of the Gilded Rose.
 * 
 * @author kleinen
 * 
 */
public class GildedRoseCharacterizationTest {

	protected Item updateQuality(Item item) {
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		GildedRose.setItems(items);
		GildedRose.updateQuality();
		return item;
	}

	// This is just a Description:
	// - All items have a SellIn value which denotes the number of days we have
	// to sell the item
	// - All items have a Quality value which denotes how valuable the item is

	/**
	 * - At the end of each day our system lowers both values for every item
	 */
	@Test
	public void sellInAndQualityShouldBeLoweredEachDay() {
		Item item = updateQuality(new Item("anything", 5, 60));

		assertEquals(59, item.getQuality());
		assertEquals(4, item.getSellIn());

	}

	/**
	 * - Once the sell by date has passed, Quality degrades twice as fast
	 */
	@Test
	public void qualityShouldDegradeTwiceAsFastAfterSellInHasPassed() {
		Item item = updateQuality(new Item("anything", 0, 60));

		assertEquals(58, item.getQuality());
		assertEquals(-1, item.getSellIn());

	}

	/**
	 * - The Quality of an item is never negative
	 */
	@Test
	public void qualityOfItemShouldNeverBeNegative() {
		Item item = updateQuality(new Item("anything", 5, 0));

	//	assertEquals(item.getSellIn(), 4);
		assertEquals(0, item.getQuality());

	}
	@Test
	public void qualityOfItemShouldNeverBeNegativeEvenAfterSellin() {
		Item item = updateQuality(new Item("anything", -3, 0));

		assertEquals(0, item.getQuality());

	}

	/**
	 * - "Aged Brie" actually increases in Quality the older it gets 
	 */
	@Test
	public void agedBrieShouldIncreaseQuality() {
		Item item = updateQuality(new Item("Aged Brie", 2, 0));
		assertEquals(1, item.getQuality());
	}
	/**
	 * - "Aged Brie" actually increases in Quality the older it gets 
	 *  * - The Quality of an item is never more than 50
	 */
	@Test
	public void agedBrieShouldIncreaseQualityButNotAbove50() {
		Item item = updateQuality(new Item("Aged Brie", 2, 50));
		assertEquals(50, item.getQuality());
	}

	/**
	 * - The Quality of an item is never more than 50
	 * TBD: This does not work in the original version!
	 */
	@Test
	public void qualityShouldNeverBeMoreThan50() {
		Item item = updateQuality(new Item("anything", 30, 55));
		assertEquals(54, item.getQuality());

	}

	/**
	 
	 * - "Sulfuras", being a legendary item, never has to be sold or decreases 
	 *  in Quality
	 */
	@Test
	public void sulfurasNeverNeedsToBeSold() {
		Item item = updateQuality(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		assertEquals(80, item.getQuality());

	}
	@Test
	public void sulfurasNeverDecreasesQuality() {
		Item item = updateQuality(new Item("Sulfuras, Hand of Ragnaros", -5, 80));
		assertEquals(80, item.getQuality());

	}
	/**
	 * - "Backstage passes", like aged brie, increases in Quality as it's SellIn
	approaches;
	 */
	@Test
	public void qualityOfBackstagePassesIncrease() {
		Item item = updateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		assertEquals(21, item.getQuality());

	}

	/**
	 * - "Backstage passes", like aged brie, increases in Quality as it's SellIn
	approaches; but also is limited at 50
	 */
	@Test
	public void qualityOfBackstagePassesIncreasesNotAbove50() {
		Item item = updateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50));
		assertEquals(50, item.getQuality());

	}
	/**
	 * - "Backstage passes", like aged brie, increases in Quality as it's SellIn
	approaches; Quality increases by 2 when there are 10 days or less 
	 */
	@Test
	public void qualityOfBackstagePassesIncrease10Days() {
		Item item = updateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		assertEquals(22, item.getQuality());
	}
	
	/**
	 * - "Backstage passes", like aged brie, increases in Quality as it's SellIn
	approaches; Quality increases by 2 when there are 10 days or less 
	 */
	@Test
	public void qualityOfBackstagePassesIncrease10DaysLimit50() {
		Item item = updateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50));
		assertEquals(50, item.getQuality());

	}
	/**
	 * - "Backstage passes", like aged brie, increases in Quality as it's SellIn
	approaches; Quality increases by 2 when there are 9 days or less 
	 */
	@Test
	public void qualityOfBackstagePassesIncrease9Days() {
		Item item = updateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20));
		assertEquals(22, item.getQuality());

	}
	@Test
	public void qualityOfBackstagePassesIncrease9DaysLimit50() {
		Item item = updateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50));
		assertEquals(50, item.getQuality());

	}
	/**
	 * - "Backstage passes", like aged brie, increases in Quality as it's SellIn
	approaches; Quality increases by 2 when there are 10 days or less 
	 */
	@Test
	public void qualityOfBackstagePassesIncrease11Days() {
		Item item = updateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));
		assertEquals(21, item.getQuality());
	}
	/**
	 * - "Backstage passes", like aged brie, increases in Quality as it's SellIn
	approaches; Quality increases by 2 when there are 10 days or less and by 3 
	when there are 5 days or less but Quality drops to 0 after the concert
	 */
	@Test
	public void qualityOfBackstagePassesIncrease5() {
		Item item = updateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		assertEquals(23, item.getQuality());
	}
	@Test
	public void qualityOfBackstagePassesIncrease5Limit50() {
		Item item = updateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50));
		assertEquals(50, item.getQuality());
	}
	/**
	 * - "Backstage passes",  but Quality drops to 0 after the concert
	 */
	@Test
	public void qualityOfBackstagePassesIncrease0() {
		Item item = updateQuality(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
		assertEquals(0, item.getQuality());

	}
	
	/**
	 * Another Case for full coverage:
	 */
	/**
	 * - "Aged Brie" actually increases in Quality the older it gets 
	 * - and twice as fast after the sellin date
	 */
	@Test
	public void agedBrieShouldIncreaseQualityAfterSellin() {
		Item item = updateQuality(new Item("Aged Brie", -1, 15));
		assertEquals(17, item.getQuality());
	}
	@Test
	public void agedBrieShouldIncreaseQualityAfterSellinLimit50() {
		Item item = updateQuality(new Item("Aged Brie", -1, 50));
		assertEquals(50, item.getQuality());
	}
	

}
