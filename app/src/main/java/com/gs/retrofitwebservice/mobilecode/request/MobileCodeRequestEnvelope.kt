package com.gs.retrofitwebservice.mobilecode.request

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList
import org.simpleframework.xml.Root

@Root(name = "soap:Envelope")
@NamespaceList(
    Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
    Namespace(prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
    Namespace(prefix = "soap", reference = "http://www.w3.org/2003/05/soap-envelope")
)
class MobileCodeRequestEnvelope {
    @Element(name = "soap:Body", required = false)
    var body: MobileCodeRequestBody? = null
}