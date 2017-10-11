package wangjing.kotlintest

/**
 * Created by wangjing on 2017/10/11.
 */
public class Person {
    // 六、类属性
    // 1.只定义变量及默认值就可以
    // 2.一般不用写其get,set方法；除非你想改成自己的值
    var name: String = ""
        get()= field.toUpperCase()
        set(value){
            field = "Name:$value"
        }
}