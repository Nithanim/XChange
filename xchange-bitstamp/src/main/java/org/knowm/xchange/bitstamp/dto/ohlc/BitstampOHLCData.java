package org.knowm.xchange.bitstamp.dto.ohlc;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BitstampOHLCData {
  private final String pair;
  private final List<BitstampOHLC> ohlc;

  public BitstampOHLCData(
      @JsonProperty("pair") String pair, @JsonProperty("ohlc") List<BitstampOHLC> ohlc) {
    this.pair = pair;
    this.ohlc = ohlc;
  }

  public String getPair() {
    return pair;
  }

  public List<BitstampOHLC> getOhlc() {
    return ohlc;
  }

  @Override
  public String toString() {
    return "BitstampOhlcData{" + "pair='" + pair + '\'' + ", ohlc=" + ohlc + '}';
  }
}
