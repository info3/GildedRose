package gildedrose.goblinignored;


public class ItemFactory {
	public static Item createItem(String name, int sellIn, int quality){
		if (name.contains("Aged Brie"))
			return new AgedBrie(name,sellIn,quality);
		return new Item(name,sellIn,quality);
	}

}
