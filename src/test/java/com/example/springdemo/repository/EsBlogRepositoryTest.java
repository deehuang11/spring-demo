package com.example.springdemo.repository;

import com.example.springdemo.domain.EsBlog;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * EsBlogRepository 接口测试用例
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {
    private static final long serialVersionUID = 1L;

    @Resource
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRepositoryData() {
        //1、清除所有的数据
        esBlogRepository.deleteAll();
        //2、往仓库中初始化数据
        esBlogRepository.save(new EsBlog("登黄鹤楼","王之涣的登黄鹤楼", "白日依山尽，黄河入海流，欲穷千里莫，更上一层楼"));
        esBlogRepository.save(new EsBlog("相思","王维的相思", "红豆生南国，春来发几枝, 愿君多采撷，此物最相思"));
        esBlogRepository.save(new EsBlog("静夜思","李白的静夜思", "床前明月光，疑是地上霜，举头望明月，低头思故乡"));
    }

    @Test
    public void TestFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable = new PageRequest(0, 20);
        String tile = "1111";
//        String summary = "相思";
//      String content = "相思";
        String summary = "王之涣";
        String content = "1111";
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleOrSummaryOrContent(tile, summary, content, pageable);
        //断言
        assertThat(page.getTotalElements()).isEqualTo(1);

        System.out.println("--------start-----------");
        for (EsBlog esBlog : page.getContent()) {
            System.out.println("esBlog ==  " +  esBlog);
        }
        System.out.println("--------end-----------");
    }
}
