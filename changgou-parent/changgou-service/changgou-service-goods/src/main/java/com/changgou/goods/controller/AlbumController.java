package com.changgou.goods.controller;

import com.changgou.common.pojo.Result;
import com.changgou.common.pojo.StatusCode;
import com.changgou.goods.api.pojo.TbAlbum;
import com.changgou.goods.service.AlbumService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("album")
@RestController
@CrossOrigin
public class AlbumController {
    @Autowired
    private AlbumService albumService;


    /***
     * Album分页条件搜索实现
     * @param album
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "分页条件查询Album")
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(
            @ApiParam(name = "album", value = "Album模型")@RequestBody(required = false) TbAlbum album,
            @ApiParam(name = "page", value = "当前页")@PathVariable  Integer page,
            @ApiParam(name = "size", value = "每页显示多少条")@PathVariable  Integer size){
        //执行搜索
        PageInfo<TbAlbum> pageInfo = albumService.findPage(album, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Album分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "分页查询Brand")
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(
            @ApiParam(name = "page", value = "当前页")@PathVariable  Integer page,
            @ApiParam(name = "size", value = "每页显示多少条")@PathVariable  Integer size
    ){
        //分页查询
        PageInfo<TbAlbum> pageInfo = albumService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param album
     * @return
     */
    @ApiOperation(value = "条件查询Album")
    @PostMapping(value = "/search" )
    public Result<List<TbAlbum>> findList(
            @ApiParam(name = "album", value = "Album模型")@RequestBody(required = false)  TbAlbum album
    ){
        List<TbAlbum> list = albumService.findList(album);
        return new Result<List<TbAlbum>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID删除Album")
    @ApiImplicitParam(name = "id", value = "相册id", required = true)
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        albumService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Album数据
     * @param album
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID修改Album")
    @PutMapping(value="/{id}",produces = "application/json")
    public Result update(
            @ApiParam(name = "album",value = "Album模型")@RequestBody  TbAlbum album,
            @ApiParam(name = "id",value = "AlbumId",required = true)@PathVariable Long id
    ){
        //设置主键值
        album.setId(id);
        //修改数据
        albumService.update(album);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Album数据
     * @param album
     * @return
     */
    @ApiOperation(value = "添加Album")
    @PostMapping(produces = "application/json")
    public Result add(@ApiParam(name = "album", value = "Album模型")@RequestBody TbAlbum album){
        albumService.add(album);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Album数据
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID查询Album")
    @ApiImplicitParam(name = "id", value = "相册id", required = true)
    @GetMapping("/{id}")
    public Result<TbAlbum> findById(@PathVariable Long id){
        //根据ID查询
        TbAlbum album = albumService.findById(id);
        return new Result<TbAlbum>(true,StatusCode.OK,"查询成功",album);
    }

    /***
     * 查询Album全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Album")
    @GetMapping
    public Result<TbAlbum> findAll(){
        List<TbAlbum> list = albumService.findAll();
        return new Result<TbAlbum>(true, StatusCode.OK,"查询成功",list) ;
    }

}
