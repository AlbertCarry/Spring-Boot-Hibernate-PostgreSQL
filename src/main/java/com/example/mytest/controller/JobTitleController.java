package com.example.mytest.controller;

import com.example.mytest.model.JobTitle;
import com.example.mytest.model.Users;
import com.example.mytest.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobTitleController {
    private final JobTitleService jobTitleService;
    @Autowired
    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }
/*--------------------FindTitleBuId--------------------------------------------*/
/*     @GetMapping("/find")
     public String getById(Long id){
         return "";
}*/

/*--------------------FindAllTitle--------------------------------------------*/
    @GetMapping("/jobtitle-list")
    public String list(Model model){
       List<JobTitle> jobTitles =  jobTitleService.getAll();
       model.addAttribute("jobtitle",jobTitles);
        return "jobtitle-list";
    }
/*--------------------CreateUser--------------------------------------------*/
    @GetMapping("/jobtitle-create")
    public String addJobTitle(JobTitle jobTitle) {
        return "jobtitle-create";
    }

    @PostMapping("/jobtitle-create")
    public String createJobTitle(JobTitle jobTitle) {
        jobTitleService.add(jobTitle);
        return "redirect:/jobtitle-list";
    }

/*--------------------UpDateUser--------------------------------------------*/
    @GetMapping("/jobtitle-update/{id}")
    public String updateJobTitleForm(@PathVariable("id") Long id, Model model){
        JobTitle jobTitle = jobTitleService.getById(id);
        model.addAttribute("jobtitle", jobTitle);
        return "jobtitle-update";
    }
    @PostMapping("/jobtitle-update")
    public String updateJobTitle(JobTitle jobTitle){
        jobTitleService.add(jobTitle);
        return "redirect:/jobtitle-list";
    }

/*--------------------Delete--------------------------------------------*/
    @GetMapping("/jobtitle-remove/{id}")
    public String removeJJobTitle(@PathVariable("id") Long id) {
        jobTitleService.remove(id);
        return "redirect:/jobtitle-list";
    }
}
