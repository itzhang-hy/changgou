package com.changgou.goods.api.pojo;

import javax.persistence.*;

@Table(name = "tb_album")
public class TbAlbum {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 相册名称
     */
    private String title;

    /**
     * 相册封面
     */
    private String image;

    /**
     * 图片列表
     */
    @Column(name = "image_items")
    private String imageItems;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取相册名称
     *
     * @return title - 相册名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置相册名称
     *
     * @param title 相册名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取相册封面
     *
     * @return image - 相册封面
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置相册封面
     *
     * @param image 相册封面
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取图片列表
     *
     * @return image_items - 图片列表
     */
    public String getImageItems() {
        return imageItems;
    }

    /**
     * 设置图片列表
     *
     * @param imageItems 图片列表
     */
    public void setImageItems(String imageItems) {
        this.imageItems = imageItems;
    }
}