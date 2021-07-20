package com.damon.spring.drools;

import static org.assertj.core.api.Assertions.assertThat;

import com.damon.spring.drools.model.TaxiFareResponse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;


@DisplayName("Integration Tests")
@Tag("integration")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DecisionApplicationTest
{

    @Autowired
    private WebTestClient webClient;

    @Test
    public void whenNightSurchargeFalseAndDistanceLessThan10_thenFixFareWithoutNightSurcharge()
    {
        // WHEN
        final EntityExchangeResult<TaxiFareResponse> result =
                webClient.get().uri("/v1/taxi/fare")
                    .exchange()
                    .expectStatus().isEqualTo(HttpStatus.OK)
                    .expectBody(TaxiFareResponse.class)
                    .returnResult();

        // THEN
        assertThat(result).isNotNull();
        assertThat(result.getResponseBody().getFinalFare()).isEqualTo(575L);
        assertThat(result.getResponseBody().getMiles()).isEqualTo(190L);
    }
}
