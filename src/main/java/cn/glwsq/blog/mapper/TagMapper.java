package cn.glwsq.blog.mapper;

import cn.glwsq.blog.domain.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author happen
* @description 针对表【ms_tag】的数据库操作Mapper
* @createDate 2022-03-09 14:36:35
* @Entity cn.glwsq.blog.domain.Tag
*/
public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> findTagsByArticleId(Long articleId);
}




