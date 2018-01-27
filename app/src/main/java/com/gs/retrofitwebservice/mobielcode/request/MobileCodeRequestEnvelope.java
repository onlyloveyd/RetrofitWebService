package com.gs.retrofitwebservice.mobielcode.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * 文 件 名: MobileCodeRequestEnvelope
 * 创 建 人: 易冬
 * 创建日期: 2018/1/24 09:46
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
@Root(name = "soap:Envelope")
@NamespaceList({
        @Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace(prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace(prefix = "soap", reference = "http://www.w3.org/2003/05/soap-envelope")
})
public class MobileCodeRequestEnvelope {

    @Element(name = "soap:Body", required = false)
    private MobileCodeRequestBody body;

    public MobileCodeRequestBody getBody() {
        return body;
    }

    public void setBody(MobileCodeRequestBody body) {
        this.body = body;
    }
}
