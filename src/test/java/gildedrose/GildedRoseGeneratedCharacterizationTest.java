package gildedrose;
import static org.junit.Assert.assertEquals;
import gildedrose.original.GildedRose;
import gildedrose.original.Item;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
// original version of Gilded Rose - to check if the tests cover everything.

public class GildedRoseGeneratedCharacterizationTest {

	@Before
	public void initItems() {
		GildedRose.initItemList();
	}

	final static int N = 20;

	@Test
	public void testTheTruth() {
		ArrayList<List<Item>> assertBruteForce = generatedTruth();
		for (int i = 0; i < N; i++) {
			GildedRose.updateQuality();
			assertItemListEquals(i, assertBruteForce.get(i),
					GildedRose.getItems());
		}
	}

	private void assertItemListEquals(int n, List<Item> expected,
			List<Item> actual) {
		assertEquals("item lists " + n + " have not the same size",
				expected.size(), actual.size());
		int s = expected.size(); // should be N
		for (int i = 0; i < s; i++) {
			assertItemEqual(n, i, expected.get(i), actual.get(i));

		}

	}

	private void assertItemEqual(int n, int i, Item expected, Item actual) {
		assertEquals("run " + n + " item " + i + " name " + expected.getName(),
				expected.getName(), actual.getName());
		assertEquals(
				"run " + n + " item " + i + " sellin " + expected.getName(),
				expected.getSellIn(), actual.getSellIn());
		assertEquals(
				"run " + n + " item " + i + " quality " + expected.getName(),
				expected.getQuality(), actual.getQuality());

	}

	/**
	 * this method serves to generate the expected test data in 
	 * method generatedTruth.
	 * 
	 * @see generatedTruth
	 */
	@Test
	public void generateTheTruth() {
		final int N = 20;
		System.out
				.println("ArrayList<List<Item>> batchItems = new ArrayList<List<Item>>();");
		System.out.println("List<Item> items;");
		for (int i = 0; i < N; i++) {
			List<Item> items = GildedRose.getItems();
			GildedRose.updateQuality();

			System.out.println();
			// System.out.println("--- run no " + i + " ---");
			System.out.println("items = new ArrayList<Item>();");
			for (Item item : items) {
				System.out.println("items.add(new Item(\"" + item.getName()
						+ "\", " + item.getSellIn() + ", " + item.getQuality()
						+ "));");
			}
			System.out.println("batchItems.add(items);");
		}
	}
	/**
	 * generatedTruth returns a list containing the itemLists after
	 * each call to updateQuality().
	 * @return
	 */
	private ArrayList<List<Item>> generatedTruth() {
		ArrayList<List<Item>> batchItems = new ArrayList<List<Item>>();
		List<Item> items;

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 9, 19));
		items.add(new Item("Aged Brie", 1, 1));
		items.add(new Item("Elixir of the Mongoose", 4, 6));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21));
		items.add(new Item("Conjured Mana Cake", 2, 5));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 8, 18));
		items.add(new Item("Aged Brie", 0, 2));
		items.add(new Item("Elixir of the Mongoose", 3, 5));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 13, 22));
		items.add(new Item("Conjured Mana Cake", 1, 4));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 7, 17));
		items.add(new Item("Aged Brie", -1, 4));
		items.add(new Item("Elixir of the Mongoose", 2, 4));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 23));
		items.add(new Item("Conjured Mana Cake", 0, 3));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 6, 16));
		items.add(new Item("Aged Brie", -2, 6));
		items.add(new Item("Elixir of the Mongoose", 1, 3));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 24));
		items.add(new Item("Conjured Mana Cake", -1, 1));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 5, 15));
		items.add(new Item("Aged Brie", -3, 8));
		items.add(new Item("Elixir of the Mongoose", 0, 2));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 25));
		items.add(new Item("Conjured Mana Cake", -2, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 4, 14));
		items.add(new Item("Aged Brie", -4, 10));
		items.add(new Item("Elixir of the Mongoose", -1, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 27));
		items.add(new Item("Conjured Mana Cake", -3, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 3, 13));
		items.add(new Item("Aged Brie", -5, 12));
		items.add(new Item("Elixir of the Mongoose", -2, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 8, 29));
		items.add(new Item("Conjured Mana Cake", -4, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 2, 12));
		items.add(new Item("Aged Brie", -6, 14));
		items.add(new Item("Elixir of the Mongoose", -3, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 7, 31));
		items.add(new Item("Conjured Mana Cake", -5, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 1, 11));
		items.add(new Item("Aged Brie", -7, 16));
		items.add(new Item("Elixir of the Mongoose", -4, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 33));
		items.add(new Item("Conjured Mana Cake", -6, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 0, 10));
		items.add(new Item("Aged Brie", -8, 18));
		items.add(new Item("Elixir of the Mongoose", -5, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 35));
		items.add(new Item("Conjured Mana Cake", -7, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", -1, 8));
		items.add(new Item("Aged Brie", -9, 20));
		items.add(new Item("Elixir of the Mongoose", -6, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 38));
		items.add(new Item("Conjured Mana Cake", -8, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", -2, 6));
		items.add(new Item("Aged Brie", -10, 22));
		items.add(new Item("Elixir of the Mongoose", -7, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 41));
		items.add(new Item("Conjured Mana Cake", -9, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", -3, 4));
		items.add(new Item("Aged Brie", -11, 24));
		items.add(new Item("Elixir of the Mongoose", -8, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 2, 44));
		items.add(new Item("Conjured Mana Cake", -10, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", -4, 2));
		items.add(new Item("Aged Brie", -12, 26));
		items.add(new Item("Elixir of the Mongoose", -9, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 47));
		items.add(new Item("Conjured Mana Cake", -11, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", -5, 0));
		items.add(new Item("Aged Brie", -13, 28));
		items.add(new Item("Elixir of the Mongoose", -10, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50));
		items.add(new Item("Conjured Mana Cake", -12, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", -6, 0));
		items.add(new Item("Aged Brie", -14, 30));
		items.add(new Item("Elixir of the Mongoose", -11, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0));
		items.add(new Item("Conjured Mana Cake", -13, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", -7, 0));
		items.add(new Item("Aged Brie", -15, 32));
		items.add(new Item("Elixir of the Mongoose", -12, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", -2, 0));
		items.add(new Item("Conjured Mana Cake", -14, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", -8, 0));
		items.add(new Item("Aged Brie", -16, 34));
		items.add(new Item("Elixir of the Mongoose", -13, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", -3, 0));
		items.add(new Item("Conjured Mana Cake", -15, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", -9, 0));
		items.add(new Item("Aged Brie", -17, 36));
		items.add(new Item("Elixir of the Mongoose", -14, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", -4, 0));
		items.add(new Item("Conjured Mana Cake", -16, 0));
		batchItems.add(items);

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", -10, 0));
		items.add(new Item("Aged Brie", -18, 38));
		items.add(new Item("Elixir of the Mongoose", -15, 0));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", -5, 0));
		items.add(new Item("Conjured Mana Cake", -17, 0));
		batchItems.add(items);
		return batchItems;
	}

}
