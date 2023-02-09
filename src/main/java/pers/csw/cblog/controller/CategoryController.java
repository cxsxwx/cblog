package pers.csw.cblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.csw.cblog.controller.utils.R;
import pers.csw.cblog.pojo.Category;
import pers.csw.cblog.service.CategoryService;

/**
 * @author csw
 * @date 2022/3/8
 * @time 17:03
 */
@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAll")
    public R getAll(){
        return new R(true,categoryService.list(),"获取成功");
    }

    @GetMapping("/getById/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,categoryService.getById(id));
    }

    @PostMapping("/saveCategory")
    public R saveCategory(@RequestBody Category category){
        return new R(true,categoryService.save(category));
    }

    @PutMapping("/updateCategory")
    public R updateCategory(Category category){
        return new R(true,categoryService.updateById(category));
    }

    @DeleteMapping("/deleteCategory/{id}")
    public R deleteCategory(@PathVariable Integer id){
        return new R(true,categoryService.removeById(id));
    }

}
