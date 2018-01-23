package com.gs.retrofitwebservice.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 文 件 名: UsCityRequestBody
 * 创 建 人: 易冬
 * 创建日期: 2018/1/23 15:36
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
@Root(name = "soap12:Body", strict = false)
public class UsCityRequestBody {

    @Element(name = "GetInfoByCity",required = false)
    private UsCityRequestData usStatesRequestData;

    public UsCityRequestData getUsStatesRequestData() {
        return usStatesRequestData;
    }

    public void setUsStatesRequestData(UsCityRequestData usStatesRequestData) {
        this.usStatesRequestData = usStatesRequestData;
    }

}

