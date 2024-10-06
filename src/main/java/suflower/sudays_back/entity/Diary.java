package suflower.sudays_back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import suflower.sudays_back.constant.ConditionConstants;
import suflower.sudays_back.constant.StatusConstant;
import suflower.sudays_back.constant.converter.ConditionAttributeConverter;
import suflower.sudays_back.constant.converter.StatusAttributeConverter;
import suflower.sudays_back.util.DateUtils;

@Entity
@Table(name = "diary")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

//    @ManyToOne
//    @JoinColumn(name = "member_id", nullable = false)
//    private Member member;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "content", length = 10000, nullable = false)
    private String content;

    @Convert(converter = ConditionAttributeConverter.class)
    @Column(name = "condition", length = 2, nullable = false)
    private ConditionConstants condition;

    @Convert(converter = StatusAttributeConverter.class)
    @Column(name = "status", length = 2, nullable = false)
    private StatusConstant status;

    @Column(name = "created_at", length = 19, nullable = false)
    private String createdAt;

    @Column(name = "updated_at", length = 19)
    private String updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = DateUtils.nowToString();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = DateUtils.nowToString();
    }
}
