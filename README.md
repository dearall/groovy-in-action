# Groovy In Action
Source code of the book [Groovy in Action, 2nd edition (manning,](http://manning.com/koenig2/?a_aid=regina&a_bid=8ade3b0e)
[amazon)](http://www.amazon.com/gp/product/1935182447/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=1935182447&linkCode=as2&tag=httpgroovycan-20&linkId=XLTAIALXLIUBWPOH)

### Use it? Star it!
All source code is free for everybody's use under the Apache 2 license.

If you want to do us a favor in return, please give this repo a "star" such that we can get at least a feeling of how many developers are using it. _Thanks!_ 

# Prerequisites

* Java 1.7 or higher
* Groovy 2.4.1 or higher

# Considerations

One can run all listings by calling

    groovy alltests

However, since some listings rely on external
constraints like special versions of the JVM
(e.g. to test Groovy features for Java 8) or
OS-specific integration features, some listings
may be excluded from execution.

Listings are usually made such that you can 
`cd` into the directory for that chapter and
call the listing via

	groovy mylistingname
	
If no other instructions apply, you best 
use Groovy 2.4.1 and Java 7. More recent versions
will also work in most cases.

There are code adaptions to Java 8.
Please use the Java_8 branch if you rely on those.

Keep groovin'

The authors	

#update

此代码在原作者的基础上做了如下更新：

1. groovy 升级为 v2.4.21
2. chap09 为 gradle 项目，使用 Gradle 5.6.4(自带 groovy v2.5.4) 编译，wrapper 任务同时使用 gradle 5.6.4 封装。
3. chap13 数据库代码，新建 mysql 目录，相关数据库代码使用 mysql 重写，方便 Groovy 使用 mysql 数据库。
4. 相关章节代码做了微调，以适应更新版本的 Groovy 和 Gradle
5. 以上更改适用于 Java_8 分支，对 master 分支没有影响。
