package com.test.mink.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.mink.model.Dummy;

@Mapper
public interface DummyMapper {
	List<Dummy> selectDummyList();
}
