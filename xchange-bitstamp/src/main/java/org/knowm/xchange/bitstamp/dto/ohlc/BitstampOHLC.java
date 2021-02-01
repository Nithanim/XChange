package org.knowm.xchange.bitstamp.dto.ohlc;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Objects;

public class BitstampOHLC {
  private final long timestamp;
  private final BigDecimal high;
  private final BigDecimal volume;
  private final BigDecimal low;
  private final BigDecimal close;
  private final BigDecimal open;

  public BitstampOHLC(
      @JsonProperty("timestamp") long timestamp,
      @JsonProperty("high") BigDecimal high,
      @JsonProperty("volume") BigDecimal volume,
      @JsonProperty("low") BigDecimal low,
      @JsonProperty("close") BigDecimal close,
      @JsonProperty("open") BigDecimal open) {
    this.high = high;
    this.timestamp = timestamp;
    this.volume = volume;
    this.low = low;
    this.close = close;
    this.open = open;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public BigDecimal getHigh() {
    return high;
  }

  public BigDecimal getVolume() {
    return volume;
  }

  public BigDecimal getLow() {
    return low;
  }

  public BigDecimal getClose() {
    return close;
  }

  public BigDecimal getOpen() {
    return open;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BitstampOHLC that = (BitstampOHLC) o;
    return timestamp == that.timestamp
        && Objects.equals(high, that.high)
        && Objects.equals(volume, that.volume)
        && Objects.equals(low, that.low)
        && Objects.equals(close, that.close)
        && Objects.equals(open, that.open);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, high, volume, low, close, open);
  }

  @Override
  public String toString() {
    return "BitstampOhlcCandle{"
        + "timestamp="
        + timestamp
        + ", high="
        + high
        + ", volume="
        + volume
        + ", low="
        + low
        + ", close="
        + close
        + ", open="
        + open
        + '}';
  }
}
