package io.humourmind.flightwatch.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightDelay {

	private String flightNo;
	private LocalDateTime sta;
	private LocalDateTime ata;
	private long delayInterval;
}
