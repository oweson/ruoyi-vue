package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 成语管理对象 public_idiom
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public class PublicIdiom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 名字 */
    @Excel(name = "名字")
    private String name;

    /** 拼音 */
    @Excel(name = "拼音")
    private String spell;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 出处 */
    @Excel(name = "出处")
    private String derivation;

    /** 举列 */
    @Excel(name = "举列")
    private String samples;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSpell(String spell) 
    {
        this.spell = spell;
    }

    public String getSpell() 
    {
        return spell;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setDerivation(String derivation) 
    {
        this.derivation = derivation;
    }

    public String getDerivation() 
    {
        return derivation;
    }
    public void setSamples(String samples) 
    {
        this.samples = samples;
    }

    public String getSamples() 
    {
        return samples;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("spell", getSpell())
            .append("content", getContent())
            .append("derivation", getDerivation())
            .append("samples", getSamples())
            .toString();
    }
}
