package pers.csw.cblog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author csw
 * @date 2022/3/5
 * @time 12:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorAndAdmin {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String phone;
    private String information;
}
