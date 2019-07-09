package com.bjx.consumer.entity;

import javax.persistence.*;

@Entity
@Table(name = "attention")
public class Attention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 关注用户ID
     */
    @Column(nullable = false, name = "user_id")
    private Long userId;
    /**
     * 自己ID
     */
    @Column(nullable = false, name = "own_id")
    private Long ownId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOwnId() {
        return ownId;
    }

    public void setOwnId(Long ownId) {
        this.ownId = ownId;
    }
}
