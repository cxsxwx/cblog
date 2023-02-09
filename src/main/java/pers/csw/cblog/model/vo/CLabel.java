package pers.csw.cblog.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.csw.cblog.pojo.Label;

import java.util.List;

/**
 * @author csw
 * @date 2022/3/9
 * @time 10:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CLabel {
    public CLabel(Integer labelId, Integer blogId) {
        this.labelId = labelId;
        this.blogId = blogId;
    }

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer labelId;
    private Integer blogId;


}
