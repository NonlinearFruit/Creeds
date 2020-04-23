package com.nonlinearfruit.creeds.main

import com.nonlinearfruit.creeds.confession.ConfessionActivity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MainDatabaseTests {
    @Test
    fun `Database has approximately the right number of creeds`() {
        val db = MainDatabase()

        val items = db.mainMenuItems

        assertTrue(items.size >= 29)
    }

    @Test
    fun `Database has Westminster Confession`() {
        val db = MainDatabase()

        val wcf = db.mainMenuItems.single { it.CreedTitle == "Westminster Confession of Faith" }

        assertEquals(1647, wcf.CreedYear);
        assertEquals(ConfessionActivity::class.java, wcf.IntentClass);
        assertEquals(2131558416, wcf.JsonFileId);
    }
}