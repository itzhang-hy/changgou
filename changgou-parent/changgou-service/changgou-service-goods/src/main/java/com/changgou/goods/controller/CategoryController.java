package com.changgou.goods.controller;

import com.changgou.common.pojo.Result;
import com.changgou.common.pojo.StatusCode;
import com.changgou.goods.api.pojo.TbCategory;
import com.changgou.goods.service.CategoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin
public class CategoryController {
 
    @Autowired
    private CategoryService categoryService;
 
    /***
     * Category分页条件搜索实现
     * @param category
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(
            @RequestBody(required = false) TbCategory category,
            @PathVariable  Integer page,
            @PathVariable  Integer size
    ){
        //执行搜索
        PageInfo<TbCategory> pageInfo = categoryService.findPage(category, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }
 
    /***
     * Category分页搜索实现
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
        PageInfo<TbCategory> pageInfo = categoryService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }
 
    /***
     * 多条件搜索品牌数据
     * @param category
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<TbCategory>> findList(
            @RequestBody(required = false)  TbCategory category
    ){
        List<TbCategory> list = categoryService.findList(category);
        return new Result<List<TbCategory>>(true,StatusCode.OK,"查询成功",list);
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
        categoryService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
 
    /***
     * 修改Category数据
     * @param category
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(
            @RequestBody TbCategory category,
            @PathVariable Integer id
    ){
        //设置主键值
        category.setId(id);
        //修改数据
        categoryService.update(category);
        return new Result(true,StatusCode.OK,"修改成功");
    }
 
    /***
     * 新增Category数据
     * @param category
     * @return
     */
    @PostMapping
    public Result add(
            @RequestBody TbCategory category
    ){
        categoryService.add(category);
        return new Result(true,StatusCode.OK,"添加成功");
    }
 
    /***
     * 根据ID查询Category数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<TbCategory> findById(
            @PathVariable Integer id
    ){
        //根据ID查询
        TbCategory category = categoryService.findById(id);
        return new Result<TbCategory>(true,StatusCode.OK,"查询成功",category);
    }
 
    /***
     * 查询Category全部数据
     * @return
     */
    @GetMapping
    public Result<TbCategory> findAll(){
        List<TbCategory> list = categoryService.findAll();
        return new Result<TbCategory>(true, StatusCode.OK,"查询成功",list) ;
    }
 
    /**
     * 根据父ID查询
     */
    @RequestMapping(value ="/list/{pid}")
    public Result<TbCategory> findByPrantId(
            @PathVariable(value = "pid")Integer pid
    ){
        //根据父节点ID查询
        List<TbCategory> list = categoryService.findByParentId(pid);
        return new Result<TbCategory>(true,StatusCode.OK,"查询成功",list);
    }
}