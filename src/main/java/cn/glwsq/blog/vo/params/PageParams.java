package cn.glwsq.blog.vo.params;

import lombok.Data;

@Data
public class PageParams { // 前后同一风格的实体类
    private int page = 1;
    private int pageSize = 10;
}
