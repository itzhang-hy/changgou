package com.changgou.goods.controller;


import com.changgou.common.pojo.Result;
import com.changgou.common.pojo.StatusCode;
import com.changgou.goods.api.pojo.TbSpec;
import com.changgou.goods.service.SpecService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spec")
@CrossOrigin //开启跨域请求
public class SpecController {

    @Autowired
    private SpecService specService;

    /***
     * Spec分页条件搜索实现
     * @param spec
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(
            @RequestBody(required = false)  TbSpec spec,
            @PathVariable  Integer page,
            @PathVariable  Integer size){
        //执行搜索
        PageInfo<TbSpec> pageInfo = specService.findPage(spec, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Spec分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(
            @PathVariable  Integer page,
            @PathVariable  Integer size
    ){
        //分页查询
        PageInfo<TbSpec> pageInfo = specService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param spec
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<TbSpec>> findList(
            @RequestBody(required = false)  TbSpec spec
    ){
        List<TbSpec> list = specService.findList(spec);
        return new Result<List<TbSpec>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(
            @PathVariable Integer id
    ){
        specService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Spec数据
     * @param spec
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(
            @RequestBody TbSpec spec,
            @PathVariable Integer id
    ){
        //设置主键值
        spec.setId(id);
        //修改数据
        specService.update(spec);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Spec数据
     * @param spec
     * @return
     */
    @PostMapping
    public Result add(
            @RequestBody TbSpec spec
    ){
        specService.add(spec);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Spec数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<TbSpec> findById(
            @PathVariable Integer id
    ){
        //根据ID查询
        TbSpec spec = specService.findById(id);
        return new Result<TbSpec>(true,StatusCode.OK,"查询成功",spec);
    }

    /***
     * 查询Spec全部数据
     * @return
     */
    @GetMapping
    public Result<TbSpec> findAll(){
        List<TbSpec> list = specService.findAll();
        return new Result<TbSpec>(true, StatusCode.OK,"查询成功",list) ;
    }
}
