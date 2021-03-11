package org.miracum.etl.fhirgateway.processor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.miracum.etl.fhirgateway.processors.BaseKafkaProcessor;
import org.miracum.etl.fhirgateway.processors.KafkaConsumer;
import org.miracum.etl.fhirgateway.processors.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

public class KafkaProcessorTests {

  @Nested
  @SpringBootTest
  @ActiveProfiles("test")
  @TestPropertySource(
      properties = {
        "services.kafka.enabled=true",
        "spring.cloud.stream.bindings.process-out-0.destination=fhir.post-gateway"
      })
  public class KafkaConsumerProducerTests {

    @Autowired private BaseKafkaProcessor processor;

    @Test
    public void processorShouldBeEnabled() {
      assertThat(processor).isInstanceOf(KafkaProcessor.class);
    }
  }

  @Nested
  @SpringBootTest
  @ActiveProfiles("test")
  @TestPropertySource(
      properties = {
        "services.kafka.enabled=true",
        "spring.cloud.stream.bindings.process-out-0.destination="
      })
  public class KafkaConsumerTests {

    @Autowired private BaseKafkaProcessor consumer;

    @Test
    public void consumerShouldBeEnabled() {
      assertThat(consumer).isInstanceOf(KafkaConsumer.class);
    }
  }
}
