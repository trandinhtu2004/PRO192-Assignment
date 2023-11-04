/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment;

/**
 *
 * @author ADMIN
 */

import java.util.*;
import java.lang.*;
import static java.lang.Math.E;
import static java.lang.StrictMath.E;
import java.util.ArrayList;
import java.util.Scanner;
import extension.MyUtils;
public class Menu <E>{

    Scanner scanner = new Scanner(System.in);
    /*public void menu(){
    System.out.println("1- List all brands");
    System.out.println("2- Add a new brand");
    System.out.println("3- Search a brand based on its ID");
    System.out.println("4- Update a brand");
    System.out.println("5- Save brands to the file, named brands.txt");
    System.out.println("6- List all cars in ascending order of brand names");
    System.out.println("7- List cars based on a part of an input brand name");
    System.out.println("8- Add a car");
    System.out.println("9- Remove a car based on its ID");
    System.out.println("10- Update a car based on its ID");
    System.out.println("11- Save cars to file, named cars.txt");
    }*/

   private String menuTitle;
    private ArrayList<String> optionList = new ArrayList();

    //khởi tạo tên của app., tên của menu
    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public Menu() {
        
    }
    public void addNewOption(String newOption) {
        //TODO: cần kiểm tra coi option đưa vào có trùng với option
        //sẵn có hay ko?
        //nếu ko trùng, add vào danh sách lựa chọn
        optionList.add(newOption);
    }
    
    
    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There is no item in the menu");
            return;
        }
        System.out.println("\n------------------------------------");
        System.out.println(menuTitle);
        for (String x : optionList) {
            System.out.println(x);
        }
    }
     public int int_getChoice() {
        int maxOption = optionList.size();
        //lựa chọn lớn nhất là số thứ tự ứng với số mục chọn
        String inputMsg = "Please choose an option [1.." + maxOption + "]: ";
        String errorMsg = "You must choose an option 1.." + maxOption;
        return MyUtils.getAnInteger(inputMsg, errorMsg, 1, maxOption);
    }
    
    

    
    public int int_getChoice(ArrayList<E> options){
        int maxOption = options.size();
        int response;
        for (int i = 0; i < maxOption; i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        String inputMsg = "Please choose an option [1.." + maxOption + "]: ";
        String errorMsg = "You must choose an option 1.." + maxOption;
        response = MyUtils.getAnInteger(inputMsg, errorMsg, 1, maxOption);
        return response;
    
    }
    
    //lấy lựa chọn của người dùng nhưng là object trong brandList
    public Brand ref_getChoice(ArrayList<Brand> options) {
        int maxOption = options.size();
        int response;
        System.out.println("Brand ID list:");
        do {
            response = int_getChoice((ArrayList<E>) options);
        } while (response < 0 || response > maxOption);
        return options.get(response - 1);
    }

    
    
    public void close() {
        scanner.close();
    }


}