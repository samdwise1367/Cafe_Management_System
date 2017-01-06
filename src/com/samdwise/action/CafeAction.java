/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samdwise.action;

import com.samdwise.to.CafeTO;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author samdwise
 */
public class CafeAction {
    
    public String returnIndividualCost(String cost, String item, boolean combo){    
        double getItemCost = Double.parseDouble(cost);
        double getItem = Double.parseDouble(item);
        double iLattle = 1.99;
        double ans;
        String pDrink ="";
        if(combo){
            ans = (iLattle * getItem) + getItemCost;
            pDrink = String.format("%.2f", ans);
            return pDrink;
        }else{
            return pDrink = "0";
           
        }
    
    }
    
    public void costOfDrinks(CafeTO cafeTo){
        double answer = Double.parseDouble(cafeTo.getCoffee()) + Double.parseDouble(cafeTo.getIceTea()) + 
                Double.parseDouble(cafeTo.getIceCream()) + Double.parseDouble(cafeTo.getLattle())+
                Double.parseDouble(cafeTo.getTea());
        
        //tax will be equal to task of this plus task of cakes
        double tax = (answer * 0.1) + Double.parseDouble(cafeTo.getTax());
        cafeTo.setTax(String.format("%.2f", tax));
        
        cafeTo.setCostOfDrinks(String.format("%.2f", answer));
        
        
    }
    
    public void costOfCakes(CafeTO cafeTo){
        double answer = Double.parseDouble(cafeTo.getLagosCake()) + Double.parseDouble(cafeTo.getBaltimoreCake()) + 
                Double.parseDouble(cafeTo.getNewYorkCake()) + Double.parseDouble(cafeTo.getMarylandCake())+
                Double.parseDouble(cafeTo.getIndianCake()) + Double.parseDouble(cafeTo.getBlackCake()) +
                Double.parseDouble(cafeTo.getPoliceCake())+Double.parseDouble(cafeTo.getQueensCake());
        
        //tax will be equal to task of this plus task of cakes
        double tax = (answer * 0.1) + Double.parseDouble(cafeTo.getTax());
        cafeTo.setTax(String.format("%.2f", tax));
        
        cafeTo.setCostOfCakes(String.format("%.2f", answer));

    }
    
    public void subTotal(CafeTO cafeTo){
         double answer = Double.parseDouble(cafeTo.getCostOfCakes()) + Double.parseDouble(cafeTo.getCostOfDrinks());
         cafeTo.setSubTotal(String.format("%.2f", answer));
         
    }
    
    public void total(CafeTO cafeTo){
        double answer = Double.parseDouble(cafeTo.getCostOfCakes()) + Double.parseDouble(cafeTo.getCostOfDrinks())
                + Double.parseDouble(cafeTo.getTax()) + Double.parseDouble(cafeTo.getServiceCharge());
        cafeTo.setTotal(String.format("%.2f", answer));
    }
    
    public void printReceipt(CafeTO cafeTo){
        //Generate reference number for receipt
        int referNumber;
        referNumber = 1234 + (int)(Math.random()*4321);
        
        //get date and time
        Calendar cal = Calendar.getInstance();
        //cal.getTime();
        SimpleDateFormat getTime = new SimpleDateFormat("HH:mm:ss");
       // getTime.format(cal.getTime());
        SimpleDateFormat getDate = new SimpleDateFormat("YYYY-MM-DD");
        
        String message = "\tCafe Manament Systems:\n\n" +
                "Reference: \t\t\t"+referNumber+
                "\n**********************************************************\t\t "+
                "\nCoffee:\t\t\t\t" + cafeTo.getCoffee()+
                "\nIce Tea:\t\t\t" + cafeTo.getIceTea()+
                "\nIce Cream:\t\t\t" + cafeTo.getIceCream()+
                "\nLattle:\t\t\t\t" + cafeTo.getLattle()+
                "\nTea:\t\t\t\t" + cafeTo.getTea()+
                "\n**********************************************************\t\t "+
                    "\nLagos Cake: \t\t\t "+ cafeTo.getLagosCake()+
                    "\nBaltimore Cake: \t\t "+cafeTo.getBaltimoreCake()+
                    "\nNew York Cake: \t\t\t "+cafeTo.getNewYorkCake()+
                    "\nMaryland Cake: \t\t\t "+cafeTo.getMarylandCake()+
                    "\nIndian Cake: \t\t\t "+cafeTo.getIndianCake()+
                    "\nBlack Cake: \t\t\t"+cafeTo.getBlackCake()+
                    "\nPolice Cake: \t\t\t"+cafeTo.getPoliceCake()+
                    "\nQueens Cake: \t\t\t"+cafeTo.getQueensCake()+
                    "\n**********************************************************\t\t "+
                    "\nTax: \t\t\t\t"+cafeTo.getTax()+
                    "\nService Charge: \t\t\t"+cafeTo.getServiceCharge()+
                    "\nSub Total: \t\t\t"+cafeTo.getSubTotal()+
                    "\nTotal: \t\t\t\t"+cafeTo.getTotal()+
                    "\n**********************************************************\t\t "+
                    "\n\nDate:  "+getDate.format(cal.getTime())+
                    "\tTime:  "+getTime.format(cal.getTime())+
                "\n\nThank you for your coming!";
        
        cafeTo.setReceipt(message);
    }
}
