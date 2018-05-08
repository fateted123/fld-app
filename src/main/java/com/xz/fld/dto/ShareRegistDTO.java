package com.xz.fld.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShareRegistDTO {
    private String url;
    private byte channel;
    private String describe;

    public ShareRegistDTO() {

    }

    public ShareRegistDTO(String url, byte channel, String describe) {
        this.url = url;
        this.channel = channel;
        this.describe = describe;
    }
}
