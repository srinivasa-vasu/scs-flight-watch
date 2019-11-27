package io.humourmind.flightwatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import io.humourmind.flightwatch.domain.FlightDelay;

@SpringBootApplication
@EnableBinding(Sink.class)
public class FlightWatchApplication {

	private static final long DELAY_MINUTES = 10;

	private static final Logger logger = LoggerFactory
			.getLogger(FlightWatchApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FlightWatchApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void notification(FlightDelay delay) {
		if (delay.getDelayInterval() >= DELAY_MINUTES) {
			logger.info(delay.toString());
		}
	}

}
