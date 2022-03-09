package cn.glwsq.blog.mapper;

import cn.glwsq.blog.domain.Article;
import cn.glwsq.blog.dos.Archives;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author happen
* @description 针对表【ms_article】的数据库操作Mapper
* @createDate 2022-03-09 14:36:35
* @Entity cn.glwsq.blog.domain.Article
*/
public interface ArticleMapper extends BaseMapper<Article> {

    List<Archives> listArchives();

}




