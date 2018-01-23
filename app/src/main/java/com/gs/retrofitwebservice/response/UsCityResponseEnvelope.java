package com.gs.retrofitwebservice.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * 文 件 名: UsCityResponseEnvelope
 * 创 建 人: 易冬
 * 创建日期: 2018/1/23 15:29
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
public class UsCityResponseEnvelope {

    @Element(required = false, name = "Body")
    private UsCityResponseBody body;

    public UsCityResponseBody getBody() {
        return body;
    }

    public void setBody(UsCityResponseBody body) {
        this.body = body;
    }
}
