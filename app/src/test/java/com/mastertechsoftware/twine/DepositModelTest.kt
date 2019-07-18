package com.mastertechsoftware.twine

import com.mastertechsoftware.twine.ui.DepositsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Tests for the deposit model
 *
 */
class DepositModelTest {
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    val depositsModel = DepositsModel()
    @Test
    fun modelReturnsCorrectList() {
        depositsModel.getDeposits {
            assert(it != null)
            assertEquals(6, it?.size)
        }
    }
}
