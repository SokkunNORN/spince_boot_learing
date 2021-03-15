package com.baby.dev.learning.basicspringboot.datasource.mock

import com.baby.dev.learning.basicspringboot.datasource.BankDataSource
import com.baby.dev.learning.basicspringboot.model.Bank
import org.springframework.stereotype.Repository
import kotlin.IllegalArgumentException

@Repository
class MockBankDataSource : BankDataSource {

    val banks = mutableListOf(
        Bank("1234", 3.14, 17),
        Bank("1010", 17.0, 0),
        Bank("5678", 0.0, 100)
    )

    override fun retrieveBanks() : List<Bank> = banks

    override fun selectBank(accountNumber: String) : Bank =
        banks.firstOrNull() { it.accountNumber === accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with the id $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber === bank.accountNumber }) {
            throw IllegalArgumentException("Bank id [${bank.accountNumber}] already exists.")
        }

        banks.add(bank)

        return bank
    }

    override fun updateBank(accountNumber: String, bank: Bank): Bank {
        val currentBank = banks.firstOrNull { it.accountNumber === accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with the id $accountNumber")

        banks.remove(currentBank)
        banks.add(bank)

        return bank
    }

    override fun removeBank(accountNumber: String): String {
        val currentBank = banks.firstOrNull { it.accountNumber === accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with the id $accountNumber")

        banks.remove(currentBank)

        return "Bank with id [$accountNumber] is removed successfully"
    }

}