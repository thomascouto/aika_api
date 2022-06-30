package com.aika.backend.api.base;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseClass implements Serializable {

    @Id
    protected UUID id;
}
