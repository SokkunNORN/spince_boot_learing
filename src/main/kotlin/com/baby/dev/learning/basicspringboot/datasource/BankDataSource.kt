package com.baby.dev.learning.basicspringboot.datasource

import com.baby.dev.learning.basicspringboot.model.Bank

interface BankDataSource {

    fun retrieveBanks() : List<Bank>

    fun selectBank(accountNumber: String) : Bank

    fun createBank(bank: Bank) : Bank

    fun updateBank(accountNumber: String, bank: Bank): Bank

    fun removeBank(accountNumber: String) : String
}