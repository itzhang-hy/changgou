package com.changgou.goods.service;

import com.changgou.goods.api.mapper.TbAlbumMapper;
import com.changgou.goods.api.pojo.TbAlbum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private TbAlbumMapper albumMapper;


    /**
     * Album条件+分页查询
     * @param album 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    public PageInfo<TbAlbum> findPage(TbAlbum album, Integer page, Integer size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(album);
        //执行搜索
        return new PageInfo<TbAlbum>(albumMapper.selectByExample(example));
    }

    /**
     * Album分页查询
     * @param page
     * @param size
     * @return
     */
    public PageInfo<TbAlbum> findPage(Integer page, Integer size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<TbAlbum>(albumMapper.selectAll());
    }

    /**
     * Album条件查询
     * @param album
     * @return
     */
    public List<TbAlbum> findList(TbAlbum album){
        //构建查询条件
        Example example = createExample(album);
        //根据构建的条件查询数据
        return albumMapper.selectByExample(example);
    }


    /**
     * Album构建查询对象
     * @param album
     * @return
     */
    public Example createExample(TbAlbum album){
        Example example=new Example(TbAlbum.class);
        Example.Criteria criteria = example.createCriteria();
        if(album!=null){
            // 编号
            if(album.getId() != null){
                criteria.andEqualTo("id",album.getId());
            }
            // 相册名称
            if(!StringUtils.isEmpty(album.getTitle())){
                criteria.andLike("title","%"+album.getTitle()+"%");
            }
            // 相册封面
            if(!StringUtils.isEmpty(album.getImage())){
                criteria.andEqualTo("image",album.getImage());
            }
            // 图片列表
            if(!StringUtils.isEmpty(album.getImageItems())){
                criteria.andEqualTo("imageItems",album.getImageItems());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id){
        albumMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Album
     * @param album
     */
    public void update(TbAlbum album){
        albumMapper.updateByPrimaryKey(album);
    }

    /**
     * 增加Album
     * @param album
     */
    public void add(TbAlbum album){
        albumMapper.insert(album);
    }

    /**
     * 根据ID查询Album
     * @param id
     * @return
     */
    public TbAlbum findById(Long id){
        return  albumMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Album全部数据
     * @return
     */
    public List<TbAlbum> findAll() {
        return albumMapper.selectAll();
    }
}
