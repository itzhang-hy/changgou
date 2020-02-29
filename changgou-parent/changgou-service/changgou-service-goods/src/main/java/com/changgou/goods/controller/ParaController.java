package com.changgou.goods.controller;

import com.changgou.common.pojo.Result;
import com.changgou.common.pojo.StatusCode;
import com.changgou.goods.api.pojo.TbPara;
import com.changgou.goods.service.ParaService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("para")
@RestController
@CrossOrigin
public class ParaController {

    @Autowired
    private ParaService paraService;

    /***
     * Para分页条件搜索实现
     * @param para
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(
            @RequestBody(required = false) TbPara para,
            @PathVariable  Integer page,
            @PathVariable  Integer size){
        //执行搜索
        PageInfo<TbPara> pageInfo = paraService.findPage(para, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Para分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(
            @PathVariable  Integer page,
            @PathVariable  Integer size){
        //分页查询
        PageInfo<TbPara> pageInfo = paraService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param para
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<TbPara>> findList(
            @RequestBody(required = false)  TbPara para
    ){
        List<TbPara> list = paraService.findList(para);
        return new Result<List<TbPara>>(true,StatusCode.OK,"查询成功",list);
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
        paraService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Para数据
     * @param para
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(
            @RequestBody  TbPara para,
            @PathVariable Integer id
    ){
        //设置主键值
        para.setId(id);
        //修改数据
        paraService.update(para);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Para数据
     * @param para
     * @return
     */
    @PostMapping
    public Result add(
            @RequestBody  TbPara para
    ){
        paraService.add(para);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Para数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<TbPara> findById(
            @PathVariable Integer id
    ){
        //根据ID查询
        TbPara para = paraService.findById(id);
        return new Result<TbPara>(true,StatusCode.OK,"查询成功",para);
    }

    /***
     * 查询Para全部数据
     * @return
     */
    @GetMapping
    public Result<TbPara> findAll(){
        List<TbPara> list = paraService.findAll();
        return new Result<TbPara>(true, StatusCode.OK,"查询成功",list) ;
    }
}
