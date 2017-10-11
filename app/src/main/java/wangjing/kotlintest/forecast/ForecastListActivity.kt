package wangjing.kotlintest.forecast

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import wangjing.kotlintest.R

/**
 * 四、RecyclerView的使用，及展示列表
 */
class ForecastListActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val forecastList = findViewById(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        forecastList.adapter = ForecastListAdapter(items)

//        val fList:RecyclerView = find(R.id.forecast_list)//Anko写法

        // 九、数据类函数
//        val f1 = Forecast(Date(), 27.5, "Shiny day")
//        val f2 = f1.copy(temperature = 30.0)
//        Log.d("Forecast f2 :",f2.toString())
// Todo 用法
//        val (date, temperature, details) = f1
//        for ((key,value) in map){
//            Log.d("map","key:$key,value:$value")
//        }

        // 十、异步执行发起请求
        async(){   //异步执行发起请求
            val result= ForecastRequest("94043").execute()
            uiThread {  //请求完毕之后线程切换
                Log.e("123456", "City Name :"+result.city.name)
            }
        }
    }
}
