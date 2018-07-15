package de.adesso.wickedcharts.chartjs.jackson.serializer;

import de.adesso.wickedcharts.chartjs.ChartConfiguration;
import de.adesso.wickedcharts.chartjs.jackson.JsonRenderer;
import de.adesso.wickedcharts.chartjs.json.JsonValueEnum;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JsonValueEnumSerializerTest {
	
	public enum TestEnum implements JsonValueEnum {
		LOWERCASE("lowercase"),
		MIXED("miXeD"),
		UPPERCASE("UPPERCASE");

		private String jsonValue;
		
		private TestEnum(String jsonValue) {
			this.jsonValue = jsonValue;
		}
		
		@Override
		public String getJsonValue() {
			return jsonValue;
		}
	}
	
	public class TestChartConfiguration extends ChartConfiguration {
		
		private TestEnum testEnum;

		public TestEnum getTestEnum() {
			return testEnum;
		}

		public void setTestEnum(TestEnum testEnum) {
			this.testEnum = testEnum;
		}
	}
	
	private TestChartConfiguration config;
	private JsonRenderer renderer;
	
	@Before
	public void setUp() throws Exception {
		config = new TestChartConfiguration();
		renderer = new JsonRenderer();
	}

	
	
	@Test
	public void testLowercase() {
		config.setTestEnum(TestEnum.LOWERCASE);
		
		String json = renderer.toJson(config);
		assertTrue(json.contains("lowercase"));
	}
	
	
	@Test
	public void testMixed() {
		config.setTestEnum(TestEnum.MIXED);
		
		String json = renderer.toJson(config);
		assertTrue(json.contains("miXeD"));
	}
	
	
	@Test
	public void testUppercase() {
		config.setTestEnum(TestEnum.UPPERCASE);
		
		String json = renderer.toJson(config);
		assertTrue(json.contains("UPPERCASE"));
	}
	

}
