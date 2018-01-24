package com.gs.retrofitwebservice.uszip.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * 文 件 名: UsCityRequestEnvelope
 * 创 建 人: 易冬
 * 创建日期: 2018/1/23 15:35
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
@Root(name = "soap12:Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap12", reference = "http://www.w3.org/2003/05/soap-envelope")
})
public class UsCityRequestEnvelope {

    @Element(name = "soap12:Body", required = false)
    private UsCityRequestBody body;

    public UsCityRequestBody getBody() {
        return body;
    }

    public void setBody(UsCityRequestBody body) {
        this.body = body;
    }
}