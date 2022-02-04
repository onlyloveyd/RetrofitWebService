package com.gs.retrofitwebservice.mobilecode.request

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root

@Root(name = "getMobileCodeInfo", strict = false)
@Namespace(reference = "http://WebXml.com.cn/")
class MobileCodeRequestData {
    @Element(name = "mobileCode", required = false)
    var mobileCode: String? = null
}