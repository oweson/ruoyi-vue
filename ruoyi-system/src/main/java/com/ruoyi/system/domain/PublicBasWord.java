package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 汉字大全对象 public_bas_word
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public class PublicBasWord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 文字 */
    @Excel(name = "文字")
    private String word;

    /** 繁体字 */
    @Excel(name = "繁体字")
    private String oldword;

    /** 拼音 */
    @Excel(name = "拼音")
    private String pinyin;

    /** 偏旁 */
    @Excel(name = "偏旁")
    private String radicals;

    /** 笔画 */
    @Excel(name = "笔画")
    private Long strokes;

    /** 解释 */
    @Excel(name = "解释")
    private String explanation;

    /** 更多 */
    @Excel(name = "更多")
    private String more;

    /** $column.columnComment */
    private Long addUserId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWord(String word) 
    {
        this.word = word;
    }

    public String getWord() 
    {
        return word;
    }
    public void setOldword(String oldword) 
    {
        this.oldword = oldword;
    }

    public String getOldword() 
    {
        return oldword;
    }
    public void setPinyin(String pinyin) 
    {
        this.pinyin = pinyin;
    }

    public String getPinyin() 
    {
        return pinyin;
    }
    public void setRadicals(String radicals) 
    {
        this.radicals = radicals;
    }

    public String getRadicals() 
    {
        return radicals;
    }
    public void setStrokes(Long strokes) 
    {
        this.strokes = strokes;
    }

    public Long getStrokes() 
    {
        return strokes;
    }
    public void setExplanation(String explanation) 
    {
        this.explanation = explanation;
    }

    public String getExplanation() 
    {
        return explanation;
    }
    public void setMore(String more) 
    {
        this.more = more;
    }

    public String getMore() 
    {
        return more;
    }
    public void setAddUserId(Long addUserId) 
    {
        this.addUserId = addUserId;
    }

    public Long getAddUserId() 
    {
        return addUserId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("word", getWord())
            .append("oldword", getOldword())
            .append("pinyin", getPinyin())
            .append("radicals", getRadicals())
            .append("strokes", getStrokes())
            .append("explanation", getExplanation())
            .append("more", getMore())
            .append("addUserId", getAddUserId())
            .toString();
    }
}
