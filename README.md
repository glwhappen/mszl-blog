## 简介

一个博客的练手项目
视频地址：https://www.bilibili.com/video/BV1Gb4y1d7zb

## 用到的依赖

- jdk 1.8
- spring-boot 2.4.1
- mysql-connector
- mybatis-plus 3.5.1
- lombok

## 项目结构

P4后形成的目录结构

```txt
src/cn.glwsq.blog
│  BlogApplication.java # 启动文件
│
├─config # 配置文件
│      MyBatisPlusConfig.java # MyBatisPlus配置文件
│      WebMVCConfig.java # 跨域配置
│
├─controller
│      ArticleController.java
│
├─domain
│      Article.java
│      SysUser.java
│      Tag.java
│
├─mapper # 会去寻找resources下面的同名mapper
│      ArticleMapper.java
│      SysUserMapper.java
│      TagMapper.java
│
├─service
│  │  ArticleService.java
│  │  SysUserService.java
│  │  TagService.java
│  │
│  └─impl
│          ArticleServiceImpl.java
│          SysUserServiceImpl.java
│          TagServiceImpl.java
│
└─vo
    │  ArticleVo.java
    │  Result.java
    │  TagVo.java
    │
    └─params
            PageParams.java
```

```txt
resources
│  application.yml # 项目配置
│
├─mapper # mapper映射文件
│      ArticleMapper.xml
│      SysUserMapper.xml
│      TagMapper.xml
│
├─static
└─templates
```

## 学习记录

- [x] [P1. 项目介绍](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=1)
- [x] [P2. 项目搭建](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=2)
  - 用自己的方法搭建博客后台项目
  - 加入mybatis-plus的分页插件
  - 跨域配置
- [x] [P3. 首页文章列表实现-1](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=3)
  - idea的MybatisX插件真好用，直接通过mysql数据库把相关的代码实现了，具体的代码如下
    1. domain层，包含了数据库的表结构
    2. mapper层，包含了mybatis的数据库操作Mapper
    3. service层，逻辑处理层
    4. 和resources下的mapper.xml
- [x] [P4. 首页文章列表实现-2](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=4)
- [x] [P5. 首页-最热标签](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=5)
- [x] [P6. 统一异常处理](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=6)
- [x] [P7. 首页-最热文章](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=7)
- [x] [P8. 首页-最新文章](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=8)
- [x] [P9. 首页-文章归档](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=9)
- [x] [P10. 登录JWT技术](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=10)
- [ ] [P11. 登录功能](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=11)
- [ ] [P12. 登录后获取用户信息](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=12)
- [ ] [P13. 退出登录](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=13)
- [ ] [P14. 注册功能](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=14)
- [ ] [P15. 登录拦截器](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=15)
- [ ] [P16. ThreadLocal保存登录用户信息](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=16)
- [ ] [P17. ThreadLocal内存泄漏](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=17)
- [ ] [P18. 文章详情](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=18)
- [ ] [P19. 线程池的使用](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=19)
- [ ] [P20. 阅读次数bug修正](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=20)
- [ ] [P21. 评论列表](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=21)
- [ ] [P22. 评论功能](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=22)
- [ ] [P23. 写文章-所有分类](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=23)
- [ ] [P24. 写文章-所有标签](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=24)
- [ ] [P25. 发布文章](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=25)
- [ ] [P26. AOP记录日志](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=26)
- [ ] [P27. 文章归档bug修复](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=27)
- [ ] [P28. 文章图片上传](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=28)
- [ ] [P29. 导航-文章分类](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=29)
- [ ] [P30. 分类文章列表](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=30)
- [ ] [P31. 标签文章列表](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=31)
- [ ] [P32. 归档文章列表](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=32)
- [ ] [P33. 统一缓存处理（优化）](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=33)
- [ ] [P34. 统一缓存精度bug](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=34)
- [ ] [P35. 思考别的优化+作业](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=35)
- [ ] [P36. 管理后台-搭建工程](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=36)
- [ ] [P37. 管理后台-页面讲解](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=37)
- [ ] [P38. 权限表增删改查](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=38)
- [ ] [P39. security配置说明](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=39)
- [ ] [P40. 登录认证](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=40)
- [ ] [P41. 权限认证](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=41)
- [ ] [P42. 管理台权限布置作业](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=42)
- [ ] [P43. 总结-面试技术亮点](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=43)
- [ ] [P44. 前端代码讲解1](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=44)
- [ ] [P45. 前端代码讲解2](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=45)
- [ ] [P46. 部署-云服务器购买](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=46)
- [ ] [P47. 部署-域名和备案](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=47)
- [ ] [P48. 部署-打包](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=48)
- [ ] [P49. 部署-安装mysql和redis](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=49)
- [ ] [P50. 部署-app镜像制作](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=50)
- [ ] [P51. 部署-服务编排](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=51)
- [ ] [P52. 部署-网络错误解决](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=52)
- [ ] [P53. 补充-53-缓存一致性问题](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=53)
- [ ] [P54. 补充-54-缓存一致性问题-消费者逻辑](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=54)
- [ ] [P55. 补充-55-缓存一致性问题-文章列表解决方案](https://www.bilibili.com/video/BV1Gb4y1d7zb?p=55)


