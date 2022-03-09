package cn.glwsq.blog.service.impl;

import cn.glwsq.blog.domain.SysUser;
import cn.glwsq.blog.service.SysUserService;
import cn.glwsq.blog.service.TagService;
import cn.glwsq.blog.vo.ArticleVo;
import cn.glwsq.blog.vo.Result;
import cn.glwsq.blog.vo.TagVo;
import cn.glwsq.blog.vo.params.PageParams;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.glwsq.blog.domain.Article;
import cn.glwsq.blog.service.ArticleService;
import cn.glwsq.blog.mapper.ArticleMapper;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.joda.time.DateTime;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author happen
* @description 针对表【ms_article】的数据库操作Service实现
* @createDate 2022-03-09 14:36:35
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private TagService tagService;

    @Resource
    private SysUserService sysUserService;

    @Override
    public Result listArticle(PageParams pageParams) {
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        // 是否置顶进行排序 时间排序
        queryWrapper.orderByDesc(Article::getWeight, Article::getCreateDate);
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<Article> records = articlePage.getRecords();
        // 数据库中查询到的数据不能直接返回给前端
        // 需要数据转换 可以用tream
        List<ArticleVo> articleVoList = copyList(records, true, true);
        return Result.success(articleVoList);
    }

    @Override
    public Result hotArticle(int limit) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getViewCounts);
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.last("limit " + limit);
        List<Article> articles = articleMapper.selectList(queryWrapper);


        return Result.success(copyList(articles, false, false));
    }

    private List<ArticleVo> copyList(List<Article> records, boolean isTag, boolean isAuthor ) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record, isTag, isAuthor));
        }
        return articleVoList;
    }

    private ArticleVo copy(Article article, boolean isTag, boolean isAuthor) {
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        // 并不是所有的接口都需要标签和作者信息
        if(isTag) {
            Long id = article.getId();
            List<TagVo> tagsVo = tagService.findTagsByArticleId(id);
            articleVo.setTags(tagsVo);
        }
        if(isAuthor) {
            Long id = article.getAuthorId();
            SysUser author = sysUserService.findUserById(id);
            articleVo.setAuthor(author.getNickname());
        }
        return articleVo;
    }
}




