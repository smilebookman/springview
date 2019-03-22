/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dataserve.controller;

import com.spring.dataserve.service.StGenZongService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/genzong")
public class StGenZongController {

    @Autowired
    private StGenZongService stgenzongservice;

    /**
     * 根据页数和关键词得到列表数据
     *
     * @param page 页数
     * @param keyword 跟踪的关键词
     * @return
     */
    @GetMapping("/receievedata")
    public @ResponseBody
    HashMap<String, Object> getRecord(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "repeat", required = false) String repeat) {
        return stgenzongservice.getDataByPage(page, keyword, repeat);
    }

    /**
     * 根据id得到数据详情
     *
     * @param id 数据id
     * @return
     */
    @GetMapping(value = "/receievedataid/{id}")
    public @ResponseBody
    HashMap<String, Object> getRecordById(
            @PathVariable("id") int id) {
        return stgenzongservice.getInfo(id);
    }

    /**
     * 根据id将对应数据的repeat置为1
     *
     * @param id 数据id
     * @return 返回true代表操作成功,返回false代表操作失败
     */
    @PostMapping(value = "/setrepeatbyid")
    public @ResponseBody
    HashMap<String, Object> setRepeatTrue(
            @RequestParam(name = "id", required = true) int id) {
        return stgenzongservice.setRepeatTrue(id);
    }

}
