package com.gs.retrofitwebservice.mobilecode.response

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
class MobileCodeResponseEnvelope {
    @Element(name = "Body", required = false)
    var mobildCodeResponseBody: MobileCodeResponseBody? = null
}