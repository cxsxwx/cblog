package pers.csw.cblog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import pers.csw.cblog.pojo.BlogPosts;

/**
 * @author csw
 * @date 2022/3/5
 * @time 12:29
 */
public interface BlogPostsService extends IService<BlogPosts> {
    BlogPosts create(BlogPosts blogPosts);

}
