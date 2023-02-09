package pers.csw.cblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.csw.cblog.dao.AuthorAndAdminDao;
import pers.csw.cblog.pojo.AuthorAndAdmin;
import pers.csw.cblog.service.AuthorAndAdminService;

/**
 * @author csw
 * @date 2022/3/5
 * @time 12:32
 */
@Service
public class AuthorAndAdminServiceImpl extends ServiceImpl<AuthorAndAdminDao, AuthorAndAdmin> implements AuthorAndAdminService {
}
