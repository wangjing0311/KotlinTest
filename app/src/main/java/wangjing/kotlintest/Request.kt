package wangjing.kotlintest

import android.util.Log
import java.net.URL

/**
 * Created by wangjing on 2017/10/11.
 * 七、执行请求返回结果
 */
public class Request(val url:String){
    public fun run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName,forecastJsonStr)
    }
}