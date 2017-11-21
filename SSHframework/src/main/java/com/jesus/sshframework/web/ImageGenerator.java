package com.jesus.sshframework.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 通过servlet来自动生成随机码
 * @author likun
 *
 */
public class ImageGenerator extends HttpServlet {

  private static final long serialVersionUID = -3938318741402322164L;
  
  private static final Logger LOG = LoggerFactory.getLogger(ImageGenerator.class);
  
  private static Color getRandColor(int fc, int bc) {
    Random random = new Random();
    if (fc > 255)
      fc = 255;
    if (bc > 255)
      bc = 255;
    int r = fc + random.nextInt(bc - fc);
    int g = fc + random.nextInt(bc - fc);
    int b = fc + random.nextInt(bc - fc);
    return new Color(r, g, b);
  }

  private static String charsLong = "23456789abcdefghjkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";

  private static String chars = charsLong;

  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    try {
      int charsLength = chars.length();

      response.setHeader("Pragma", "No-cache");
      response.setHeader("Cache-Control", "no-cache");
      response.setDateHeader("Expires", 0);

      int width = 70, height = 20;
      BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      
      Graphics g = image.getGraphics();
      
      Random random = new Random();

      g.setColor(getRandColor(200, 250));
      g.fillRect(0, 0, width, height);

      g.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, height-3));

      g.setColor(getRandColor(160, 200));
      for (int i = 0; i < 35; i++) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(12);
        int yl = random.nextInt(12);
        g.drawLine(x, y, x + xl, y + yl);
      }

      StringBuilder sRand = new StringBuilder();
      String[] fontNames = { "Times New Roman", "Arial", "Book antiqua", "" };

      for (int i = 0; i < 4; i++) {
        g.setFont(new Font(fontNames[random.nextInt(3)], Font.ITALIC, height-3));
        char rand = chars.charAt(random.nextInt(charsLength));
        sRand.append(rand);

        g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
        g.drawString(String.valueOf(rand), 16 * i + random.nextInt(5) + 4, height - 5 - random.nextInt(2));
      }

      request.getSession().setAttribute("VALIDATECODESESSION", sRand.toString());
      LOG.info("current verficode:"+sRand.toString());
      g.dispose();

      try {
        Thread.sleep(100);
      } catch (Exception ex) { 
      }
      OutputStream os = response.getOutputStream();
      ImageIO.write(image, "JPEG", os);
      os.flush();
      os.close();
    } catch (Exception ex) {

    }
  }
}