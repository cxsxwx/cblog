package pers.csw.cblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.csw.cblog.dao.LabelDao;
import pers.csw.cblog.pojo.Label;
import pers.csw.cblog.service.LabelService;

/**
 * @author csw
 * @date 2022/3/5
 * @time 12:35
 */
@Service
public class LabelServiceImpl extends ServiceImpl<LabelDao, Label> implements LabelService {
}
