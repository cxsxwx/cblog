package pers.csw.cblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.csw.cblog.dao.CategoryDao;
import pers.csw.cblog.pojo.Category;
import pers.csw.cblog.service.CategoryService;

/**
 * @author csw
 * @date 2022/3/5
 * @time 12:34
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {
}
