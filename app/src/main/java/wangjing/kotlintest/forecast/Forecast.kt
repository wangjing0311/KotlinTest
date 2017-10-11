package wangjing.kotlintest.forecast

import java.util.*

/**
 * Created by wangjing on 2017/10/11.
 * Forecast的Bean
 */
data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float,
                    val humidity: Int, val weather: List<Weather>,
                    val speed: Float, val deg: Int, val clouds: Int,
                    val rain: Float)