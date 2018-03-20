package com.itguang.elasticsearch.service;

import com.itguang.elasticsearch.entity.UserEntity;
import com.oracle.tools.packager.Log;
import io.searchbox.client.JestClient;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author itguang
 * @create 2018-03-20 10:24
 **/

@Service
@Slf4j
public class UserEsService {


    @Autowired
    JestClient jestClient;

    public void saveEntity(UserEntity entity) {

        Index index = new Index.Builder(entity).index(UserEntity.INDEX_NAME).type(UserEntity.TYPE).build();

        try {
            jestClient.execute(index);
            Log.info("插入完成");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * 批量保存
     *
     * @param list
     */
    public void saveEntity(List<UserEntity> list) {

        Bulk.Builder bulk = new Bulk.Builder();
        for (UserEntity entity : list) {
            Index index = new Index.Builder(entity).index(UserEntity.INDEX_NAME).type(UserEntity.TYPE).build();
            bulk.addAction(index);
        }

        try {
            jestClient.execute(bulk.build());
            Log.info("es 批量插入完成");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }





}
