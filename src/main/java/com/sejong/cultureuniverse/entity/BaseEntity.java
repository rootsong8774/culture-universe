package com.sejong.cultureuniverse.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;

    @PrePersist
    public void prePersist() {
        this.regDate = LocalDateTime.now();
        this.modDate = LocalDateTime.now();

    }

    @PreUpdate
    public void preUpdate() {
        this.modDate = LocalDateTime.now();
    }
}
