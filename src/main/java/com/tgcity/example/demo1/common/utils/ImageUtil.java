package com.tgcity.example.demo1.common.utils;

import com.tgcity.example.demo1.common.exception.BizException;
import com.tgcity.example.demo1.common.model.response.Message;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Slf4j
public class ImageUtil {
    // 图片默认缩放比率
    private static final double DEFAULT_SCALE = 0.8d;
    private static final double MAX_SIZE = 100.00;


    /**
     * 压缩图片
     *
     * @param multipartfile 源图路径
     * @param savePath      压缩图保存路径
     * @return R(照片的处理情况)
     */
    public static void compressImage(MultipartFile multipartfile, String savePath, String fileName) throws Exception {
        String[] imageExtension = new String[]{"jpeg", "jpg", "gif", "bmp", "png"};
        String extension = null;
        boolean isImage = false;
        double scale = 1.0;
        //获取图片文件的名称

        if (!multipartfile.isEmpty()) {
            // 获取文件后缀
            extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            final File resourseImage = File.createTempFile(fileName, extension);
            multipartfile.transferTo(resourseImage);
            for (String e : imageExtension) {
                if (extension.equalsIgnoreCase(e)) {
                    isImage = true;
                    break;
                }
            }
            if (isImage) {
                double size = (double) resourseImage.length() / 1024;
                if (size >= MAX_SIZE) {
                    scale = DEFAULT_SCALE;
                }

                Thumbnails.of(resourseImage).scale(scale).toFile(savePath + fileName);
            } else {
                throw new BizException(Message.UPLOADED_IMAGE_FORMAT_ERROR);
            }

        } else {
            throw new BizException(Message.IMAGE_NOT_EXIST);
        }
    }

    public static void compressImage2(MultipartFile multipartfile, String savePath, String fileName) throws IOException {
        byte[] bytes = multipartfile.getBytes();
        bytes = compressPicForScale(bytes, 100);// 图片小于300kb
        FileUtils.writeByteArrayToFile(new File(savePath + fileName), bytes);
    }

    public static void compressImage3(byte[] bytes, String savePath, String fileName) throws IOException {
        bytes = compressPicForScale(bytes, 100);// 图片小于300kb
        FileUtils.writeByteArrayToFile(new File(savePath + fileName), bytes);
    }

    /**
     * 根据指定大小压缩图片
     *
     * @param imageBytes  源图片字节数组
     * @param desFileSize 指定图片大小，单位kb
     * @return 压缩质量后的图片字节数组
     */
    public static byte[] compressPicForScale(byte[] imageBytes, long desFileSize) {
        if (imageBytes == null || imageBytes.length <= 0 || imageBytes.length < desFileSize * 1024) {
            return imageBytes;
        }
        long srcSize = imageBytes.length;
        double accuracy = getAccuracy(srcSize / 1024);
        try {
            while (imageBytes.length > desFileSize * 1024) {
                ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream(imageBytes.length);
                Thumbnails.of(inputStream)
                        .scale(accuracy)
                        .outputQuality(accuracy)
                        .toOutputStream(outputStream);
                imageBytes = outputStream.toByteArray();
            }
            log.info("【图片压缩】图片原大小={}kb | 压缩后大小={}kb", srcSize / 1024, imageBytes.length / 1024);
        } catch (Exception e) {
            log.error("【图片压缩】msg=图片压缩失败!", e);
        }
        return imageBytes;
    }

    /**
     * 自动调节精度(经验数值)
     *
     * @param size 源图片大小
     * @return 图片压缩质量比
     */
    private static double getAccuracy(long size) {
        double accuracy;
        if (size < 900) {
            accuracy = 0.85;
        } else if (size < 2047) {
            accuracy = 0.6;
        } else if (size < 3275) {
            accuracy = 0.44;
        } else {
            accuracy = 0.4;
        }
        return accuracy;
    }
}

