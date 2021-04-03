package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 单词管理对象 public_englishwords
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public class PublicEnglishwords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private Integer id;

    /** 单词 */
    @Excel(name = "单词")
    private String word;

    /** 英式发音 */
    @Excel(name = "英式发音")
    private String englishPronunciation;

    /** 美式发音 */
    @Excel(name = "美式发音")
    private String americaPronunciation;

    /** 解释 */
    @Excel(name = "解释")
    private String meaning;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
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
    public void setEnglishPronunciation(String englishPronunciation) 
    {
        this.englishPronunciation = englishPronunciation;
    }

    public String getEnglishPronunciation() 
    {
        return englishPronunciation;
    }
    public void setAmericaPronunciation(String americaPronunciation) 
    {
        this.americaPronunciation = americaPronunciation;
    }

    public String getAmericaPronunciation() 
    {
        return americaPronunciation;
    }
    public void setMeaning(String meaning) 
    {
        this.meaning = meaning;
    }

    public String getMeaning() 
    {
        return meaning;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("word", getWord())
            .append("englishPronunciation", getEnglishPronunciation())
            .append("americaPronunciation", getAmericaPronunciation())
            .append("meaning", getMeaning())
            .toString();
    }
}
