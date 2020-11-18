package com.ex.service;

import com.ex.common.base.CommandResult;
import com.ex.model.UmsMember;
import org.springframework.stereotype.Service;

import java.util.List;


/*
 * @Author maiBangMin
 * @Description [用户管理业务接口]
 * @Date 10:45 下午 2020/11/18
 * @Version 1.0
 **/

@Service
public interface UmsMemberService {


    /*
     * @Author maiBangMin
     * @Description [查询所有的用户]
     * @Date 10:48 下午 2020/11/18
     * @Version 1.0
     **/
    CommandResult<List<UmsMember>> queryAllMembers();
    
    
    /*
     * @Author maiBangMin
     * @Description [查询用户信息通过用户Id]
     * @Date 11:20 下午 2020/11/18
     * @Version 1.0
     **/
    CommandResult<UmsMember> queryMemberInfoBymemberId(Long memberId);
    
    
    /*
     * @Author maiBangMin
     * @Description [新增用户]
     * @Date 11:09 下午 2020/11/18
     * @Version 1.0
     **/
    CommandResult insertMember(UmsMember member);


    
    /*
     * @Author maiBangMin
     * @Description [修改用户信息]
     * @Date 11:09 下午 2020/11/18
     * @Version 1.0
     **/
    CommandResult updateMember(UmsMember member);

    
    
    /*
     * @Author maiBangMin
     * @Description [删除用户]
     * @Date 11:09 下午 2020/11/18
     * @Version 1.0
     **/
    CommandResult delMember(Long memberId);

}
