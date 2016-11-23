/*
 * Decompiled with CFR 0_118.
 */
package com.qq.connect.utils.http;

import com.qq.connect.QQConnectException;
import com.sun.imageio.plugins.bmp.BMPImageReader;
import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.imageio.plugins.jpeg.JPEGImageReader;
import com.sun.imageio.plugins.png.PNGImageReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.MemoryCacheImageInputStream;

public class ImageItem {
    private byte[] content;
    private String name;
    private String contentType;

    public ImageItem(byte[] content) throws QQConnectException {
        this("pic", content);
    }

    public ImageItem(String name, byte[] content) throws QQConnectException {
        String imgtype = null;
        try {
            imgtype = ImageItem.getContentType(content);
        }
        catch (IOException e) {
            throw new QQConnectException(e);
        }
        if (imgtype == null || !imgtype.equalsIgnoreCase("image/gif") && !imgtype.equalsIgnoreCase("image/png") && !imgtype.equalsIgnoreCase("image/jpeg")) {
            throw new QQConnectException("Unsupported image type, Only Suport JPG ,GIF,PNG!");
        }
        this.content = content;
        this.name = name;
        this.contentType = imgtype;
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getName() {
        return this.name;
    }

    public String getContentType() {
        return this.contentType;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String getContentType(byte[] mapObj) throws IOException {
        String type;
        type = "";
        ByteArrayInputStream bais = null;
        MemoryCacheImageInputStream mcis = null;
        try {
            bais = new ByteArrayInputStream(mapObj);
            mcis = new MemoryCacheImageInputStream(bais);
            Iterator<ImageReader> itr = ImageIO.getImageReaders(mcis);
            while (itr.hasNext()) {
                ImageReader reader = itr.next();
                if (reader instanceof GIFImageReader) {
                    type = "image/gif";
                    continue;
                }
                if (reader instanceof JPEGImageReader) {
                    type = "image/jpeg";
                    continue;
                }
                if (reader instanceof PNGImageReader) {
                    type = "image/png";
                    continue;
                }
                if (!(reader instanceof BMPImageReader)) continue;
                type = "application/x-bmp";
            }
        }
        finally {
            if (bais != null) {
                try {
                    bais.close();
                }
                catch (IOException ioe) {}
            }
            if (mcis != null) {
                try {
                    mcis.close();
                }
                catch (IOException ioe) {}
            }
        }
        return type;
    }
}

