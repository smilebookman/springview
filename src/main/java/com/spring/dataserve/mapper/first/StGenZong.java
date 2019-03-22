/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.dataserve.mapper.first;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface StGenZong {

    List<HashMap<String, Object>> getdata(HashMap<String, Object> map);

    int getpage(HashMap<String, Object> map);

    HashMap<String, Object> getdatabyid(HashMap<String, Object> map);

    void setrepeattrue(HashMap<String, Object> map);

}
