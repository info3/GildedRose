package gildedrose.goblinignored;

public class AgedBrie extends Item {
	public AgedBrie(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public void updateQuality() {
		sellIn--;
		
		quality++;
	}
}
