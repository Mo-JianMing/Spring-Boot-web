package com.mj.controller;

import com.mj.dao.EmpDao;
import com.mj.dao.UserDao;
import com.mj.entity.User;
import com.mj.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@Controller
public class Test_01 {
    @Autowired
    private UserDao userDao;
    @Autowired
    private EmpDao empDao;

    private String code,id;

    //登陆页面
    @RequestMapping("/")
    String s1(){
        return "login";
    }

    //注册页面
    @RequestMapping("toRegister")
    String s2(){
        return "regist";
    }

    //生成验证码
    @RequestMapping("code")
    void s3(HttpSession session, HttpServletResponse response) throws IOException {
        code = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(code);
        session.setAttribute("code",code);
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image,"png",os);
    }

    //ajax验证码
    @RequestMapping("aCode")
    @ResponseBody
    String s4(){
        return code;
    }

    //ajax用户
    @RequestMapping("aUser")
    @ResponseBody
    List<User> S5(){
        return userDao.select();
    }

    //保存注册用户
    @RequestMapping("save")
    String s6(User user){
        userDao.save(user);
        return "redirect:/";
    }

    //通过用户名找到ID
    @RequestMapping("sid")
    String s7(String name){
        id = userDao.sId(name);
        return "redirect:empL";
    }

    //通过ID找到员工表
    @RequestMapping("empL")
    String s8(Model model){
        model.addAttribute("emps",empDao.select(id));
        return "emplist";
    }

    @RequestMapping("toAdd")
    String s9(Model model){
        model.addAttribute("id",id);
        return "addEmp";
    }
}
