package org.knowm.xchange.bitstamp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.knowm.xchange.bitstamp.BitstampV2;
import org.knowm.xchange.bitstamp.dto.BitstampException;
import org.knowm.xchange.bitstamp.dto.marketdata.BitstampOrderBook;
import org.knowm.xchange.bitstamp.dto.marketdata.BitstampPairInfo;
import org.knowm.xchange.bitstamp.dto.marketdata.BitstampTicker;
import org.knowm.xchange.bitstamp.dto.marketdata.BitstampTransaction;
import org.knowm.xchange.bitstamp.dto.ohlc.BitstampOHLC;
import org.knowm.xchange.bitstamp.dto.ohlc.BitstampOHLCResponse;
import org.knowm.xchange.currency.CurrencyPair;

public class BitstampOHLCTest {
  @Test
  public void testUnmarshal() throws IOException {
    BitstampV2 dummy = new DummyClient();
    BitstampMarketDataServiceRaw service = new BitstampMarketDataServiceRaw(null, dummy);
    List<BitstampOHLC> ohlcs = service.getBitstampOHLC(CurrencyPair.BTC_EUR, null, null, 5, 60);

    assertThat(ohlcs).hasSize(5);
    BitstampOHLC ohlc = ohlcs.get(0);
    assertThat(ohlc.getTimestamp()).isEqualTo(1612212120);
    assertThat(ohlc.getOpen()).isEqualTo(new BigDecimal("28038.24"));
    assertThat(ohlc.getHigh()).isEqualTo(new BigDecimal("28054.42"));
    assertThat(ohlc.getLow()).isEqualTo(new BigDecimal("28022.21"));
    assertThat(ohlc.getClose()).isEqualTo(new BigDecimal("28054.42"));
    assertThat(ohlc.getVolume()).isEqualTo("2.31692622");
  }

  private static class DummyClient implements BitstampV2 {
    @Override
    public BitstampOrderBook getOrderBook(Pair pair) throws IOException, BitstampException {
      throw new UnsupportedOperationException();
    }

    @Override
    public BitstampTicker getTicker(Pair pair) throws IOException, BitstampException {
      throw new UnsupportedOperationException();
    }

    @Override
    public BitstampTicker getTickerHour(Pair pair) throws IOException, BitstampException {
      throw new UnsupportedOperationException();
    }

    @Override
    public BitstampTransaction[] getTransactions(
        Pair pair, BitstampMarketDataServiceRaw.BitstampTime time)
        throws IOException, BitstampException {
      throw new UnsupportedOperationException();
    }

    @Override
    public BitstampPairInfo[] getTradingPairsInfo() throws IOException, BitstampException {
      throw new UnsupportedOperationException();
    }

    @Override
    public BitstampOHLCResponse getOhlc(Pair pair, Long start, Long end, int limit, int step)
        throws IOException, BitstampException {
      InputStream is = BitstampOHLCTest.class.getResourceAsStream("/bitstamp_ohlc.json");
      return new ObjectMapper().readValue(is, BitstampOHLCResponse.class);
    }
  }
}
