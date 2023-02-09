package pers.csw.cblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.csw.cblog.pojo.Category;

/**
 * @author csw
 * @date 2022/3/5
 * @time 12:26
 */
@Mapper
public interface CategoryDao extends BaseMapper<Category> {
}
