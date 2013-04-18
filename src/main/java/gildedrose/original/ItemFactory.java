package gildedrose.original;

public class ItemFactory {
	public static Item createItem(String name, int sellIn, int quality){
		return new Item(name,sellIn,quality);
	}

}
