package com.changgou.goods.controller;

import com.changgou.common.pojo.Result;
import com.changgou.common.pojo.StatusCode;
import com.changgou.goods.api.pojo.TbBrand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("brand")
@CrossOrigin //开启跨域请求
public class BrandController {

    @Autowired
    private BrandService brandService;

    /***
     * 分页搜索实现
     * @param tbBrand
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "分页条件查询Brand")
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(
            @ApiParam(name = "tbBrand", value = "Brand模型")@RequestBody(required = false) TbBrand tbBrand,
            @ApiParam(name = "page", value = "当前页")@PathVariable  Integer page,
            @ApiParam(name = "size", value = "每页显示多少条")@PathVariable  Integer size
    ){
        //执行搜索
        PageInfo<TbBrand> pageInfo = brandService.findPage(tbBrand, page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "分页查询Brand")
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(
            @ApiParam(name = "page", value = "当前页")@PathVariable Integer page,
            @ApiParam(name = "size", value = "每页显示多少条")@PathVariable Integer size){
        //分页查询
        PageInfo<TbBrand> pageInfo = brandService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }


    /***
     * 条件查询
     * @param tbBrand
     * @return
     */
    @ApiOperation(value = "条件查询Brand")
    @PostMapping(value = "search",produces = "application/json")
    public Result<List<TbBrand>> findList(@ApiParam(name = "tbBrand", value = "brand模型")@RequestBody TbBrand tbBrand){
        List<TbBrand> brands = brandService.findList(tbBrand);
        if(brands != null) {
            return new Result<List<TbBrand>>(true, StatusCode.OK, "条件查询品牌成功！", brands);
        }else {
            return new Result<List<TbBrand>>(false, StatusCode.ERROR, "条件查询品牌失败！");
        }
    }

    /***
     * 根据ID删除Brand
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID删除Brand")
    @ApiImplicitParam(name = "id", value = "品牌id", required = true)
    @DeleteMapping("{id}")
    public Result delete(@PathVariable("id")Integer id){
        Boolean delete = brandService.delete(id);
        if(delete){
            return new Result(delete, StatusCode.OK,"删除Brand成功！");
        }else {
            return new Result(delete, StatusCode.ERROR, "删除Brand失败！");
        }
    }
    /**
     * 根据ID修改Brand
     * @param id
     * @param tbBrand
     * @return
     */
    /*@ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "品牌Id",required = true),
            @ApiImplicitParam(name = "tbBrand", value = "brand模型")
    })*/
    @ApiOperation(value = "根据ID修改Brand")
    @PutMapping(value = "{id}",produces = "application/json")
    public Result update (
            @ApiParam(name = "id",value = "BrandId",required = true) @PathVariable("id")Integer id,
            @ApiParam(name = "tbBrand",value = "Brand模型")@RequestBody TbBrand tbBrand
    ){
        tbBrand.setId(id);
        Boolean update = brandService.update(tbBrand);
        if(update){
            return new Result(update, StatusCode.OK,"修改Brand成功！");
        }else {
            return new Result(update, StatusCode.ERROR, "修改Brand失败！");
        }
    }

    /**
     * 添加Brand
     * @param tbBrand
     * @return
     */

    //@ApiImplicitParam(name = "tbBrand", value = "brand模型")
    @ApiOperation(value = "添加Brand")
    @PostMapping(produces = "application/json")
    public Result add(@ApiParam(name = "tbBrand", value = "brand模型")@RequestBody TbBrand tbBrand){
        Boolean add = brandService.add(tbBrand);
        if(add){
            return new Result(add, StatusCode.OK,"添加Brand成功！");
        }else {
            return new Result(add, StatusCode.ERROR, "添加Brand失败！");
        }
    }
    /**
     * 根据ID查询单个品牌
     * @param brandId
     * @return
     */
    @ApiOperation(value = "根据ID查询Brand")
    @ApiImplicitParam(name = "id", value = "品牌id", required = true)
    @GetMapping("{id}")
    public Result<TbBrand> findById(@PathVariable("id")Integer brandId){
        TbBrand brand = brandService.fingById(brandId);
        //响应结果封装
        if(brand != null) {
            return new Result<TbBrand>(true, StatusCode.OK, "根据品牌ID查询成功！", brand);
        }else {
            return new Result<TbBrand>(false, StatusCode.ERROR, "根据品牌ID查询失败！");
        }
    }

    /**
     * 查询所有品牌
     * @return
     */
    @ApiOperation(value = "查询所有Brand")
    @GetMapping
    public Result<List<TbBrand>> findAll(){

        List<TbBrand> brands = brandService.findAll();
        //响应结果封装
        if(brands != null) {
            return new Result<List<TbBrand>>(true, StatusCode.OK, "查询所有品牌成功！", brands);
        }else {
            return new Result<List<TbBrand>>(false, StatusCode.ERROR, "查询所有品牌失败！");
        }
    }

}
