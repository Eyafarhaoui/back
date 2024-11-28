package com.example.back.service;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${stripe.secret.key}")
    private String secretKey;

      @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }
    

    public Map<String, String> createPaymentIntent(long amount) throws Exception {
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(amount) // amount in cents
                .setCurrency("eur") // use the desired currency
                .build();
        PaymentIntent intent = PaymentIntent.create(params);

        Map<String, String> response = new HashMap<>();
        response.put("clientSecret", intent.getClientSecret());
        return response;
    }
}
