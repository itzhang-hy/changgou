package com.changgou.goods.api.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "undo_log")
public class UndoLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "branch_id")
    private Long branchId;

    private String xid;

    @Column(name = "log_status")
    private Integer logStatus;

    @Column(name = "log_created")
    private Date logCreated;

    @Column(name = "log_modified")
    private Date logModified;

    private String ext;

    @Column(name = "rollback_info")
    private byte[] rollbackInfo;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return branch_id
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * @param branchId
     */
    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    /**
     * @return xid
     */
    public String getXid() {
        return xid;
    }

    /**
     * @param xid
     */
    public void setXid(String xid) {
        this.xid = xid;
    }

    /**
     * @return log_status
     */
    public Integer getLogStatus() {
        return logStatus;
    }

    /**
     * @param logStatus
     */
    public void setLogStatus(Integer logStatus) {
        this.logStatus = logStatus;
    }

    /**
     * @return log_created
     */
    public Date getLogCreated() {
        return logCreated;
    }

    /**
     * @param logCreated
     */
    public void setLogCreated(Date logCreated) {
        this.logCreated = logCreated;
    }

    /**
     * @return log_modified
     */
    public Date getLogModified() {
        return logModified;
    }

    /**
     * @param logModified
     */
    public void setLogModified(Date logModified) {
        this.logModified = logModified;
    }

    /**
     * @return ext
     */
    public String getExt() {
        return ext;
    }

    /**
     * @param ext
     */
    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * @return rollback_info
     */
    public byte[] getRollbackInfo() {
        return rollbackInfo;
    }

    /**
     * @param rollbackInfo
     */
    public void setRollbackInfo(byte[] rollbackInfo) {
        this.rollbackInfo = rollbackInfo;
    }
}