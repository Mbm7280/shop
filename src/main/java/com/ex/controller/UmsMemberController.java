package com.ex.controller;


/*
 * @Author maiBangMin
 * @Description [用户管理控制层]
 * @Date 11:48 下午 2020/11/18
 * @Version 1.0
 **/

import com.ex.common.base.CommandResult;
import com.ex.model.UmsMember;
import com.ex.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/shop")
public class UmsMemberController {


    @Autowired
    private UmsMemberService memberService;


    /*
     * @Author maiBangMin
     * @Description [查询所有的用户]
     * @Date 11:55 下午 2020/11/18
     * @Version 1.0
     **/
    @GetMapping("/queryAllMembers")
    public CommandResult<List<UmsMember>> queryAllMembers(){
        return memberService.queryAllMembers();
    }


    /*
     * @Author maiBangMin
     * @Description [查询用户信息通过用户Id]
     * @Date 11:55 下午 2020/11/18
     * @Version 1.0
     **/
    @GetMapping("/queryMemberInfoBymemberId")
    public CommandResult<UmsMember> queryMemberInfoBymemberId(@RequestParam Long memberId){
        return memberService.queryMemberInfoBymemberId(memberId);
    }


    /*
     * @Author maiBangMin
     * @Description [新增用户]
     * @Date 11:55 下午 2020/11/18
     * @Version 1.0
     **/
    @PostMapping("/insertMember")
    public CommandResult insertMember(@RequestBody UmsMember member){
        return memberService.insertMember(member);
    }


    /*
     * @Author maiBangMin
     * @Description [修改用户信息]
     * @Date 11:55 下午 2020/11/18
     * @Version 1.0
     **/
    @PostMapping("/updateMember")
    public CommandResult updateMember(@RequestBody UmsMember member){
        return memberService.updateMember(member);
    }


    /*
     * @Author maiBangMin
     * @Description [删除用户]
     * @Date 11:55 下午 2020/11/18
     * @Version 1.0
     **/
    @DeleteMapping("/delMember")
    public CommandResult delMember(@RequestParam Long memberId){
        return memberService.delMember(memberId);
    }
}
