package com.gs.retrofitwebservice.uszip.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * 文 件 名: UsCityRequestData
 * 创 建 人: 易冬
 * 创建日期: 2018/1/23 15:37
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
@Root(name = "GetInfoByCity", strict = false)
@Namespace(reference = "http://www.webserviceX.NET")
public class UsCityRequestData {

    @Element(name = "USCity", required = false)
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
