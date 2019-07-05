package com.example.naillashes.entity.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.MappedSuperclass;

/**
 * Created by rajeevkumarsingh on 19/08/17.
 */

@MappedSuperclass
@JsonIgnoreProperties(
        value = {"createdBy"},
        allowGetters = true
)
public abstract class UserDateAudit extends DateAudit {

    @CreatedBy
    private Long createdBy;
//
//    private Long updatedBy;
//    @LastModifiedBy

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

}
