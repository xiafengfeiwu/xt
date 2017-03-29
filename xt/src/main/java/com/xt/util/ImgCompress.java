package com.xt.util;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImgCompress {
	private Image img;
	private int width;
	private int height;

	public static void todo(String path) {
		try {
			new ImgCompress(path).resizeFix(path, 260, 260);
		} catch (IOException e) {
		}
	}

	/**
	 * 构造函数
	 */
	private ImgCompress(String fileName) throws IOException {
		File file = new File(fileName);// 读入文件
		img = ImageIO.read(file); // 构造Image对象
		width = img.getWidth(null); // 得到源图宽
		height = img.getHeight(null); // 得到源图长
	}

	/**
	 * 按照宽度还是高度进行压缩
	 * 
	 * @param w
	 *            int 最大宽度
	 * @param h
	 *            int 最大高度
	 */
	private void resizeFix(String savePath, int w, int h) throws IOException {
		if (width / height > w / h) {
			resizeByWidth(savePath, w);
		} else {
			resizeByHeight(savePath, h);
		}
	}

	/**
	 * 以宽度为基准，等比例放缩图片
	 * 
	 * @param w
	 *            int 新宽度
	 */
	private void resizeByWidth(String savePath, int w) throws IOException {
		int h = (int) (height * w / width);
		resize(savePath, w, h);
	}

	/**
	 * 以高度为基准，等比例缩放图片
	 * 
	 * @param h
	 *            int 新高度
	 */
	private void resizeByHeight(String savePath, int h) throws IOException {
		int w = (int) (width * h / height);
		resize(savePath, w, h);
	}

	/**
	 * 强制压缩/放大图片到固定的大小
	 * 
	 * @param w
	 *            int 新宽度
	 * @param h
	 *            int 新高度
	 */
	private void resize(String savePath, int w, int h) throws IOException {
		// SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
		File destFile = new File(savePath);
		FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
		// 可以正常实现bmp、png、gif转jpg
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image); // JPEG编码
		out.close();

		if (w > h) {
			cutImage(savePath, w - h, 0, h, h);
		} else {
			cutImage(savePath, 0, h - w, w, w);
		}
	}

	private void cutImage(String path, int offsetW, int offsetH, int destWidth, int destHeight) {
		try {
			Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("JPEG");
			ImageReader reader = iterator.next();
			InputStream inputStream = new FileInputStream(path);
			ImageInputStream iis = ImageIO.createImageInputStream(inputStream);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			Rectangle rectangle = new Rectangle(offsetW / 2, offsetH / 2, destWidth, destHeight);/* 指定截取范围 */
			param.setSourceRegion(rectangle);
			BufferedImage bi = reader.read(0, param);
			ImageIO.write(bi, "JPEG", new File(path));
		} catch (Exception e) {
		}
	}
}