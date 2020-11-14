循环依赖总结一下（假设A,B之间循环依赖）：
一级缓存singletonObject，也就是常说的单例池，是个Map
二级缓存earlySingletonObjects，也就是提前一点的单例池，哈哈，字面翻译,也是Map
三级缓存singletonFactories，这个Map有点特殊，因为这个Map的value存放的是一个lambda表达式
1、单例池不能存放原始对象，只能存放经过完整生命周期的对象，也就是java bean
2、A，B在注入属性都会执行一个addSingletonFactory方法，这个方法里面三级缓存就出现了，三级缓存put了key为beanName，
   value为一个lambda表达式
3、其实最容易绕晕的地方是，当B注入属性A的时候，执行populateBean注入一个bean的属性的时候会执行getSingleton这个方法，
   一定要记得！！populateBean方法体中没有直接调用getSingleton这个方法，但一定要记得，执行了这个方法
4、getSingleton这个方法，会依次到一级缓存，二级缓存，三级缓存中get(beanName)，很显然当B注入A属性的时候，一级，二级里面
   都没有内容，只有三级有，这时会执行lambda表达式，lambda表达式的作用就是生成代理对象！！然后把生成的代理对象存入二级缓存，
   并返回这个代理对象，B就会得到这个代理对象A，B就会认为这个代理对象A就是A的最后的bean对象，因此也就完成了对A的属性注入这步
   操作，接着依次执行B后续的操作，最后就完成了B的生命周期，B就成功变成了bean对象，B也就完成了使命
5、当B完成使命之后，A就会继续注入B，这时就会注入属性成功了，接下来开始执行AOP操作，因为上一步中A已经生成了代理对象A，也就是
   相当于完成了AOP，所以B就不执行AOP操作了，此时A就会执行最后一步操作，将代理对象A放入到单例池中去，这时A就会执行方法getSingleton，
   从二级缓存中获得了代理对象A，最后将其存入单例池，也就是一级缓存！好了，现在A和B都放入了单例池，圆满结束！！！！