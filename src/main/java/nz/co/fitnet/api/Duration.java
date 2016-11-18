package nz.co.fitnet.api;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = DurationDeserializer.class)
@JsonSerialize(using = DurationSerializer.class)
public enum Duration {
	EndDate(0), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Ten(10), Fourteen(14), TwentyOne(21), TwentyEight(
			28), Thirty(30), FortyTwo(42), FiftySix(56), Ninety(90), UntilWithdrawn(-1);

	private final int num;

	private Duration(final int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public static Duration byNum(final int num) {
		for (Duration duration : Duration.values()) {
			if (duration.getNum() == num) {
				return duration;
			}
		}
		return null;
	}
}
