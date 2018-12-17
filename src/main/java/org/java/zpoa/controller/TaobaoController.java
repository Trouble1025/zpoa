package org.java.zpoa.controller;


import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgItemCouponGetRequest;
import com.taobao.api.response.TbkDgItemCouponGetResponse;
import org.java.zpoa.beans.TaobaoConpon;
import org.java.zpoa.util.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/taobao")
public class TaobaoController {

    private String appkey = "25085171";
    private String appSk = "f66bd449316c3e7c958b83e821d2bb6b";
    private String url = "http://gw.api.taobao.com/router/rest";
    @RequestMapping( path = "coupon")
    public String coupon(){
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, appSk);
        TbkDgItemCouponGetRequest req = new TbkDgItemCouponGetRequest();
        req.setAdzoneId(29874650260L);
        req.setPlatform(1L);
        req.setPageSize(100L);
        req.setQ("女装");
        req.setPageNo(1L);
        TbkDgItemCouponGetResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
        List<TaobaoConpon> taobaoConponList = JsonUtils.jsonToList(rsp.getBody(), TaobaoConpon.class);
        for (TaobaoConpon t:taobaoConponList
             ) {
            List<TaobaoConpon.ResultsBean.TbkCouponBean> tbkCoupon = t.getResults().getTbk_coupon();
            for (int i = 0; i <  tbkCoupon.size(); i++) {
                System.out.println(tbkCoupon.get(i).getTitle());
                System.out.println(tbkCoupon.get(i).getZk_final_price());
                System.out.println(tbkCoupon.get(i).getCoupon_click_url());
            }
        }
        return rsp.getBody();
    }
}
