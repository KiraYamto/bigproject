package org.bobo.util.elasticsearch;

import org.bobo.model.es.EsBaseDoc;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.VersionType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: bobo
 * @Date: 2020/11/27 14:30
 */
@Component
public class ElasticsearchClient {


    @Autowired
    private RestHighLevelClient client;
    
    
    //构建索引对象
    private IndexRequest get_indexRequest(String index, String indexType, String docId) {
        IndexRequest indexRequest = null;
        if (null == index || null == indexType) {
            throw new ElasticsearchException("index or indexType must not be null");
        }
        if (null == docId) {
            indexRequest = new IndexRequest(index, indexType);
        } else {
            indexRequest = new IndexRequest(index, indexType, docId);
        }
        return indexRequest;
    }

    /**
     * 同步执行索引
     *
     * @param index
     * @param indexType
     * @param docId
     * @param dataMap
     * @throws IOException
     */
    public IndexResponse execIndex(String index, String indexType, String docId, Map<String, Object> dataMap) throws IOException {

        return client.index(get_indexRequest(index, indexType, docId).source(dataMap), RequestOptions.DEFAULT);
    }

    /**
     * 异步执行
     *
     * @param index
     * @param indexType
     * @param docId
     * @param dataMap
     * @param indexResponseActionListener
     * @throws IOException
     */
    public void asyncExecIndex(String index, String indexType, String docId, Map<String, Object> dataMap, ActionListener<IndexResponse> indexResponseActionListener) throws IOException {
        client.indexAsync(get_indexRequest(index, indexType, docId).source(dataMap), RequestOptions.DEFAULT, indexResponseActionListener);
    }

    /**
     * @param index
     * @param indexType
     * @param docId
     * @param includes  返回需要包含的字段，可以传入空
     * @param excludes  返回需要不包含的字段，可以传入为空
     * @param excludes  version
     * @param excludes  versionType
     * @return
     * @throws IOException
     */

    public GetResponse getRequest(String index, String indexType, String docId, String[] includes, String[] excludes, Integer version, VersionType versionType) throws IOException {
        if (null == includes || includes.length == 0) {
            includes = Strings.EMPTY_ARRAY;
        }
        if (null == excludes || excludes.length == 0) {
            excludes = Strings.EMPTY_ARRAY;
        }
        GetRequest getRequest = new GetRequest(index, indexType, docId);
        FetchSourceContext fetchSourceContext = new FetchSourceContext(true, includes, excludes);
        getRequest.realtime(true);
        if (null != version) {
            getRequest.version(version);
        }
        if (null != versionType) {
            getRequest.versionType(versionType);
        }
        return client.get(getRequest.fetchSourceContext(fetchSourceContext), RequestOptions.DEFAULT);
    }

    /**
     * @param index
     * @param indexType
     * @param docId
     * @param includes
     * @param excludes
     * @return
     * @throws IOException
     */

    public GetResponse getRequest(String index, String indexType, String docId, String[] includes, String[] excludes) throws IOException {
        return getRequest(index, indexType, docId, includes, excludes, null, null);
    }

    /**
     * @param index
     * @param indexType
     * @param docId
     * @return
     * @throws IOException
     */
    public GetResponse getRequest(String index, String indexType, String docId) throws IOException {
        GetRequest getRequest = new GetRequest(index, indexType, docId);
        return client.get(getRequest, RequestOptions.DEFAULT);
    }

    /**
     * @param index
     * @param indexType
     * @param docId
     * @return
     * @throws IOException
     */
    public Boolean existDoc(String index, String indexType, String docId) throws IOException {
        GetRequest getRequest = new GetRequest(index, indexType, docId);
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");
        return client.exists(getRequest, RequestOptions.DEFAULT);
    }

