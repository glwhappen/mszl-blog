package cn.glwsq.blog.service;

import cn.glwsq.blog.domain.Article;
import cn.glwsq.blog.vo.Result;
import cn.glwsq.blog.vo.params.PageParams;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author happen
* @description 针对表【ms_article】的数据库操作Service
* @createDate 2022-03-09 14:36:35
*/
public interface ArticleService extends IService<Article> {
    /**
     * 分页查询文章列表
     * @param pageParams
     * @return
     */
    public Result listArticle(PageParams pageParams);

    /**
     * 最热文章
     * @param limit
     * @return
     */
    Result hotArticle(int limit);

    /**
     * 最新文章
     * @param limit
     * @return
     */
    Result newArticle(int limit);

    /**
     * 文章归档
     * @return
     */
    Result listArchives();
}
