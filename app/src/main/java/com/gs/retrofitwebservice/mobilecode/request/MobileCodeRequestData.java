package com.gs.retrofitwebservice.mobilecode.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * 文 件 名: MobileCodeRequestData
 * 创 建 人: 易冬
 * 创建日期: 2018/1/24 09:48
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
@Root(name = "getMobileCodeInfo", strict = false)
@Namespace(reference = "http://WebXml.com.cn/")
public class MobileCodeRequestData {
    @Element(name = "mobileCode", required = false)
    private String mobileCode;

    public String getMobileCode() {
        return mobileCode;
    }

    public void setMobileCode(String mobileCode) {
        this.mobileCode = mobileCode;
    }
}
