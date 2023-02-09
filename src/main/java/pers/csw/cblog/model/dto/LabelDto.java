package pers.csw.cblog.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author csw
 * @date 2022/3/9
 * @time 13:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabelDto {
    private Integer id;
    private String name;
}
