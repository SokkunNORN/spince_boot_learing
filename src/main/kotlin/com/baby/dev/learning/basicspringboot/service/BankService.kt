package com.baby.dev.learning.basicspringboot.service

import com.baby.dev.learning.basicspringboot.datasource.BankDataSource
import com.baby.dev.learning.basicspringboot.model.Bank
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class BankService(
    @Qualifier("network") private val dataSource: BankDataSource
) {

    fun getBanks() : List<Bank> = dataSource.retrieveBanks()

    fun selectBank(accountNumber: String) : Bank = dataSource.selectBank(accountNumber)

    fun createBank(bank: Bank) : Bank = dataSource.createBank(bank)

    fun updateBank(accountNumber: String, bank: Bank): Bank = dataSource.updateBank(accountNumber, bank)

    fun removeBank(accountNumber: String) : String = dataSource.removeBank(accountNumber)
}