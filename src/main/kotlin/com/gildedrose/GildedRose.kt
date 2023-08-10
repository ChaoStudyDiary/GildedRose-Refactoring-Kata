package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            doUpdateItemQuality(items[i])
        }
    }

    private fun doUpdateItemQuality(item: Item) {
        when (item.name) {
            "Aged Brie" -> {
                doUpdateAgedBrie(item)
            }

            "Backstage passes to a TAFKAL80ETC concert" -> {
                doUpdateBackstage(item)
            }

            "Sulfuras, Hand of Ragnaros" -> {
                doUpdateSulfuras(item)
            }

            else -> {
                doUpdateDefault(item)
            }
        }
    }


}

private fun doUpdateSulfuras(item: Item) {

}

private fun doUpdateDefault(item: Item) {
    if (item.quality > 0) {
        item.quality = item.quality - 1
    }

    item.sellIn = item.sellIn - 1

    if (item.sellIn < 0) {
        if (item.quality > 0) {
            item.quality = item.quality - 1
        }
    }
}

private fun doUpdateBackstage(item: Item) {
    if (item.quality < 50) {
        item.quality = item.quality + 1

        if (item.sellIn < 11) {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }

        if (item.sellIn < 6) {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }
    }

    item.sellIn = item.sellIn - 1

    if (item.sellIn < 0) {
        item.quality = item.quality - item.quality
    }
}

private fun doUpdateAgedBrie(item: Item) {
    if (item.quality < 50) {
        item.quality = item.quality + 1

    }
    item.sellIn = item.sellIn - 1

    if (item.sellIn < 0) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
    }
}



