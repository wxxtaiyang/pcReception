package com.cykj.utils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GraphValidateCode {
    private int width = 100;// 宽
    private int height = 30;// 高
    private int lineSize = 5;// 干扰线

    //    随机产生数字和字母组合的字符串,字体只显示大写，去掉了1,0,i,o几个容易混淆的字符
    public static final String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";

    private Font getFont(){
        return new Font("微软雅黑",Font.BOLD,18);
    }

    /**
     * 获取颜色
     * @return Color
     */
    private Color getRandColor(){
        Random rd = new Random();
        int r = rd.nextInt(256);
        int g = rd.nextInt(256);
        int b = rd.nextInt(256);
        return new Color(r,g,b);
    }

    /**
     * 得到验证码
     * @return String
     */
    public String getIdentifyCode(HttpSession session){
        Random rd = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            char c = VERIFY_CODES.charAt(rd.nextInt(VERIFY_CODES.length()));
            sb.append(c);
        }
        session.setAttribute("identify",sb);
        return sb.toString();
    }

    /**
     * 绘制干扰线
     * @param g Graphics
     */
    private void drawLine(Graphics g){
        Random rd = new Random();
        int x1 = rd.nextInt(10);
        int y1 = rd.nextInt(height);
        int x2 = rd.nextInt(10)+width-10;
        int y2 = rd.nextInt(height);
//        在此图形上下文的坐标系中，使用当前颜色在点 (x1, y1) 和 (x2, y2) 之间画一条线。
        g.drawLine(x1,y1,x2,y2);
    }

    /**
     * 绘制验证码
     * @param g 画笔
     */
    private void drawIdentifyCode(HttpSession session,Graphics g){
        String code = getIdentifyCode(session);
        Random rd = new Random();
        for (int i = 0; i < code.toCharArray().length; i++) {
            int y = rd.nextInt(15)+15;
            g.drawChars(code.toCharArray(),i,1,(i*20)+10,y);
        }
    }

    /**
     * 绘制验证码图片
     * @return BufferedImage
     */
    public BufferedImage getIdentifyImages(HttpSession session){
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.fillRect(0,0,width,height);
        g.setFont(getFont());
        g.setColor(getRandColor());
        for (int i = 0; i < lineSize; i++) {
            drawLine(g);
        }
        drawIdentifyCode(session,g);
        g.dispose();
        return image;
    }

    /**
     * 响应请求，回传验证码
     * @param session 浏览器绘画请求session
     * @param resp response
     */
    public void responseIdentifyImage(HttpSession session, HttpServletResponse resp){
        BufferedImage image = getIdentifyImages(session);
        //设置响应类型，告诉浏览器输出的内容是图片
        resp.setContentType("image/jpeg");
        //设置响应头信息，告诉浏览器不用缓冲此内容
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expire", 0);
        try {
            //把内存中的图片通过流动形式输出到客户端
            ImageIO.write(image, "JPEG", resp.getOutputStream());
        } catch (Exception e) {
            System.err.println("图形验证码输出错误");
            e.printStackTrace();
        }
    }
}
