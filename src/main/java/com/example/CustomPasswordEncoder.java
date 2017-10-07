package com.example;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.Charset;

/**
 * Created by luoxx on 2017/10/7.
 */
public class CustomPasswordEncoder implements PasswordEncoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomPasswordEncoder.class);
    private String encodingAlgorithm = "SHA1";
    private String characterEncoding = "UTF-8";

    public String encode(CharSequence password) {
        if (password == null) {
            return null;
        } else if (StringUtils.isBlank(this.encodingAlgorithm)) {
            LOGGER.warn("No encoding algorithm is defined. Password cannot be encoded; Returning null");
            return null;
        } else {
            String encodingCharToUse = StringUtils.isNotBlank(this.characterEncoding) ? this.characterEncoding : Charset.defaultCharset().name();
            LOGGER.debug("Using [{}] as the character encoding algorithm to update the digest", encodingCharToUse);

            try {
                byte[] e = password.toString().getBytes(encodingCharToUse);
                String encoded = Hex.encodeHexString(DigestUtils.getDigest(this.encodingAlgorithm).digest(e));
                LOGGER.debug("Encoded password via algorithm [{}] and character-encoding [{}] is [{}]", new Object[]{this.encodingAlgorithm, encodingCharToUse, encoded});
                return encoded;
            } catch (Exception var5) {
                LOGGER.error(var5.getMessage(), var5);
                return null;
            }
        }
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String encodedRawPassword = StringUtils.isNotBlank(rawPassword) ? this.encode(rawPassword.toString()) : null;
        boolean matched = StringUtils.equals(encodedRawPassword, encodedPassword);
        LOGGER.debug("Provided password does{}match the encoded password", BooleanUtils.toString(matched, "", " not "));
        return matched;
    }

}
