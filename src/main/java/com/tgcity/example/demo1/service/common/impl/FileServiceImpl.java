package com.tgcity.example.demo1.service.common.impl;

import com.tgcity.example.demo1.common.exception.BizException;
import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.common.model.response.Message;
import com.tgcity.example.demo1.common.utils.ImageUtil;
import com.tgcity.example.demo1.service.common.FileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: TGCity
 * @create: 2020/5/29
 * @description 图片对内实现类
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Value("${file.server.url}")
    private String baseUrl;
    @Value("${file.server.path}")
    private String filePath;

    @Override
    public BaseResponse saveBase64Image(String base64Data) {
        log.info("==上传图片==");
        //base64格式前头
        String dataPrix;
        //实体部分数据
        String data;
        if (StringUtils.isBlank(base64Data)) {
            throw new BizException(Message.BASE64_NOT_EMPTY);
        } else {
            String[] d = base64Data.split("base64,");//将字符串分成数组
            if (d.length == 2) {
                dataPrix = d[0];
                data = d[1];
            } else {
                throw new BizException(Message.UPLOADED_IMAGE_FORMAT_ERROR);
            }
        }
        //图片后缀，用以识别哪种格式数据
        String suffix;
        //data:image/jpeg;base64,base64编码的jpeg图片数据
        if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {
            suffix = ".jpg";
        } else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {
            //data:image/x-icon;base64,base64编码的icon图片数据
            suffix = ".ico";
        } else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {
            //data:image/gif;base64,base64编码的gif图片数据
            suffix = ".gif";
        } else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {
            //data:image/png;base64,base64编码的png图片数据
            suffix = ".png";
        } else {
            throw new BizException(Message.UPLOADED_IMAGE_FORMAT_ERROR);
        }
        String tempFileName = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS") + RandomUtils.nextInt(100, 999) + suffix;

//        Base64.Decoder decoder = Base64.getDecoder();
        try {
            byte[] bytes = Base64.decodeBase64(data);
            ImageUtil.compressImage3(bytes, filePath + "upload/", tempFileName);
            return BaseResponse.ok(baseUrl + "upload/" + tempFileName);
            //Base64解码
//            byte[] b = decoder.decode(data);
//            for (int i = 0; i < b.length; ++i) {
//                if (b[i] < 0) {
//                    //调整异常数据
//                    b[i] += 256;
//                }
//            }
        } catch (Exception e) {
            log.error("----------上传失败信息：${}", e.getMessage());
            throw new BizException(Message.IMPORT_ERROR);
        }
    }
}
