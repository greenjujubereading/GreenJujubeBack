package com.bupt.qingzaoreading.po;

import javax.persistence.*;

public class Admin {
    /**
     * 管理员id
     */
    @Id
    @Column(name = "admin_id")
    private String adminId;

    /**
     * 管理员密码
     */
    @Column(name = "admin_password")
    private String adminPassword;

    /**
     * 获取管理员id
     *
     * @return admin_id - 管理员id
     */
    public String getAdminId() {
        return adminId;
    }

    /**
     * 设置管理员id
     *
     * @param adminId 管理员id
     */
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取管理员密码
     *
     * @return admin_password - 管理员密码
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * 设置管理员密码
     *
     * @param adminPassword 管理员密码
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}