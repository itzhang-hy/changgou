package com.changgou.goods.controller;


import com.changgou.common.pojo.Result;
import com.changgou.common.pojo.StatusCode;
import com.changgou.goods.api.pojo.TbTemplate;
import com.changgou.goods.service.TemplateService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("template")
@RestController
@CrossOrigin
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    /***
     * Template分页条件搜索实现
     * @param template
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(
            @RequestBody(required = false)  TbTemplate template,
            @PathVariable  Integer page, @PathVariable  Integer size
    ){
        //执行搜索
        PageInfo<TbTemplate> pageInfo = templateService.findPage(template, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Template分页搜索实现
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
        PageInfo<TbTemplate> pageInfo = templateService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param template
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<TbTemplate>> findList(
            @RequestBody(required = false)  TbTemplate template
    ){
        List<TbTemplate> list = templateService.findList(template);
        return new Result<List<TbTemplate>>(true,StatusCode.OK,"查询成功",list);
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
        templateService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Template数据
     * @param template
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(
            @RequestBody TbTemplate template,
            @PathVariable Integer id
    ){
        //设置主键值
        template.setId(id);
        //修改数据
        templateService.update(template);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Template数据
     * @param template
     * @return
     */
    @PostMapping
    public Result add(
            @RequestBody TbTemplate template
    ){
        templateService.add(template);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Template数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<TbTemplate> findById(
            @PathVariable Integer id
    ){
        //根据ID查询
        TbTemplate template = templateService.findById(id);
        return new Result<TbTemplate>(true, StatusCode.OK,"查询成功",template);
    }

    /***
     * 查询Template全部数据
     * @return
     */
    @GetMapping
    public Result<TbTemplate> findAll(){
        List<TbTemplate> list = templateService.findAll();
        return new Result<TbTemplate>(true, StatusCode.OK,"查询成功",list) ;
    }
}
