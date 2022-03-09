package cn.glwsq.blog.service.impl;

import cn.glwsq.blog.vo.Result;
import cn.glwsq.blog.vo.TagVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.glwsq.blog.domain.Tag;
import cn.glwsq.blog.service.TagService;
import cn.glwsq.blog.mapper.TagMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* @author happen
* @description 针对表【ms_tag】的数据库操作Service实现
* @createDate 2022-03-09 14:36:35
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

    @Resource
    TagMapper tagMapper;

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        List<Tag> tags = tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }

    @Override
    public Result hots(int limit) {
        /**
         * 1. 标签所拥有的文章数量最多，就是最热标签
         * 2. 查询 根据tag_id分组 计数，从大到小 排列去前几
         */
        List<Long> tagsIds = tagMapper.findHotsTagIds(limit);
        System.out.println("tagsIds" + tagsIds);
        if(CollectionUtils.isEmpty(tagsIds)) {
            return Result.success(Collections.emptyList());
        }

        List<Tag> tagList = tagMapper.findTagsByTagIds(tagsIds);

        return Result.success(tagList);
    }

    public TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        tagVo.setId(String.valueOf(tag.getId()));
        return tagVo;
    }
    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }
}




