package com.app.springapp.mapper;

import com.app.springapp.domain.vo.FollowVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowMapper {
    public void insert(FollowVO followVO);
}
