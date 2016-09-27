# PoiZhihuDaily
#### Just study，just fun!
这个项目是为了想实现下图中的架构(但并未使用EventBus，而是由Presenter将数据传给View)，使用Dagger将全局单例DataManager注入进每个Presenter中，通过Rx操作符将从服务器获取到的数据转换为想要的数据，最后传给View。
因为懒，所以只简单做了一个页面。

![](https://github.com/wuapnjie/PoiZhihuDaily/blob/master/pic/architecture_diagram.png)

参考项目[android-architecture](https://github.com/googlesamples/android-architecture)
