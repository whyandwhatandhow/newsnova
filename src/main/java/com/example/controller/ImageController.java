package com.example.controller;/**
 * @className: Wnews
 * @description:
 * @author: 彭城江
 **/

import com.example.entity.EmailClient;
import com.example.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 *@ClassName ImageController
 *@Description TODO
 *@Author pzl
 */
@RestController
@RequestMapping("/api/email")
public class ImageController {

    @Resource
    JavaMailSender sender;

    @PostMapping("/send")
    public Result send(@RequestBody EmailClient email){
        System.out.println(email);
        System.out.println(email.getEmail());
        SimpleMailMessage message = new SimpleMailMessage();
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000;
        //设置邮件标题
        message.setSubject("注册验证码");
        //设置邮件内容
        message.setText("验证码："+randomNumber);
        //设置邮件发送给谁，可以多个，这里就发给你的QQ邮箱
        message.setTo(email.getEmail()); //"1251148852@qq.com"
        //邮件发送者，这里要与配置文件中的保持一致
        message.setFrom("m15979492670@163.com");
        //OK，万事俱备只欠发送
        sender.send(message);
        return Result.success(randomNumber);
    }
}
