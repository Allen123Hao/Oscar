package com.hao.elasticsearch;

import com.google.gson.Gson;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <code>ElasticDemo2</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/4/28
 * @version: 1.0
 */
public class ElasticDemo2 {
    private TransportClient client = ElasticConfig.initClient2();

    private void getById(){
        GetResponse response = client.prepareGet("mc_asset_unilever","unilever_type","AWMF64OK0FVoUuISICYt").get();
        Map map = response.getSource();
        System.out.println(new Gson().toJson(map));

    }

    private void query(){
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("offset","5968578");
        paramMap.put("action","1");
        for(String key : paramMap.keySet()){
            String value = paramMap.get(key);
            queryBuilder.must(QueryBuilders.termQuery(key,value));
        }
        /**
        SearchResponse response = client.prepareSearch("mc_asset_unilever").setTypes("unilever_type")
                .setQuery(queryBuilder)
                .setFrom(0).setSize(10000)
                .setExplain(true)
                .execute().actionGet();
        long total = response.getHits().totalHits;
        Map map = response.getHits().getAt(9999).getSource();
        System.out.println("total:"+total);
        System.out.println(new Gson().toJson("map:"+map));
         **/

        SearchResponse response = client.prepareSearch("mc_asset_unilever").setTypes("unilever_type")
                .setQuery(queryBuilder)
                .setExplain(true)
                .setSearchType(SearchType.DEFAULT).setSize(2)
                .setScroll(new TimeValue(20000)).execute().actionGet();
        long total = response.getHits().getTotalHits();
        String res = response.getHits().getAt(0).getSourceAsString();
        System.out.println("total:"+total);
        System.out.println(new Gson().toJson("res:"+res));

        for(int i=0;i<2;i++){
            System.out.println("======:"+i);
            String scrollId = response.getScrollId();
            System.out.println("scrollId:"+scrollId);
            response = client.prepareSearchScroll(scrollId)
                    .setScroll(new TimeValue(20000)).execute()
                    .actionGet();
            int total1 = response.getHits().getHits().length;
            String res1 = response.getHits().getAt(0).getSourceAsString();
            System.out.println("total1:"+total1);
            System.out.println(new Gson().toJson("res1:"+res1));
        }
    }

    private void query_aggregation(){
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        Map<String,String> paramMap = new HashMap<>();
//        paramMap.put("offset","5968578");
        paramMap.put("action","2");
        for(String key : paramMap.keySet()){
            String value = paramMap.get(key);
            queryBuilder.must(QueryBuilders.termQuery(key,value));
        }
        AbstractAggregationBuilder aggregation = AggregationBuilders
                .terms("group_by_offset").size(1000100)
                .field("offset")
                .subAggregation(
                        AggregationBuilders.sum("sum_std_cnt").field("std_cnt")
                );
        SearchResponse response = client.prepareSearch("mc_asset_unilever").setTypes("unilever_type")
                .setQuery(queryBuilder)
                .addAggregation(aggregation)
                .setExplain(true)
                .setSearchType(SearchType.DEFAULT).setSize(2)
                .setScroll(new TimeValue(20000)).execute()
                .actionGet();

//        long total = response.getHits().getTotalHits();
//        String res = response.getHits().getAt(0).getSourceAsString();
        Map map1 = response.getAggregations().getAsMap();
        LongTerms longTerms = (LongTerms) map1.get("group_by_offset");
        List<LongTerms.Bucket> bucketses = longTerms.getBuckets();
        int size = bucketses.size();
        LongTerms.Bucket bucket = bucketses.get(size-1);
        System.out.println("size:"+size);
        System.out.println(new Gson().toJson(bucket));
//        List<Aggregation> list = response.getAggregations().asList();
//        Aggregation aggregation1 = list.get(0);
//        System.out.println("total:"+total);
//        System.out.println(new Gson().toJson("res:"+res));
//        System.out.println("map1:"+new Gson().toJson(map1));
//        System.out.println("list:"+new Gson().toJson(list));
//        System.out.println("map:"+new Gson().toJson(aggregation1));
//        System.out.println("response:"+new Gson().toJson(response));

//        for(int i=0;i<2;i++){
//            System.out.println("======:"+i);
//            String scrollId = response.getScrollId();
//            System.out.println("scrollId:"+scrollId);
//            response = client.prepareSearchScroll(scrollId)
//                    .setScroll(new TimeValue(20000)).execute()
//                    .actionGet();
//            int total1 = response.getHits().getHits().length;
//            String res1 = response.getHits().getAt(0).getSourceAsString();
//            System.out.println("total1:"+total1);
//            System.out.println(new Gson().toJson("res1:"+res1));
//        }
    }

    private void test(){
        Map<String,Object> map = new HashMap<>();
        map.put("a1",1);
        map.put("b2","hello");
        map.put("c3","Beijing");
        map.put("d4",false);
        System.out.println(new Gson().toJson(map));
    }

    public static void main(String[] args) {
        ElasticDemo2 demo2 = new ElasticDemo2();
//        demo2.test();
//        demo2.getById();
//        demo2.query();
        demo2.query_aggregation();
    }
}
