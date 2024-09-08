package br.com.locarena.api.domain.pagamento;

import com.mercadopago.*;

import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.common.PhoneRequest;
import com.mercadopago.client.payment.*;
import com.mercadopago.core.MPRequestOptions;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pagamento {

    public static void main(String[] args) throws MPException, MPApiException {
        MercadoPagoConfig.setAccessToken("TEST-5310296812629717-083120-0d2d1fba1b0ab3f53a18178e935a5662-214038590");

        Map<String, String> customHeaders = new HashMap<>();
        customHeaders.put("x-idempotency-key", "TEST;jabfjasbfasbfkjbsakjdfbE");

        MPRequestOptions requestOptions = MPRequestOptions.builder()
                .customHeaders(customHeaders)
                .build();

        PaymentClient client = new PaymentClient();

        List<PaymentItemRequest> items = new ArrayList<>();

        PaymentItemRequest item =
                PaymentItemRequest.builder()
                        .title("Camisa")
                        .quantity(2)
                        .unitPrice(new BigDecimal("58.8"))
                        .build();

        items.add(item);

        PaymentCreateRequest createRequest =
                PaymentCreateRequest.builder()
                        .installments(1)
                        .payer(PaymentPayerRequest.builder()
                                .entityType("individual")
                                .type("customer")
                                .email("test_user_123@testuser.com")
                                .identification(IdentificationRequest.builder()
                                        .type("CPF")
                                        .number("01234567890")
                                        .build())
                                .build())
                        .token("ff8080814c11e237014c1ff593b57b4d")
                        .transactionAmount(new BigDecimal("58.8"))
                        .build();
        client.create(createRequest, requestOptions);
        }
}