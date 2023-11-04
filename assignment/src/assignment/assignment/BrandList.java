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
import java.lang.String;
import java.util.ArrayList;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import extension.MyUtils;

public class BrandList extends ArrayList<Brand> {

    private String brandID, brandName, soundBrand;
    private double price;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<String> brandIDList = new ArrayList<>();

    public BrandList() {
    }
    
 public boolean loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] arr;
            String line = br.readLine();
            while ((line != null)) {
                arr = line.split(",");
                brandID = arr[0].trim();
                brandName = arr[1].trim();
                soundBrand = arr[2].split(":")[0].trim();
                price = Double.parseDouble(arr[2].split(":")[1].trim());
                this.add(new Brand(brandID, brandName, soundBrand, price));
                brandIDList.add(brandID);
                line = br.readLine();
            }
            br.close();
            return true;
        } catch (IOException e) {
            System.out.println("File " + filename + " not found !");
        }
        return false;
    }


        
        /* try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}*/  
     public boolean saveToFile(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Brand brand : this) {
                String line = brand.getBrandID() + ", " + brand.getBrandName() + ", " + brand.getSoundBrand() + ": " + brand.getPrice();
                pw.println(line);
            }
            pw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

     
    public int searchID(String bID) {
        if (this.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.size(); i++) {
            if (bID.equals(this.get(i).getBrandID())) {
                return i;
            }
        }
        return -1;
    }
    
  
    
    public Brand getUserChoice(){
        Menu mnu = new Menu();
            return (Brand)mnu.ref_getChoice(brandIDList);      
    }
    
 public void addBrand() {
        int pos;
        do {
            brandID = MyUtils.getID("Input brand ID: ", "The brandID must not be null. Try again !");
            pos = searchID(brandID);
            if (pos >= 0) {
                System.out.println("This brand ID is existed. Try another one!");
            }
        } while (pos != -1);

        brandName = MyUtils.getString("Input brand name: ", "The brand name must not be null. Try again !");
        soundBrand = MyUtils.getString("Input sound brand: ", "The sound brand must not be null. Try again !");
        price = MyUtils.getADouble("Input price: ", "The price must be a number and greater than 0. Try again !", 0);
        this.add(new Brand(brandID, brandName, soundBrand, price));
        brandIDList.add(brandID);
        System.out.println("Brand has been added successfully");
    }
 
  public void updateBrand() {
        Menu mnu = new Menu("Please choose the characteristics of brand that you want to update");
        mnu.addNewOption("1. Update brand name");
        mnu.addNewOption("2. Update sound brand");
        mnu.addNewOption("3. Update price");
        mnu.addNewOption("4. Update all");
        mnu.addNewOption("5. Exit");
        int choice;
        String exitPoint = "Y";
        brandID = MyUtils.getID("Input brand ID: ", /*dấu , ngăn cách để khi mình không viết gì mà enter thì nó sẽ báo mình phải thử lại*/ "The brandID must not be null. Try again !");
        int pos = searchID(brandID);
        if (pos == -1) {
            System.out.println("Not found !");
        } else {
            do {
                Brand x = this.get(pos);
                System.out.println("Here is the Brand before updating");
                System.out.println(x);
                mnu.printMenu();
                choice = mnu.int_getChoice();
                switch (choice) {
                    case 1:
                        brandName = MyUtils.getString("Input brand name: ", "The brand name must not be null. Try again !");
                        x.setBrandName(brandName);
                        System.out.println("Brand has been updated successfully !");
                        System.out.println("Do you want to continue updating the brand with ID " + x.getBrandID());
                        System.out.print("Choose(Y/N): ");
                        exitPoint = sc.nextLine().toUpperCase();
                        if (!exitPoint.equals("Y")) {
                            exitPoint = "N";
                        }
                        break;
                    case 2:
                        soundBrand = MyUtils.getString("Input sound brand: ", "The sound brand must not be null. Try again !");
                        x.setSoundBrand(soundBrand);
                        System.out.println("Brand has been updated successfully !");
                        System.out.println("Do you want to continue updating the brand with ID " + x.getBrandID());
                        System.out.print("Choose(Y/N): ");
                        exitPoint = sc.nextLine().toUpperCase();
                        if (!exitPoint.equals("Y")) {
                            exitPoint = "N";
                        }
                        break;
                    case 3:
                        price = MyUtils.getADouble("Input price: ", "The price must be a number and greater than 0. Try again !", 0);
                        x.setPrice(price);
                        System.out.println("Brand has been updated successfully !");
                        System.out.println("Do you want to continue updating the brand with ID " + x.getBrandID());
                        System.out.print("Choose(Y/N): ");
                        exitPoint = sc.nextLine().toUpperCase();
                        if (!exitPoint.equals("Y")) {
                            exitPoint = "N";
                        }
                        break;
                    case 4:
                        brandName = MyUtils.getString("Input brand name: ", "The brand name must not be null. Try again !");
                        soundBrand = MyUtils.getString("Input sound brand: ", "The sound brand must not be null. Try again !");
                        price = MyUtils.getADouble("Input price: ", "The price must be a number and greater than 0. Try again !", 0);
                        x.setBrandName(brandName);
                        x.setSoundBrand(soundBrand);
                        x.setPrice(price);
                        System.out.println("Brand has been updated successfully !");
                        System.out.println("Do you want to continue updating the brand with ID " + x.getBrandID());
                        System.out.print("Choose(Y/N): ");
                        exitPoint = sc.nextLine().toUpperCase();
                        if (!exitPoint.equals("Y")) {
                            exitPoint = "N";
                        }
                        break;
                }
            } while (choice >= 1 && choice <= 4 && exitPoint.equals("Y"));
        }
    }
 
   public void listBrands() {
        String format = "| %-8s | %-29s | %-16s | %-5s |%n";
        System.out.println("Brand list");
        System.out.format("+----------+-------------------------------+------------------+-------+%n");
        System.out.format("| Brand ID | Brand Name                    | Sound Brand      | Price |%n");
        System.out.format("+----------+-------------------------------+------------------+-------+%n");

        for (Brand brand : this) {
            String brandID = brand.getBrandID();
            String brandName = brand.getBrandName();
            String soundBrand = brand.getSoundBrand();
            String price = String.format("%.3f", brand.getPrice()); // Làm tròn 3 chữ số thập phân
            System.out.format(format, brandID, brandName, soundBrand, price);
        }

        System.out.format("+----------+-------------------------------+------------------+-------+%n");
        System.out.println("There are " + this.size() + " brand(s) in the list.");
    } 
}

 