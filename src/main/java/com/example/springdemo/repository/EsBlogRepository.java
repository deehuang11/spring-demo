package com.example.springdemo.repository;

import com.example.springdemo.domain.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * EsBlog Repository 接口
 * 分布式的 文档 存储
 * 它能存储和检索复杂的数据结构–序列化成为JSON文档–以 实时 的方式。
 * 换句话说，一旦一个文档被存储在 Elasticsearch 中，它就是可以被集群中的任意节点检索到。
 *
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

    /**
     * 分页查询博客（去重功能）
     * @param title
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleOrSummaryOrContent(String title,
                                                             String summary,
                                                             String content,
                                                             Pageable pageable);
}
