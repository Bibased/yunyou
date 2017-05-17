package com.yunyou.util;


import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by lds on 2017/5/5.
 */
@Component
public class VerificationCode {

    private int width = 90;//验证码宽度 默认值：90
    private int height = 40;//验证码高度 默认值：40
    private int codeCount = 4;//验证码个数  默认值：4
    private int lineCount = 19;//混淆线个数  默认值：19
    private int  fontSize = 20;//字体大小像素
    //存储session中的key值 默认值："validateCode"
    private String sessionKey = "validateCode";
    private final int MAX_COLOR = 0xEEEEEE;
    public VerificationCode(){}

    /**
     *
     * @param width 验证码宽度
     * @param height 验证码高度
     * @param fontSize 字体大小像素
     */
    public VerificationCode(int width, int height, int fontSize){
        this.width = width;
        this.height = height;
        this.fontSize = fontSize;
    }

    /**
     *
     * @param width 验证码宽度
     * @param height 验证码高度
     * @param fontSize 字体大小像素
     * @param sessionKey 存储session中的key值
     */
    public VerificationCode(int width, int height, int fontSize, String sessionKey){
        this.width = width;
        this.height = height;
        this.fontSize = fontSize;
        this.sessionKey = sessionKey;
    }

    /**
     *
     * @param width 验证码宽度
     * @param height 验证码高度
     * @param codeCount 验证码个数
     * @param fontSize 字体大小像素
     * @param sessionKey 存储session中的key值
     */
    public VerificationCode(int width, int height, int codeCount, int fontSize, String sessionKey){
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.fontSize = fontSize;
        this.sessionKey = sessionKey;
    }

    /**
     *
     * @param width 验证码宽度
     * @param height 验证码高度
     * @param codeCount 验证码个数
     * @param lineCount 混淆线个数
     * @param fontSize 字体大小像素
     * @param sessionKey 存储session中的key值
     */
    public VerificationCode(int width, int height, int codeCount, int lineCount, int fontSize, String sessionKey){
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        this.fontSize = fontSize;
        this.sessionKey = sessionKey;
    }


    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    /**
     * 具体获取验证码的方法
     * @throws IOException
     */
    public void getCode(HttpSession session, HttpServletResponse response){
        //定义随机数类
        Random r = new Random();
        //定义存储验证码的类
        StringBuilder builderCode = new StringBuilder();
        //定义画布
        BufferedImage buffImg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //得到画笔
        Graphics g = buffImg.getGraphics();
        //1.设置颜色,画边框
        g.setColor(Color.gray);
        g.drawRect(0,0,width,height);
        //2.设置颜色,填充内部
        g.setColor(Color.white);
        g.fillRect(1,1,width-2,height-2);
        for (int i = 0; i < lineCount; i++) {
            int rgb = r.nextInt(MAX_COLOR);
            g.setColor(new Color(rgb));
            g.drawLine(r.nextInt(width),r.nextInt(height),r.nextInt(width),r.nextInt(height));
        }
        //4.设置验证码
        g.setColor(Color.blue);
        //4.1设置验证码字体
        g.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,fontSize));
        for (int i = 0; i < codeCount; i++) {
            char c = codeSequence[r.nextInt(codeSequence.length)];
            builderCode.append(c);
            g.drawString(c+"",((width/codeCount)*i+2),height*4/5);
        }
        try {
            //5.输出到屏幕
            ServletOutputStream sos = response.getOutputStream();
            ImageIO.write(buffImg,"png",sos);
            session.setAttribute(sessionKey,builderCode.toString());
            //7.禁止图像缓存。
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/png");
            //8.关闭sos
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public boolean verify(String code, HttpSession session){
        if (null == code) return false;
        return code.equalsIgnoreCase((String)session.getAttribute(sessionKey));
    }
}
