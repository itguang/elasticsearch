package com.itguang.elasticsearch;

import com.itguang.elasticsearch.entity.Article;
import com.itguang.elasticsearch.entity.UserEntity;
import com.itguang.elasticsearch.service.UserEsService;
import com.oracle.tools.packager.Log;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.BulkResult;
import io.searchbox.core.Delete;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

    @Autowired
    UserEsService userEsService;

    @Autowired
    JestClient client;


    @Test
    public void contextLoads() {
    }

    /**
     * 创建索引并插入数据
     */
    @Test
    public void save() {
        UserEntity entity = new UserEntity(1L, "小光光");
        userEsService.saveEntity(entity);
    }

    /**
     * 创建索引
     */
    @Test
    public void createIndex1() {

        Article article = new Article("东野圭吾", "虚像小丑");

        //必须有 type
        Index index = new Index.Builder(article).index("articles").type("_doc").build();

        try {
            client.execute(index);
            Log.info("插入完成");
        } catch (IOException e) {
            System.out.println("插入失败");
            e.printStackTrace();
        }


    }

    /**
     * 索引文档(Indexing Documents)
     */

    @Test
    public void indexDocument() {

        Article source = new Article();
        source.setAuthor("东野圭吾");

        Index index = new Index.Builder(source).index("articles").type("_doc").id("1").build();
        try {
            DocumentResult documentResult = client.execute(index);

            System.out.println("索引结果" + documentResult.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 查询
     */
    @Test
    public void search() {

        //Add ElasticSearch dependency to use SearchSourceBuilder
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.query(QueryBuilders.matchQuery("author", "东野圭吾"));

        Search search = new Search.Builder(searchSourceBuilder.toString())
                // multiple index or types can be added.
                .addIndex("articles")
                .addType("_doc")
                .build();

        SearchResult result = null;
        try {
            result = client.execute(search);
            System.out.println("查询结果=" + result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

//Result can be cast to List of domain object;

        List<SearchResult.Hit<Article, Void>> hits = result.getHits(Article.class);
// or
        List<Article> articles = result.getSourceAsObjectList(Article.class);

        articles.stream()
                .forEach(entity -> System.out.println(entity.toString()));

    }


    @Test
    public void getDocument(){

        Get get = new Get.Builder("articles", "1").type("_doc").build();

        try {
            JestResult result = client.execute(get);



            Article article = result.getSourceAsObject(Article.class);

            System.out.println(article.toString());
        } catch (IOException e) {
            e.printStackTrace();


        }




    }

    /**
     * 删除document
     */

    @Test
    public void deleteDocument(){
        try {
            DocumentResult result = client.execute(new Delete.Builder("KZ1DQ2IBfM9pwKq2JhbU")
                    .index("articles")
                    .type("_doc")
                    .build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批处理 Bulk Operations
     */

    @Test
    public void bulkbulkOperations(){

        Article article1 = new Article("毛泽东", "论持久战");
        Article article2 = new Article("余华", "活着");

//        Bulk bulk = new Bulk.Builder()
//                .defaultIndex("twitter")
//                .defaultType("tweet")
//                .addAction(new Index.Builder(article1).build())
//                .addAction(new Index.Builder(article2).build())
//                .addAction(new Delete.Builder("KJ05Q2IBfM9pwKq2UxYz").index("articles").type("_doc").build())
//                .build();

        Bulk bulk = new Bulk.Builder()
                .defaultIndex("articles")
                .defaultType("_doc")
                .addAction(Arrays.asList(
                        new Index.Builder(article1).build(),
                        new Index.Builder(article2).build()))
                .build();



        try {
            BulkResult bulkResult = client.execute(bulk);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
