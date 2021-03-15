package com.baby.dev.learning.basicspringboot.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Bank(
    @JsonProperty("account_number")
    val accountNumber: String, // primary constructor

    @JsonProperty("trust")
    val trust: Double,

    @JsonProperty("default_transaction_fee")
    val transactionFee: Int
)