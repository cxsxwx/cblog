package pers.csw.cblog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author csw
 * @date 2022/3/5
 * @time 12:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Label {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
}
