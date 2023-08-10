package com.gildedrose

import org.approvaltests.Approvals
import org.approvaltests.combinations.CombinationApprovals
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApprovalTest {

    @Test
    fun testApproval() {
        val items = listOf(Item("foo", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        Approvals.verifyAll("", app.items)
    }

    @Test
    fun updateQuality() {
        CombinationApprovals.verifyAllCombinations(
            this::callUpdateQuality,
            arrayOf("a common item", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert","Aged Brie"),
            arrayOf(0, -1, 20),
            arrayOf(0, 1, 80, 49, 50)
        )
    }


    private fun callUpdateQuality(name: String, sellIn: Int, quality: Int): String {
        val items = arrayListOf(Item(name, sellIn, quality))
        val gildedRose = GildedRose(items)
        gildedRose.updateQuality()
        return gildedRose.items[0].toString()
    }
}