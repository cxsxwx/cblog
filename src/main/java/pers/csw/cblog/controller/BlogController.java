package pers.csw.cblog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.csw.cblog.controller.utils.R;
import pers.csw.cblog.dao.CLabelDao;
import pers.csw.cblog.model.vo.Bm;
import pers.csw.cblog.model.vo.CLabel;
import pers.csw.cblog.model.vo.Post;
import pers.csw.cblog.pojo.BlogPosts;
import pers.csw.cblog.pojo.Label;
import pers.csw.cblog.service.BlogPostsService;
import pers.csw.cblog.service.CategoryService;
import pers.csw.cblog.service.LabelService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author csw
 * @date 2022/3/5
 * @time 12:56
 */

@RestController
@CrossOrigin
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogPostsService postsService;
    @Autowired
    CLabelDao cLabelDao;
    @Autowired
    CategoryService categoryService;
    @Autowired
    LabelService labelService;

    @GetMapping("/getAllBlog")
    public R getAllBlog(){
        return new R(true,postsService.list(),"获取成功");
    }

    @GetMapping("/getBlog/{id}")
    public R getBlogById(@PathVariable Integer id){
        BlogPosts byId = postsService.getById(id);
        QueryWrapper<CLabel> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("blog_id",byId.getId());
        List<CLabel> cLabels = cLabelDao.selectList(queryWrapper);
        List<Label> label =new ArrayList<>();
        System.out.println(cLabels);
        cLabels.forEach((labelsId)->{
            Label byId1 = labelService.getById(labelsId.getLabelId());
            label.add(byId1);
        });
        System.out.println(label);
        return new R(true,new Post(byId,categoryService.getById(byId.getCategory()),label),"获取成功");
    }

    @PostMapping("/saveBlog")
    public R saveBlog(@RequestBody Bm blogPosts){
        System.out.println(blogPosts);
        blogPosts.getBlogPosts().setLove(0);
        blogPosts.getBlogPosts().setPview(0);
        BlogPosts ablogPosts = postsService.create(blogPosts.getBlogPosts());
        blogPosts.getMlabels().forEach((a)->{
            CLabel cLabel = new CLabel();
            cLabel.setBlogId(ablogPosts.getId());
            cLabel.setLabelId(a);
            cLabelDao.insert(cLabel);
        });
        return new R(true,ablogPosts,"添加成功");
    }

    @PutMapping("/updateBlog")
    public R updateBlog(@RequestBody Bm bm){
        System.out.println(bm);
        QueryWrapper<CLabel> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("blog_id",bm.blogPosts.getId());
        cLabelDao.delete(queryWrapper);
        bm.Mlabels.forEach((labels)->{
            CLabel cLabel = new CLabel();
            cLabel.setBlogId(bm.getBlogPosts().getId());
            cLabel.setLabelId(labels);
            cLabelDao.insert(cLabel);
        });
        bm.getBlogPosts().setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return new R(true,postsService.updateById(bm.getBlogPosts()),"修改成功");
    }

    @DeleteMapping("/deleteBlog/{id}")
    public R deleteBlogById(@PathVariable Integer id){
        QueryWrapper<CLabel> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("blog_id",id);
        int delete = cLabelDao.delete(queryWrapper);
        System.out.println(delete);
        return new R(true,postsService.removeById(id),"删除成功");
    }


    @GetMapping("{current}/{size}")
    public R getPage(@PathVariable Integer current , @PathVariable Integer size){
        IPage<BlogPosts> a=null;
        IPage<BlogPosts> page =new Page<>(current,size);
        a=postsService.page(page, null);
        if(current>page.getPages()){
            page =new Page<>(page.getPages(),size);
            a = postsService.page(page, null);
        }
        return new R(true,a);
    }


    @GetMapping("/updateGetById/{id}")
    public R getById(@PathVariable Integer id){
        BlogPosts byId = postsService.getById(id);
        QueryWrapper<CLabel> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("blog_id",byId.getId());
        List<CLabel> cLabels = cLabelDao.selectList(queryWrapper);
        Bm bm= new Bm();
        bm.setBlogPosts(byId);
        List<Integer>list =new ArrayList<>();
        cLabels.forEach((a)->list.add(a.getLabelId()));
        bm.setMlabels(list);
        System.out.println("文章属性"+byId);
        System.out.println("整体数据"+bm);
        return new R(true,bm,"获取成功");
    }


    @GetMapping("/labels/{id}")
    public R labelGetBlog(@PathVariable Integer id){
        QueryWrapper<CLabel> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("label_id",id);
        List<CLabel> cLabels = cLabelDao.selectList(queryWrapper);
        List<BlogPosts> blogPosts =new ArrayList<>();
        cLabels.forEach((labelId)->{
            blogPosts.add(postsService.getById(labelId.getBlogId()));
        });
        return new R(true,blogPosts,"获取成功");
    }


    @GetMapping("/category/{id}")
    public R categoryGetBlog(@PathVariable Integer id){
        QueryWrapper<BlogPosts> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("category",id);
        return new R(true,postsService.list(queryWrapper),"获取成功");
    }

}
