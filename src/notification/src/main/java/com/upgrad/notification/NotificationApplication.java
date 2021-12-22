package com.upgrad.notification;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

@SpringBootApplication
public class NotificationApplication {

	public static void main(String[] args) {

		SpringApplication.run(NotificationApplication.class, args);

		Properties properties = new Properties();
		properties.put("bootstrap.servers", "ec2-3-220-49-19.compute-1.amazonaws.com:9092");
		properties.put("group.id", "test");
		properties.put("enable.auto.commit", "true");
		properties.put("auto.commit.interval.ms", "1000");
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


		KafkaConsumer<String, String> consumer=  new KafkaConsumer<String, String>(properties);
		consumer.subscribe(Arrays.asList("message"));

		Set<String> subscribedTopics = consumer.subscription();
		subscribedTopics.stream().forEach(System.out::println);

		try{
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
				for(ConsumerRecord<String, String> record: records)
					System.out.println(record.value());
			}
		} finally {
			consumer.close();
		}

	}

}
