package wangjing.kotlintest

//一、layout的引入
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

// 二、类的写法
// 1.类的写法class
// 2.如果需要继承他，关键字写上open/abstract
// 3.继承自某个类用：
// 4.构造方法class Person(name: String, surname: String) { init{ ... } }，没有任何内容初始化时不需要写init及{}
class MainActivity : AppCompatActivity() {

    // 五、基本类型的变量的定义初始化
    // 1.var可变，val不可变
    val i = 12 // An Int
    val iHex = 0x0f // 一个十六进制的Int类型
    val l = 3L // A Long
    val d = 3.5 // A Double
    val f = 3.5F // A Float

    private var thread: Thread? = null
    private var handler: Handler = object : Handler() {     //此处的object 要加，否则无法重写 handlerMessage
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            //八、多线程：主线程
            if (msg?.what == 0) {
                Toast.makeText(applicationContext, "主线程消息", Toast.LENGTH_LONG).show()
            }

        }
    }

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

        message.setOnClickListener(View.OnClickListener {
            startActivity(intent) //TODO 怎么跳转？
        })

        // 五、基本变量
        // 迭代String
        val ss = "Example"
        val c = ss[2] // 这是一个字符'a'
        val s2 = "Example"
        for (c in s2) {
            print(c)
        }

        // 六、类属性
        val person = Person()
        person.name = "Wangjing"
        val name = person.name
        message.text = name

        // 七、执行网络请求要在子线程里边调用，不能在UI线程
        myTherad()
        thread?.start()
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

    // 八、多线程用法，子线程
    private fun myTherad() {
        thread = Thread(Runnable {
            kotlin.run {
                val request = Request("https://www.baidu.com/")
                request?.run()
                var message = Message()
                message.what = 0
                handler.sendMessage(message)
            }
        })
    }

}
