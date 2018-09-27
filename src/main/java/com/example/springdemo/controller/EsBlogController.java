package com.example.springdemo.controller;

import com.example.springdemo.domain.EsBlog;
import com.example.springdemo.repository.EsBlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/blogs")
public class EsBlogController {

    @Resource
    private EsBlogRepository esBlogRepository;

    @RequestMapping("/list")
    public List<EsBlog> list(@RequestParam(value = "title") String title,
                             @RequestParam(value = "summary") String summary,
                             @RequestParam(value = "content") String content,
                             @RequestParam(value = "pageIndex", defaultValue = "0")  int pageIndex,
                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        //数据是在test用例中初始化的
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleOrSummaryOrContent(title,
                summary, content, pageable);
        return page.getContent();
    }
}
