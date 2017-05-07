
## 预备

1. 上网了解 markdown 语法, 下载 markdown 客户端, 开始使用 markdown 写文档, 笔记
2. 了解 git 使用, 创建 github 账号.

## EchoClientV1.java EchoServerV1.java

客户端访问服务端

1. 客户端输入任何字符, 服务端打印客户端的字符, 并将当前日期返回给客户端
2. 客户端收到服务端的日期并打印出来

### 启动服务端

javac EchoServerV1.java
java EchoServerV1

### 启动客户端

javac EchoClientV1.java
java EchoClientV1

注: 必须先启动服务端, 后启动客户端.

## EchoClientV2.java EchoClientV3.java EchoServerV2.java

运行 EchoClientV2, EchoClientV3 客户端访问服务端 EchoServerV2

1. EchoClientV2 客户端发送数据给服务端
2. 服务端将收到的 EchoClientV2 的数据转发给 EchoClientV3 的客户端

### 启动服务端

javac EchoServerV2.java
java EchoServerV2

### 启动客户端

javac EchoClientV2.java
java EchoClientV2

javac EchoClientV3.java
java EchoClientV3

在 EchoClientV2 的窗口发送消息, EchoClientV3 的窗口可以收到消息.
可以同时运行多个 EchoClientV3, 每个运行 EchoClientV3 的窗口
都可以收到 EchoClientV2 发送的消息

思考问题

1. 对比 EchoClientV1 EchoClientV2 如何读一行的方法.
2. 阅读 jdk 源码 BufferedInputStream, BufferedOutputStream, BufferedReader 相关源码, 理解 buffer 实现

## EchoClientV4.java EchoServerV2.java

运行 多个EchoClientV4, 客户端访问服务端 EchoServerV2

1. EchoClientV4 客户端发送数据给服务端
2. 服务端将收到的 EchoClientV4 的数据转发给其他的 EchoClientV4

EchoClientV4 用两个线程将 EchoClientV2, EchoClientV4 整合起来.

这样一个简单的群聊工具就可以用了, 不过还有很多问题, 后面慢慢完善.

## 课堂笔记

### 基础

1. [java 体系](http://www.oracle.com/technetwork/java/javase/tech/index.html)
2. 不要害怕读 jdk 源码, 而且有些 jdk 必须读. 自行搜索如何获取 jdk 源码
3. 读[英文文档](https://docs.oracle.com/javase/7/docs/api/allclasses-noframe.html)
4. Socket, ServerSocket 文档, 注意 TCP_NODELAY
5. 创建线程两种方式(继承实现 run 方法, 实现 Runnable 接口), 另外一种后续介绍, Thread.sleep

### socket 模型

0. 同步异步, 阻塞非阻塞
1. 单线程多连接
2. 多线程每线程连接
3. IO 复用(关键词 select, poll, epoll), Reactor 模型

### 网络编程设计

1. 协议
2. 序列化, 反序列化(kyro)

[netty](https://github.com/netty/netty)
[kyro](https://github.com/EsotericSoftware/kryo)
[thrift](https://thrift.apache.org/)
[Protocol buffers](https://github.com/google/protobuf)

