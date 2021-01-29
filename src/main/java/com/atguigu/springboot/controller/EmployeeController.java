package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import com.atguigu.springboot.exception.UserException;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        //模板引擎
        Collection<Employee> lists = employeeDao.getAll();
        model.addAttribute("emps",lists);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee  employee){
        employeeDao.save(employee);
        System.out.println("你好");
        //重定向来跳转到相应的界面
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id ,Model model){
        //通过传递过来的参数获得的回显数据
        Employee employee = employeeDao.get(id);
        //通过Model来将数据带过去
        model.addAttribute("emp",employee);
        //获取部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }


    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("userid") String userid){

        if ("aaa".equals(userid)){
            throw new UserException();
        }
        return "hello world";
    }
}
