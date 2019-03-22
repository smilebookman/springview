/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dataserve.service;

import com.spring.dataserve.mapper.first.StGenZong;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
@Qualifier("stgenzongservice")
public class StGenZongService {

    @Autowired
    StGenZong stgenzong;
    private static final int PERPAGE = 15;

    /**
     * 鏍规嵁椤垫暟鑾峰彇鏁版嵁
     *
     * @param page 椤垫暟
     * @param keyword 璺熻釜鐨勫叧閿瘝
     * @param repeat 0代表查看未去重部分,1代表查看去重部分,null代表全都看
     * @return
     */
    public HashMap<String, Object> getDataByPage(int page, String keyword, String repeat) {
        HashMap<String, Object> resultMap = new HashMap<>();
        List<HashMap<String, Object>> list = new ArrayList<>();
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put("skip", (page - 1) * 15);
            map.put("pagen", PERPAGE);
            map.put("keyword", keyword);
            map.put("repeat", repeat);
            list = stgenzong.getdata(map);
            resultMap.put("data", list);
            resultMap.put("totalpage", getTotalPage(keyword, repeat));
        } catch (Exception e) {
            resultMap.put("data", list);
            resultMap.put("totalpage", 0);
            System.out.println(e.toString());
        }
        return resultMap;
    }

    /**
     * 寰楀埌鎬婚〉鏁�
     *
     * @param keyword 璺熻釜鐨勫叧閿瘝
     * @param repeat 0代表查看未去重部分,1代表查看去重部分,null代表全都看
     * @return
     */
    public int getTotalPage(String keyword, String repeat) {
        int pages = 0;
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put("keyword", keyword);
            map.put("repeat", repeat);
            pages = stgenzong.getpage(map);
            if (pages % PERPAGE == 0) {
                pages = pages / PERPAGE;
            } else {
                pages = pages / PERPAGE + 1;
            }
        } catch (Exception e) {
            System.out.println("鑾峰彇鎬婚〉鏁板け璐ワ紒閿欒淇℃伅锛�" + e.toString());
        }
        return pages;
    }

    /**
     * 鏍规嵁id鑾峰彇璇︽儏
     *
     * @param id 鏁版嵁id
     * @return
     */
    public HashMap<String, Object> getInfo(int id) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", id);
            resultMap = stgenzong.getdatabyid(map);
        } catch (Exception e) {
            resultMap.put("info", "");
            System.out.println("鑾峰彇id锛�" + String.valueOf(id) + "璇︽儏澶辫触锛侀敊璇俊鎭細" + e.toString());
        }
        return resultMap;
    }

    /**
     * 灏唕epeat瀛楁缃负1
     *
     * @param id 鏁版嵁id
     * @return 杩斿洖true浠ｈ〃鎿嶄綔鎴愬姛,杩斿洖false浠ｈ〃鎿嶄綔澶辫触
     */
    public HashMap<String, Object> setRepeatTrue(int id) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", id);
            stgenzong.setrepeattrue(map);
            resultMap.put("result", true);
        } catch (Exception e) {
            resultMap.put("result", false);
            System.out.println("鑾峰彇id锛�" + String.valueOf(id) + "璇︽儏澶辫触锛侀敊璇俊鎭細" + e.toString());
        }
        return resultMap;
    }

}
