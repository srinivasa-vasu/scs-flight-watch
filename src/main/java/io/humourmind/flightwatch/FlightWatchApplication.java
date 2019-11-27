package io.humourmind.flightwatch;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

import io.humourmind.flightwatch.domain.FlightDelay;
import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableBinding(Sink.class)
public class FlightWatchApplication {

	private static final long DELAY_MINUTES = 10;

	private static final Logger logger = LoggerFactory
			.getLogger(FlightWatchApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FlightWatchApplication.class, args);
	}

	@Bean
	public Consumer<Flux<FlightDelay>> delayNotification() {
		return element -> element.subscribe(delay -> {
			if (delay.getDelayInterval() >= DELAY_MINUTES) {
				logger.info(delay.toString());
			}
		});
	}

}
