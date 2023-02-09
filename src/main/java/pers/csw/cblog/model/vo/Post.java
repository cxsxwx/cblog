package pers.csw.cblog.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.csw.cblog.pojo.BlogPosts;
import pers.csw.cblog.pojo.Category;
import pers.csw.cblog.pojo.Label;

import java.util.List;

/**
 * @author csw
 * @date 2022/3/13
 * @time 21:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private BlogPosts blogPosts;
    private Category category;
    private List<Label> list;
}
