package com.mastertechsoftware.twine.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mastertechsoftware.twine.api.TwineAPI
import com.mastertechsoftware.twine.models.Deposit
import kotlinx.coroutines.launch

/**
 *
 */
typealias DepositResult = (List<Deposit>?) -> Unit

class DepositsModel: ViewModel() {
    fun getDeposits(resultListener: DepositResult) {
        viewModelScope.launch {
            resultListener.invoke(TwineAPI.getDeposits())
        }
    }
}