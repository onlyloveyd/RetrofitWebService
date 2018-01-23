package com.gs.retrofitwebservice.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 文 件 名: UsCityResponseBody
 * 创 建 人: 易冬
 * 创建日期: 2018/1/23 15:30
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
@Root(name = "Body", strict = false)
public class UsCityResponseBody {

    @Element(name = "GetInfoByCityResponse", required = false)
    private UsCityResponseData data;

    public UsCityResponseData getData() {
        return data;
    }

    public void setData(UsCityResponseData data) {
        this.data = data;
    }
}