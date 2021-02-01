package org.knowm.xchange.bitstamp.dto.ohlc;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitstampOHLCResponse {
  private final BitstampOHLCData data;

  public BitstampOHLCResponse(@JsonProperty("data") BitstampOHLCData data) {
    this.data = data;
  }

  public BitstampOHLCData getData() {
    return data;
  }

  @Override
  public String toString() {
    return "BitstampOhlcResponse{" + "data=" + data + '}';
  }
}
