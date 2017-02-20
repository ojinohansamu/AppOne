package com.example.homannh.dsd.dto;

/**
 * this class represents the attribute that describe a product
 * Created by HOH on 2/20/2017.
 */

public class ProductDTO {
    int guid; //This is a global identifier, right now I used item no and convert it to int
    String product_id;
    String item_no;
    String company_code;
    String upc_code;
    String sub_upc_cede;
    String group_code;
    String cat_code;
    String financial_cat_code;
    String description;
    int shelf_life_day_1;
    int shelf_life_day_2;
    int shelf_life_day_3;
    int shelf_life_day_4;
    int shelf_life_day_5;
    int shelf_life_day_6;
    int shelf_life_day_7;


    public int getGuid() {
        return guid;
    }

    public void setGuid(int guid) {
        this.guid = guid;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getItem_no() {
        return item_no;
    }

    public void setItem_no(String item_no) {
        this.item_no = item_no;
    }

    public String getCompany_code() {
        return company_code;
    }

    public void setCompany_code(String company_code) {
        this.company_code = company_code;
    }

    public String getUpc_code() {
        return upc_code;
    }

    public void setUpc_code(String upc_code) {
        this.upc_code = upc_code;
    }

    public String getSub_upc_cede() {
        return sub_upc_cede;
    }

    public void setSub_upc_cede(String sub_upc_cede) {
        this.sub_upc_cede = sub_upc_cede;
    }

    public String getGroup_code() {
        return group_code;
    }

    public void setGroup_code(String group_code) {
        this.group_code = group_code;
    }

    public String getCat_code() {
        return cat_code;
    }

    public void setCat_code(String cat_code) {
        this.cat_code = cat_code;
    }

    public String getFinancial_cat_code() {
        return financial_cat_code;
    }

    public void setFinancial_cat_code(String financial_cat_code) {
        this.financial_cat_code = financial_cat_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getShelf_life_day_1() {
        return shelf_life_day_1;
    }

    public void setShelf_life_day_1(int shelf_life_day_1) {
        this.shelf_life_day_1 = shelf_life_day_1;
    }

    public int getShelf_life_day_2() {
        return shelf_life_day_2;
    }

    public void setShelf_life_day_2(int shelf_life_day_2) {
        this.shelf_life_day_2 = shelf_life_day_2;
    }

    public int getShelf_life_day_3() {
        return shelf_life_day_3;
    }

    public void setShelf_life_day_3(int shelf_life_day_3) {
        this.shelf_life_day_3 = shelf_life_day_3;
    }

    public int getShelf_life_day_4() {
        return shelf_life_day_4;
    }

    public void setShelf_life_day_4(int shelf_life_day_4) {
        this.shelf_life_day_4 = shelf_life_day_4;
    }

    public int getShelf_life_day_5() {
        return shelf_life_day_5;
    }

    public void setShelf_life_day_5(int shelf_life_day_5) {
        this.shelf_life_day_5 = shelf_life_day_5;
    }

    public int getShelf_life_day_6() {
        return shelf_life_day_6;
    }

    public void setShelf_life_day_6(int shelf_life_day_6) {
        this.shelf_life_day_6 = shelf_life_day_6;
    }

    public int getShelf_life_day_7() {
        return shelf_life_day_7;
    }

    public void setShelf_life_day_7(int shelf_life_day_7) {
        this.shelf_life_day_7 = shelf_life_day_7;
    }

    public String toString()
    {
        return  product_id + " " + item_no + " " + company_code + " " + upc_code + sub_upc_cede + " " + group_code + " " + cat_code + " " + financial_cat_code  + " " + description;
    }
}
