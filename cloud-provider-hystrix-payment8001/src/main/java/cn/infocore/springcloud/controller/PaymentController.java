package cn.infocore.springcloud.controller;

import cn.infocore.springcloud.service.PaymentService;
import cn.infocore.springcloud.service.serviceImpl.PaymentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author wei.zhang@infocore.cn
 * @Date 2020/5/8 10:21
 * @Description
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService service;

    @Resource
    private PaymentServiceImpl serviceImpl;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String getPaymentInfo_ok(@PathVariable("id") Integer id) {
        return service.getPaymentInfo_ok(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String getPaymentInfo_timeout(@PathVariable("id") Integer id) {
        return service.getPaymentInfo_timeout(id);
    }

    @GetMapping(value = "/payment/hystrix/circuitBreak/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return serviceImpl.paymentCircuitBreaker(id);
    }
}
