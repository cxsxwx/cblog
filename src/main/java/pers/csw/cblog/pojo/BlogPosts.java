package pers.csw.cblog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author csw
 * @date 2022/3/5
 * @time 12:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPosts {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String author;
    private String title;
    private String content;
    private Integer love;
    private String postedTime;
    private String updateTime;
    private Integer pview;
    private Integer category;
    private String mfile;
    private String intro;
    private String img;
}
