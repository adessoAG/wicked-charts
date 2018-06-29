package de.adesso.wickedcharts.chartjs.jackson.serializer;

import de.adesso.wickedcharts.chartjs.chartoptions.valueType.ConstValue;
import de.adesso.wickedcharts.chartjs.jackson.JsonRenderer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstValueSerializerTest {

	
	private JsonRenderer renderer;
	private ConstValue testVal;
	
	@Before
	public void setUp() throws Exception{
		renderer = new JsonRenderer();
	}
	
	@Test
	public void testConstValue() {
		testVal = new ConstValue("100");
		String json = renderer.toJson(testVal);
		assertEquals("'100'", json);
	}
	
	@Test
	public void testEmptyValue() {
		testVal = new ConstValue("");
		String json = renderer.toJson(testVal);
		assertEquals("''",json);
	}
}
