package de.adesso.wickedcharts.chartjs.chartoptions;

import lombok.experimental.Accessors;

@Accessors(chain = true)
@lombok.Data
public class Animation {
	private Boolean animateScale;
	private Boolean animateRotate;
	private Integer duration;
	private CallbackFunction onProgress;
	private CallbackFunction onComplete;
}
