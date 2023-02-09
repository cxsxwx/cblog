package pers.csw.cblog.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.csw.cblog.pojo.BlogPosts;

import java.util.List;

/**
 * @author csw
 * @date 2022/3/9
 * @time 14:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bm {
    public BlogPosts blogPosts;
    public List<Integer> Mlabels;
}
