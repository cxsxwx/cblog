package pers.csw.cblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.csw.cblog.controller.utils.R;
import pers.csw.cblog.pojo.Label;
import pers.csw.cblog.service.LabelService;

/**
 * @author csw
 * @date 2022/3/8
 * @time 13:36
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {
    @Autowired
    LabelService labelService;

    @GetMapping("/getAll")
    public R getAll(){
        return new R(true,labelService.list(),"获取成功");
    }

    @GetMapping("/getById/{id}")
    public R getById(@PathVariable int id){
        return new R(true,labelService.getById(id));
    }

    @PostMapping("/saveLabel")
    public R saveLabel(@RequestBody  Label mlabel){
        System.out.println(mlabel.getName());
        return new R(true,labelService.save(mlabel));
    }

    @DeleteMapping("/DeleteLabel/{id}")
    public R DeleteLabel(@PathVariable Integer id){
        return new R(true,labelService.removeById(id));
    }

    @PutMapping("/updateLabel")
    public R updateLabel(Label label){
        return new R(true,labelService.updateById(label));
    }
}
