package csu.web.mypetstore.domain;

import java.io.Serializable;

/**
 * @author RongXing 1360908370@qq.com
 * @version 2022/12/27 12:48
 * @ since JDK11
 */
public class Consignee implements Serializable {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;


    public Consignee() {
    }

    public Consignee(int id, String username, String firstName, String lastName, String address1, String address2, String city, String state, String zip, String country) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 设置
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 获取
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 设置
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 获取
     * @return address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * 设置
     * @param address1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * 获取
     * @return address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * 设置
     * @param address2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * 获取
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * 设置
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取
     * @return zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * 设置
     * @param zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * 获取
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
