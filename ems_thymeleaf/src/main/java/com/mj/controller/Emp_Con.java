package com.mj.controller;

import com.mj.dao.EmpDao;
import com.mj.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class Emp_Con {
    @Autowired
    private EmpDao empDao;
    private String jn;

    @RequestMapping("delete")
    String s1(String name){
        empDao.delete(name);
        return "redirect:empL";
    }

    @RequestMapping("alter")
    String s2(String name){
        jn = name;
        return "redirect:ppp";
    }

    @RequestMapping("ppp")
    String ppp(Model model){
        model.addAttribute("emp",empDao.alter(jn));
        return "updateEmp";
    }

    @RequestMapping("upData")
    String s3(Emp emp){
        empDao.upData(emp,jn);
        return "redirect:empL";
    }

    @RequestMapping("toSave")
    String s4(Emp emp){
        empDao.toSave(emp);
        return "redirect:empL";
    }
}
