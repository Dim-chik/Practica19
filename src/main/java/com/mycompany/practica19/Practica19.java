/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica19;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PK
 */
public class Practica19 {

    public static void main(String[] args) {
        System.out.println("Start program!");
        String server = "https://android-for-students.ru";
        String serverPath = "/coursework/login.php";
        HashMap<String,String> map = new HashMap();
        map.put("lgn", "Student54350");
        map.put("pwd", "O2t9txG");
        map.put("g", "RIBO-01-22");
        HTTPRunnable httpRunnable = new HTTPRunnable(server + serverPath, map);
        Thread th = new Thread(httpRunnable);
        th.start();
        try{
            th.join();
        }catch (InterruptedException ex){
            
        }finally{
            JSONObject jSONObject = new JSONObject(httpRunnable.getResponseBody());
            int result = jSONObject.getInt("result_code");
            System.out.println("Result:" + result);
            System.out.println("Variant:" + jSONObject.getInt("variant"));
            System.out.println("Title:" + jSONObject.getString("title"));           
            switch (result){
                case 1:
            System.out.println("Task:" + jSONObject.getString("task"));
                    break;

                case 0:
                    
                    break;
                default:
                    
                    break;
            }
            }

        }
    }
