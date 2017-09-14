# MVPLoader
一款轻量级的MVP框架，只有少数几个Java文件，主要针对MVP架构中，内存泄露问题！

## 添加依赖
```Java
Step 1:

      allprojects {
          repositories {
              ...
              maven { url 'https://jitpack.io' }
          }
      }
      
Step 2:

      dependencies {
          compile 'com.github.albert-lii:MVPLoader:1.0.1'
      }
```

## MVP模式详解
![MVP](https://github.com/albert-lii/MVPLoader/blob/master/picture/mvp.png)
MVP模式中，着重提现出Model与View不直接交互，通过Presenter来进行交互。这样做可以最大程度的做到解耦，当项目变的庞大时，可以更加容易控制。  

在本项目中，我将View中需要和Model进行交互的地方，写在IView接口中，将Model中的方法也写在接口中，Presenter同时获取View的IView接口，和Model的方法接口，在Presenter中通过接口来进行两者交互。Presenter起到一个连接作用。  

此外，在Presenter中持有了View的IView接口后，在极端情况下可能会出现内存泄漏情况，如异步时，当Activity已经关闭，Presenter中才开始调用IView接口中的方法来操纵UI，而此时边可能出现异常，内存泄漏等状况，所以在项目中，还着重对Presenter和View的生命周期进行了处理，当View的生命周期结束时，Presenter持有的IView将从Presenter中解除。

> **详情请查阅本人博客：http://blog.csdn.net/liyi1009365545/article/details/77931754**

## 使用方法
```Java
注：使用前，请先看demo

View：
      提供基础类：BaseActivity、BaseCompatActivity、BaseFragmentActivity、BaseFragment
      提供接口：IView

      以BaseActivity为例：
      public abstract class BaseActivity<P extends IPresenter> extends Activity implements IView {
          ...
      }

      view必须继承这些基础类，且实现IView接口

Presenter：
      提供基础类：BasePresenter<V extends IView>
      提供接口：IPresenter

      public abstract class BasePresenter<V extends IView> implements IPresenter {
          ...
      }

      presenter必须继承BasePresenter<V extends IView>类，并实现IPresenter接口
      
Model:暂无要求




部分案例代码：
      MainActivity:
      public class MainActivity extends BaseActivity<MainPresnter> implements MainContacts.IMain {
          ...
      }

      MainPresenter:
      public class MainPresnter extends BasePresenter<MainContacts.IMain> implements MainContacts.IMainPre {
          ...
      }
      
      MainLogic:
      public class MainLogic implements MainContacts.IMainLgc {
          ...
      }
      
      MainContacts:
      /**
       * 创建一个类作为纽带，将view、presenter、model的接口方法都串联在一起，更加便于管理
       */
      public final class MainContacts {
          public interface IMain extends IView {
              void showTips(boolean isSucceess);
          }

          public interface IMainPre extends IPresenter {
              void login(String username, String password);
          }

          public interface IMainLgc {
              boolean login(String username, String password);
          }
      }
```

## 赞赏
如果你感觉 `MVPLoader` 帮助到了你，可以点右上角 "Star" 支持一下 谢谢！ ^_^


## LICENSE
Copyright 2017 liyi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
