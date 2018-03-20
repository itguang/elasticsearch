# springboot通过jest连接elasticsearch

> 官方文档: https://github.com/searchbox-io/Jest/tree/master/jest

## 第一步: 引入jest依赖

```xml
      <!--使用Jest连接es-->

        <dependency>
            <groupId>io.searchbox</groupId>
            <artifactId>jest</artifactId>
            <version>5.3.3</version>
        </dependency>
```


## 配置jest

```properties
# es jest设置,默认 localhost:9200
spring.elasticsearch.jest.uris=http://localhost:9200
spring.elasticsearch.jest.read-timeout=10000
```

## curd操作

...




