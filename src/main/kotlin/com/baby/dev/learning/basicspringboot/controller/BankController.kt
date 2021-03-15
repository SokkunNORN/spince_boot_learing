package com.baby.dev.learning.basicspringboot.controller

import com.baby.dev.learning.basicspringboot.model.Bank
import com.baby.dev.learning.basicspringboot.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.IllegalArgumentException

@RestController
@RequestMapping(path = ["/api/v1"])
class BankController(
    private val service: BankService
) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException) : ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException) : ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping("/banks")
    fun getBanks() : ResponseEntity<List<Bank>> =
        ResponseEntity.ok(service.getBanks())

    @GetMapping("/bank/{accountNumber}")
    fun selectBank( @PathVariable accountNumber: String) : ResponseEntity<Bank> =
        ResponseEntity.ok(service.selectBank(accountNumber))

    @PostMapping("/bank")
    @ResponseStatus(HttpStatus.CREATED)
    fun createBank(@RequestBody bank: Bank) : ResponseEntity<Bank> =
        ResponseEntity.ok(service.createBank(bank))

    @PutMapping("/bank/{accountNumber}")
    fun updateBank(
        @RequestBody bank: Bank,
        @PathVariable accountNumber: String
    ) : ResponseEntity<Bank> =
        ResponseEntity.ok(service.updateBank(accountNumber, bank))

    @DeleteMapping("/bank/{accountNumber}")
    fun removeBank( @PathVariable accountNumber: String) : String =
        service.removeBank(accountNumber)
}