package pers.csw.cblog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.csw.cblog.dao.CLabelDao;
import pers.csw.cblog.model.vo.CLabel;
import pers.csw.cblog.pojo.BlogPosts;
import pers.csw.cblog.pojo.Category;
import pers.csw.cblog.service.BlogPostsService;
import pers.csw.cblog.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CblogApplicationTests {
    @Autowired
    private BlogPostsService postsService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CLabelDao cLabelDao;

    @Test
    void contextLoads() {
        BlogPosts blogPosts =new BlogPosts();
        blogPosts.setTitle("测试");
//        blogPosts.setLabels("编程");

        blogPosts.setLove(1);
        blogPosts.setPview(1);
        blogPosts.setAuthor("csw");
        boolean save = postsService.save(blogPosts);
        System.out.println(save);
    }


    @Test
    void contextLoads2() {
        Category byId = categoryService.getById(1);
        System.out.println(byId);
    }
    @Test
    void LabelGetPosts(){
        QueryWrapper<CLabel> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("label_id",36);
        List<CLabel> cLabels = cLabelDao.selectList(queryWrapper);
        List<BlogPosts> blogPosts =new ArrayList<>();
        cLabels.forEach((labelId)->{
            blogPosts.add(postsService.getById(labelId.getBlogId()));
        });
    }

    @Test
    void categoryGetPosts(){
        QueryWrapper<BlogPosts> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("category",1);
        System.out.println(postsService.list(queryWrapper));
    }

}
