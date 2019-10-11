package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编码与解码操作工具类
 *
 * @author yuan
 * @since 1.0.0
 */
public final class CodecUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    /**
     * 将URL编码
     */
    public static String encodeUrl(String source) {
        String target;
        try {
            target = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("encode url fail", e);
            throw new RuntimeException(e);
        }
            return target;
    }
    /**
     * 将URL解码
     */
    public static String decodeUrl(String source) {
        String target;
        try {
            target = URLDecoder.decode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("decode url fail", e);
            throw new RuntimeException(e);
        }
        return target;
    }

}
