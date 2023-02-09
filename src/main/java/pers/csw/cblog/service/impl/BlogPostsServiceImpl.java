package pers.csw.cblog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.csw.cblog.dao.BlogPostsDao;
import pers.csw.cblog.pojo.BlogPosts;
import pers.csw.cblog.pojo.Category;
import pers.csw.cblog.service.BlogPostsService;
import pers.csw.cblog.service.CategoryService;
import pers.csw.cblog.service.LabelService;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author csw
 * @date 2022/3/5
 * @time 12:33
 */
@Service
public class BlogPostsServiceImpl extends ServiceImpl<BlogPostsDao, BlogPosts> implements BlogPostsService {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogPostsDao blogPostsDao;
    @Autowired
    LabelService labelService;

    @Override
    public BlogPosts create(BlogPosts entity) {
        entity.setPostedTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        entity.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
         this.baseMapper.insert(entity);
         return entity;
    }

    @Override
    public BlogPosts getById(Serializable id) {
        BlogPosts blogPosts= blogPostsDao.selectById(id);
        return blogPosts;
    }

    @Override
    public List<BlogPosts> list() {
        return super.list();
    }


}
