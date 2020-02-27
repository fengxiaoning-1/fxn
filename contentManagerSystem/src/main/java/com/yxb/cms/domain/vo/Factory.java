package com.yxb.cms.domain.vo;

import java.io.Serializable;
import java.util.Date;

import com.yxb.cms.domain.dto.PageDto;

/**
 * @ClassName:  Factory   
 * @Description:TODO(工厂类实体)   
 * @author: zhangxy
 * @date:   2020年2月25日 下午2:33:44   
 *
 */
public class Factory extends PageDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String creator;

    private Date createTime;

    private String modifier;

    private Date modifierTime;
    /**
     * 查询项
     */
    private String searchTerm;
    /**
     * 查询内容
     */
    private String searchContent;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Date getModifierTime() {
		return modifierTime;
	}

	public void setModifierTime(Date modifierTime) {
		this.modifierTime = modifierTime;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
    
}
