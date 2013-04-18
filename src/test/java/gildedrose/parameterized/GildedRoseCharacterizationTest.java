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
 * This is a parameterized Version of the Gilded Rose Characterization Test. It
 * allows for easier switching between the different implementations.
 * http://junit.sourceforge.net/javadoc/org/junit/runners/Parameterized.html
 * 
 * @author kleinen
 * 
 */
@RunWith(Parameterized.class)
public class GildedRoseCharacterizationTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] 
				{ {"At the end of each day our system lowers both values for every item","any name",5,49,4,48},
				
				{"Once the sell by date has passed, Quality degrades twice as fast","any name",0,40,-1,38},
				
				{"The Quality of an item is never negative","anything",5,0,4,0},
				{"qualityOfItemShouldNeverBeNegativeEvenAfterSellin","",-5,0,-6,0},
				{"\"Aged Brie\" actually increases in Quality the older it gets","Aged Brie",2,10,1,11},		
				{"\"Aged Brie\" actually increases in Quality the older it gets + The Quality of an item is never more than 50","Aged Brie",2,50,1,50 },
				
				{"\"Aged Brie\" actually increases in Quality twice as fast after the sellin date","Aged Brie",-2,10,-3,12},		
				{"\"Aged Brie\" actually increases in Qualitytwice as fast after the sellin date + The Quality of an item is never more than 50","Aged Brie",-2,50,-3,50 },
		
				
				
				{"- The Quality of an item is never more than 50 TBD: This does not work in the original version!","",5,55,4,54},
				{"- \"Sulfuras\", I being a legendary item, never has to be sold or decreases in Quality","Sulfuras, Hand of Ragnaros",0,80,0,80},
				{"- \"Sulfuras\", sellIn stays even if negative","Sulfuras, Hand of Ragnaros",-5,80,-5,80},
				
				{"\"Backstage passes\", like aged brie, increases in Quality as it's SellIn approaches;","Backstage passes to a TAFKAL80ETC concert",15,20,14,21},
				{"\"Backstage passes\", like aged brie, increases in Quality as it's SellIn approaches; also limited to 50","Backstage passes to a TAFKAL80ETC concert",15,50,14,50},
		
				{"\"Backstage passes\", Quality increases by 2 when there are 10 days or less","Backstage passes to a TAFKAL80ETC concert",10,20,9,22},
				{"\"Backstage passes\", Quality increases by 2 when there are 10 days or less - limit 50","Backstage passes to a TAFKAL80ETC concert",10,50,9,50},
			
				{"\"Backstage passes\", Quality increases by 2 when there are 10 days or less - 9 days","Backstage passes to a TAFKAL80ETC concert",9,20,8,22},
				{"\"Backstage passes\", Quality increases by 2 when there are 10 days or less - limit 50 - 9 days","Backstage passes to a TAFKAL80ETC concert",9,50,8,50},
			
				{"\"Backstage passes\", Quality increases by 2 when there are 10 days or less - 11 days","Backstage passes to a TAFKAL80ETC concert",11,20,10,21},
				{"\"Backstage passes\", Quality increases by 2 when there are 10 days or less - limit 50 - 11 days","Backstage passes to a TAFKAL80ETC concert",11,50,10,50},

				{"\"Backstage passes\", Quality increases by 3 when there are 5 days","Backstage passes to a TAFKAL80ETC concert",5,20,4,23},
				{"\"Backstage passes\", Quality increases by 3 when there are 5 days or less - limit 50","Backstage passes to a TAFKAL80ETC concert",5,50,4,50},

				{"\"Backstage passes\", Quality increases by 3 when there are 5 days - grenzwert 6 ","Backstage passes to a TAFKAL80ETC concert",6,20,5,22},
				
				{"\"Backstage passes\", Quality increases by 3 when there are 5 days - grenzwert 4","Backstage passes to a TAFKAL80ETC concert",4,20,3,23},
				
				{"\"Backstage passes\", Quality drops to 0 after the concert","Backstage passes to a TAFKAL80ETC concert",0,20,-1,0}
				
				} );
	}


	String message;
	String itemName;
	int sellIn;
	int quality;
	int expectedSellIn;
	int expectedQuality;

	public GildedRoseCharacterizationTest(String message, String itemName, int sellIn, int quality,
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
