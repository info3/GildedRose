package gildedrose.parameterized;

import static org.junit.Assert.assertEquals;
import gildedrose.original.GildedRose;
import gildedrose.original.Item;
import gildedrose.original.ItemFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
// original version

/**
 * Tests for the new Conjured Items:
 * - "Conjured" items degrade in Quality twice as fast as normal items
 * 
 * @author kleinen
 * 
 */

@RunWith(Parameterized.class)
public class ConjuredTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] 
				{ {"\"Conjured\" items have a lowest quality of 0","Conjured mana cake",5,0,4,0},			
				{"\"Conjured\" items degrade in Quality twice as fast as normal items","Conjured mana cake",5,49,4,47},			
				{"\"Conjured\" items degrade in Quality twice as fast as normal items - after sell in","Conjured mana cake",-5,49,-6,45}				
				} );
	}



	

	String message;
	String itemName;
	int sellIn;
	int quality;
	int expectedSellIn;
	int expectedQuality;

	public ConjuredTest(String message, String itemName, int sellIn, int quality,
			int expectedSellIn, int expectedQuality) {
		this.message = message;
		this.itemName = itemName;
		this.sellIn = sellIn;
		this.quality = quality;
		this.expectedSellIn = expectedSellIn;
		this.expectedQuality = expectedQuality;
	}

	@Test 
	public void test(){
		Item item = ItemFactory.createItem(itemName, sellIn, quality);
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		GildedRose.setItems(items);
		GildedRose.updateQuality();
		assertEquals(message+ " (SellIn)",expectedSellIn,item.getSellIn());
		assertEquals(message+ " (Quality)",expectedQuality,item.getQuality());	
	}
	


}
