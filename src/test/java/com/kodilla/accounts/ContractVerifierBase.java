package com.kodilla.accounts;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.mockito.Mockito.when;

@Ignore
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ContractVerifierBase {

	@Autowired
	private WebApplicationContext context;

	@MockBean
	private AccountsRepository accountsRepository;

	@BeforeEach
	public void setUp() {
		RestAssuredMockMvc.webAppContextSetup(context);
		when(accountsRepository.findByCustomerId(1234L)).thenReturn(
				Collections.singletonList(
						Account.builder()
						.id(95213L)
						.nrb("08897810189710581776778244")
						.currency("PLN")
						.customerId(1234L)
						.build()
				)
		);
	}
}
