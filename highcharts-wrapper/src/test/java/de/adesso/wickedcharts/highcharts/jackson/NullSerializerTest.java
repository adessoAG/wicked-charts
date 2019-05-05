/*
 * Copyright 2012-2019 Wicked Charts (tom.hombergs@gmail.com)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package de.adesso.wickedcharts.highcharts.jackson;

import de.adesso.wickedcharts.highcharts.options.ChartOptions;
import de.adesso.wickedcharts.highcharts.options.Options;
import de.adesso.wickedcharts.highcharts.options.SeriesType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NullSerializerTest {

  public class MyOptions extends Options {

    private static final long serialVersionUID = 1L;

    private String myIgnoredField = null;

    private String myIncludedField = "included";

    public String getMyIgnoredField() {
      return this.myIgnoredField;
    }

    public String getMyIncludedField() {
      return this.myIncludedField;
    }

    public void setMyIgnoredField(final String myIgnoredField) {
      this.myIgnoredField = myIgnoredField;
    }

    public void setMyIncludedField(final String myIncludedField) {
      this.myIncludedField = myIncludedField;
    }

  }

  @Test
  void test() {
    // given
    Options options = new MyOptions();
    ChartOptions chartOptions = new ChartOptions();
    chartOptions.setType(SeriesType.AREA);
    options.setChartOptions(chartOptions);
    JsonRenderer renderer = new JsonRenderer();

    // when
    String json = renderer.toJson(options);

    // then
    assertFalse(json.contains("myIgnoredField"));
    assertTrue(json.contains("myIncludedField"));
  }

}
