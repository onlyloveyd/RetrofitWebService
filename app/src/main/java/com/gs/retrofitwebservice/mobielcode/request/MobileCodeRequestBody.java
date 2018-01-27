package com.gs.retrofitwebservice.mobielcode.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 文 件 名: MobileCodeRequestBody
 * 创 建 人: 易冬
 * 创建日期: 2018/1/24 09:50
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
@Root(name = "soap:Body", strict = false)
public class MobileCodeRequestBody {
    @Element(name = "getMobileCodeInfo", required = false)
    private MobileCodeRequestData mMobileCodeRequestData;

    public MobileCodeRequestData getMobileCodeRequestData() {
        return mMobileCodeRequestData;
    }

    public void setMobileCodeRequestData(
            MobileCodeRequestData mobileCodeRequestData) {
        mMobileCodeRequestData = mobileCodeRequestData;
    }
}