    /**
     * @param index
     * @param indexType
     * @param docId
     * @param timeValue
     * @param refreshPolicy
     * @param version
     * @param versionType
     * @return
     * @throws IOException
     */
    public DeleteResponse deleteDoc(String index, String indexType, String docId, TimeValue timeValue, WriteRequest.RefreshPolicy refreshPolicy, Integer version, VersionType versionType) throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(index, indexType, docId);
        if (null != timeValue) {
            deleteRequest.timeout(timeValue);
        }
        if (null != refreshPolicy) {
            deleteRequest.setRefreshPolicy(refreshPolicy);
        }
        if (null != version) {
            deleteRequest.version(version);
        }
        if (null != versionType) {
            deleteRequest.versionType(versionType);
        }
        return client.delete(deleteRequest, RequestOptions.DEFAULT);
    }

    /**
     * @param index
     * @param indexType
     * @param docId
     * @return
     * @throws IOException
     */
    public DeleteResponse deleteDoc(String index, String indexType, String docId) throws IOException {
        return deleteDoc(index, indexType, docId, null, null, null, null);
    }

    /**
     * @param index
     * @param indexType
     * @param docId
     * @param dataMap
     * @param timeValue
     * @param refreshPolicy
     * @param version
     * @param versionType
     * @param docAsUpsert
     * @param includes
     * @param excludes
     * @return
     * @throws IOException
     */
    public UpdateResponse updateDoc(String index, String indexType, String docId, Map<String, Object> dataMap, TimeValue timeValue, WriteRequest.RefreshPolicy refreshPolicy, Integer version, VersionType versionType, Boolean docAsUpsert, String[] includes, String[] excludes) throws IOException {
        UpdateRequest updateRequest = new UpdateRequest(index, indexType, docId);
        updateRequest.doc(dataMap);
        if (null != timeValue) {
            updateRequest.timeout(timeValue);
        }
        if (null != refreshPolicy) {
            updateRequest.setRefreshPolicy(refreshPolicy);
        }
        if (null != version) {
            updateRequest.version(version);
        }
        if (null != versionType) {
            updateRequest.versionType(versionType);
        }
        updateRequest.docAsUpsert(docAsUpsert);
        //冲突时重试的次数
        updateRequest.retryOnConflict(3);
        if (null == includes && null == excludes) {
            return client.update(updateRequest);
        } else {
            if (null == includes || includes.length == 0) {
                includes = Strings.EMPTY_ARRAY;
            }
            if (null == excludes || excludes.length == 0) {
                excludes = Strings.EMPTY_ARRAY;
            }
            return client.update(updateRequest.fetchSource(new FetchSourceContext(true, includes, excludes)), RequestOptions.DEFAULT);
        }
    }

    /**
     * 更新时不存在就插入
     *
     * @param index
     * @param indexType
     * @param docId
     * @param dataMap
     * @return
     * @throws IOException
     */
    public UpdateResponse upDdateocAsUpsert(String index, String indexType, String docId, Map<String, Object> dataMap) throws IOException {
        return updateDoc(index, indexType, docId, dataMap, null, null, null, null, true, null, null);
    }

    /**
     * 存在才更新
     *
     * @param index
     * @param indexType
     * @param docId
     * @param dataMap
     * @return
     * @throws IOException
     */
    public UpdateResponse updateDoc(String index, String indexType, String docId, Map<String, Object> dataMap) throws IOException {
        return updateDoc(index, indexType, docId, dataMap, null, null, null, null, false, null, null);
    }

    /**
     * 批量操作
     *
     * @param EsBaseDocList
     * @param timeValue
     * @param refreshPolicy
     * @return
     * @throws IOException
     */
    public BulkResponse bulkRequest(List<EsBaseDoc> EsBaseDocList, TimeValue timeValue, WriteRequest.RefreshPolicy refreshPolicy) throws IOException {
        BulkRequest bulkRequest = getBulkRequest(EsBaseDocList);
        if (null != timeValue) {
            bulkRequest.timeout(timeValue);
        }
        if (null != refreshPolicy) {
            bulkRequest.setRefreshPolicy(refreshPolicy);
        }
        return client.bulk(bulkRequest, RequestOptions.DEFAULT);
    }

    private BulkRequest getBulkRequest(List<EsBaseDoc> EsBaseDocList) {
        BulkRequest bulkRequest = new BulkRequest();
        EsBaseDocList.forEach(EsBaseDoc -> {
            if (ESOperateType.CREATE.equals(EsBaseDoc.getOperateType())) {
                bulkRequest.add(null != EsBaseDoc.get_id() ? new IndexRequest(EsBaseDoc.get_index(), EsBaseDoc.get_type(), EsBaseDoc.get_id()) : new IndexRequest(EsBaseDoc.get_index(), EsBaseDoc.get_type()));
            } else if (ESOperateType.UPDATE.equals(EsBaseDoc.getOperateType())) {
                if ((null != EsBaseDoc.get_id())) {
                    throw new ElasticsearchException("update action docId must not be null");
                }
                bulkRequest.add(new UpdateRequest(EsBaseDoc.get_index(), EsBaseDoc.get_type(), EsBaseDoc.get_id()));
            } else if (ESOperateType.DELETE.equals(EsBaseDoc.getOperateType())) {
                if ((null != EsBaseDoc.get_id())) {
                    throw new ElasticsearchException("delete action docId must not be null");
                }
                bulkRequest.add(new DeleteRequest(EsBaseDoc.get_index(), EsBaseDoc.get_type(), EsBaseDoc.get_id()));
            } else {
                throw new ElasticsearchException("OperateType" + EsBaseDoc.getOperateType() + "is not support");
            }
        });
        return bulkRequest;
    }

    /**
     * 批量操作
     *
     * @param EsBaseDocList
     * @return
     */
    public BulkResponse bulkRequest(List<EsBaseDoc> EsBaseDocList) throws IOException {
        return bulkRequest(EsBaseDocList, null, null);
    }

    /**
     * 批量异步操作
     *
     * @param EsBaseDocList
     * @param bulkResponseActionListener
     */

    public void AsyncBulkRequest(List<EsBaseDoc> EsBaseDocList, ActionListener<BulkResponse> bulkResponseActionListener) {
        client.bulkAsync(getBulkRequest(EsBaseDocList), RequestOptions.DEFAULT, bulkResponseActionListener);
    }


    private SearchRequest getSearchRequest(String index, String indexType) {
        SearchRequest searchRequest;
        if (null == index) {
            throw new ElasticsearchException("index name must not be null");
        }
        if (null != indexType) {
            searchRequest = new SearchRequest(index, indexType);
        } else {
            searchRequest = new SearchRequest(index);
        }
        return searchRequest;
    }

    /**
     * @param index
     * @param indexType
     * @return
     * @throws IOException
     */
    public SearchResponse searchRequest(String index, String indexType) throws IOException {
        return client.search(getSearchRequest(index, indexType), RequestOptions.DEFAULT);
    }

    /**
     * @param index
     * @param indexType
     * @param from
     * @param size
     * @param termQueryBuilder
     * @return
     * @throws IOException
     */
    public SearchResponse searchRequest(String index, String indexType, Integer from, Integer size, TermQueryBuilder termQueryBuilder) throws IOException {
        return client.search(getSearchRequest(index, indexType).source(getSearchSourceBuilder(index, indexType, from, size, termQueryBuilder, null, null, null)), RequestOptions.DEFAULT);
    }

    private SearchSourceBuilder getSearchSourceBuilder(String index, String indexType, Integer from, Integer size, TermQueryBuilder termQueryBuilder, String sortField, SortBuilder sortBuilder, Boolean fetchSource) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        if (null != termQueryBuilder) {
            searchSourceBuilder.query(termQueryBuilder);
        }
        searchSourceBuilder.from(from);
        searchSourceBuilder.size(size);
        if (null != sortField) {
            searchSourceBuilder.sort(sortField);
        }
        if (null != sortBuilder) {
            searchSourceBuilder.sort(sortBuilder);
        }
        //设置超时时间
        searchSourceBuilder.timeout(new TimeValue(120, TimeUnit.SECONDS));
        if (null != fetchSource) {
            searchSourceBuilder.fetchSource(fetchSource);
        }
        return searchSourceBuilder;
    }

    /**
     * @param index
     * @param indexType
     * @param from
     * @param size
     * @param termQueryBuilder
     * @param matchQueryBuilder
     * @return
     * @throws IOException
     */
    public SearchResponse searchRequest(String index, String indexType, Integer from, Integer size, TermQueryBuilder termQueryBuilder, MatchQueryBuilder matchQueryBuilder) throws IOException {
        if (null == matchQueryBuilder) {
            throw new ElasticsearchException("matchQueryBuilder is null");
        }
        return client.search(getSearchRequest(index, indexType).source(getSearchSourceBuilder(index, indexType, from, size, termQueryBuilder, null, null, null).query(matchQueryBuilder)), RequestOptions.DEFAULT);
    }

    /**
     * @param index
     * @param indexType
     * @param from
     * @param size
     * @param matchQueryBuilder
     * @return
     * @throws IOException
     */
    public SearchResponse searchRequest(String index, String indexType, Integer from, Integer size, MatchQueryBuilder matchQueryBuilder) throws IOException {
        if (null == matchQueryBuilder) {
            throw new ElasticsearchException("matchQueryBuilder is null");
        }
        return client.search(getSearchRequest(index, indexType).source(getSearchSourceBuilder(index, indexType, from, size, null, null, null, null).query(matchQueryBuilder)), RequestOptions.DEFAULT);
    }

    /**
     * @param index
     * @param indexType
     * @param from
     * @param size
     * @param matchQueryBuilder
     * @param sortField
     * @return
     * @throws IOException
     */
    public SearchResponse searchRequest(String index, String indexType, Integer from, Integer size, MatchQueryBuilder matchQueryBuilder, String sortField) throws IOException {
        if (null == matchQueryBuilder) {
            throw new ElasticsearchException("matchQueryBuilder is null");
        }
        return client.search(getSearchRequest(index, indexType).source(getSearchSourceBuilder(index, indexType, from, size, null, sortField, null, null).query(matchQueryBuilder)), RequestOptions.DEFAULT);
    }

    /**
     * @param index
     * @param indexType
     * @param from
     * @param size
     * @param matchQueryBuilder
     * @param sortField
     * @param fetchSource
     * @return
     * @throws IOException
     */
    public SearchResponse searchRequest(String index, String indexType, Integer from, Integer size, MatchQueryBuilder matchQueryBuilder, String sortField, Boolean fetchSource) throws IOException {
        if (null == matchQueryBuilder) {
            throw new ElasticsearchException("matchQueryBuilder is null");
        }
        return client.search(getSearchRequest(index, indexType).source(getSearchSourceBuilder(index, indexType, from, size, null, sortField, null, fetchSource).query(matchQueryBuilder)), RequestOptions.DEFAULT);
    }

    /**
     * @param index
     * @param indexType
     * @param from
     * @param size
     * @param matchQueryBuilder
     * @param sortBuilder
     * @return
     * @throws IOException
     */
    public SearchResponse searchRequest(String index, String indexType, Integer from, Integer size, MatchQueryBuilder matchQueryBuilder, SortBuilder sortBuilder) throws IOException {
        if (null == matchQueryBuilder) {
            throw new ElasticsearchException("matchQueryBuilder is null");
        }
        return client.search(getSearchRequest(index, indexType).source(getSearchSourceBuilder(index, indexType, from, size, null, null, sortBuilder, null).query(matchQueryBuilder)), RequestOptions.DEFAULT);
    }


    /**
     * 支持排序
     *
     * @param index
     * @param indexType
     * @param from
     * @param size
     * @param termQueryBuilder
     * @param matchQueryBuilder
     * @param sortField
     * @return
     * @throws IOException
     */
    public SearchResponse searchRequest(String index, String indexType, Integer from, Integer size, TermQueryBuilder termQueryBuilder, MatchQueryBuilder matchQueryBuilder, String sortField) throws IOException {
        if (null == matchQueryBuilder) {
            throw new ElasticsearchException("matchQueryBuilder is null");
        }
        return client.search(getSearchRequest(index, indexType).source(getSearchSourceBuilder(index, indexType, from, size, termQueryBuilder, sortField, null, null).query(matchQueryBuilder)), RequestOptions.DEFAULT);
    }

    /**
     * @param index
     * @param indexType
     * @param from
     * @param size
     * @param termQueryBuilder
     * @param matchQueryBuilder
     * @param sortBuilder
     * @param fetchSource       开关
     * @return
     * @throws IOException
     */
    public SearchResponse searchRequest(String index, String indexType, Integer from, Integer size, TermQueryBuilder termQueryBuilder, MatchQueryBuilder matchQueryBuilder, SortBuilder sortBuilder, Boolean fetchSource) throws IOException {
        if (null == matchQueryBuilder) {
            throw new ElasticsearchException("matchQueryBuilder is null");
        }
        return client.search(getSearchRequest(index, indexType).source(getSearchSourceBuilder(index, indexType, from, size, termQueryBuilder, null, sortBuilder, fetchSource).query(matchQueryBuilder)), RequestOptions.DEFAULT);
    }

    /**
     * @param index
     * @param indexType
     * @param from
     * @param size
     * @param termQueryBuilder
     * @param matchQueryBuilder
     * @param sortBuilder
     * @return
     * @throws IOException
     */
    public SearchResponse searchRequest(String index, String indexType, Integer from, Integer size, TermQueryBuilder termQueryBuilder, MatchQueryBuilder matchQueryBuilder, SortBuilder sortBuilder) throws IOException {
        if (null == matchQueryBuilder) {
            throw new ElasticsearchException("matchQueryBuilder is null");
        }
        return client.search(getSearchRequest(index, indexType).source(getSearchSourceBuilder(index, indexType, from, size, termQueryBuilder, null, sortBuilder, null).query(matchQueryBuilder)), RequestOptions.DEFAULT);
    }

    /**
     * @param index
     * @param indexType
     * @param from
     * @param size
     * @param termQueryBuilder
     * @param matchQueryBuilder
     * @param sortField
     * @param fetchSource
     * @return
     * @throws IOException
     */
    public SearchResponse searchRequest(String index, String indexType, Integer from, Integer size, TermQueryBuilder termQueryBuilder, MatchQueryBuilder matchQueryBuilder, String sortField, Boolean fetchSource) throws IOException {
        if (null == matchQueryBuilder) {
            throw new ElasticsearchException("matchQueryBuilder is null");
        }
        return client.search(getSearchRequest(index, indexType).source(getSearchSourceBuilder(index, indexType, from, size, termQueryBuilder, sortField, null, fetchSource).query(matchQueryBuilder)), RequestOptions.DEFAULT);
    }

    /**
     * 异步操作
     * @param index
     * @param indexType
     * @param from
     * @param size
     * @param termQueryBuilder
     * @param matchQueryBuilder
     * @param sortBuilder
     * @param listener
     * @throws IOException
     */

    public void asyncSearchRequest(String index, String indexType, Integer from, Integer size, TermQueryBuilder termQueryBuilder, MatchQueryBuilder matchQueryBuilder, SortBuilder sortBuilder,ActionListener<SearchResponse> listener) throws IOException {
        if (null == matchQueryBuilder) {
            throw new ElasticsearchException("matchQueryBuilder is null");
        }
        client.searchAsync(getSearchRequest(index, indexType).source(getSearchSourceBuilder(index, indexType, from, size, termQueryBuilder, null, sortBuilder, null).query(matchQueryBuilder)), RequestOptions.DEFAULT,listener);
    }

    /**
     * 异步操作
     * @param index
     * @param indexType
     * @param from
     * @param size
     * @param termQueryBuilder
     * @param matchQueryBuilder
     * @param sortField
     * @param listener
     * @throws IOException
     */
    public void asyncSearchRequest(String index, String indexType, Integer from, Integer size, TermQueryBuilder termQueryBuilder, MatchQueryBuilder matchQueryBuilder, String sortField,ActionListener<SearchResponse> listener) throws IOException {
        if (null == matchQueryBuilder) {
            throw new ElasticsearchException("matchQueryBuilder is null");
        }
        client.searchAsync(getSearchRequest(index, indexType).source(getSearchSourceBuilder(index, indexType, from, size, termQueryBuilder, sortField, null, null).query(matchQueryBuilder)), RequestOptions.DEFAULT,listener);
    }

    public void test(){
        ActionListener<IndexResponse> listener = new ActionListener<IndexResponse>() {
            @Override
            public void onResponse(IndexResponse indexResponse) {
                String index = indexResponse.getIndex();
                String type = indexResponse.getType();
                String id = indexResponse.getId();
                long version = indexResponse.getVersion();
                if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
                    System.out.println("添加成功");
                    System.out.println("type:" + type);
                    System.out.println("id:" + id);
                    System.out.println("version:" + version);
                    System.out.println("index:" + index);
                } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
                    System.out.println("更新成功");
                    System.out.println("index:" + index);
                    System.out.println("type:" + type);
                    System.out.println("id:" + id);
                    System.out.println("version:" + version);
                }
                ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
                if (shardInfo.getTotal() != shardInfo.getSuccessful()) {

                }
                if (shardInfo.getFailed() > 0) {
                    for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {
                        String reason = failure.reason();
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
            }
        };
    }
}

