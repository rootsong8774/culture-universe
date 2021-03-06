package com.sejong.cultureuniverse.entity.event;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import com.sejong.cultureuniverse.entity.admin.Admin;
import com.sejong.cultureuniverse.entity.BaseEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

@SuperBuilder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "event_seq", sequenceName = "event_seq", initialValue = 1, allocationSize = 1)
public class EventBoard extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    private Long eventIdx;
    private String eventTitle;
    
    @Lob
    private String eventContent;
    private Long readCount;
    
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "admin_idx")
    private Admin admin;

    @OneToMany(mappedBy = "eventBoard", fetch = LAZY, cascade = CascadeType.ALL)
    private List<EventComment> comments;
    
    public void changeTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }
    
    public void changeContent(String eventContent) {
        this.eventContent = eventContent;
    }
}
    

