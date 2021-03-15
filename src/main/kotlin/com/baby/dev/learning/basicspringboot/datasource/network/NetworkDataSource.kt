package com.baby.dev.learning.basicspringboot.datasource.network

import com.baby.dev.learning.basicspringboot.datasource.BankDataSource
import com.baby.dev.learning.basicspringboot.datasource.network.dto.BankList
import com.baby.dev.learning.basicspringboot.model.Bank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class NetworkDataSource(
    @Autowired private val restTemplate: RestTemplate
) : BankDataSource {
    override fun retrieveBanks(): List<Bank> {
        val response: ResponseEntity<BankList> =
            restTemplate.getForEntity<BankList>("http://54.193.31.159/banks")

        return response.body?.results
            ?: throw IOException("Could not fetch banks from network...")
    }

    override fun selectBank(accountNumber: String): Bank {
        TODO("Not yet implemented")
    }

    override fun createBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun updateBank(accountNumber: String, bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun removeBank(accountNumber: String): String {
        TODO("Not yet implemented")
    }
}