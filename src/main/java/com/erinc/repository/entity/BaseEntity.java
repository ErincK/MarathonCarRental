package com.erinc.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {
    Long createdate;
    Long updatedate;
    @Enumerated(EnumType.STRING)
    EntityState state;
}
