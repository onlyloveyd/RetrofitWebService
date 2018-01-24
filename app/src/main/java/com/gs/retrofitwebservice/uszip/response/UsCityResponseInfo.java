package com.gs.retrofitwebservice.uszip.response;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * 文 件 名: UsCityResponseInfo
 * 创 建 人: 易冬
 * 创建日期: 2018/1/23 15:31
 * 邮   箱: onlyloveyd@gmail.com
 * 博   客: https://onlyloveyd.cn
 * 描   述：
 *
 * @author Mraz
 */
@Root(name = "GetInfoByCityResult",strict = false)
public class UsCityResponseInfo {

    @ElementList(name = "NewDataSet",required = false)
    List<TableElement> elements;

    public List<TableElement> getElements() {
        return elements;
    }

    public void setElements(List<TableElement> elements) {
        this.elements = elements;
    }

}
