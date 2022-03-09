package cn.glwsq.blog.service;

import cn.glwsq.blog.domain.Tag;
import cn.glwsq.blog.vo.TagVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author happen
* @description 针对表【ms_tag】的数据库操作Service
* @createDate 2022-03-09 14:36:35
*/
public interface TagService extends IService<Tag> {
    List<TagVo> findTagsByArticleId(Long articleId);
}
