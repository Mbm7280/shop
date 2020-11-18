package com.ex.service.impl;

import com.ex.common.base.CommandResult;
import com.ex.mapper.UmsMemberMapper;
import com.ex.model.UmsMember;
import com.ex.model.UmsMemberExample;
import com.ex.service.UmsMemberService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


/*
 * @Author maiBangMin
 * @Description [用户管理业务实现类]
 * @Date 10:45 下午 2020/11/18
 * @Version 1.0
 **/

public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private UmsMemberMapper memberMapper;

    /*
     * @Author maiBangMin
     * @Description 查询所有的用户
     * @Date 11:30 下午 2020/11/18
     * @Param []
     * @return com.ex.common.base.CommandResult<java.util.List<com.ex.model.UmsMember>>
     **/
    @Override
    public CommandResult<List<UmsMember>> queryAllMembers() {
        UmsMemberExample memberExample = new UmsMemberExample();
        memberExample.createCriteria().andStatusEqualTo(1);
        List<UmsMember> umsMembers = memberMapper.selectByExample(memberExample);
        if(CollectionUtils.isNotEmpty(umsMembers)){
            return CommandResult.success(umsMembers);
        }
        return CommandResult.failed();
    }

    /*
     * @Author maiBangMin
     * @Description 查询用户信息通过用户Id
     * @Date 11:32 下午 2020/11/18
     * @Param [memberId]
     * @return com.ex.common.base.CommandResult<com.ex.model.UmsMember>
     **/
    @Override
    public CommandResult<UmsMember> queryMemberInfoBymemberId(Long memberId) {
        if(null != memberId){
            UmsMemberExample memberExample = new UmsMemberExample();
            memberExample.createCriteria().andIdEqualTo(memberId);
            List<UmsMember> umsMemberList = memberMapper.selectByExample(memberExample);
            if(CollectionUtils.isNotEmpty(umsMemberList)){
                return CommandResult.success(umsMemberList.get(0));
            }
        }
        return CommandResult.failed();
    }

    /*
     * @Author maiBangMin
     * @Description 新增用户
     * @Date 11:37 下午 2020/11/18
     * @Param [member]
     * @return com.ex.common.base.CommandResult
     **/
    @Override
    public CommandResult insertMember(UmsMember member) {
        if(null != member){
            member.setCreateTime(new Date());
            member.setStatus(1);
            int i = memberMapper.insertSelective(member);
            if(i == 0){
                return CommandResult.success();
            }
        }
        return CommandResult.failed();
    }

    /*
     * @Author maiBangMin
     * @Description 修改用户信息
     * @Date 11:38 下午 2020/11/18
     * @Param [member]
     * @return com.ex.common.base.CommandResult
     **/
    @Override
    public CommandResult updateMember(UmsMember member) {
        if(null != member){
            int i = memberMapper.updateByPrimaryKey(member);
            if(i > 0){
                return CommandResult.success();
            }
        }
        return CommandResult.failed();
    }

    /*
     * @Author maiBangMin
     * @Description 删除用户
     * @Date 11:42 下午 2020/11/18
     * @Param [memberId]
     * @return com.ex.common.base.CommandResult
     **/
    @Override
    public CommandResult delMember(Long memberId) {
        if(null != memberId){
            UmsMemberExample memberExample = new UmsMemberExample();
            memberExample.createCriteria().andIdEqualTo(memberId).andStatusEqualTo(1);
            List<UmsMember> umsMemberList = memberMapper.selectByExample(memberExample);
            if(CollectionUtils.isNotEmpty(umsMemberList)) {
                int i = memberMapper.deleteByPrimaryKey(memberId);
                if(i == 1){
                    return CommandResult.success();
                }
            }
        }
        return CommandResult.failed();
    }


}
