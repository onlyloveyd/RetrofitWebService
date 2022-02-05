package com.gs.ws.mobilecode.request

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList
import org.simpleframework.xml.Root

@Root(name = "soapenv:Envelope")
@NamespaceList(
    Namespace(prefix = "soapenv", reference = "http://schemas.xmlsoap.org/soap/envelope/"),
    Namespace(prefix = "web", reference = "http://WebXml.com.cn/")
)
class MobileCodeRequestEnvelope {
    @field:Element(name = "soapenv:Body", required = true)
    var body: MobileCodeRequestBody? = null
}