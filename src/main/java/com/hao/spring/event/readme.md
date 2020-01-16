**spring事件发送监听涉及3个部分**

* ApplicationEvent：表示事件本身，自定义事件需要继承该类,可以用来传递数据,比如上述操作,我们需要将用户的邮箱地址传给事件监听器.
* ApplicationEventPublisherAware：事件发送器,通过实现这个接口,来触发事件.
* ApplicationListener：事件监听器接口,事件的业务逻辑封装在监听器里面.