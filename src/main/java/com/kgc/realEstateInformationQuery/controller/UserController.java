package com.kgc.realEstateInformationQuery.controller;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.kgc.realEstateInformationQuery.pojo.RealEstate;
import com.kgc.realEstateInformationQuery.pojo.Users;
import com.kgc.realEstateInformationQuery.service.RealEstateService;
import com.kgc.realEstateInformationQuery.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.naming.Name;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

@RequestMapping("users")
@Controller
public class UserController {

    @Resource
    UsersService usersService;
    @Resource
    RealEstateService realEstateService;

    @RequestMapping("login.do")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "verify.do",method = RequestMethod.POST,produces="text/html;charset=utf-8")
    @ResponseBody
    public String verify(Model model,@RequestParam("cardid") String cardid,@RequestParam("password") String password,HttpServletResponse response){
        Users users= usersService.selectUsers(cardid);
        if(users==null){
            return "<script>alert('该账号不存在，请先注册！');location.href='login.do';</script>";
        }else if(!users.getPassword().equals(password)){
            return "<script>alert('登录失败，身份证号或密码错误！');location.href='login.do';</script>";
        }else if(users.getStatus()==0){
            return "<script>alert('登录失败，该账号已被冻结！');location.href='login.do';</script>";
        }else{
            String username = users.getName();
            model.addAttribute("username",username);
            return "<script>alert('登录成功！');location.href='index.do?username="+username+"';</script>";
        }
    }

    @RequestMapping("index.do")
    public String index(Model model,@RequestParam(value = "username") String username){
        if(username!=null){
            model.addAttribute("username",username);
        }
        return "index";
    }

    @RequestMapping("register.do")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "addUsers.do",method = RequestMethod.POST,produces="text/html;charset=utf-8")
    @ResponseBody
    public String addUsers(@RequestParam("cardid") String cardid,@RequestParam("name") String name,@RequestParam("password") String password){
        int i =0;
        i=usersService.addUsers(cardid, name, password);
        if(i>0){
            return "<script>var result=confirm('注册已成功,现在去登陆吗？');if(result==true){location.href='login.do';}else{location.href='register.do';}</script>";
        }else{
            return "<script>alert('注册失败！');location.href='register.do';</script>";
        }
    }

    @RequestMapping(value = "show.do",method = RequestMethod.GET,produces="text/html;charset=utf-8")
    @ResponseBody
    public void show(@RequestParam(value = "cardid") String cardid,@RequestParam(value = "name") String name,@RequestParam(value = "pageNum") String pageNum,HttpServletResponse response){
        System.out.println("进入show.do");
//        response.setContentType("application/json;charset=utf-8");
        Integer dqy=1;
        if(pageNum.trim()!=null){
            dqy=Integer.parseInt(pageNum);
        }
        name=name.equals("null")||name.equals("")?"%%":"%"+name+"%";
        List<Users> usersList = usersService.getUsersList(name);
        Integer pageSize=5;//一页几条数据
        PageInfo<RealEstate> pageInfo =realEstateService.selectUsers(cardid,dqy,pageSize);
        List<RealEstate> list=new ArrayList<>();//创建对象的list集合
        for(int i=0;i<pageInfo.getList().size();i++){
            RealEstate realEstate=pageInfo.getList().get(i);
            list.add(realEstate);
        }
        System.out.println("name="+name);
        System.out.println("dqy="+dqy);
        System.out.println("cardid="+cardid);
        System.out.println(list.toString());
        String str = "{\"rlist\":" + JSON.toJSONString(list) +",\"pageInfo\":" + JSON.toJSONString(pageInfo) +",\"ulist\":"+JSON.toJSONString(usersList)+"}";
        System.out.println("str="+str);
        try {
            response.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
