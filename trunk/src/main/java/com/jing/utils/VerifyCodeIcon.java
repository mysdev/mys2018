package com.jing.utils;

import java.awt.Color;        
import java.awt.Font;        
import java.awt.Graphics2D;        
import java.awt.image.BufferedImage;        
import java.util.Random;

public class VerifyCodeIcon {

	// 验证码图片的宽度。        
    private int width = 80;        
    // 验证码图片的高度。        
    private int height = 46;        
    // 验证码字符个数        
    private int codeCount = 4;        
    private int x = 0;        
    // 字体高度        
    private int fontHeight;        
    private int codeY;        
    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',        
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',        
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' }; 
    
    // randomCode用于保存随机产生的验证码，以便用户登录后进行验证
    private StringBuffer randomCode = new StringBuffer();
    
    /**
     * 获取字符验证码
     * @return
     */
    public String getValidateCode(){
    	return randomCode.toString();
    }
    
    /**
     * 带参构造函数
     * @param width 宽度
     * @param height 高度
     * @param codeCount 字符个数
     */
    public VerifyCodeIcon(int width, int height, int codeCount){   
    	super();
    	this.width = width;
    	this.height = height;
    	this.codeCount = codeCount;
        x = this.width / (this.codeCount + 1); 
        fontHeight = this.height - 2;
        codeY = this.height - 4;  
    }
    
    /**
     * 构造函数
     */
    public VerifyCodeIcon(){
    	super();
    	x = this.width / (this.codeCount + 1); 
        fontHeight = this.height - 2;
        codeY = this.height - 4;  
    }
    
    /**
     * 字符，请通过getValidateCode()方法获取
     * @return
     */
    public BufferedImage getVerifyImg() {
        // 定义图像buffer        
        BufferedImage buffImg = new BufferedImage(width, height,        
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        // 创建一个随机数生成器类        
        Random random = new Random();        
        // 将图像填充为白色        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);        
        // 创建字体，字体的大小应该根据图片的高度来定。        
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);        
        // 设置字体。        
        g.setFont(font);        
        // 画边框。        
        g.setColor(Color.WHITE);        
        g.drawRect(0, 0, width - 1, height - 1);        
        // 随机产生50条干扰线，使图象中的认证码不易被其它程序探测到。        
//        g.setColor(Color.BLACK);        
//        for (int i = 0; i < 10; i++) {        
//            int x = random.nextInt(width);        
//            int y = random.nextInt(height);        
//            int xl = random.nextInt(12);        
//            int yl = random.nextInt(12);        
//            g.drawLine(x, y, x + xl, y + yl);        
//        }
//        for(int k=0; k<5; k++){
//        	 int x = random.nextInt(height);        
//             int y = random.nextInt(height); 
//             g.drawLine(0, x, width, y); 
//        }
        int red = 0, green = 0, blue = 0;        
        // 随机产生codeCount数字的验证码。        
//        for (int i = 0; i < codeCount; i++) {        
            // 得到随机产生的验证码数字。        
//            String strRand = String.valueOf(codeSequence[random.nextInt(36)]);        
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。        
            red = random.nextInt(255);        
            green = random.nextInt(255);        
            blue = random.nextInt(255);        
            // 用随机产生的颜色将验证码绘制到图像中。        
            g.setColor(new Color(red, green, blue));        
//            g.drawString(strRand, (i* x)+5, codeY);	//+5为起始空白        
            // 将产生的四个随机数组合在一起。        
//            randomCode.append(strRand);        
//        }    
        
        int i1 = random.nextInt(9);
        i1++;
        g.drawString(""+i1, 3, codeY);
        g.drawString("+", x*1+6, codeY);
        int i2 = random.nextInt(9);
        i2++;
        g.drawString(""+i2, x*2+9, codeY);
        g.drawString("=", x*3+12, codeY);
        randomCode.append(i1+i2);
        return buffImg;
        /* 将四位数字的验证码保存到Session中。        
       	getcheckcode(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
			VerifyCodeIcon vc = new VerifyCodeIcon();
	
			HttpSession session = request.getSession();
			BufferedImage bi = vc.getVerifyImg();
			session.setAttribute("validateCode", vc.getValidateCode());
			// 禁止图像缓存。
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Cache-Control", "no-cache");
			resp.setDateHeader("Expires", 0);
			resp.setContentType("image/jpeg");
			// 将图像输出到Servlet输出流中。
			ServletOutputStream sos = resp.getOutputStream();
			ImageIO.write(bi, "jpeg", sos);
			sos.close();
	
		}    */    
    }    
}
