package com.gs.retrofitwebservice.uszip.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * 文 件 名: UsCityResponseData
 * 创 建 人: 易冬
 * 创建日期: 2018/1/23 15:30
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */

@Root(name = "GetInfoByCityResponse", strict = false)
@Namespace(reference = "http://www.webserviceX.NET")
public class UsCityResponseData {

    @Element(name = "GetInfoByCityResult", required = false)
    private UsCityResponseInfo data;

    public UsCityResponseInfo getData() {
        return data;
    }

    public void setData(UsCityResponseInfo data) {
        this.data = data;
    }
}