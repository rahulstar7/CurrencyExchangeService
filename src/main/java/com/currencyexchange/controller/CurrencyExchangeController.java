package com.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currencyexchange.beans.CurrencyExchange;
import com.currencyexchange.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeRepository repo;

	@Autowired
	Environment env;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveCurrencyExchange(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyexchange = repo.findByFromAndTo(from, to);

		String port = env.getProperty("local.server.port");

		currencyexchange.setEnv(port);

		return currencyexchange;

	}

}
