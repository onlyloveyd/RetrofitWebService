package com.gs.retrofitwebservice.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 文 件 名: TableElement
 * 创 建 人: 易冬
 * 创建日期: 2018/1/23 15:32
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
@Root(name = "Table", strict = false)
public class TableElement {

    @Element(name = "CITY", required = false)
    private String city;

    @Element(name = "STATE", required = false)
    private String state;

    @Element(name = "ZIP", required = false)
    private String zip;

    @Element(name = "TIME_ZONE", required = false)
    private String timeZone;

    @Element(name = "AREA_CODE", required = false)
    private String areaCode;


    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
