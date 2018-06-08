package de.adesso.wickedcharts.chartjs.jackson.serializer;

import de.adesso.wickedcharts.chartjs.chartoptions.Dataset;
import de.adesso.wickedcharts.chartjs.jackson.JsonRenderer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DatasetSerializerTest {
	private JsonRenderer renderer;
	private Dataset testData;
	
	@Before
	public void setUp() throws Exception{
		renderer = new JsonRenderer();
	}	
	
	@Test
	public void testYaxisID() {
		testData = new Dataset();
		testData.setYAxisID("axis-1");
		String json = renderer.toJson(testData);
		assertTrue(json.contains("yAxisID"));
	}

	@Test
	public void testXaxisID() {
		testData = new Dataset();
		testData.setXAxisID("axis-1");
		String json = renderer.toJson(testData);
		assertTrue(json.contains("xAxisID"));
	}
}
