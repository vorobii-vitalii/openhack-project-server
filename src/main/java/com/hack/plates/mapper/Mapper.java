package com.hack.plates.mapper;

public interface Mapper <I, J> {

    I from(J j);

    J to(I i);

}
