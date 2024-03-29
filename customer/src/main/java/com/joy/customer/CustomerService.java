package com.joy.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final RestTemplate restTemplate;

  public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
    Customer customer = Customer.builder()
        .firstName(customerRegistrationRequest.firstName())
        .lastName(customerRegistrationRequest.lastName())
        .email(customerRegistrationRequest.email())
        .build();
    // TODO check if email valid
    // TODO check if email not taken
    customerRepository.saveAndFlush(customer);
    // TODO check if fraudster
    FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
        "http://FRAUD/api/v1/fraud-check/{customerId}",
        FraudCheckResponse.class,
        customer.getId());

    if (fraudCheckResponse.isFraudster()) {
      throw new IllegalStateException("fraudster");
    }

    // TODO send notification

  }
}
