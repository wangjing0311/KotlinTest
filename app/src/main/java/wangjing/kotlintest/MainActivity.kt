package wangjing.kotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
//一、layout的引入
import kotlinx.android.synthetic.main.activity_main.*

// 二、类的写法
// 1.类的写法class
// 2.如果需要继承他，关键字写上open/abstract
// 3.继承自某个类用：
// 4.构造方法class Person(name: String, surname: String) { init{ ... } }，没有任何内容初始化时不需要写init及{}
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = "Hello Kotlin!"
        //不用findViewById直接可以使用设置值
        message.text = "x+y=" + add(2, 3)
        //三、2.函数参数有默认值时可传入或者不传入参数
        toast("Hello")
        toast("Hello 你好", Toast.LENGTH_LONG)
        niceToast("Hello", "MyTag", Toast.LENGTH_SHORT)

        message.setOnClickListener(View.OnClickListener{
            startActivity(intent)
        })
    }

    // 三、方法函数的写法
    //1.传参，返回值
//    fun add(x: Int, y: Int) : Int {
//        return x + y
//    }
    fun add(x: Int, y: Int): Int = x + y

    // 2.参数设置默认值，可传入或者不传入有默认的参数
    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

    fun niceToast(message: String,
                  tag: String,
                  length: Int = Toast.LENGTH_SHORT) {
        //String模板表达式："[$tag] $message"，$变量名可直接取值，如果复杂点可加入{}，"Your name is ${user.name}"
        Toast.makeText(this, "[$tag] $message", length).show()
    }



}
