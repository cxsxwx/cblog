package pers.csw.cblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.csw.cblog.model.vo.CLabel;

/**
 * @author csw
 * @date 2022/3/9
 * @time 10:26
 */
@Mapper
public interface CLabelDao extends BaseMapper<CLabel> {
}
